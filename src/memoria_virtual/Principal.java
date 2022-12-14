package memoria_virtual;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal
{
	public static int fallos = 0;
	public static long tiempoDatos = 0;
	public static long tiempoDirecciones = 0;
	
	public static void main(String[] args) throws InterruptedException
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
			
			BufferedReader lector = new BufferedReader(new FileReader("./data/" + nombreArchivo));
			
			ArrayList<Integer> referencias = new ArrayList<>();
			
			String linea = lector.readLine();
			while (linea != null)
			{
				referencias.add(Integer.parseInt(linea));
				linea = lector.readLine();
			}
			lector.close();

			ArrayList<Integer> tlb = new ArrayList<>();
			TP tp = new TP(marcosRAM);
			
			Actualizador actualizador = new Actualizador(referencias, tp, tlb, entradasTLB);
			Envejecimiento envejecimiento = new Envejecimiento(tp);
			
			actualizador.start();
			envejecimiento.start();
			
			actualizador.join();
			envejecimiento.kill();
			
			System.out.println("\nFallos: " + fallos
					+ "\nTiempo carga de datos: " + tiempoDatos + " ns"
					+ "\nTiempo traduccion direcciones: " + tiempoDirecciones + " ns");
			
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
	}
}
