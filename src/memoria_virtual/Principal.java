package memoria_virtual;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Principal
{
	public static void main(String[] args)
	{
		try {
			Scanner in = new Scanner(System.in);
			// Preguntar por entradas del programa
			System.out.print("Ingrese el numero de entradas de la TBL: ");
			int entradasTLB = in.nextInt();
			System.out.print("Ingrese el numero de marcos de pagina en memoria RAM: ");
			int marcosRAM = in.nextInt();
			System.out.print("Ingrese el nombre del archivo con las referencias: ");
			String nombreArchivo = in.next();
			in.close(); // Cerramos el input stream scanner
			
			// Leemos el archivo linea a linea y cargamos las referencias
			BufferedReader lector = new BufferedReader(new FileReader(
					new File("").getAbsolutePath() + "\\archivos\\" + nombreArchivo));
			ArrayList<Integer> referencias = new ArrayList<>(1025);
			String linea = lector.readLine();
			while (linea != null) {
				referencias.add(Integer.valueOf(linea));
				linea = lector.readLine();
			}
			System.out.println(referencias);
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida");
			e.printStackTrace();
			System.exit(1); // Forzamos la salida del programa en caso de error
		} catch (FileNotFoundException e) {
			System.out.println("Error al tratar de encontrar el archivo");
			e.printStackTrace();
			System.exit(1); // Forzamos la salida del programa en caso de error
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
			e.printStackTrace();
			System.exit(1); // Forzamos la salida del programa en caso de error
		} catch (NumberFormatException e) {
			System.out.println("Error al tratar de convertir una referencia leída del archivo en un número");
			e.printStackTrace();
			System.exit(1); // Forzamos la salida del programa en caso de error
		}

		/*
		TIEMPO DIRECCIONES:
			TBL -> 2 ns
			TP -> 30 ns
			FALLO PG -> 2*TP
		
		TIEMPO DATOS:
			RAM ->  30 ns
			FALLO PG -> 10 ns
		*/
	}
}
