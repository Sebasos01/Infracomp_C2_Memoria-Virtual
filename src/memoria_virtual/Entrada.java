package memoria_virtual;

public class Entrada 
{
	// La traduccion de pagina virtual a marco de pagina fisica
	private int traduccion;
	
	// Sirve para saber desde hace cuanto no se referencia esta pagina
	// si contador a es menor que contador b, significa que la pagina b se referencia despues que la pagina a
	private long contador;
	
	// Indica si la pagina fue referenciada recientemente (en el ciclo actual)
	private boolean R;
	
	public Entrada() {
		// -1 significa que la pagina no esta en memoria fisica
		// En un principio, por default, todas las paginas estan asi (por revisar)
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
