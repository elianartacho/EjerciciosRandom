package ejer5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import static java.lang.String.format;

public class CrearAlumnos {
    private static  String directorio="src/ejer5/";
    private static String fichero= "practicas.dat";
    private static int registro= 123;

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.println("Indique la cantidad de alumnos que desea guardar");
        int cant= Integer.parseInt(sc.nextLine());

        try(RandomAccessFile escribir= new RandomAccessFile(directorio+fichero,"rw")){
            escribir.seek(escribir.length());
            for (int i = 0; i < cant; i++) {
                System.out.println("Introduce el nombre del alumno: ");
                String nombre= format("%-10s",sc.nextLine());
                System.out.println("Introduce los apellidos: ");
                String apellidos=format("%-35s",sc.nextLine());
                System.out.println("Introduce el DNI: ");
                String dni= format("%-9s",sc.nextLine());
                System.out.println("Introduce el numero del vehiculo: ");
                int numVehiculo= Integer.parseInt(sc.nextLine());
                System.out.println("Introduce el numero de clases practicas: ");
                int numClases= Integer.parseInt(sc.nextLine());
                escribir.writeChars(nombre);
                escribir.writeChars(apellidos);
                escribir.writeChars(dni);
                escribir.writeInt(numVehiculo);
                escribir.writeInt(numClases);
                System.out.println("escrito correctamente");
            }


        } catch (IOException e) {
            System.out.println("Error al escribir el fichero ");
        }

        try (RandomAccessFile leer=new RandomAccessFile(directorio+fichero,"r")){
            leer.seek(0);
            while (leer.getFilePointer()< leer.length()){
                char [] nombreC= new char[10];
                for (int i = 0; i < nombreC.length; i++) {
                    nombreC[i]= leer.readChar();
                }
                String nombre= new String(nombreC).trim();
                char[] apellidosC= new  char[35];
                for (int i = 0; i < apellidosC.length; i++) {
                    apellidosC[i]= leer.readChar();
                }
                String apellidos= new String(apellidosC).trim();
                char[] dniC= new char[9];
                for (int i = 0; i <dniC.length ; i++) {
                    dniC[i]= leer.readChar();
                }
                String dni= new String(dniC).trim();

                int numVehiculo= leer.readInt();
                int numClases=leer.readInt();

                System.out.println("Nombre completo "+ nombre + " "+apellidos +" DNI: "+dni+ " numero de vehiculo "+ numVehiculo+ " numero de clases: " +numClases);
            }

        }catch (IOException e) {
            System.out.println("Error al leer el fichero ");
        }
        sc.close();

    }
}
