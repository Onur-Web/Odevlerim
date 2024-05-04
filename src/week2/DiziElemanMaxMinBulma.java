package week2;

import java.util.Scanner;

public class DiziElemanMaxMinBulma {
    public static void main(String[] args) {

        int[] array = {15, 12, 788, 1, -1, -778, 2, 0};
        System.out.println("Dizi: {15, 12, 788, 1, -1, -778, 2, 0}");

        Scanner input = new Scanner(System.in);
        System.out.print("Girilen Sayı : ");
        int enteredNumber = input.nextInt();

        System.out.println(findLessCloseNumber(array, enteredNumber));
        System.out.println(findBiggerCloseNumber(array, enteredNumber));
    }

    public static String findBiggerCloseNumber(int[] array, int enteredNumber) {
//Integer.MAX_VALUE Daha öğrenmedik ama araştırırken başka bir alternatif yolu bulamadım.
        int minDifference = Integer.MAX_VALUE;
        int foundNumber = 0;

        for (int currentNumber : array) {
            // gezdiğim sayı girilen sayıdan büyükse işleme al.
            if (currentNumber > enteredNumber) {

                // gezilen sayı ile girilen sayı arasındaki fark, benim bildiğim farktan daha az ise, o ana kadar bulunan en düşük fark alınır.
                if (currentNumber - enteredNumber < minDifference) {
                    minDifference = currentNumber - enteredNumber;
                    foundNumber = currentNumber;
                }
            }
        }
        return "Girilen sayıdan büçük en yakın sayı : " + foundNumber;
    }

    public static String findLessCloseNumber(int[] array, int enteredNumber) {

        // array içinde gezerken gezdiğim sayı, girilen sayıdan küçükse işleme alacağım.
////Integer.MAX_VALUE Daha öğrenmedik ama araştırırken başka bir alternatif yolu bulamadım.
        int minDifference = Integer.MAX_VALUE; // 3
        int foundNumber = 0;

        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            if (currentNumber < enteredNumber) {

                if (enteredNumber - currentNumber < minDifference) {
                    minDifference = enteredNumber - currentNumber;
                    foundNumber = array[i];
                }
            }
        }
        return "Girilen sayıdan küçük en yakın sayı : " + foundNumber;

    }
}
