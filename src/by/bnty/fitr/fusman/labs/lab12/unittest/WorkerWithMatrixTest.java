package by.bnty.fitr.fusman.labs.lab12.unittest;

import by.bnty.fitr.fusman.labs.lab12.WorkerWithMatrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerWithMatrixTest {

    @Test
    public void transpose() {
        int[][] mas = WorkerWithMatrix.transpose(new int[][]{{4, 5, 6}, {9, 10, 11}, {100, 200, 300}});
        assertArrayEquals(new int[]{4, 9, 100}, mas[0]);
        assertArrayEquals(new int[]{5, 10, 200}, mas[1]);
        assertArrayEquals(new int[]{6, 11, 300}, mas[2]);
    }

    @Test
    public void multiply() {
        for (int[] mas : WorkerWithMatrix.multiply(new int[][]{{5, 3}}, new int[][]{{5, 10, 54}}
        )) {
            assertArrayEquals(new int[]{270, 162}, mas);

        }

        for (int[] mas : WorkerWithMatrix.multiply(new int[][]{{5, 3, 0}}, new int[][]{{5, 10, 54}}
        )) {
            assertArrayEquals(new int[]{270, 162, 0}, mas);

        }

    }
}