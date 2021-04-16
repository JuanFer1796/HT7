import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VisitarPalabra<K,T> implements IVisitar<K,T>{
    File archivo;
    String listadoElementos;

    public VisitarPalabra(String path) {
        archivo = new File(path);
        listadoElementos = "";
    }

    @Override
    public void VisitarNodo(NodoArbol<K, T> arbol) {
        Palabra actual = (Palabra) arbol._value;
        //ListadoElementos = ListadoElementos + "";
        listadoElementos += "Ingles: " + actual.inlges + " Frances: " + actual.frances +
                " Espanol: " + actual.espanol + "\r\n";
        System.out.println(listadoElementos);
        try {
            FileWriter fw = new FileWriter(archivo, false);
            fw.write(listadoElementos );
            fw.close();
        }catch(IOException e) {
            e.printStackTrace();
        }

    }
}
