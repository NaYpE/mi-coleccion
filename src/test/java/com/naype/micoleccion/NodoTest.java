package com.naype.micoleccion;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class NodoTest {

    @Test
    public void testSetAndGetInfo() {
        Nodo<Integer> nodo = new Nodo<>();
        nodo.setInfo(10);
        assertEquals(Optional.of(10), Optional.ofNullable(nodo.getInfo()));
    }

    @Test
    public void testSetAndGetReferencia() {
        Nodo<String> nodo1 = new Nodo<>();
        nodo1.setInfo("A");

        Nodo<String> nodo2 = new Nodo<>();
        nodo2.setInfo("B");

        nodo1.setReferencia(nodo2);

        assertNotNull(nodo1.getReferencia());
        assertEquals("B", nodo1.getReferencia().getInfo());
    }

    @Test
    public void testReferenciaIsNullByDefault() {
        Nodo<Double> nodo = new Nodo<>();
        assertNull(nodo.getReferencia());
    }
}
