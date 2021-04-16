import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ArbolBinarioBusqueda<String, Palabra> abIngles;
        abIngles = new ArbolBinarioBusqueda<String, Palabra>(new ComparadorPalabras<String, Palabra>(),
                new KeyPalabra<String, Palabra>());

        ArbolBinarioBusqueda<String, Palabra> abEspanol;
        abEspanol = new ArbolBinarioBusqueda<String, Palabra>(new ComparadorPalabras<String, Palabra>(),
                new KeyPalabra<String, Palabra>());

        ArbolBinarioBusqueda<String, Palabra> abFrances;
        abFrances = new ArbolBinarioBusqueda<String, Palabra>(new ComparadorPalabras<String, Palabra>(),
                new KeyPalabra<String, Palabra>());

        try {
            File miArchivo = new File("Palabras.txt");
            Scanner myReader = new Scanner(miArchivo);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] values = line.split(",");
                abIngles.Insert(values[0], new Palabra(
                                values[2]
                                , values[0]
                                , values[1]
                        )
                );

                abEspanol.Insert(values[1], new Palabra(
                        values[2]
                        , values[0]
                        , values[1]
                        )
                );

                abFrances.Insert(values[2], new Palabra(
                        values[2]
                        , values[0]
                        , values[1]
                        )
                );
            }
        }catch(
                IOException e) {
            System.out.print("Error" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println(" *** LISTADO DE PALABRAS EN ARCHIVO (IN ORDER)*** ");
        abIngles.InOrder(new VisitarPalabra<>("Ejemplo.txt"), abIngles._raiz);
        System.out.println(abEspanol._raiz._key);
        System.out.println(abEspanol.Find("mujer"));
    }





}
