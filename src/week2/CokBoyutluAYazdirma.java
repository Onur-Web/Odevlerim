package week2;

public class CokBoyutluAYazdirma {
    public static void main(String[] args) {

        //satırlar "i"   sütunlar "k"
        //i == 0 || i == 3 || i == 6
        //k == 0 || k == 3

        String[][] letter = new String[7][4];

        for (int i = 0; i < letter.length; i++) {
            for (int k = 0; k < letter[i].length;k++) {
                if (i == 0 || i == 3 || i == 6) {
                    letter[i][k] = "  * ";
                } else if (k == 0 || k == 3) {
                    letter[i][k] = "  * ";
                }else {
                    letter[i][k] = "    ";
                }
            }
        }
        for (String[] row : letter){
            for (String col : row){
                System.out.print(col);
            }
            System.out.println();
        }


    }
}
