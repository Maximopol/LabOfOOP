package by.bnty.fitr.fusman.lab12.unittest;

import by.bnty.fitr.fusman.lab12.WorkerWithMatrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerWithMatrixTest {

    @Test
    public void searchMinFromMatrix() {
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