package ejer3Y4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Filtrar {
    private static String directorio = "src/ejer3Y4/";
    private static String nombre_fichero = "juego.dat";
    private static int registro = 48;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edadIntroducida = 0;
        String nombreIntroducido = "";
        try (RandomAccessFile puntero = new RandomAccessFile(directorio + nombre_fichero, "r")) {
            System.out.println("Quieres filtrar por: 1.Edad 2.Categoria");
            int res = Integer.parseInt(sc.nextLine());
            if (res == 1) {
                System.out.println("Introduce la edad :");
                edadIntroducida = Integer.parseInt(sc.nextLine());
            }else if(res== 2) {
                System.out.println("Introduce la categoria :");
                nombreIntroducido = sc.nextLine();
            }
            while (puntero.getFilePointer() < puntero.length()) {
                int num = puntero.readInt();
                char[] nombreC = new char[10];
                for (int i = 0; i < nombreC.length; i++) {
                    nombreC[i] = puntero.readChar();
                }
                int edad = puntero.readInt();
                char[] categoriaC = new char[10];
                for (int i = 0; i < categoriaC.length; i++) {
                    categoriaC[i] = puntero.readChar();
                }
                String nombre = new String(nombreC).trim();
                String categoria = new String(categoriaC).trim();
                 if (edad == edadIntroducida) {

                        System.out.println("numero de orden: "+num + " nombre de juego: "+ nombre+ " edad recomendada: "+edad +
                                " categoria: "+categoria);
                    }

                    if(categoria.equalsIgnoreCase(nombreIntroducido)){
                        System.out.println("numero de orden: "+num + " nombre de juego: "+ nombre+ " edad recomendada: "+edad +
                                " categoria: "+categoria);
                    }

                }

        } catch (IOException e) {
            System.out.println("Error al acceder al fichero.");
        }
    }
}