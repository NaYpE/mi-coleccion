package com.naype.micoleccion;

/**
 * Clase que implementa una colección genérica similar a un arreglo dinámico.
 * Permite insertar, eliminar, buscar y obtener elementos, así como ajustar automáticamente su tamaño.
 *
 * @param <T> Tipo de dato que almacenará la colección.
 */
public class MiColeccion<T> {

    // Arreglo para almacenar los elementos de la colección
    private T[] datos;

    // Número actual de elementos en la colección
    private int len = 0;

    /**
     * Constructor que inicializa la colección con una capacidad inicial.
     * @param capacidadInicial Capacidad inicial del arreglo de datos.
     */
    public MiColeccion(int capacidadInicial) {
        // Inicializa el arreglo con la capacidad especificada
        datos = (T[]) new Object[capacidadInicial];
    }

    /**
     * Obtiene el elemento en la posición especificada.
     * @param i Índice del elemento a obtener.
     * @return El elemento en la posición indicada.
     * @throws IndexOutOfBoundsException Si el índice está fuera de los límites.
     */
    public T obtener(int i) {
        // Verificamos si el índice es válido
        if (i < 0 || i >= len){
            throw new IndexOutOfBoundsException("Índice fuera de los límites: " + i);
        }
        return datos[i];
    }

    /**
     * Devuelve la cantidad actual de elementos en la colección.
     * @return El número de elementos en la colección.
     */
    public int cantidad() {
        return len;
    }

    /**
     * Inserta un elemento en la posición especificada, desplazando los demás elementos.
     * Si el arreglo está lleno, se duplica su capacidad.
     * @param elm El elemento a insertar.
     * @param i El índice en el que se debe insertar el elemento.
     * @throws IndexOutOfBoundsException Si el índice está fuera de los límites.
     */
    public void insertar(T elm, int i) {
        // Verificamos si el índice es válido
        if (i < 0 || i > len) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites: " + i);
        }

        // Si el arreglo está lleno, duplicamos su capacidad
        if (len == datos.length) {
            T[] aux = datos;
            datos = (T[]) new Object[datos.length * 2]; // Doblamos el tamaño
            System.arraycopy(aux, 0, datos, 0, len); // Copiamos los elementos al nuevo arreglo
            aux = null; // Liberamos el arreglo antiguo
        }

        // Desplazamos los elementos hacia la derecha para hacer espacio en la posición i
        for (int j = len - 1; j >= i; j--) {
            datos[j + 1] = datos[j];
        }
        datos[i] = elm; // Insertamos el nuevo elemento
        len++; // Aumentamos el tamaño de la colección
    }

    /**
     * Busca el índice de un elemento en la colección.
     * @param elm El elemento a buscar.
     * @return El índice del elemento, o -1 si no se encuentra.
     */
    public int buscar(T elm) {
        for (int i = 0; i < len; i++) {
            if (datos[i].equals(elm)) {
                return i; // Retorna el índice si encuentra el elemento
            }
        }
        return -1; // Retorna -1 si el elemento no está en la colección
    }

    /**
     * Agrega un elemento al final de la colección.
     * @param elm El elemento a agregar.
     */
    public void agregar(T elm) {
        insertar(elm, len); // Agrega el elemento al final
    }

    /**
     * Elimina el elemento en la posición especificada.
     * @param i Índice del elemento a eliminar.
     * @return El elemento eliminado.
     * @throws IndexOutOfBoundsException Si el índice está fuera de los límites.
     */
    public T eliminar(int i) {
        // Verificamos si el índice es válido
        if (i < 0 || i >= len) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites: " + i);
        }

        T aux = datos[i]; // Guardamos el elemento a eliminar

        // Desplazamos los elementos hacia la izquierda para llenar el vacío
        for (int j = i; j < len - 1; j++) {
            datos[j] = datos[j + 1];
        }

        len--; // Reducimos el tamaño de la colección
        reducirCapacidad(); // Ajustamos la capacidad si es necesario

        return aux; // Retornamos el elemento eliminado
    }

    /**
     * Reduce la capacidad del arreglo a la mitad si la cantidad de elementos es menor al 50%.
     */
    public void reducirCapacidad() {
        if (len < datos.length / 2) {
            T[] aux = (T[]) new Object[datos.length / 2]; // Reducimos el tamaño
            System.arraycopy(datos, 0, aux, 0, len); // Copiamos los elementos al nuevo arreglo
            datos = aux; // Asignamos el nuevo arreglo
        }
    }

    /**
     * Representa la colección en forma de cadena de texto.
     * @return Una cadena que representa los elementos de la colección.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < len; i++) {
            sb.append(datos[i]);
            if (i < len - 1) {
                sb.append(", "); // Añadimos coma entre elementos
            }
        }
        sb.append("]");
        return sb.toString(); // Retornamos la cadena construida
    }
}
