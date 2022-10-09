package memoria_virtual;

import java.util.ArrayList;

// Aquí se almacenan y acceden las referencias
public class Referencias 
{
	private static ArrayList<Integer> referencias;
	
	public static void inicializar() {
		referencias = new ArrayList<>(1025);
	}
	
	public static void almacenarReferencia(int ref) {
		referencias.add(ref);
	}
	
	public static void obtenerReferencia(int pos) {
		referencias.get(pos);
	}
	
	public static void imprimirReferencias() {
		System.out.println(referencias);
	}
}
