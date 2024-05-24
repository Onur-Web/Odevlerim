package week5.patikaStore;

import java.util.*;

public class Main {

    public static List<String> brandList;

    static {
        brandList = Arrays.asList("Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster","Redmi"); // ArrayList ve içi bunlarla dolu
    }

    public static void main(String[] args) {

        List<Notebook> notebookList = new ArrayList<>();

        Notebook notebook1 = new Notebook(1, 7000.0, 1, "HUAWEI Matebook 14", 4, brandList.get(3), 16, 512, 14.0);
        Notebook notebook2 = new Notebook(2, 3699.0, 1, "LENOVO V14 IGL", 2, brandList.get(1), 8, 1024, 14.0);
        Notebook notebook3 = new Notebook(3,8199.0,1,"ASUS Tuf Gaming",6,brandList.get(5),4,2048,15.6);

        notebookList.add(notebook1);
        notebookList.add(notebook2);
        notebookList.add(notebook3);

        List<Phone> phoneList = new ArrayList<>();

        Phone phone1 = new Phone(1, 3199.0, 1, "SAMSUNG GALAXY A51", 1, brandList.get(0), 6, 128, 6.5 , 32, 4000.0, "Siyah");
        Phone phone2 = new Phone(2, 7379.0, 1, "iPhone 11 64 GB", 3, brandList.get(2), 6, 64, 6.5,5, 3046.0, "Mavi");
        Phone phone3 = new Phone(3,4012.0,1,"Redmi Note 10 Pro 8GB",10,brandList.get(9),12,128,6.5,35,4000.0,"Beyaz");

        phoneList.add(phone1);
        phoneList.add(phone2);
        phoneList.add(phone3);

        Collections.sort(brandList);

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        System.out.println("PatikaStore Ürün Yönetim Paneli !");
        System.out.println("1 - Notebook İşlemleri\n" +
                "2 - Cep Telefonu İşlemleri\n" +
                "3 - Marka Listele\n" +
                "0 - Çıkış Yap");

        while (!exit) {
            System.out.print("Tercihiniz : ");
            int selection;
            try {
                selection = scanner.nextInt();
            } catch (Exception e) {
                selection = -1;
            }

            switch (selection) {
                case 1:
                    System.out.println("----------------------------------------------------------------------------------------------------");

                    System.out.println("|ID| Ürün Adı                           | Fiyat | Marka | Depolama | Ekran | RAM |");
                    for (Notebook notebook : notebookList) {
                        System.out.println(notebook.toString());
                    }

                    System.out.println("----------------------------------------------------------------------------------------------------");


                    break;
                case 2:
                    System.out.println("----------------------------------------------------------------------------------------------------");

                    System.out.println("| ID | Ürün Adı                      | Fiyat | Marka | Depolama | Ekran | Kamera | Pil | RAM | Renk |");
                    for (Phone phone : phoneList) {

                        System.out.println(phone.toString());
                    }

                    System.out.println("----------------------------------------------------------------------------------------------------");

                    break;
                case 3:
                    System.out.println("Markalarımız");
                    System.out.println("--------------");
                    for (String brand : brandList) {
                        System.out.println(brand);
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Geçersiz seçim");
            }
        }
        System.out.println("Bye!");
    }
}
