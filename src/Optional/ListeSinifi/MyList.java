package Optional.ListeSinifi;

import java.lang.reflect.Array;

public class MyList<T> {
    private Integer size = 10;
    private T[] array;
    private Class<T> clazz;

    public MyList() {
    }

    public MyList(int capacity) {
        size = capacity;
    }

    public void init(Class<T> clazz, int size) {
        this.clazz = clazz;
        array = (T[]) Array.newInstance(clazz, size);
    }

    public void increaseSize() {
        int newSize = size * 2;
        size = newSize;
        T[] newArray = (T[]) Array.newInstance(clazz, newSize);

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
    public int size() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                count++;
            }
        }
        return count;
    }
    public int getCapacity() {
        return array.length;
    }

    public void add(T data) {
        // Dizide yer var mı
        if (array[array.length - 1] != null) {
            increaseSize();
        }
        // [1,2,3,4,5,null,null,null]
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = data;
                break;
            }
        }
    }
}
