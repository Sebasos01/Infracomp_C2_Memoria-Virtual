package memoria_virtual;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TLB 
{
	// Toca crear cache y fila para poder tener un acceso a las traducciones en O(1) y saber a quién sacar en O(1)
	private int[] cache;
	private Queue<Integer> fila;
	private int capacidad;
	
	public TLB(int numEntradas, int numPaginas) {
		cache = new int[numPaginas];
		Arrays.fill(cache, -1); // Establecemos que el cache está vacío
		fila = new LinkedList<>();
	}
	
	public void cargarTraduccion(int paginaVirtual, int traduccion) {
		if (fila.size() == capacidad) {
			cache[fila.poll()] = -1;
		}
		fila.add(paginaVirtual);
		cache[paginaVirtual] = traduccion;
	}
}
