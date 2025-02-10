package com.naype.micoleccion;

public class Nodo<T> {
    private T info;
    private Nodo<T> referencia;

    public Nodo<T> getReferencia() {
        return referencia;
    }

    public void setReferencia(Nodo<T> referencia) {
        this.referencia = referencia;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
