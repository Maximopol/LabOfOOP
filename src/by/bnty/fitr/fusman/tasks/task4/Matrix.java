package by.bnty.fitr.fusman.tasks.task4;

public class Matrix {
    public static boolean isSymmetry(int[][] array) {
        for (int i = 0; i < array.length; i++) {

            for (int j = 1; j < array[0].length; j++) {

                if (array[i][j] != array[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] searchMax(int[][] array) {
        int posx = 0, posy = 0;
        int length = array.length;
        int max = array[posx][posy];

        for (int i = 0; i < length; i++) {
            if (max < array[i][i]) {
                max = array[i][i];
                posx = posy = i;
            }
        }
        for (int i = length - 1, j = 0; i != 0; i--, j++) {
            if (max < array[i][j]) {
                max = array[i][j];
                posx = i;
                posy = j;
            }
        }
        if (length % 2 != 0) {
            array[posx][posy] = array[length / 2][length / 2];
            array[length / 2][length / 2] = max;
        }

        return array;
    }

}

