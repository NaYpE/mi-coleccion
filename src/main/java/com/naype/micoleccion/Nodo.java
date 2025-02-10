package com.naype.micoleccion;

/**
 * Clase que representa un nodo genérico en una lista enlazada.
 * Cada nodo contiene un valor y una referencia al siguiente nodo.
 *
 * @param <T> Tipo de dato que almacenará el nodo.
 */
public class Nodo<T> {
    // Información almacenada en el nodo
    private T info;

    // Referencia al siguiente nodo en la lista (puede ser null si es el último nodo)
    private Nodo<T> referencia;

    /**
     * Constructor por defecto: crea un nodo sin valor y sin referencia.
     */
    public Nodo() {
        this.info = null;
        this.referencia = null;
    }

    /**
     * Constructor que inicializa el nodo con un valor.
     * @param info El valor a almacenar en el nodo.
     */
    public Nodo(T info) {
        this.info = info;
        this.referencia = null;
    }

    /**
     * Constructor que inicializa el nodo con un valor y una referencia al siguiente nodo.
     * @param info El valor a almacenar en el nodo.
     * @param referencia Referencia al siguiente nodo en la lista.
     */
    public Nodo(T info, Nodo<T> referencia) {
        this.info = info;
        this.referencia = referencia;
    }

    /**
     * Obtiene la referencia al siguiente nodo.
     * @return Nodo siguiente en la lista o null si es el último nodo.
     */
    public Nodo<T> getReferencia() {
        return referencia;
    }

    /**
     * Establece la referencia al siguiente nodo.
     * @param referencia Nodo al que debe apuntar este nodo.
     */
    public void setReferencia(Nodo<T> referencia) {
        this.referencia = referencia;
    }

    /**
     * Obtiene el valor almacenado en el nodo.
     * @return El valor del nodo.
     */
    public T getInfo() {
        return info;
    }

    /**
     * Establece un nuevo valor en el nodo.
     * @param info El valor que se asignará al nodo.
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Retorna una representación en cadena del nodo.
     * @return Cadena que representa el valor del nodo.
     */
    @Override
    public String toString() {
        return String.valueOf(info);
    }
}
