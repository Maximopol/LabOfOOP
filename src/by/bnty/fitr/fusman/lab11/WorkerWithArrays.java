package by.bnty.fitr.fusman.lab11;

//В векторе, состоящем из n вещественных элементов, вычислить: количество
//элементов вектора, равных 0 и сумму элементов вектора, расположенных после минимального элемента.
public class WorkerWithArrays {
    public static int countZeros(double[] mas) {
        int count = 0;
        for (double element : mas) {
            if (element == 0.0) {
                count++;
            }
        }

        return count;
    }

    public static int searchIndexOfMinElement(double[] mas) {
        int position = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < mas[position]) {
                position = i;
            }
        }
        return position;
    }

    public static double sumElementsAfterMin(double[] mas, int positionMin) {
        double sum = 0;
        for (int i = positionMin; i < mas.length; i++) {
            sum += mas[i];
        }
        return sum;
    }
}
