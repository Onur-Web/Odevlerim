package week1;

import java.util.Scanner;

public class DaireAC {
    public static void main(String[] args) {

        int r;
        double pi = 3.14 , q ;

        Scanner s1 = new Scanner(System.in);
        System.out.print("Dairenin Yarıçapını Giriniz : ");
        r = s1.nextInt();

        System.out.print("Direnin Merkez Açısını Giriniz : ");
        q = s1.nextDouble();

        double alan = pi * r * r ;
        double cevre = 2 * pi * r ;
        double dilimalani = (pi*r*r*q)/360 ;

        System.out.println("Dairenin Alanı : " + alan);
        System.out.println("Dairenin Çevresi : " + cevre);
        System.out.println("Daire Diliminin Alanı : " + dilimalani);

    }
}