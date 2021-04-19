/**
 * Codigo tomado de ejemplo de clase de Algoritmos y Estructura de datos de maestro Moises UVG
 * @author Juan Fernando Ramirez
 * @param <K>
 * @param <T>
 */
public class ArbolBinarioBusqueda<K, T> implements IArbolBinario<K, T> {

    public NodoArbol<K, T> _raiz;
    int _count;
    IComparator<K, T> _keyComparator;
    IKeyCalculator<K, T> _keyCalculator;

    /**
     *
     * @param metodoComparar
     * @param metodoCalcularLlave
     */
    public ArbolBinarioBusqueda(IComparator<K, T> metodoComparar, IKeyCalculator<K, T> metodoCalcularLlave) {
        _keyComparator = metodoComparar;
        _keyCalculator = metodoCalcularLlave;
        _raiz = null;
        _count = 0;
    }

    /**
     *
     * @param key
     * @param value
     */
    @Override
    public void Insert(K key, T value) {
        NodoArbol<K, T> _new = new NodoArbol<K, T>(key, value);

        if (_raiz == null) {
            _raiz = _new;
            _count++;
        } else {
            try {
                InsertAux(_raiz, _new);
            } catch(Exception e) {
                //Manejo de exception
            }

        }
    }

    /**
     *
     * @param _actual
     * @param _new
     * @throws Exception
     */
    private void InsertAux(NodoArbol<K, T> _actual, NodoArbol<K, T> _new) throws Exception{
        if (_actual != null) {

            if (_keyComparator.Compare(_actual._key, _new._key) > 0) { //Entra cuando actual > nuevo Inserta en hijo izquierdo
                if (_actual.hijoIzquierdo == null) { //Puedo insertar en hijo izquierdo
                    _actual.hijoIzquierdo = _new;
                    _count++;
                } else { //Entra cuando no puedo insertar en el hijo izquierdo de actual ya que está ocupado
                    InsertAux(_actual.hijoIzquierdo, _new);
                }
            } else if (_keyComparator.Compare(_actual._key, _new._key) < 0) { //Entra cuando actual < nuevo Inserta en hijo derecho

                if (_actual.hijoDerecho == null) { //Puedo insertar en hijo derecho
                    _actual.hijoDerecho = _new;
                    _count++;
                } else { //Entra cuando no puedo insertar en el hijo derecho de actual ya que está ocupado
                    InsertAux(_actual.hijoDerecho, _new);
                }
            } else {
                throw new Exception("Llaves repetidas");
            }

        }
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public T Delete(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     *
     * @param key
     * @param value
     * @return retorna un nodo para seguir buscando o bien para devolver y poder traducir la palabra correctamente
     */
    @Override
    public T Find( K key, NodoArbol<K,T> value) {
        T temp = null;


        if (value != null) {

            if((value._key).equals(key)){
                temp = value._value;
            }

            if(temp == (null)){
                temp = Find(key, value.hijoIzquierdo);
            }
            if(temp == (null)){
                temp = Find(key, value.hijoDerecho);
            }

        }

        return temp;
    }

    /**
     *
     * @return
     */
    @Override
    public int Count() {
        return _count;
    }

    @Override
    public boolean IsEmpty() {
        return _count == 0;
    }

    @Override
    public void InOrder(IVisitar<K, T> visitNode, NodoArbol<K, T> actual) {
        if (actual != null) {

            InOrder(visitNode, actual.hijoIzquierdo);

            visitNode.VisitarNodo(actual);

            InOrder(visitNode, actual.hijoDerecho);


        }

    }

    /**
     *
     * @param visitNode
     * @param actual
     */
    @Override
    public void PreOrder(IVisitar<K, T> visitNode, NodoArbol<K, T> actual) {
        if (actual != null) {
            visitNode.VisitarNodo(actual);

            PreOrder(visitNode, actual.hijoIzquierdo);

            PreOrder(visitNode, actual.hijoDerecho);
        }

    }

    /**
     *
     * @param visitNode
     * @param actual
     */
    @Override
    public void PostOrder(IVisitar<K, T> visitNode, NodoArbol<K, T> actual) {
        if (actual != null) {

            PostOrder(visitNode, actual.hijoIzquierdo);

            PostOrder(visitNode, actual.hijoDerecho);

            visitNode.VisitarNodo(actual);
        }

    }

}
