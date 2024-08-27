import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ArchivoManager {

    public static void crearArchivo(String directorio, String fichero) {
        File dir = new File(directorio);
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                System.out.println("Directorio creado: " + directorio);
            } else {
                System.out.println("Error al crear directorio");
                return;
            }
        } else {
            System.out.println("El directorio ya existe.");
        }

        File archivo = new File(dir, fichero + ".txt");
        try (FileWriter writer = new FileWriter(archivo)) {
            ArrayList<String> lista = new ArrayList<>();
            lista.add("Perro");
            lista.add("Gato");
            lista.add("Juan");
            lista.add("Daniel");
            lista.add("Juan");
            lista.add("Gato");
            lista.add("Perro");
            lista.add("Camila");
            lista.add("Daniel");
            lista.add("Camila");

            Iterator<String> it = lista.iterator();
            while (it.hasNext()) {
                writer.write(it.next() + System.lineSeparator());
            }
            System.out.println("Archivo escrito exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        crearArchivo("miDirectorio", "miArchivo");
    }
}
