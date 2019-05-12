package by.bnty.fitr.fusman.labs.lab12;

//Найти минимальное из чисел, встречающихся в заданной матрице ровно один раз.


import by.bnty.fitr.fusman.labs.lab11.WorkerWithArrays;
import by.bnty.fitr.fusman.tasks.task4.Matrix;

//Даны две действительные квадратные матрицы порядка n. Получить новую
//матрицу умножением элементов каждой строки первой матрицы на
//наибольшее из значений элементов соответствующей строки второй матрицы.
public class WorkerWithMatrix {

    public static Matrix transpose(Matrix matrix) {
        Matrix matrix1 = new Matrix(matrix.getCountColumns(), matrix.getCountRows());

        for (int i = 0; i < matrix1.getCountRows(); i++) {
            for (int j = 0; j < matrix1.getCountColumns(); j++) {
                matrix1.setElement(i, j, matrix.getElement(j, i));
            }
        }
        return matrix1;
    }

    public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
        Matrix matrix = new Matrix(matrix1.getCountRows(), matrix1.getCountColumns());

        for (int i = 0; i < matrix.getCountRows(); i++) {
            int max = WorkerWithArrays.searchMaxElement(matrix2, i);
            for (int j = 0; j < matrix.getCountColumns(); j++) {
                matrix.setElement(i, j, max * matrix1.getElement(i, j));
            }
        }
        return matrix;
    }
}

