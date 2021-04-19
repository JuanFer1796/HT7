/**
 * Codigo tomado de ejemplo de clase de Algoritmos y Estructura de datos de maestro Moises UVG
 * @author Juan Fernando Ramirez
 * @param <K>
 * @param <T>
 */
public class KeyPalabra<K,T> implements IKeyCalculator<K,T> {
    /**
     *
     * @param value
     * @return devuelve una llave para crear el arbol correctamente
     */
    @Override
    public K GetKey(T value) {
        Palabra actual = (Palabra) value;
        return (K)actual.inlges;
    }


}
