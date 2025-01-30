package com.naype.micoleccion;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MiColeccionTest {

    @Test
    public void testAgregarYObterner() {
        MiColeccion<String> coleccion = new MiColeccion<>(2);
        coleccion.agregar("Hola");
        coleccion.agregar("Mundo");

        assertEquals("Hola", coleccion.obtener(0));
        assertEquals("Mundo", coleccion.obtener(1));
    }

    @Test
    public void testInsertar() {
        MiColeccion<Integer> coleccion = new MiColeccion<>(3);
        coleccion.agregar(10);
        coleccion.agregar(30);
        coleccion.insertar(20, 1);

        assertEquals(Integer.valueOf(10), coleccion.obtener(0));
        assertEquals(Integer.valueOf(20), coleccion.obtener(1));
        assertEquals(Integer.valueOf(30), coleccion.obtener(2));
    }

    @Test
    public void testEliminar() {
        MiColeccion<String> coleccion = new MiColeccion<>(2);
        coleccion.agregar("Hola");
        coleccion.agregar("Mundo");

        String eliminado = coleccion.eliminar(0);
        assertEquals("Hola", eliminado);
        assertEquals("Mundo", coleccion.obtener(0));
        assertEquals(1, coleccion.cantidad());
    }

    @Test
    public void testBuscar() {
        MiColeccion<String> coleccion = new MiColeccion<>(2);
        coleccion.agregar("Hola");
        coleccion.agregar("Mundo");

        assertEquals(0, coleccion.buscar("Hola"));
        assertEquals(1, coleccion.buscar("Mundo"));
        assertEquals(-1, coleccion.buscar("Java"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testObtenerFueraDeLimites() {
        MiColeccion<String> coleccion = new MiColeccion<>(2);
        coleccion.obtener(10);  // Esto debería lanzar una excepción
    }

    @Test
    public void testToString() {
        MiColeccion<String> coleccion = new MiColeccion<>(2);
        coleccion.agregar("Hola");
        coleccion.agregar("Mundo");
        assertNotNull(coleccion.toString());
    }
}