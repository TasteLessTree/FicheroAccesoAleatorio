import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFicheroAleatorio {
    public static void main(String[] args) {
        String[] apellidos = {"FERNANDEZ", "GIL", "LOPEZ"};
        int[] dep = {10, 20, 10};
        double[] salario = {1000.45, 2400.60, 3000.0};

        try (RandomAccessFile file = new RandomAccessFile(new File("data/AleatorioExample.dat"), "rw")) {
            StringBuffer buffer = null; // Almace el apellido
            int apellido = apellidos.length;

            for (int i = 0; i < apellido; i++) {
                file.writeInt(i + 1); // Identificar el empledo
                buffer = new StringBuffer(apellidos[i]);
                buffer.setLength(10); // 10 chars por apellido
                file.writeChars(buffer.toString()); // Inserta el apellido
                file.writeInt(dep[i]); // Inserta el departamento
                file.writeDouble(salario[i]); // Inserta el salario
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}