/**
 * Codigo tomado de ejemplo de clase de Algoritmos y Estructura de datos de maestro Moises UVG
 * @author Juan Fernando Ramirez
 * @param <K>
 * @param <T>
 */

public class VisitarPalabra<K,T> implements IVisitar<K,T>{

    String listadoElementos;

    public VisitarPalabra() {
        listadoElementos = "";
    }

    /**
     *
     * @param arbol
     */
    @Override
    public void VisitarNodo(NodoArbol<K, T> arbol) {
        Palabra actual = (Palabra) arbol._value;
        //ListadoElementos = ListadoElementos + "";
        listadoElementos += "Ingles: " + actual.inlges + " Frances: " + actual.frances +
                " Espanol: " + actual.espanol + "\r\n";

        System.out.println(listadoElementos);
    }
}
