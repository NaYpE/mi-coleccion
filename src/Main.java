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
    }
}