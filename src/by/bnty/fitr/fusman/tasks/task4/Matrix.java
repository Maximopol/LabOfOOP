package by.bnty.fitr.fusman.tasks.task4;

public class Matrix {
    public static final int DEFAULT_SIZE = 3;
    private int[][] array;

    public Matrix() {
        array = new int[DEFAULT_SIZE][DEFAULT_SIZE];
    }

    public Matrix(int[][] array) {
        this.array = array;
    }

    public Matrix(int rows, int column) {
        array = new int[rows][column];
    }


    public Matrix(int size) {
        this(size, size);
    }

    public Matrix(Matrix matrix) {
        this(matrix.array.length, matrix.array[0].length);
        for (int i = 0; i < matrix.array.length; i++) {
            for (int j = 0; j < matrix.array[0].length; j++) {
                array[i][j] = matrix.array[i][j];
            }
        }
    }

    public int getCountRows() {
        return array.length;
    }

    public int getCountColumns() {
        return array[0].length;
    }

    public int getElement(int i, int j) {
        return array[i][j];
    }

    public void setElement(int i, int j, int value) {
        array[i][j] = value;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int[] ints : array) {
            for (int x : ints) {
                builder.append(x).append("  ");

            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
