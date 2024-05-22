package week5.enCokGecenKelimeyiBulma.info;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Metni girin: ");
        String metin = input.nextLine();
        String[] kelimeler = metin.split(" ");//Boşluklara Göre Kelimeleri dizilere ekle

        HashMap<String, Integer> kelimeSayilari = new HashMap<>();

        for (String str : kelimeler) {
            str = str.trim();// Boşlukları temizle
            if (!(str.isEmpty())) {
                if (kelimeSayilari.containsKey(str)) {
                    kelimeSayilari.put(str, kelimeSayilari.get(str) + 1);// Eğer varsa, sayısını bir artır
                } else {
                    kelimeSayilari.put(str, 1);// Eğer yoksa, ekleyip sayısını 1 yap
                }
            }
        }
        String enCokGecenKelime = "";// En çok geçen kelimeyi bul
        int enCokGecenSayi = 0;
        for (HashMap.Entry<String, Integer> name : kelimeSayilari.entrySet()) {
            if (name.getValue() > enCokGecenSayi) {
                enCokGecenKelime = name.getKey();
                enCokGecenSayi = name.getValue();
            }
        }
        System.out.println("En çok geçen kelime: " + enCokGecenKelime);
        System.out.println("Bu kelime metinde " + enCokGecenSayi + " kez geçiyor.");
    }
}