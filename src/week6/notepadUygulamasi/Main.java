package week6.notepadUygulamasi;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String data = "src/week6/notepadUygulamasi/Metin.txt";
        Scanner scanner = new Scanner(System.in);
        boolean devam = true;
        while (devam) {
            try {
                FileReader frName = new FileReader(data);
                BufferedReader brName = new BufferedReader(frName);
                System.out.println("İçerik : " + brName.readLine());
                brName.close();

                System.out.print("Bir metin girin veya çıkmak için 'exit' yazın: ");
                String metin = scanner.nextLine();

                if (metin.equalsIgnoreCase("exit")) {
                    devam = false;
                } else {
                    metin = metin + " ";

                    FileWriter fwName = new FileWriter(data, true);
                    PrintWriter pwName = new PrintWriter(fwName);
                    pwName.print(metin);
                    pwName.close();

                    FileReader frName2 = new FileReader(data);
                    BufferedReader brName2 = new BufferedReader(frName2);
                    brName2.readLine();
                    brName2.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Program sonlandırıldı.");
    }
}