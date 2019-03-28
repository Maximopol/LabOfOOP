package by.bnty.fitr.fusman.tasks.task4;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixWorkerTest {
    @Test
    public void isSymmetry1() {
        assertTrue(MatrixWorker.isSymmetry(new Matrix()));
    }

    @Test
    public void isSymmetry2() {
        Matrix matrix = new Matrix(2);
        matrix.setElement(0, 0, 0);
        matrix.setElement(0, 1, 2);
        matrix.setElement(1, 0, 2);
        matrix.setElement(1, 1, 0);

        assertTrue(MatrixWorker.isSymmetry(matrix));
    }

    @Test
    public void isSymmetry3() {
        assertFalse(MatrixWorker.isSymmetry(new Matrix(3, 2)));
    }

    @Test
    public void isSymmetry4() {
        Matrix matrix3 = new Matrix(1, 1);
        matrix3.setElement(0, 0, 0);
        assertTrue(MatrixWorker.isSymmetry(matrix3));
    }

    @Test
    public void searchMax1() {
        Matrix matrix = new Matrix();
        assertEquals(matrix, MatrixWorker.searchMax(matrix));
    }

    @Test
    public void searchMax2() {
        Matrix matrix1 = new Matrix();

        matrix1.setElement(0, 0, 1);
        matrix1.setElement(0, 1, 1);
        matrix1.setElement(0, 2, 1);

        matrix1.setElement(1, 0, 1);
        matrix1.setElement(1, 1, 10);
        matrix1.setElement(1, 2, 1);

        matrix1.setElement(2, 0, 70);
        matrix1.setElement(2, 1, 1);
        matrix1.setElement(2, 2, 1);

        Matrix matrix2 = new Matrix(matrix1);
        matrix2.setElement(1, 1, 70);
        matrix2.setElement(2, 0, 10);

        matrix1 = MatrixWorker.searchMax(matrix1);
        for (int i = 0; i < matrix1.getCountRows(); i++) {
            for (int j = 0; j < matrix1.getCountRows(); j++) {
                assertEquals(matrix2.getElement(i, j), matrix1.getElement(i, j));
            }
        }
    }

    @Test
    public void searchMax3() {
        Matrix matrix3 = new Matrix(2);
        matrix3.setElement(0, 0, 4);
        matrix3.setElement(0, 1, 8);
        matrix3.setElement(1, 0, 1);
        matrix3.setElement(1, 1, 0);

        Matrix matrix4 = new Matrix(matrix3);
        matrix4.setElement(1, 1, 8);
        matrix4.setElement(0, 1, 0);

        matrix3 = MatrixWorker.searchMax(matrix3);


        for (int i = 0; i < matrix3.getCountRows(); i++) {
            for (int j = 0; j < matrix3.getCountRows(); j++) {
                assertEquals(matrix4.getElement(i, j), matrix3.getElement(i, j));
            }
        }
    }
}