package memoria_virtual;

public class Entrada 
{
	// La traducción de página virtual a marco de página física
	private int traduccion;
	
	// Sirve para saber desde hace cuanto no se referencia esta página
	// si contador a es menor que contador b, significa que la página b se referenció después que la página a
	private long contador;
	
	// Indica si la pagina fue referenciada recientemente (en el ciclo actual)
	private boolean R;
	
	public Entrada() {
		// -1 significa que la página no está en memoria física
		// En un principio, por default, todas las páginas están así (por revisar)
		traduccion = -1;
	}
	
	public synchronized int obtenerTraduccion() {
		return traduccion;
	}
	
	public synchronized long obtenerContador() {
		return contador;
	}
	
	public synchronized boolean obtenerR() {
		return R;
	}
	
	public synchronized void establecerTraduccion(int mp) {
		traduccion = mp;
	}
	
	public synchronized void establecerContador(long c) {
		contador = c;
	}
	
	public synchronized void establecerR(boolean r) {
		R = r;
	}

}
