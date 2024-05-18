package week4.maceraOyunu.Gears;

public class Weapon {
    private String name;
    private int id;
    private int damage;
    private int prize;

    public Weapon(String name, int id, int damage, int prize) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.prize = prize;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponsList = new Weapon[3];
        weaponsList[0] = new Weapon("Tabanca", 1, 2, 25);
        weaponsList[1] = new Weapon("Katana", 2, 3, 35);
        weaponsList[2] = new Weapon("Tüfek", 3, 7, 45);
        return weaponsList;
    }

    public static Weapon getWeaponObjeByID(int id) {
        for (Weapon w : Weapon.weapons()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}
