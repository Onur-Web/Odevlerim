package week6.dosyadanSayilariOku_Topla;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String dosyaYolu = "src/week6/dosyadanSayilariOku_Topla/Sayilar.txt";
        int toplam = 0;
        try {
            FileReader frName = new FileReader(dosyaYolu);
            BufferedReader brName = new BufferedReader(frName);

            String line;
            while ((line = brName.readLine()) != null) {
                int sayi = Integer.parseInt(line);
                toplam += sayi;
                System.out.println("Okunan Sayı: " + sayi);
            }
            System.out.println("Okunanların Toplamı : " + toplam);
            brName.close();
            frName.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}