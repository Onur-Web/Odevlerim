package week1;

import java.util.Scanner;

public class ManavKP {
    public static void main(String[] args) {

        double aF = 2.14, eF = 3.67 , dF = 1.11, mF = 0.95, pF = 5.00;
        double aK , eK , dk , mK , pK ;


        Scanner MDK = new Scanner(System.in);
        System.out.print("Armut kaç kilo : ");
        aK = MDK.nextDouble();

        System.out.print("Elma kaç kilo : ");
        eK = MDK.nextDouble();

        System.out.print("Domates kaç kilo : ");
        dk = MDK.nextDouble();

        System.out.print("Muz kaç kilo : ");
        mK = MDK.nextDouble();

        System.out.print("Patlıcan kaç kilo : ");
        pK = MDK.nextDouble();

        double toplamtutar = (aK*aF) + (eK*eF) + (dk*dF) + (mK*mF) + (pK*pF) ;

        System.out.println("Toplam Tutar : " + toplamtutar);

    }
}
