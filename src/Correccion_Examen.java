
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Correccion_Examen {

    public static void listarFicherosPorCarpeta(File carpeta) {
        //realizamos un for para recorrer la carpeta del archivo:
        for (File ficheroEntrada : carpeta.listFiles()) {
            //si es un directorio lo que esta dentro del archivo que pasamos volvera a mirar dentro:
            if (ficheroEntrada.isDirectory()) {
                listarFicherosPorCarpeta(ficheroEntrada);
            } else {
                //si no imprimirá el fichero lo que tiene dentro:
                 System.out.println("El contenido es: ");
                //Leer texto del fichero escrito:
                try (FileReader fr = new FileReader(ficheroEntrada)) {
                    int caracter = fr.read();
                    while (caracter != -1) {
                        System.out.print((char) caracter);
                        caracter = fr.read();
                    }fr.close();
                }catch (IOException e) {
                    System.out.println("Problema con la lectura en el fichero " + e);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        //1º PARTE LEER 1 ARCHIVO:
        //Ruta para introducir ejemplo -->  C:\Users\DAW\Documents\NetBeansProjects\Examen_Ordinaria\Bomberos\2017.csv
//       Scanner leer = new Scanner(System.in);
//       System.out.println("Introduce la ruta del fichero");
//       String ruta = leer.nextLine();

//       File archivo = new File(ruta);

        //2º PARTE
        File archivo = new File("C:\\Users\\DAW\\Documents\\NetBeansProjects\\Examen_Ordinaria\\Bomberos");
        listarFicherosPorCarpeta(archivo);
    }
}
