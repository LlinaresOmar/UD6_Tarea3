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
        Compte c = new Compte("ES8200491500051234567892");
        assertEquals("ES7100302053091234567895", c.generaIBAN("0030", "2053","09","1234567895"));
    }
}