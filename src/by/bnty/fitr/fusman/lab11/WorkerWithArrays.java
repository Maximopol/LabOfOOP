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


    public static int searchIndexOfMinElement(int[] mas) {
        int position = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < mas[position]) {
                position = i;
            }
        }
        return position;
    }

    public static boolean isAlone(int[] mas, int lol) {
        int count = 0;
        for (int ma : mas) {
            if (ma == lol) {
                count++;
            }
        }
        return count == 1;
    }

    public static int sumElementsAfterMin(int[] mas, int positionMin) {
        int sum = 0;
        for (int i = positionMin; i < mas.length; i++) {
            sum += mas[i];
        }
        return sum;
    }

//    public static boolean isRepeat(int[] mas){
//        for (;;){
//            if(true){
//
//            }
//        }
//
//        return false;
//    }
}

