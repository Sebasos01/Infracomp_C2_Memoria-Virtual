package memoria_virtual;

public class Actualizador extends Thread
{
	private TP tablaPaginas;
	private Referencias referencias;
	private TLB cache;
	private int marcosRAM;
	
	public Actualizador(Referencias referencias, TP tablaPaginas, TLB cache, int marcosRAM) {
		this.tablaPaginas = tablaPaginas;
		this.referencias = referencias;
		this.cache = cache;
		this.marcosRAM = marcosRAM;
	}

    public void run() {
        // To implement
    }

}
