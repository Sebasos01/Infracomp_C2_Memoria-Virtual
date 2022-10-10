package memoria_virtual;

import java.util.ArrayList;

public class Actualizador extends Thread
{
	private TP tablaPaginas;
	private ArrayList<Integer> referencias;
	private TLB cache;
	private int marcosRAM;
	
	public Actualizador(ArrayList<Integer> referencias, TP tablaPaginas, TLB cache, int marcosRAM) {
		this.tablaPaginas = tablaPaginas;
		this.referencias = referencias;
		this.cache = cache;
		this.marcosRAM = marcosRAM;
	}

    public void run() {
        try
        {
			Thread.sleep(2);
		}
        catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

}
