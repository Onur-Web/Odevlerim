package week5;

import java.util.Scanner;

public class Try_Catch_Blogu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen ((0 ve 10 dahil) arasında) bir indeks girin: ");
        int index = scanner.nextInt();

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        try {
            int eleman = getElement(array, index);
            System.out.println("Belirtilen indeksteki eleman: " + eleman);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Hata: Belirtilen indeks dizi boyutunun dışında!");
        }
    }

    public static int getElement(int[] array, int index) {
        return array[index];
    }
}
