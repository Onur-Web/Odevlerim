package week4.maceraOyunu.Monsters;

import java.util.Random;

public class Snake extends Monster {
    private static Random random = new Random();

    public Snake() {
        super(4, "Yılan", random.nextInt(3) + 3, 12, 0);
    }
}
