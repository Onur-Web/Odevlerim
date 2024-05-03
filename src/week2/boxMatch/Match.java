package week2.boxMatch;

public class Match {
    //Fighter sınıfını çağırmak
    Fighter f1;
    Fighter f2;
    //Nitelikler
    int minWeight;
    int maxWeight;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void startMatch() {
        // Başlangıcı %50 şansla belirle
        double random = Math.random() * 100;
        if (random < 50) {
            System.out.println(f1.name + " başlıyor!");
            run(this.f1, this.f2);
        } else {
            System.out.println(f2.name + " başlıyor!");
            run(this.f2, this.f1);
        }
    }

    public void run(Fighter f1,Fighter f2) {
        if (isCheck()) {
            while (f1.health > 0 && f2.health > 0) {
                System.out.println("=============================");
                f2.health = f1.hit(f2);
                if (isWin()){
                    break;
                }
                f1.health = f2.hit(f1);
                if (isWin()){
                    break;
                }
                System.out.println(f1.name + " Sağlık = " +f1.health
                        + " & " + f2.name + " Sağlık = " + f2.health);
            }
        } else {
            System.out.println("Sikletler Uymuyor!!!");
        }
    }

    boolean isCheck() {

        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight)
                && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " kazandı");
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " kazandı");
            return true;
        }
        return false;
    }
}