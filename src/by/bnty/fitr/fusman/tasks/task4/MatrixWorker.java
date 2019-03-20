package by.bnty.fitr.fusman.tasks.task4;

public class MatrixWorker {
    public static boolean isSymmetry(Matrix matrix) {
        return matrix.getCountColumns() == matrix.getCountRows() && Symmetry(matrix);
    }

    private static boolean Symmetry(Matrix matrix) {
        for (int i = 0; i < matrix.getCountRows(); i++) {

            for (int j = 1; j < matrix.getCountColumns(); j++) {

                if (matrix.getElement(i, j) != matrix.getElement(j, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Matrix searchMax(Matrix matrix) {
        return matrix.getCountRows() == matrix.getCountColumns() ? Search(matrix) : matrix;
    }

    private static Matrix Search(Matrix matrix) {
        int posx = 0, posy = 0,
                length = matrix.getCountColumns(),
                maxEl = matrix.getElement(posx, posy);

        for (int i = 0; i < length; i++) {
            if (maxEl < matrix.getElement(i, i)) {
                maxEl = matrix.getElement(i, i);
                posx = posy = i;
            }
        }

        for (int i = 0, j = length - 1; i < length; i++, j--) {
            if (maxEl < matrix.getElement(i, j)) {
                maxEl = matrix.getElement(i, j);
                posx = i;
                posy = j;
            }
        }

        int xx = matrix.getElement(posx, posy);
        matrix.setElement(posx, posy, matrix.getElement(length / 2, length / 2));
        matrix.setElement(length / 2, length / 2, xx);

        return matrix;
    }

}

