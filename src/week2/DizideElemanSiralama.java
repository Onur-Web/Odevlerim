package week2;

import java.util.Arrays;
import java.util.Scanner;

public class DizideElemanSiralama {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Dizinin Boyutunu Giriniz : ");
        int n = input.nextInt();

        int[] arr = new int[n];
        System.out.println("Dizinin Elemanlarını Giriniz");

        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + " Eleman : ");
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Sıralama : ");
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
