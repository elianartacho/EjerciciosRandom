package ejer1Y2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Contador {
    private static String directorio="src/ejer1Y2/";
    private static String nombre_fichero="enteros.dat";


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try(RandomAccessFile acceso=new RandomAccessFile(directorio+nombre_fichero,"rw")){
            for (int i = 0; i < 6; i++) {
                acceso.writeInt(1);
            }
            for (int i = 0; i < 10; i++) {
                acceso.writeInt(2);
            }
            System.out.println("Registros almacenados correctamente.");
            acceso.seek(0);
            while(acceso.getFilePointer()<acceso.length()){
                int num= acceso.readInt();
                System.out.println("numeros "+num);
            }
            System.out.println("Escriba un numero del 0 al 9: ");
            int numElegido=Integer.parseInt(sc.nextLine());
            acceso.seek(0);
            while (acceso.getFilePointer()< acceso.length()){
                if(acceso.readInt()==2){
                    acceso.seek(acceso.getFilePointer()-4);
                    acceso.writeInt(numElegido);
                }
            }
            acceso.seek(0);
            while(acceso.getFilePointer()<acceso.length()){
                int num= acceso.readInt();
                System.out.print("numeros "+num);
            }

        }catch (IOException e) {
            System.out.println("Error al escribir el fichero.");
            return;
        }


    }
}
