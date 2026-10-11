package ejer6Y7;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class CalcularDescuento {
    private static String directorio = "src/ejer6Y7/";
    private static String ficheroPrecio = "precio.dat";
    private static  String ficheroDesc="descuento.dat";

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String nombre = "";
        String apellidos = "";
        String dni = "";
        int numVehiculo = 0;
        int numClases = 0;
        Double cantPago=0.0;

        try (RandomAccessFile leer = new RandomAccessFile(directorio + ficheroPrecio, "r");
             RandomAccessFile escribir = new RandomAccessFile(directorio+ ficheroDesc, "rw")) {

            while (leer.getFilePointer() < leer.length()) {
                char[] nombreC = new char[10];
                for (int i = 0; i < nombreC.length; i++) {
                    nombreC[i] = leer.readChar();
                }
                nombre = new String(nombreC).trim();
                char[] apellidosC = new char[35];
                for (int i = 0; i < apellidosC.length; i++) {
                    apellidosC[i] = leer.readChar();
                }
                apellidos = new String(apellidosC).trim();
                char[] dniC = new char[9];
                for (int i = 0; i < dniC.length; i++) {
                    dniC[i] = leer.readChar();
                    escribir.writeChar(dniC[i]);
                }

                dni = new String(dniC);
                numVehiculo = leer.readInt();
                numClases = leer.readInt();
                cantPago= leer.readDouble();

                System.out.println("que descuento le quiere aplicar al dni: "+dni);
                double descuento= sc.nextDouble();
                double porcent= (cantPago*descuento)/100;
                double precioDesc= cantPago-porcent;
                escribir.writeChars(dni);
                escribir.writeDouble(cantPago);
                escribir.writeDouble(precioDesc);

                System.out.println( " DNI: " + dni +  " Total a pagar: " + Math.round(cantPago)+" Precio con Descuento: "+precioDesc);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero ");
        }

    }

}
