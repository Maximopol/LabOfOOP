package by.bnty.fitr.fusman.labs.lab11;

import by.bnty.fitr.fusman.tasks.task4.Matrix;

//В векторе, состоящем из n вещественных элементов, вычислить: количество
//элементов вектора, равных 0 и сумму элементов вектора, расположенных после минимального элемента.
public class WorkerWithArrays {

    public static int countZeros(Arrays arrays) {
        int count = 0;
        for (int i = 0; i < arrays.getLength(); i++) {
            if (arrays.getElement(i) == 0) {
                count++;
            }
        }

        return count;
    }


    public static int searchIndexOfMinElement(Arrays arrays) {
        int position = 0;
        for (int i = 0; i < arrays.getLength(); i++) {
            if (arrays.getElement(i) < arrays.getElement(position)) {
                position = i;
            }
        }
        return position;
    }

    public static int searchMaxElement(Arrays arrays) {
        int Max = arrays.getElement(0);
        for (int i = 0; i < arrays.getLength(); i++) {
            if (Max < arrays.getElement(i)) {
                Max = arrays.getElement(i);
            }
        }
        return Max;
    }

    public static int searchMaxElement(Matrix matrix, int pos) {
        int Max = matrix.getElement(pos, 0);
        for (int i = 0; i < matrix.getCountColumns(); i++) {
            if (Max < matrix.getElement(pos, i)) {
                Max = matrix.getElement(pos, i);
            }
        }
        return Max;
    }


    public static int sumElementsAfterMin(Arrays arrays, int positionMin) {
        int sum = 0;
        if (positionMin != arrays.getLength() - 1) {
            for (int i = positionMin; i < arrays.getLength(); i++) {
                sum += arrays.getElement(i);
            }
        }
        return sum;
    }
}

