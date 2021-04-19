import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Codigo tomado de ejemplo de clase de Algoritmos y Estructura de datos de maestro Moises UVG
 * @author Juan Fernando Ramirez
 */
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

        /*
        Se insertan valores a los arboles
         */
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

        /**
         * empieza el programa
         */
        String salir = "no";
        while(salir.equals("no")){
            Scanner teclado = new Scanner(System.in);

            System.out.println("*******Traduccion de Textos*******");
            System.out.println("1. Traducir " +
                    "\n2. Ver datos de diccionario" +
                    "\n3. salir");
            String s = teclado.nextLine();

            if(s.equals("1")){
                String traduccion = "";
                System.out.println(" *** Idioma de texto a traducir *** ");
                System.out.println("1. Inglés\n" +
                        "2. Frances" +
                        "\n3. Español");
                String s2 = teclado.nextLine();
            /*
            ingles
             */
                if (s2.equals("1")){
                    String archivo = "Traduccion.txt";
                    ArrayList<String> traducir = traducciones(archivo);
                    System.out.println(" *** Idioma de traducción *** ");
                    System.out.println("1. Español" +
                            "\n2. Francés");
                    String s3 = teclado.nextLine();
                    if(s3.equals("1")){

                        for (int i = 0; i< traducir.size(); i++){
                            String texto = traducir.get(i);
                            Palabra palabra = abIngles.Find(texto,abIngles._raiz);
                            if(palabra!= null){
                                String temp = palabra.espanol;
                                traduccion = traduccion + temp +" ";
                            }else{
                                String temp = "*" + traducir.get(i) +"*";
                                traduccion = traduccion + temp + " ";
                            }
                        }
                    }else if(s3.equals("2")){

                        for (int i = 0; i< traducir.size(); i++){
                            String texto = traducir.get(i);
                            Palabra palabra = abIngles.Find(texto,abIngles._raiz);
                            if(palabra!= null){
                                String temp = palabra.frances;
                                traduccion = traduccion + temp +" ";
                            }else{
                                String temp = "*" + traducir.get(i) +"*";
                                traduccion = traduccion + temp + " ";
                            }
                        }
                    }

                }
            /*
            frances
             */
                else if (s2.equals("2")){
                    String archivo = "Traduccionfr.txt";
                    ArrayList<String> traducir = traducciones(archivo);
                    System.out.println(" *** Idioma de traducción *** ");
                    System.out.println("1. Ingles" +
                            "\n2. Espanol");
                    String s3 = teclado.nextLine();
                    if(s3.equals("1")){

                        for (int i = 0; i< traducir.size(); i++){
                            String texto = traducir.get(i);
                            Palabra palabra = abFrances.Find(texto,abFrances._raiz);
                            if(palabra!= null){
                                String temp = palabra.inlges;
                                traduccion = traduccion + temp +" ";
                            }else{
                                String temp = "*" + traducir.get(i) +"*";
                                traduccion = traduccion + temp + " ";
                            }
                        }
                    }else if(s3.equals("2")){

                        for (int i = 0; i< traducir.size(); i++){
                            String texto = traducir.get(i);
                            Palabra palabra = abFrances.Find(texto,abFrances._raiz);
                            if(palabra!= null){
                                String temp = palabra.espanol;
                                traduccion = traduccion + temp +" ";
                            }else{
                                String temp = "*" + traducir.get(i) +"*";
                                traduccion = traduccion + temp + " ";
                            }
                        }
                    }

                }
            /*
            espanol
             */
                else if (s2.equals("3")){
                    String archivo = "Traducciones.txt";
                    ArrayList<String> traducir = traducciones(archivo);
                    System.out.println(" *** Idioma de traducción *** ");
                    System.out.println("1. Ingles" +
                            "\n2. frances");
                    String s3 = teclado.nextLine();
                    if(s3.equals("1")){

                        for (int i = 0; i< traducir.size(); i++){
                            String texto = traducir.get(i);
                            Palabra palabra = abEspanol.Find(texto,abEspanol._raiz);
                            if(palabra!= null){
                                String temp = palabra.inlges;
                                traduccion = traduccion + temp +" ";
                            }else{
                                String temp = "*" + traducir.get(i) +"*";
                                traduccion = traduccion + temp + " ";
                            }
                        }
                    }else if(s3.equals("2")){

                        for (int i = 0; i< traducir.size(); i++){
                            String texto = traducir.get(i);
                            Palabra palabra = abEspanol.Find(texto,abEspanol._raiz);
                            if(palabra!= null){
                                String temp = palabra.espanol;
                                traduccion = traduccion + temp +" ";
                            }else{
                                String temp = "*" + traducir.get(i) +"*";
                                traduccion = traduccion + temp + " ";
                            }
                        }

                    }

                }
                System.out.println(traduccion);
            } else if(s.equals("2")) {
                System.out.println("Mostrar diccionario ordenado por idioma");
                System.out.println("1. Ingles" +
                        "\n2. Español" +
                        "\n3. Frances");
                String opcion = teclado.nextLine();
                if(opcion.equals("1")) {
                    abIngles.InOrder(new VisitarPalabra<>(), abIngles._raiz);
                }
                else if(opcion.equals("2")) {
                    abEspanol.InOrder(new VisitarPalabra<>(), abEspanol._raiz);
                }
                else if(opcion.equals("3")) {
                    abFrances.InOrder(new VisitarPalabra<>(), abFrances._raiz);
                }

            }else if(s.equals("3")){
                salir = "si";
            }
        }




        /*System.out.println(" *** LISTADO DE PALABRAS EN ARCHIVO (IN ORDER)*** ");
        abIngles.InOrder(new VisitarPalabra<>("Ejemplo.txt"), abIngles._raiz);
*/



    }



public static  ArrayList<String> traducciones(String archivo) {
    ArrayList<String> traducir = new ArrayList<String>();
    String[] traduTemp = new String[0];
    try {
        File miArchivo = new File(archivo);
        Scanner myReader = new Scanner(miArchivo);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            traduTemp = line.split(" ");


        }
    } catch (
            IOException e) {
        System.out.print("Error" + e.getMessage());
        e.printStackTrace();
    }
        /*
        Se llena el array para poder traducir oración
         */
    for (int i = 0; i < traduTemp.length; i++) {
        traducir.add(traduTemp[i]);
    }
    return traducir;
}
}




