
import java.util.Scanner;

public class KucukToBuyuk {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int a, b, c;

        System.out.print("A Sayısını Giriniz : ");
        a = input.nextInt();

        System.out.print("B Sayısını Giriniz : ");
        b = input.nextInt();

        System.out.print("C Sayısını Giriniz : ");
        c = input.nextInt();

        if ((a < b) && (a < c)) {                //Koşul1
            if (b < c) {
                System.out.println("a < b < c");
            } else {
                System.out.println("a < c < b");
            }

        } else if ((b < a) && (b < c)) {          //Koşul2
            if (a < c) {
                System.out.println("b < a < c");
            } else {
                System.out.println("b < c < a");
            }
        } else if ((c < a) && (c < b)) {          // Üsteki 2 koşul karşılanmadığında programın bu satırı hedef alacağından ötürü Else if yerine Else de kullanılabilirdi
            if (a < b) {
                System.out.println("c < a < b");
            } else {
                System.out.println("c < b < a");
            }
        }


    }
}