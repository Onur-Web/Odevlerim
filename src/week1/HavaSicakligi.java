package week1;

import java.util.Scanner;

public class HavaSicakligi {
    public static void main(String[] args) {

        int heat;

        Scanner input = new Scanner(System.in);
        System.out.print("Sıcaklık Giriniz : ");
        heat = input.nextInt();

        if (heat < 5) {
            System.out.println("Kayak Yapabilirsin");

        } else if (heat <= 25) {
            if (heat <= 15) {
                System.out.println("Sinemaya Gidebilirsin");
            }
            if (heat >= 10) {
                System.out.println("Pikniğe Gidebilirsin");
            }

        } else {
            System.out.println("Yüzmeye Gidebilirsin");

        }
        if (heat >= 30) {
            System.out.println("Klima Altında Oturabilirsin");
        }

    }
}