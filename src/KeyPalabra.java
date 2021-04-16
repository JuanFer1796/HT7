public class KeyPalabra<K,T> implements IKeyCalculator<K,T> {
    @Override
    public K GetKey(T value) {
        Palabra actual = (Palabra) value;
        return (K)actual.inlges;
    }


}
