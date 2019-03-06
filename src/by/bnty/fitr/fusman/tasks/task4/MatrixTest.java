package by.bnty.fitr.fusman.tasks.task4;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void isSymmetry() {
        assertTrue(Matrix.isSymmetry(new int[][]{//test task №1
                {4, 2, 4},
                {2, 6, 3},
                {4, 3, 8}}));

        assertTrue(Matrix.isSymmetry(new int[][]{{1}}));                                //test task №2
        assertTrue(Matrix.isSymmetry(new int[][]{{1, 2}, {2, 43}}));                    //test task №3
    }

    @Test
    public void searchMax() {
        //test task №1

        assertArrayEquals(new int[][]{
                        {111, 2, 3},
                        {4, 1000, 6},
                        {5, 8, 19}},
                Matrix.searchMax(new int[][]{
                        {111, 2, 3},
                        {4, 5, 6},
                        {1000, 8, 19}}));
        //test task №2

        assertArrayEquals(new int[][]{
                        {1, 2, 3, 4, 5},
                        {1, 22, 3, 4, 5},
                        {1, 2, 432, 4, 5},
                        {1, 20, 3, 3, 5},
                        {1, 2, 3, 4, 50}},
                Matrix.searchMax(new int[][]{
                        {1, 2, 3, 4, 5},
                        {1, 22, 3, 4, 5},
                        {1, 2, 3, 4, 5},
                        {1, 20, 3, 432, 5},
                        {1, 2, 3, 4, 50}}));

        //test task №3
        assertArrayEquals(new int[][]{{2}}, Matrix.searchMax(new int[][]{{2}}));

    }


}