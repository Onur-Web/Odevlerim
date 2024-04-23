package Week1;

import java.util.Scanner;

public class kdvTutari {
    public static void main(String[] args) {

        double tutar , kdvTutar , kdvsizTutar ;

        Scanner s1 = new Scanner(System.in);
        System.out.print("Ürünün Satış Tutarını Giriniz : ");
        tutar = s1.nextDouble();

        double kdvOran = (tutar > 0 && tutar <= 1000) ? 0.18 : 0.08;

        kdvTutar = tutar * kdvOran ;
        kdvsizTutar = tutar - kdvTutar ;

        System.out.println("KDV Oranı : " + kdvOran);
        System.out.println("KDV Tutarı : " + kdvTutar);
        System.out.println("Ürününü KDV'siz Tutarı : " + kdvsizTutar);

    }
}
