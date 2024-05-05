package week2;

public class PalindromikKelimeBulma {
    //Muhteşem Yöntem 1
    static boolean isPalindrom(String str) {

        int bastan = 0;
        int sondan = str.length() - 1;
        while (bastan < sondan) {
            if (str.charAt(bastan) != str.charAt(sondan)) {
                return false;
            }
            bastan++;
            sondan--;
        }
        return true;
    }
    //Tırıs Yöntem 2
    static boolean isPalindrom2(String str) {

        String reverse = "";
        for (int bastan = str.length() - 1; bastan >= 0; bastan--) {
            reverse += str.charAt(bastan);
        }
        return str.equals(reverse);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrom("abba"));
        System.out.println(isPalindrom2("abbaa"));

    }
}