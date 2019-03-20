package by.bnty.fitr.fusman.labs.lab12.unittest;

import by.bnty.fitr.fusman.labs.lab12.WorkerWithMatrix;
import by.bnty.fitr.fusman.tasks.task4.Matrix;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class WorkerWithMatrixTest {


    @Test
    public void transpose1() {
        Matrix matrix = new Matrix(2);

        matrix.setElement(0, 0, 1);
        matrix.setElement(0, 1, 2);
        matrix.setElement(1, 0, 3);
        matrix.setElement(1, 1, 4);


        matrix = WorkerWithMatrix.transpose(matrix);

        Matrix matrix1 = new Matrix(2);

        matrix1.setElement(0, 0, 1);
        matrix1.setElement(0, 1, 3);
        matrix1.setElement(1, 0, 2);
        matrix1.setElement(1, 1, 4);

        for (int i = 0; i < matrix.getCountRows(); i++) {
            for (int j = 0; j < matrix.getCountColumns(); j++) {
                assertEquals(matrix1.getElement(i, j), matrix.getElement(i, j));
            }
        }
    }

    @Test
    public void transpose2() {
        Matrix matrix = new Matrix(2, 1);

        matrix.setElement(0, 0, 1);
        matrix.setElement(1, 0, 2);


        matrix = WorkerWithMatrix.transpose(matrix);

        Matrix matrix1 = new Matrix(1, 2);

        matrix1.setElement(0, 0, 1);
        matrix1.setElement(0, 1, 2);


        for (int i = 0; i < matrix.getCountRows(); i++) {
            for (int j = 0; j < matrix.getCountColumns(); j++) {
                assertEquals(matrix1.getElement(i, j), matrix.getElement(i, j));
            }
        }
    }

    @Test
    public void multiply1() {

        Matrix matrix = new Matrix(2, 1);

        matrix.setElement(0, 0, 1);
        matrix.setElement(1, 0, 2);

        Matrix matrix1 = new Matrix(2, 1);

        matrix1.setElement(0, 0, 3);
        matrix1.setElement(1, 0, 4);


        Matrix matrix3 = WorkerWithMatrix.multiply(matrix, matrix1);


        Matrix matrix2 = new Matrix(2, 1);
        matrix2.setElement(0, 0, 3);
        matrix2.setElement(1, 0, 8);


        for (int i = 0; i < matrix.getCountRows(); i++) {
            for (int j = 0; j < matrix.getCountColumns(); j++) {
                assertEquals(matrix2.getElement(i, j), matrix3.getElement(i, j));
            }
        }

    }

    @Test
    public void multiply2() {

        Matrix matrix = new Matrix(2, 2);

        matrix.setElement(0, 0, 1);
        matrix.setElement(0, 1, 2);
        matrix.setElement(1, 0, 3);
        matrix.setElement(1, 1, 4);

        Matrix matrix1 = new Matrix(2, 3);

        matrix1.setElement(0, 0, 5);
        matrix1.setElement(0, 1, 9);
        matrix1.setElement(0, 2, 1);

        matrix1.setElement(1, 0, 10);
        matrix1.setElement(1, 1, 0);
        matrix1.setElement(1, 2, 4);


        Matrix matrix3 = WorkerWithMatrix.multiply(matrix, matrix1);


        Matrix matrix2 = new Matrix(2, 2);
        matrix2.setElement(0, 0, 9);
        matrix2.setElement(0, 1, 18);
        matrix2.setElement(1, 0, 30);
        matrix2.setElement(1, 1, 40);


        for (int i = 0; i < matrix.getCountRows(); i++) {
            for (int j = 0; j < matrix.getCountColumns(); j++) {
                assertEquals(matrix2.getElement(i, j), matrix3.getElement(i, j));
            }
        }

    }

    @Test
    public void multiply3() {

        Matrix matrix = new Matrix(1, 1);

        matrix.setElement(0, 0, 1);


        Matrix matrix1 = new Matrix(1, 2);

        matrix1.setElement(0, 0, 5);
        matrix1.setElement(0, 1, 9);


        Matrix matrix3 = WorkerWithMatrix.multiply(matrix, matrix1);


        Matrix matrix2 = new Matrix(1, 1);
        matrix2.setElement(0, 0, 9);


        for (int i = 0; i < matrix.getCountRows(); i++) {
            for (int j = 0; j < matrix.getCountColumns(); j++) {
                assertEquals(matrix2.getElement(i, j), matrix3.getElement(i, j));
            }
        }

    }
}
