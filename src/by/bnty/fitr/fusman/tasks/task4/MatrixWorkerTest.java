package by.bnty.fitr.fusman.tasks.task4;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MatrixWorkerTest {
    @Test
    public void isSymmetry() {


        assertTrue(MatrixWorker.isSymmetry(new Matrix()));  //test task №1

        Matrix matrix = new Matrix(2, 2);
        matrix.setElement(0, 0, 0);
        matrix.setElement(0, 1, 2);
        matrix.setElement(1, 0, 2);
        matrix.setElement(1, 1, 0);

        assertTrue(MatrixWorker.isSymmetry(matrix));        //test task №2

        assertTrue(!MatrixWorker.isSymmetry(new Matrix(3, 2)));        //test task №3

        Matrix matrix3 = new Matrix(1, 1);
        matrix3.setElement(0, 0, 0);
        assertTrue(MatrixWorker.isSymmetry(matrix3));        //test task №3
    }

//    @Test
//    public void searchMax() {
//        //test task №1
//
//        assertArrayEquals(new int[][]{
//                        {111, 2, 3},
//                        {4, 1000, 6},
//                        {5, 8, 19}},
//                MatrixWorker.searchMax(new int[][]{
//                        {111, 2, 3},
//                        {4, 5, 6},
//                        {1000, 8, 19}}));
//        //test task №2
//
//        assertArrayEquals(new int[][]{
//                        {1, 2, 3, 4, 5},
//                        {1, 22, 3, 4, 5},
//                        {1, 2, 432, 4, 5},
//                        {1, 20, 3, 3, 5},
//                        {1, 2, 3, 4, 50}},
//                MatrixWorker.searchMax(new int[][]{
//                        {1, 2, 3, 4, 5},
//                        {1, 22, 3, 4, 5},
//                        {1, 2, 3, 4, 5},
//                        {1, 20, 3, 432, 5},
//                        {1, 2, 3, 4, 50}}));
//
//        //test task №3
//        assertArrayEquals(new int[][]{{2}}, MatrixWorker.searchMax(new int[][]{{2}}));
//
//    }


}