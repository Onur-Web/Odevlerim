package week2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SayiTahminOyunu {
    public static void main(String[] args) {

        Random random = new Random();
        int number = random.nextInt(100);
        Scanner input = new Scanner(System.in);

        int hak = 0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;


        System.out.println(number);

        while (hak < 5) {
            System.out.print("Tahmininizi Giriniz : ");
            selected = input.nextInt();
            if (selected < 0 || selected > 99) {
                System.out.println("Lütfen 0-100 Arası Bir Değer Giriniz.");
                if (isWrong){
                    hak++;
                    System.out.println("Kalan Hak : " + (5-hak));
                }else{
                    isWrong = true;
                    System.out.println("İlk Hata Benden");
                }
                continue;
            }
            if (selected == number) {
                System.out.println("Tahmininiz Doğru " + number);
                System.out.println("Kazandınız !!!");
                isWin = true;
                break;
            } else {
                if (selected > number) {
                    System.out.println(selected + " Sayısı Gizli Sayıdan Büyüktür.");
                } else {
                    System.out.println(selected + " Sayısı Gizli Sayıdan Küçüktür.");
                }

                wrong[hak] = selected;
                hak++;
                System.out.println("Kalan Hak : " + (5 - hak));
                System.out.println("Tahminleriniz : " + Arrays.toString(wrong));
                System.out.println("------------------------");
            }
        }
        if (!isWin)
            System.out.println("Kaybettiniz !!!");
    }
}
