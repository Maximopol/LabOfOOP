package by.bnty.fitr.fusman.lab12;

//Найти минимальное из чисел, встречающихся в заданной матрице ровно один раз.


import by.bnty.fitr.fusman.lab11.WorkerWithArrays;

//Даны две действительные квадратные матрицы порядка n. Получить новую
//матрицу умножением элементов каждой строки первой матрицы на
//наибольшее из значений элементов соответствующей строки второй матрицы.
public class WorkerWithMatrix {

    public static int[][] transpose(int[][] mas) {
        int[][] new_mas = new int[mas[0].length][mas.length];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                new_mas[j][i] = mas[i][j];
            }
        }

        return new_mas;
    }

    public static int[][] multiply(int[][] mas, int[][] mas2) {
        int[][] mas3 = new int[mas.length][];
        for (int i = 0; i < mas.length; i++) {
            int max = WorkerWithArrays.searchMaxElement(mas2[i]);
            for (int j = 0; j < mas[i].length; j++) {
                mas3[i][j] = max * mas[i][j];
                // mas[i][j] *= max;
            }

        }

        return mas3;
    }
}

