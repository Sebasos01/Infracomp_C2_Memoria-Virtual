package memoria_virtual;

public class TP 
{
	// Representa la tabla de páginas
	// Es un array de entradas
	private Entrada[] tabla;
	
	public TP(int numPaginas) {
		tabla = new Entrada[numPaginas];
	}
}
