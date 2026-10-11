package ejer1Y2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Añadir {
    private static String directorio="src/ejer1Y2/";
    private static String nombre_fichero="enteros.dat";


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try(RandomAccessFile acceso=new RandomAccessFile(directorio+nombre_fichero,"rw")) {
            System.out.println("Escriba un numero del 0 al 9: ");
            int numElegido=Integer.parseInt(sc.nextLine());
            System.out.println("Cuantas veces lo quieres añadir");
            int lon=Integer.parseInt(sc.nextLine());
            acceso.seek(acceso.length());
            for (int i = 0; i< lon; i++) {
                acceso.writeInt(numElegido);

            }
            System.out.println("Escrito correctamente");
            acceso.seek(0);
            while(acceso.getFilePointer()<acceso.length()){
                int num= acceso.readInt();
                System.out.println("numeros "+num);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
