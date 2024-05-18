package week4.maceraOyunu;

import week4.maceraOyunu.Gears.Armor;
import week4.maceraOyunu.Gears.Weapon;
import week4.maceraOyunu.Locations.Location;
import week4.maceraOyunu.Monsters.Monster;
import week4.maceraOyunu.Player.Player;

import java.util.Random;

public abstract class BattleLocation extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;
    private Random random = new Random();

    public BattleLocation(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonsterNumber();
        System.out.println("Şuan Buradasınız : " + this.getName());
        System.out.println("Dikkatli Ol!!! Burada " + monsterNumber + " tane " + this.getMonster().getName() + " var.");
        System.out.print("S-Savaş veya K-Kaç : ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase().toUpperCase();
        if (selectCase.equals("S")) {
            if (combat(monsterNumber)) {
                // Inventory içindeki ödülü alması lazım
                switch (this.award){
                    case "Yemek":
                        this.getPlayer().getInventory().setFood(true);
                        break;
                    case "Odun":
                        this.getPlayer().getInventory().setWood(true);
                        break;
                    case "Su":
                        this.getPlayer().getInventory().setWater(true);
                        break;
                }
                System.out.println(this.getName() + " tüm düşmanları yendiniz");
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz !!!!!!");
            return false;
        }
        return true;
    }

    public boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getOrjinalHealth());
            playerStats();
            monsterStats(i);
            boolean playerTurn = random.nextBoolean();
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                if (playerTurn) {
                    System.out.print("S-Saldır veya K-Kaç : ");
                    String selectCombat = input.nextLine().toUpperCase();
                    if (selectCombat.equals("S")) {
                        System.out.println("Siz Vurdunuz");
                        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if (this.getMonster().getHealth() > 0) {
                            playerTurn = false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    System.out.println();
                    System.out.println("Canavar Size Vurdu");
                    int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (monsterDamage < 0) {
                        monsterDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                    afterHit();
                    if (this.getPlayer().getHealth() > 0) {
                        playerTurn = true;
                    }
                }
            }
            if (this.getMonster().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı Yendiniz");
                System.out.println(this.getMonster().getAward() + " para kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + getMonster().getAward());
                System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());
                if (!monster.getName().equals("Yılan")) {
                    getPlayer().setMoney(getPlayer().getMoney() + monster.getAward());
                } else {
                    int randomNumber = random.nextInt(100) + 1;
                    if (randomNumber <= 15) {
                        int randomWeapon = random.nextInt(100) + 1;
                        if (randomWeapon <= 20) {
                            System.out.println("Tüfek Düşürdünüz");
                            Weapon rifle = Weapon.weapons()[2];
                            getPlayer().getInventory().setWeapon(rifle);
                        } else if (randomWeapon <= 50) {
                            System.out.println("Kılıç Düşürdünüz");
                            Weapon katana = Weapon.weapons()[1];
                            getPlayer().getInventory().setWeapon(katana);
                        } else {
                            System.out.println("Tabanca Düşürdünüz");
                            Weapon gun = Weapon.weapons()[0];
                            getPlayer().getInventory().setWeapon(gun);
                        }
                    } else if (randomNumber <= 30) {
                        int randomArmor = random.nextInt(100) + 1;
                        if (randomArmor <= 20) {
                            System.out.println("Ağır Düşürdünüz");
                            Armor heavyArmor = Armor.armors()[2];
                            getPlayer().getInventory().setArmor(heavyArmor);
                        } else if (randomArmor <= 50) {
                            System.out.println("Orta Düşürdünüz");
                            Armor mediumArmor = Armor.armors()[1];
                            getPlayer().getInventory().setArmor(mediumArmor);
                        } else {
                            System.out.println("Hafif Düşürdünüz");
                            Armor lightArmor = Armor.armors()[0];
                            getPlayer().getInventory().setArmor(lightArmor);
                        }
                    } else if (randomNumber <= 55) {
                        int randomMoney = random.nextInt(100) + 1;
                        if (randomMoney <= 20) {
                            System.out.println("10 Para Düşürdünüz");
                            getPlayer().setMoney(getPlayer().getMoney() + 10);
                        } else if (randomMoney <= 50) {
                            System.out.println("5 Para Düşürdünüz");
                            getPlayer().setMoney(getPlayer().getMoney() + 5);
                        } else {
                            System.out.println("İtem Düşüremediniz");
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.monster.getName() + " Canı " + this.monster.getHealth());
    }

    public void playerStats() {
        System.out.println("----------------------------");
        System.out.println(getPlayer().getName() + " Değerleri");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());
    }

    public void monsterStats(int i) {
        System.out.println("----------------------------");
        System.out.println(i + "." + this.getMonster().getName() + " Değerleri");
        System.out.println("Sağlık : " + this.getMonster().getHealth());
        System.out.println("Hasar : " + this.getMonster().getDamage());
        System.out.println("Para : " + this.getMonster().getAward());
    }


    public int randomMonsterNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}