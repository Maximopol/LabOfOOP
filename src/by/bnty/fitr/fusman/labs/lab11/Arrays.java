package by.bnty.fitr.fusman.labs.lab11;

public class Arrays {
    private static final int DEFAULT_SIZE = 3;
    private int[] array;

    public Arrays() {
        array = new int[DEFAULT_SIZE];

    }

    public Arrays(int[] array) {
        this.array = array;
    }

    public Arrays(int length) {
        array = new int[length];
    }


    public Arrays(Arrays array) {
        this(array.array.length);
        System.arraycopy(array.array, 0, this.array, 0, array.array.length);
    }

    public int getLength() {
        return array.length;
    }


    public int getElement(int i) {
        return array[i];
    }

    public void setElement(int i, int value) {
        array[i] = value;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int x : array) {
            builder.append(x).append("  ");
        }
        return builder.toString();
    }
}
