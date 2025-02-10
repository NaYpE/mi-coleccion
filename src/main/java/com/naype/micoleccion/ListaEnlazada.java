package com.naype.micoleccion;

/**
 * Clase que implementa una lista enlazada genérica.
 * Permite agregar, buscar y eliminar elementos.
 */
public class ListaEnlazada<T> {
    // Referencia al primer nodo de la lista
    private Nodo<T> primer = null;

    /**
     * Agrega un nuevo elemento al final de la lista.
     * @param valor El valor que se añadirá a la lista.
     */
    public void agregarAlFinal(T valor) {
        // Creamos un nuevo nodo con el valor proporcionado
        Nodo<T> nuevo = new Nodo<>();
        nuevo.setInfo(valor);

        // Si la lista está vacía, el nuevo nodo será el primero
        if (primer == null) {
            primer = nuevo;
            return;
        }

        // Recorremos la lista hasta encontrar el último nodo
        Nodo<T> aux = primer;
        while (aux.getReferencia() != null) {
            aux = aux.getReferencia();
        }

        // Enlazamos el nuevo nodo al final de la lista
        aux.setReferencia(nuevo);
    }

    /**
     * Agrega un nuevo elemento al inicio de la lista.
     * @param valor El valor que se añadirá al principio de la lista.
     */
    public void agregarAlPrincipio(T valor) {
        // Creamos un nuevo nodo con el valor proporcionado
        Nodo<T> nuevo = new Nodo<>();
        nuevo.setInfo(valor);

        // El nuevo nodo apuntará al primer nodo actual
        nuevo.setReferencia(primer);

        // Ahora el nuevo nodo se convierte en el primero de la lista
        primer = nuevo;
    }

    /**
     * Busca un nodo que contenga el valor especificado.
     * @param valor El valor a buscar en la lista.
     * @return El nodo que contiene el valor o null si no se encuentra.
     */
    public Nodo<T> buscar(T valor) {
        Nodo<T> aux = primer;

        // Recorremos la lista hasta encontrar el valor o llegar al final
        while (aux != null) {
            if (aux.getInfo().equals(valor)) {
                return aux; // Retornamos el nodo encontrado
            }
            aux = aux.getReferencia();
        }

        return null; // Retornamos null si el valor no está en la lista
    }

    /**
     * Elimina un nodo que contenga el valor especificado.
     * @param valor El valor del nodo que se desea eliminar.
     * @return El nodo eliminado o null si el valor no existe en la lista.
     */
    public Nodo<T> eliminar(T valor) {
        Nodo<T> actual = primer;
        Nodo<T> anterior = null;

        // Buscamos el nodo que contiene el valor especificado
        while (actual != null && !actual.getInfo().equals(valor)) {
            anterior = actual;
            actual = actual.getReferencia();
        }

        // Si el nodo no fue encontrado, retornamos null
        if (actual == null) {
            return null;
        }

        // Si el nodo a eliminar es el primero de la lista
        if (anterior == null) {
            primer = actual.getReferencia(); // Eliminamos el primer nodo
        } else {
            // Si el nodo está en el medio o al final, ajustamos referencias
            anterior.setReferencia(actual.getReferencia());
        }

        return actual; // Retornamos el nodo eliminado
    }

    /**
     * Retorna una representación en cadena de la lista enlazada.
     * @return Una cadena con los elementos de la lista separados por comas.
     */
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        Nodo<T> aux = primer;

        // Recorremos la lista y agregamos cada valor al resultado
        while (aux != null) {
            resultado.append(aux.getInfo());
            if (aux.getReferencia() != null) {
                resultado.append(", ");
            }
            aux = aux.getReferencia();
        }

        return resultado.toString(); // Retornamos la representación de la lista
    }
}
