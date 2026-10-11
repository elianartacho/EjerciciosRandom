package ejer3Y4;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import static java.lang.String.format;

public class Juego {
    private static String directorio="src/ejer3Y4/";
    private static String nombre_fichero="juego.dat";
    private static int registro=48;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        try(RandomAccessFile escribir= new RandomAccessFile(directorio+nombre_fichero,"rw")){
            escribir.seek(escribir.length());
            System.out.println("Que cantidad de juegos quieres introducir");
            int cant= Integer.parseInt(sc.nextLine());

            for (int i = 0; i < cant; i++) {
                int id=(int)((escribir.length()/registro)+1);
                System.out.println("Escribe el nombre del juego");
                String nombre= format("%-10s",sc.nextLine());
                System.out.println("Edad minima recomentada");
                int edad= Integer.parseInt(sc.nextLine());
                System.out.println("Clasificacion segun su tematica");
                String categoria=format("%-10s",sc.nextLine());

                escribir.writeInt(id);
                escribir.writeChars(nombre);
                escribir.writeInt(edad);
                escribir.writeChars(categoria);

            }

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(RandomAccessFile fichero=new RandomAccessFile(directorio + nombre_fichero, "r")){
            fichero.seek(0);
            while(fichero.getFilePointer()< fichero.length()){
                int num = fichero.readInt();
                char[] nombreC = new char[10];
                for (int i = 0; i < nombreC.length; i++) {
                    nombreC[i] = fichero.readChar();
                }
                int edad = fichero.readInt();
                char[] categoriaC = new char[10];
                for (int i = 0; i < categoriaC.length; i++) {
                    categoriaC[i] = fichero.readChar();
                }
                String nombre = new String(nombreC).trim();
                String categoria = new String(categoriaC).trim();
                System.out.println("numero de orden: "+num + " nombre de juego: "+ nombre+ " edad recomendada: "+edad +
                        " categoria: "+categoria);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }
    }

}
