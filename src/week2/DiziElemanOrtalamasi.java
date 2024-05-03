package week2;


//Harmonik Ortalama formülü : n (eleman sayısı) / elemanların harmonik serisi

public class DiziElemanOrtalamasi {
    public static void main(String[] args) {

        int[] list = {1,2,3,4,5};
        double sum = 0.0;
        for (int i : list) {
            sum += 1.0 / i;
        }
        double harmonicAvarage = list.length/sum;
        System.out.println(harmonicAvarage);
    }
}
