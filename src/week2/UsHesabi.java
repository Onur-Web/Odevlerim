package week2;

import java.util.Scanner;

public class UsHesabi {

    static int uslu(int taban, int ust) {
        if (ust == 0)
            return 1;
        if (taban == 0)
            return 0;
        else
            return taban * uslu(taban, ust - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Taban Değerini Giriniz : ");
        int taban = input.nextInt();
        System.out.print("Üs Değerini Giriniz : ");
        int ust = input.nextInt();

        System.out.println("Sonuç : " + uslu(taban, ust));
    }
}