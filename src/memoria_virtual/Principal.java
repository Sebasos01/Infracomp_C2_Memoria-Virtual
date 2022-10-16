package memoria_virtual;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Principal
{
	private static final int NUM_PAGINAS = 64;
	
	public static void main(String[] args)
	{
		try {
			Scanner in = new Scanner(System.in);
			System.out.print("Ingrese el numero de entradas de la TLB: ");
			int entradasTLB = in.nextInt();
			System.out.print("Ingrese el numero de marcos de pagina en memoria RAM: ");
			int marcosRAM = in.nextInt();
			System.out.print("Ingrese el nombre del archivo con las referencias: ");
			String nombreArchivo = in.next();
			in.close();
			
			BufferedReader lector = new BufferedReader(new FileReader(
					new File("").getAbsolutePath() + "\\archivos\\" + nombreArchivo));
			
			Queue<Integer> referencias = new LinkedList<>();
			
			String linea = lector.readLine();
			while (linea != null) {
				referencias.add(Integer.valueOf(linea));
				linea = lector.readLine();
			}
			lector.close();

			Queue<Integer> tlb = new LinkedList<>();
			int[][] tp = new int[NUM_PAGINAS][2];
			
			Actualizador actualizador = new Actualizador(referencias, tp, tlb, marcosRAM);
			Envejecimiento envejecimiento = new Envejecimiento(tp);
			
			actualizador.start();
			envejecimiento.start();
			
		} catch (InputMismatchException e) {
			System.out.println("Entrada invalida");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Error al tratar de encontrar el archivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Error al tratar de convertir una referencia leida del archivo a numero");
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
