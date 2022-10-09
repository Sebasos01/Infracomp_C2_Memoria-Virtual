package memoria_virtual;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Principal
{
	public static void main(String[] args)
	{
		try {
			Scanner in = new Scanner(System.in);
			// Preguntar por entradas del programa
			System.out.print("Ingrese el numero de entradas de la TLB: ");
			int entradasTLB = in.nextInt();
			System.out.print("Ingrese el numero de marcos de pagina en memoria RAM: ");
			int marcosRAM = in.nextInt();
			System.out.print("Ingrese el nombre del archivo con las referencias: ");
			String nombreArchivo = in.next();
			in.close(); // Cerramos el input stream scanner
			
			// Leemos el archivo linea a linea y cargamos las referencias
			BufferedReader lector = new BufferedReader(new FileReader(
					new File("").getAbsolutePath() + "\\archivos\\" + nombreArchivo));
			Referencias referencias = new Referencias();
			String linea = lector.readLine();
			while (linea != null) {
				referencias.almacenarReferencia(Integer.valueOf(linea));
				linea = lector.readLine();
			}
			referencias.imprimirReferencias();
			
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Error al tratar de encontrar el archivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Error al tratar de convertir una referencia leída del archivo en un número");
			e.printStackTrace();
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
