package ejer6Y7;

import java.io.IOException;
import java.io.RandomAccessFile;

import static java.lang.String.format;

public class CalcularPrecio {
    private static String directorio = "src/ejer5/";

    private static String fichero = "practicas.dat";

    private static String directorio2 = "src/ejer6Y7/";
    private static String ficheroPrecio = "precio.dat";

    public static void main(String[] args) {
        String nombre = "";
        String apellidos = "";
        String dni = "";
        int numVehiculo = 0;
        int numClases = 0;

        try (RandomAccessFile leer = new RandomAccessFile(directorio + fichero, "r");
             RandomAccessFile escribir = new RandomAccessFile(directorio2 + ficheroPrecio, "rw")) {

            while (leer.getFilePointer() < leer.length()) {
                char[] nombreC = new char[10];
                for (int i = 0; i < nombreC.length; i++) {
                    nombreC[i] = leer.readChar();
                    escribir.writeChar(nombreC[i]);

                }
                nombre = new String(nombreC);
                char[] apellidosC = new char[35];
                for (int i = 0; i < apellidosC.length; i++) {
                    apellidosC[i] = leer.readChar();
                    escribir.writeChar(apellidosC[i]);
                }
                apellidos = new String(apellidosC);
                char[] dniC = new char[9];
                for (int i = 0; i < dniC.length; i++) {
                    dniC[i] = leer.readChar();
                    escribir.writeChar(dniC[i]);
                }

                dni = new String(dniC);
                numVehiculo = leer.readInt();
                numClases = leer.readInt();

                Double cantPago = numClases * 45.7;
                escribir.writeInt(numVehiculo);
                escribir.writeInt(numClases);
                escribir.writeDouble(cantPago);

                System.out.println("Nombre:" + nombre + " Apellidos: " + apellidos + " DNI: " + dni + " numero de vehiculo " + numVehiculo + " numero de clases: " + numClases + " Total a pagar: " + Math.round(cantPago));
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero ");
        }

    }

}


