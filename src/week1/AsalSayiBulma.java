package week1;

public class AsalSayiBulma {
    public static void main(String[] args) {

        boolean asal;

        System.out.println("1 - 100 arasındaki asal sayılar:");

        for (int i = 2; i <= 100; i++) {
            asal = true;
            for (int k = 2; k <= i / 2; k++) {
                if (i % k == 0) {
                    asal = false;
                    break;
                }
            }
            if (asal) {
                System.out.print(i + " ");
            }
        }
    }
}