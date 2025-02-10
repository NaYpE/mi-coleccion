package com.naype.micoleccion;

public class ListaEnlazada <T>{
    // Referencia al primer nodo de la lista
    private Nodo<T> primer = null;

    public void agregarAlFinal(T valor){
        // Creamos un nuevo nodo
        Nodo<T> nuevo = new Nodo<T>();
        nuevo.setReferencia(null);
        nuevo.setInfo(valor);

        // Si la lista aun no tiene elementos...
        if (primer == null){
            // El nuevo nodo será el primero
            primer = nuevo;
            return;
        }

        // Creamos un nodo auxiliar
        Nodo<T> aux;
        // Recorremos hasta que aux apunte al ultimo nodo
        for(aux = primer; aux.getReferencia() != null; aux=aux.getReferencia());

        // Enlazamos el nuevo nodo como siguiente del ultimo
        aux.setReferencia(nuevo);
    }

    public void agregarAlPrincipio(T valor){
        Nodo<T> nuevo = new Nodo<T>();
        nuevo.setReferencia(primer);
        nuevo.setInfo(valor);
        primer = nuevo;
    }

    public Nodo<T> buscar(T valor){
        Nodo<T> aux = primer;
        while(aux != null && !aux.getInfo().equals(valor)){
            aux = aux.getReferencia();
        }
        return aux;
    }

    public Nodo<T> eliminar(T valor){
        Nodo<T> actual = primer;
        Nodo<T> anterior = null;

        // Buscamos el nodo
        while (actual != null && !actual.getInfo().equals(valor)){
            anterior = actual;
            actual = actual.getReferencia();
        }

        // Encontrado al principio
        if(actual != null && anterior == null){
            Nodo<T> ret = actual;
            primer = actual.getReferencia();
            return ret;
        }

        // Encontrado en otra posicion
        if(actual != null && anterior != null){
            Nodo<T> ret = actual;
            anterior.setReferencia(actual.getReferencia());
            return ret;
        }
        return null;
    }

    @Override
    public String toString(){
        String x = "";
        Nodo<T> aux = primer;
        while(aux != null){
            x += "" + aux.getInfo() + (aux.getReferencia() != null ? ", ": "");
            aux = aux.getReferencia();
        }
        return x;
    }
}
