import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertarFicheroAleatorio {
    public static void main(String[] args) {
        StringBuffer buffer = null;
        String apellido = "GONZALEZ";
        double salario = 1234.56;
        int dep = 10;
        int id = 4;
        long posicion = (id - 1) * 36;

        try (RandomAccessFile file = new RandomAccessFile(new File("data/AleatorioExample.dat"), "rw")) {
            file.seek(posicion); // Nos posicionamos

            file.writeInt(id);
            buffer = new StringBuffer(apellido);
            buffer.setLength(10); // 10 chars por apellido
            file.writeChars(buffer.toString()); // Inserta el apellido
            file.writeInt(dep); // Inserta el departamento
            file.writeDouble(salario); // Inserta el salario
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}