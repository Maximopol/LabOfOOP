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


//    public static int[][] searchMax(Matrix matrix) {
//        int posx = 0, posy = 0;
//        int length = matrix.getCountRows();
//        int max = matrix.getElement(posx,posy);
//
//        for (int i = 0; i < length; i++) {
//            if (max < matrix.getElement(i,i)) {
//                max = matrix.getElement(i,i);
//                posx = posy = i;
//            }
//        }
//        for (int i = length - 1, j = 0; i != 0; i--, j++) {
//            if (max <matrix.getElement(i,j)) {
//                max = matrix.getElement(i,j);
//                posx = i;
//                posy = j;
//            }
//        }
//        if (length % 2 != 0) {
//
//           // array[posx][posy] = array[length / 2][length / 2];
//            //array[length / 2][length / 2] = max;
//        }
//
//      //  return array;
//    }

}

