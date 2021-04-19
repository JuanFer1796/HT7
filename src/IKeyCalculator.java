/**
 * Codigo tomado de ejemplo de clase de Algoritmos y Estructura de datos de maestro Moises UVG
 * @author Juan Fernando Ramirez
 * @param <K>
 * @param <T>
 */
public interface IKeyCalculator<K, T> {
    /**
     *
     * @param value
     * @return
     */
    public K GetKey(T value);
}
