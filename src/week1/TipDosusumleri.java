package week1;

import java.util.Scanner;

public class TipDosusumleri {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int tamSayi, ondalikliTamHali;
        double ondalikSayi, tamOndalikliHali;

        System.out.print("Bir Tam Sayı Giriniz : ");
        tamSayi = input.nextInt();

        System.out.print("Bir Ondalık Sayı Giriniz : ");
        ondalikSayi = input.nextDouble();

        tamOndalikliHali = tamSayi;
        ondalikliTamHali = (int) ondalikSayi;

        System.out.println("Tam Sayının Ondalıklı Hali: " + tamOndalikliHali);
        System.out.println("Ondalıklı Sayının Tam Sayı Hali: " + ondalikliTamHali);

    }
}
