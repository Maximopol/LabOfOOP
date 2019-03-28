package by.bnty.fitr.fusman.simpletube.registerandaauthorization;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterTest {

    @Test
    public void isCheckedTrueInputEmail1() {
        assertFalse(Register.isCheckedTrueInputEmail("maximopolnate@gmail.com  maximopolnate@gmail.com"));
    }

    @Test
    public void isCheckedTrueInputEmail2() {
        assertFalse(Register.isCheckedTrueInputEmail("lol@@com"));
    }

    @Test
    public void isCheckedTrueInputEmail3() {
        assertFalse(Register.isCheckedTrueInputEmail(""));
    }

    @Test
    public void isCheckedTrueInputEmail4() {
        assertTrue(Register.isCheckedTrueInputEmail("maximopolnate@gmail.com"));
    }
}