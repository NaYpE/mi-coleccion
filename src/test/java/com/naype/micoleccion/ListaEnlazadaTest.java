package com.naype.micoleccion;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ListaEnlazadaTest {

    @Test
    public void testAgregarAlFinal() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAlFinal(10);
        lista.agregarAlFinal(20);
        lista.agregarAlFinal(30);

        assertEquals("10, 20, 30", lista.toString());
    }

    @Test
    public void testAgregarAlPrincipio() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAlPrincipio(10);
        lista.agregarAlPrincipio(20);
        lista.agregarAlPrincipio(30);

        assertEquals("30, 20, 10", lista.toString());
    }

    @Test
    public void testBuscarElementoExistente() {
        ListaEnlazada<String> lista = new ListaEnlazada<>();
        lista.agregarAlFinal("A");
        lista.agregarAlFinal("B");
        lista.agregarAlFinal("C");

        Nodo<String> encontrado = lista.buscar("B");
        assertNotNull(encontrado);
        assertEquals("B", encontrado.getInfo());
    }

    @Test
    public void testBuscarElementoNoExistente() {
        ListaEnlazada<String> lista = new ListaEnlazada<>();
        lista.agregarAlFinal("X");
        lista.agregarAlFinal("Y");
        lista.agregarAlFinal("Z");

        Nodo<String> encontrado = lista.buscar("A");
        assertNull(encontrado);
    }

    @Test
    public void testEliminarElementoExistente() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(3);

        Nodo<Integer> eliminado = lista.eliminar(2);
        assertNotNull(eliminado);
        assertEquals(Optional.of(2), Optional.ofNullable(eliminado.getInfo()));
        assertEquals("1, 3", lista.toString());
    }

    @Test
    public void testEliminarElementoNoExistente() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAlFinal(5);
        lista.agregarAlFinal(10);
        lista.agregarAlFinal(15);

        Nodo<Integer> eliminado = lista.eliminar(20);
        assertNull(eliminado);
        assertEquals("5, 10, 15", lista.toString());
    }

    @Test
    public void testEliminarPrimerElemento() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAlFinal(5);
        lista.agregarAlFinal(10);
        lista.agregarAlFinal(15);

        Nodo<Integer> eliminado = lista.eliminar(5);
        assertNotNull(eliminado);
        assertEquals(Optional.of(5), Optional.ofNullable(eliminado.getInfo()));
        assertEquals("10, 15", lista.toString());
    }

    @Test
    public void testEliminarUnicoElemento() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAlFinal(100);

        Nodo<Integer> eliminado = lista.eliminar(100);
        assertNotNull(eliminado);
        assertEquals(Optional.of(100), Optional.ofNullable(eliminado.getInfo()));
        assertEquals("", lista.toString());
    }

    @Test
    public void testToStringListaVacia() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        assertEquals("", lista.toString());
    }
}
