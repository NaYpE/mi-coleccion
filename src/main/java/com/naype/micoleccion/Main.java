package com.naype.micoleccion;

public class Main {
    public static void main(String[] args) {
        MiColeccion<String> coleccion = new MiColeccion<>(2);
        coleccion.agregar("Hola");
        coleccion.agregar("Mundo");
        coleccion.insertar("Java", 1);

        System.out.println(coleccion);
        System.out.println("Cantidad: " + coleccion.cantidad());

        coleccion.eliminar(1);
        System.out.println(coleccion);
        System.out.println("Cantidad: " + coleccion.cantidad());

        ListaEnlazada<Integer> x = new ListaEnlazada<Integer>();

        x.agregarAlFinal(4);
        x.agregarAlFinal(5);
        x.agregarAlFinal(6);

        x.agregarAlPrincipio(3);
        x.agregarAlPrincipio(2);
        x.agregarAlPrincipio(1);

        System.out.println(x);
        System.out.println(x.buscar(6));
        System.out.println(x.buscar(15));
        x.eliminar(3);
        System.out.println(x);

    }
}