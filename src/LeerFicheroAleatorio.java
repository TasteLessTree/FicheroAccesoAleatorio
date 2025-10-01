import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class LeerFicheroAleatorio {
    public static void main(String[] args) {
        int id, dep, posicion = 0;
        double salario;
        char[] apellido = new char[10];
        char aux;

        // Lee todos los registros
        System.out.println("==== TODOS LOS REGISTROS ====");
        try (RandomAccessFile file = new RandomAccessFile(new File("data/AleatorioExample.dat"), "r")) {
            // Ejecutar hasta llegar al final del archivo
            while (file.getFilePointer() < file.length()) {
                file.seek(posicion); // Nos ubicamos en la posición
                id = file.readInt(); // Obtenemos el id

                for (int i = 0; i < apellido.length; i++) {
                    aux = file.readChar();
                    apellido[i] = aux;
                }

                String apellidos = new String(apellido); // Obtener apellido
                dep = file.readInt(); // Obtener departamento
                salario = file.readDouble(); // Obtener salario

                System.out.println("ID: " + id + " - APELLIDO: "+ apellidos + " - DEP: " + dep + " - SALARIO: " + salario);

                posicion += 36; // 4 bytes de ID + 20 bytes de APELLIDO + 4 bytes de DEPARTAMENTO + 8 bytes de SALARIO
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Accede a un registro en especifico
        System.out.println("==== ACCESO AL SEGUNDO REGIRSTRO ====");
        try (RandomAccessFile file = new RandomAccessFile(new File("data/AleatorioExample.dat"), "r")) {
            id = 2;
            posicion = (id - 1) * 36;

            if (posicion >= file.length()) {
                System.out.println("No existe el empleado con id: " + id);
            } else {
                file.seek(posicion);
                id = file.readInt();

                aux = ' ';
                for (int i = 0; i < apellido.length; i++) {
                    aux = file.readChar();
                    apellido[i] = aux;
                }

                String apellidos = new String(apellido); // Obtener apellido
                dep = file.readInt(); // Obtener departamento
                salario = file.readDouble(); // Obtener salario

                System.out.println("ID: " + id + " - APELLIDO: " + apellidos + " - DEP: " + dep + " - SALARIO: " + salario);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}