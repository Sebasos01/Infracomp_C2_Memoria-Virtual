package memoria_virtual;

import java.util.ArrayList;
import java.util.Queue;

public class Actualizador extends Thread
{
	private int[][] tp;
	private Queue<Integer> referencias;
	private Queue tlb;
	private int marcosRAM;
	
	public Actualizador(Queue<Integer> referencias, int[][] tp, Queue tlb, int marcosRAM) {
		this.tp = tp;
		this.referencias = referencias;
		this.tlb = tlb;
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
