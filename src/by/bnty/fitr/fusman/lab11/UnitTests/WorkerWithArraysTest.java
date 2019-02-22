package by.bnty.fitr.fusman.lab11.UnitTests;

import by.bnty.fitr.fusman.lab11.WorkerWithArrays;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerWithArraysTest {

    @Test
    public void countZeros() {
        assertEquals(0, WorkerWithArrays.countZeros(new double[]{23, 2}));

        assertEquals(2, WorkerWithArrays.countZeros(new double[]{23, 2,0,0}));
    }


}
