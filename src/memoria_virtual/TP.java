package memoria_virtual;

import java.util.Arrays;

public class TP 
{
	// Representa la tabla de paginas
	// Es un array de entradas
	private Entrada[] tabla;
	
	public TP(int numPaginas) {
		tabla = new Entrada[numPaginas];
		Arrays.fill(tabla, new Entrada());
	}
	
	public synchronized Entrada obtenerEntrada(int paginaVirtual) {
		return tabla[paginaVirtual];
	}
}
