public class MiColeccion<T> {

    private T[] datos  = null;
    private int len = 0;

    public MiColeccion(int capacidadInicial) {
        datos = (T[]) new Object[capacidadInicial];
    }

    public T obtener(int i) {
        if (i < 0 || i >= len){
            throw new IndexOutOfBoundsException("Indice fuera de los limites: " + i);
        }
        return datos[i];
    }

    public int cantidad(){
        return len;
    }

    public void insertar(T elm, int i) {
        if (i < 0 || i > len){
            throw new IndexOutOfBoundsException("Indice fuera de los limites: " + i);
        }
        if (len == datos.length) {
            T[] aux = datos;
            datos = (T[]) new Object[datos.length * 2];
            for (int j = 0; j < len; j++) {
                datos[j] = aux[j];
            }
            aux = null;
        }
        for (int j = len - 1; j >= i; j--) {
            datos[j + 1] = datos[j];
        }
        datos[i] = elm;
        len++;
    }

    public int buscar(T elm) {
        int i = 0;
        for ( ; i < len && !datos[i].equals(elm); i++);
        return i < len ? i : -1;
    }

    public void agregar(T elm){
        insertar(elm, len);
    }

    public T eliminar(int i){
        if (i < 0 || i >= len){
            throw new IndexOutOfBoundsException("Indice fuera de los limites: " + i);
        }
        T aux = datos[i];
        for(int j = i; j < len-1; j++){
            datos[j] = datos[j+1];
        }
        len--;
        reducirCapacidad();
        return aux;
    }

    public void reducirCapacidad(){
        if(len < datos.length / 2){
            T[] aux = (T[]) new Object[datos.length / 2];
            for (int j = 0; j < len; j++){
                aux[j] = datos[j];
            }
            datos = aux;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < len; i++){
            sb.append(datos[i]);
            if(i < len - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
