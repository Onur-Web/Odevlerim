package week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DiziElemanFrekans {

    public static void main(String[] args) {
        int[] array = {10, 20, 20, 10, 10, 20, 5, 20};
        System.out.println("Dizi : " + Arrays.toString(array));

        Map<Integer, Integer> myMap = new HashMap<>();
        //daha görmedik ama bir arkadaşım aracılığı ile öğrendim ve çok hoşuma gitti oyüzden kullanmak istedim

        // for loop
        for (int i = 0; i < array.length; i++) {
            // arrayden elemanı oku
            int number = array[i];
            // map içine ekle
            // eleman daha önceden bulundu mu?
            if (myMap.get(number) == null) {
                myMap.put(number, 1); // 10 --> 3
            } else {
                // bu eleman daha önceden bir defa kayıt edilmiş.
                Integer counter = myMap.get(number);
                counter++;
                myMap.put(number, counter);
            }
        }
        System.out.println("Tekrar Sayıları");
        for (Map.Entry<Integer, Integer> item : myMap.entrySet()) {
            System.out.println(item.getKey() + " sayısı " + item.getValue() + " kere tekrar edildi.");
        }
        // alternatif ve aslında doğru kullanımı
        // for-each loop

       /*

       for (int number : array) {
            if (myMap.get(number) == null) {
                myMap.put(number, 1); // 10 --> 3
            } else {
                // bu eleman daha önceden bir defa kayıt edilmiş.
                Integer counter = myMap.get(number);
                counter++;
                myMap.put(number, counter);
            }
        }
        */
    }
}