package week1;

import java.util.Scanner;

public class VucutKE {
    public static void main(String[] args) {

        double b , k , x;

        Scanner AC1 = new Scanner(System.in);
        System.out.print("Lütfen Boyunuzu Giriniz(M Cinsinden) : ");
        b = AC1.nextDouble();

        System.out.print("Lütfen Kilonuzu Giriniz(Kg Cinsinden : ");
        k = AC1.nextDouble();

        x = k/(b*b);

        System.out.println("Vücut Kitle Endeksiniz : " + x);

    }
}
