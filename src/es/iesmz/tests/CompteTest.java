package es.iesmz.tests;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompteTest {

    @Test
    void compruebaIban1(){
        Compte c = new Compte("ES6621000418401234567891");
        assertTrue(c.compruebaIban());
    }

    @Test
    void compruebaIban2(){
        Compte c = new Compte("ES6000491500051234567892");
        assertTrue(c.compruebaIban());
    }

    @Test
    void compruebaIban3(){
        Compte c = new Compte("ES9420805801101234567891");
        assertTrue(c.compruebaIban());
    }

    @Test
    void compruebaIban4(){
        Compte c = new Compte("ES7600246912501234567891");
        assertFalse(c.compruebaIban());
    }

    @Test
    void compruebaIban5(){
        Compte c = new Compte("ES4721000418401234567891");
        assertFalse(c.compruebaIban());
    }

    @Test
    void compruebaIban6(){
        Compte c = new Compte("ES8200491500051234567892");
        assertFalse(c.compruebaIban());
    }

    @Test
    void generaIban1(){
        Compte c = new Compte();
        assertEquals("ES7100302053091234567895", c.generaIBAN("0030", "2053","09","1234567895"));
    }

    @Test
    void generaIban2(){
        Compte c = new Compte();
        assertEquals("ES1000492352082414205416", c.generaIBAN("0049","2352","08","2414205416"));
    }

    @Test
    void generaIban3(){
        Compte c = new Compte();
        assertEquals("ES1720852066623456789011", c.generaIBAN("2085","2066","62","3456789011"));
    }

    @Test
    void generaIban4(){
        Compte c = new Compte();
        assertNull(c.generaIBAN("2085", "2066", "62", "3456AE9011"));
    }

    @Test
    void generaIban5(){
        Compte c = new Compte();
        assertNull(c.generaIBAN("208","2066","62","3456789011"));
    }

    @Test
    void generaIban6(){
        Compte c = new Compte();
        assertNull(c.generaIBAN("208","2066","62","3456789011"));
    }

    @Test
    void generaIban7(){
        Compte c = new Compte();
        assertNull(c.generaIBAN("2080", "2086","6","3456789011"));
    }

    @Test
    void generaIban8(){
        Compte c = new Compte();
        assertNull(c.generaIBAN("2080","2086","63","345678911"));
    }
}