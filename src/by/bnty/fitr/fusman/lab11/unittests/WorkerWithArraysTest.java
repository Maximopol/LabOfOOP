package by.bnty.fitr.fusman.lab11.unittests;

import by.bnty.fitr.fusman.lab11.WorkerWithArrays;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerWithArraysTest {

    @Test
    public void searchMaxElement(){
        assertEquals(10,WorkerWithArrays.searchMaxElement(new int[]{5,3,10}));//test case № 1
        assertEquals(0,WorkerWithArrays.searchMaxElement(new int[]{0}));//test case № 2
        assertEquals(36,WorkerWithArrays.searchMaxElement(new int[]{5,36,10}));//test case № 3
    }
    @Test
    public void countZeros() {

        assertEquals(0, WorkerWithArrays.countZeros(new double[]{23, 2}));//test case № 1

        assertEquals(2, WorkerWithArrays.countZeros(new double[]{23, 2, 0, 0}));//test case № 2
    }

    @Test
    public void searchIndexOfMinElement() {
        assertEquals(3, WorkerWithArrays.searchIndexOfMinElement(new int[]{9, 10, 32, 0}));//test case № 1
    }

    @Test
    public void sumElementsAfterMin() {
        int[] mas = new int[]{9, 0, 32, 7};
        int pozition = WorkerWithArrays.searchIndexOfMinElement(mas);
        assertEquals(39, WorkerWithArrays.sumElementsAfterMin(mas, pozition));
        //  assertEquals(39.0,WorkerWithArrays.sumElementsAfterMin(mas,WorkerWithArrays.searchIndexOfMinElement(mas)));
    }

    @Test
    public void isAlone() {

    }

}
