package src.memoria_virtual;

import java.util.Scanner;
public class Principal
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		try {
			System.out.print("Ingrese el numero de entradas de la TBL: ");
			int entradasTLB = in.nextInt();
			System.out.print("Ingrese el numero de marcos de pagina en memoria RAM: ");
			int marcosRAM = in.nextInt();
			System.out.print("Ingrese el nombre del archivo con las referencias: ");
			String nombreArchivo = in.next();
		} catch (Exception e) {
			System.out.println("Entrada inválida");
			System.exit(1);
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
