package memoria_virtual;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class TLB 
{
	// Toca crear cache y fila para poder tener un acceso a las traducciones en O(1) y saber a quien sacar en O(1)
	private HashMap<Integer, Integer> cache;
	private Queue<Integer> fila;
	private int capacidad;
	
	public TLB(int numEntradas) {
		cache = new HashMap<>(numEntradas*2);
		fila = new LinkedList<>();
	}
	
	public void cargarTraduccion(int paginaVirtual, int traduccion) {
		if (fila.size() == capacidad) {
			cache.remove(fila.poll());
		}
		fila.add(paginaVirtual);
		cache.put(paginaVirtual, traduccion);
	}
	
	public Optional<Integer> obtenerTraduccion(int paginaVirtual) {
		Optional<Integer> oTraduccion = Optional.empty();
		if (cache.containsKey(paginaVirtual)) {
			oTraduccion = oTraduccion.of(cache.get(paginaVirtual));
		}
		return oTraduccion;
	}
}
