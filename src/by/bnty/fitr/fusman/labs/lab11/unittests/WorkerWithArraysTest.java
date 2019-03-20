package by.bnty.fitr.fusman.labs.lab11.unittests;

import by.bnty.fitr.fusman.labs.lab11.Arrays;
import by.bnty.fitr.fusman.labs.lab11.WorkerWithArrays;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerWithArraysTest {

    @Test
    public void searchMaxElement1() {
        Arrays arrays = new Arrays(3);
        arrays.setElement(0, 5);
        arrays.setElement(1, 3);
        arrays.setElement(2, 10);
        assertEquals(10, WorkerWithArrays.searchMaxElement(arrays));
    }

    @Test
    public void searchMaxElement2() {
        Arrays arrays = new Arrays(1);
        arrays.setElement(0, 0);
        assertEquals(0, WorkerWithArrays.searchMaxElement(arrays));
    }

    @Test
    public void countZeros1() {

        assertEquals(3, WorkerWithArrays.countZeros(new Arrays()));
    }

    @Test
    public void countZeros2() {
        Arrays arrays = new Arrays(2);
        arrays.setElement(0, 1);
        arrays.setElement(1, 1);
        assertEquals(0, WorkerWithArrays.countZeros(arrays));
    }

    @Test
    public void searchIndexOfMinElement1() {
        Arrays arrays = new Arrays(4);
        arrays.setElement(0, 9);
        arrays.setElement(1, 10);
        arrays.setElement(2, 0);
        arrays.setElement(3, 32);
        assertEquals(2, WorkerWithArrays.searchIndexOfMinElement(arrays));

    }

    @Test
    public void searchIndexOfMinElement2() {
        Arrays arrays = new Arrays(1);
        arrays.setElement(0, 0);

        assertEquals(0, WorkerWithArrays.searchIndexOfMinElement(arrays));
    }

    @Test
    public void sumElementsAfterMin1() {
        Arrays arrays = new Arrays(4);
        arrays.setElement(0, 9);
        arrays.setElement(1, 0);
        arrays.setElement(2, 7);
        arrays.setElement(3, 32);
        assertEquals(39, WorkerWithArrays.sumElementsAfterMin(arrays, WorkerWithArrays.searchIndexOfMinElement(arrays)));

    }

    @Test
    public void sumElementsAfterMin2() {
        Arrays arrays = new Arrays(1);
        arrays.setElement(0, 2);

        assertEquals(0, WorkerWithArrays.sumElementsAfterMin(arrays, WorkerWithArrays.searchIndexOfMinElement(arrays)));

    }

    @Test
    public void sumElementsAfterMin3() {
        Arrays arrays = new Arrays(4);
        arrays.setElement(0, 9);
        arrays.setElement(1, 2);
        arrays.setElement(2, 7);
        arrays.setElement(3, 1);
        assertEquals(0, WorkerWithArrays.sumElementsAfterMin(arrays, WorkerWithArrays.searchIndexOfMinElement(arrays)));

    }

}
