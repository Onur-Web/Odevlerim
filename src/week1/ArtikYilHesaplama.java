package week1;

import java.util.Scanner;

public class ArtikYilHesaplama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int yil ;

        System.out.print("Lütfen Yılı Giriniz : ");
        yil = input.nextInt();

        if (yil % 4 == 0){
            if(yil % 100 != 0){
                System.out.println("Bir Artık Yıldır = " + yil);
            }else{
                if(yil % 400 == 0){
                    System.out.println("Bir Artık Yıldır = " + yil);
                }else{
                    System.out.println("Bir Artık Yıl Değildir = " + yil);
                }
            }
        }else{
            System.out.println("Bir Artık Yıl Değildir = " + yil);
        }
    }
}
