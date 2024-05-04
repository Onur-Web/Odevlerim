package week2;

public class DizideTekrarEdenCift {
    public static void main(String[] args) {
        int[] liste = {3, 7, 3, 3, 2, 9, 10, 21, 1, 33, 9, 1, 2, 4, 8, 4, 10, 8};
        for (int i = 0; i < liste.length; i++) {
            // aynı elemanlar arasındaki tekrarları önlemek için +1 lenght kullandım
            for (int j = i + 1; j < liste.length; j++) {
                if (liste[i] == liste[j] && liste[i] % 2 == 0) {
                    System.out.print(liste[i] + " ");
                    //Burada gerekli bir komut değil ama jargon
                    break;
                }
            }
        }
    }
}