public class ComparadorPalabras<K,T> implements IComparator<K,T>{
    @Override
    public int Compare(K abb1, K abb2) {
        String palabra1 = (String) abb1;
        String palabra2 = (String) abb2;
        return palabra1.compareTo(palabra2);
    }
}
