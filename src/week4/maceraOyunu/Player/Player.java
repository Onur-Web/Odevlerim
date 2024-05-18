package week4.maceraOyunu.Player;

import week4.maceraOyunu.Classes.Archer;
import week4.maceraOyunu.Classes.Knight;
import week4.maceraOyunu.Classes.Samurai;

import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int money;
    private int orjinalHealth;
    private String characterName;
    private String name;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCharacter() {
        while (true) {
            GameCharacter[] charakterList = {new Samurai(), new Archer(), new Knight()};
            System.out.println("--------------------------------------");
            System.out.println("Sınıf Seçeneklerin");
            for (GameCharacter gameCharacter : charakterList) {
                System.out.println(gameCharacter.getId() + "." + "\t" + gameCharacter.getName() + "\t" + "  Hasar:" +
                        gameCharacter.getDamage() + "  Sağlık:" + gameCharacter.getHealth() + "  Para:" + gameCharacter.getMoney());
            }
            System.out.println("--------------------------------------");
            System.out.print("Lütfen Sınıfını Seç : ");
            int selectCharacter = input.nextInt();
            switch (selectCharacter) {
                case 1:
                    initPlayer(new Samurai());
                    System.out.println("Sınıfın : " + this.characterName + " (Benimde Favorim :D) " + " BOL ŞANS !!!");
                    break;
                case 2:
                    initPlayer(new Archer());
                    System.out.println("Sınıfın : " + this.characterName + " (Parmaklara Dikkat :D) " + "BOL ŞANS !!!");
                    break;
                case 3:
                    initPlayer(new Knight());
                    System.out.println("Sınıfın : " + this.characterName + " (Tuvaletini nasıl yapacaksın :D) " + " BOL ŞANS !!!");
                    break;
                default:
                    System.out.println("Maelesef Seçenekler Sana Sunulanlar... \" + \"Tekrar Dene!!!");
                    continue;
            }
            break;
        }
    }

    public void printInfo() {
        System.out.println("Mevcut Silahın : " + this.getInventory().getWeapon().getName()
                + "   Mevcut Armorun : " + this.getInventory().getArmor().getName()
                + "   Mevcut Bloklama : " + this.getInventory().getArmor().getBlock()
                + "   Mevcut Hasarınız : " + this.getTotalDamage()
                + "   Mevcut Sağlığınız : " + this.getHealth()
                + "   Mevcut Paranız : " + this.getMoney());
    }

    public void initPlayer(GameCharacter gameCharacter) {
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOrjinalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setCharacterName(gameCharacter.getName());
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}