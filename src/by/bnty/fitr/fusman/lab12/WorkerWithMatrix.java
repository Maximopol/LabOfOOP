package by.bnty.fitr.fusman.lab12;

//Найти минимальное из чисел, встречающихся в заданной матрице ровно один раз.


import by.bnty.fitr.fusman.lab11.WorkerWithArrays;

//Даны две действительные квадратные матрицы порядка n. Получить новую
//матрицу умножением элементов каждой строки первой матрицы на
//наибольшее из значений элементов соответствующей строки второй матрицы.
public class WorkerWithMatrix {
    public static int searchMinFromMatrix(int[][] mas) {
        for (int[] ma : mas) {
            if (WorkerWithArrays.isAlone(ma, 3)) {
                return 1;
            }

        }
        return 0;
//    public static int[][] multiplyMathixes(int[][] mas1, int[][] mas2) {
//
//        return mas1;
//    }

    }

    public static int[][] multiply(int[][] mas, int[][] mas2) {
        for (int i = 0; i < mas.length; i++) {
            int max = WorkerWithArrays.searchMaxElement(mas2[i]);
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] *= max;
            }

        }

        return mas;
    }
}

