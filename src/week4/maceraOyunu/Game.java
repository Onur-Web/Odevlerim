package week4.maceraOyunu;

import week4.maceraOyunu.Locations.*;
import week4.maceraOyunu.Player.Player;

import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    private boolean isGameCompleted;

    public Game() {
        this.isGameCompleted = false;
    }

    public void start() {

        System.out.println("*** Macera Oyununa Hoşgeldiniz ***");
        System.out.print("Lütfen Karakterinizin İsmini Giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " bakalım bu maceradan sağ çıkabilecek misin ?");
        player.selectCharacter();

        Location location;
        while (!isGameCompleted) {
            player.printInfo();
            System.out.println();
            System.out.println("-------- Bölgeler --------");
            System.out.println();
            System.out.println("1 - Güvenli Ev (Ayağını Uzat ve Kahveni, Şömine Ateşinde Yudumla)");
            System.out.println("2 - Eşya Dükkanı (Silah veya Zırh Alabilrsin)");
            System.out.println("3 - Mağara (Karanlık ve Kötü Kokuyor)  \t\t --> Ödül : Yemek");
            System.out.println("4 - Orman (Sis ve Gizemli Seslere Dikkat Et) --> Ödül : Odun");
            System.out.println("5 - Nehir (Ayaklarını Kuru Tutmaya Çalış)  \t --> Ödül : Su");
            System.out.println("6 - Maden (Cücelerin Terkettidiği Madenler)\t --> Ödül : Teşhizat");
            System.out.println("0 - Çıkış Yap (Maceranı Sonlandır)");
            System.out.print("Lütfen Gitmek İstediğiniz Bölgeyi Seçiniz : ");
            int selectLocation = input.nextInt();
            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player,this);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    if (player.getInventory().isFood()) {
                        System.out.println("Bu bölgeyi zaten temizlediniz. Tekrar giremezsiniz!");
                        continue;
                    }
                    break;
                case 4:
                    location = new Forest(player);
                    if (player.getInventory().isWood()) {
                        System.out.println("Bu bölgeyi zaten temizlediniz. Tekrar giremezsiniz!");
                        continue;
                    }
                    break;
                case 5:
                    location = new River(player);
                    if (player.getInventory().isWater()) {
                        System.out.println("Bu bölgeyi zaten temizlediniz. Tekrar giremezsiniz!");
                        continue;
                    }
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Maceracılar Giremez!!!" + " Girebileceğin Konumları Dene.");
                    continue;
            }
            if (location == null) {
                System.out.println("Cesaretini Topladığında Tekrar Bekleriz");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Maceranız Sona Erdi.");
                break;
            }
        }
    }

    public boolean isGameCompleted() {
        return isGameCompleted;
    }

    public void setGameCompleted(boolean gameCompleted) {
        isGameCompleted = gameCompleted;
    }
}
