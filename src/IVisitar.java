/**
 * Codigo tomado de ejemplo de clase de Algoritmos y Estructura de datos de maestro Moises UVG
 * @author Juan Fernando Ramirez
 * @param <K>
 * @param <T>
 */public interface IVisitar<K, T> {
    /**
     *
     * @param arbol
     */
    public void VisitarNodo(NodoArbol<K, T> arbol);
}
