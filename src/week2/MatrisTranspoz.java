package week2;

public class MatrisTranspoz {

    public static void main(String[] args) {
        int[][] originalArray = {{2, 3, 4}, {5, 6, 4}};
        // kaç satır
        // kaç sutn var
        // 3x3 --> 9 input iste

        // Orijinal matrisi yazdır
        System.out.println("Matris:");
        printMatrix(originalArray);

        int rowCount = originalArray.length;
        int columnCount = originalArray[0].length;

        int[][] transposeArray = new int[columnCount][rowCount];
        // Transpoz matrisi hesapla
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                transposeArray[column][row] = originalArray[row][column];
            }
        }

        // Transpoz yazdırma
        System.out.println("Transpoze:");
        printMatrix(transposeArray);
    }
    // Matris yazdırma
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}