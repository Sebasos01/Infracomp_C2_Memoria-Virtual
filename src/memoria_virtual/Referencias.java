package memoria_virtual;

import java.util.ArrayList;

// Aquí se almacenan y acceden las referencias
public class Referencias 
{
	private ArrayList<Integer> referencias;
	
	public Referencias() {
		referencias = new ArrayList<>(1025);
	}
	
	public void almacenarReferencia(int ref) {
		referencias.add(ref);
	}
	
	public void obtenerReferencia(int pos) {
		referencias.get(pos);
	}
	
	public void imprimirReferencias() {
		System.out.println(referencias);
	}
}
