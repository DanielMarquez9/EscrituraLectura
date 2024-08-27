import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArchivoManager {

    public static void crearArchivo(String directorio, String fichero) {
        // Código del método anterior
    }

    public static int buscarTexto(String nombreFichero, String texto) {
        File archivo = new File(nombreFichero);
        if (!archivo.exists()) {
            System.out.println("El fichero ingresado no existe");
            return -1;
        }

        int contador = 0;
        try (Scanner scanner = new Scanner(archivo)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (linea.equals(texto)) {
                    contador++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("Cantidad de repeticiones del texto -> " + contador);
        return contador;
    }

    public static void main(String[] args) {
        crearArchivo("miDirectorio", "miArchivo");
        buscarTexto("miDirectorio/miArchivo.txt", "Gato");
    }
}
