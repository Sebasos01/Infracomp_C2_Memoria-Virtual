package memoria_virtual;

import java.util.Queue;

public class Actualizador extends Thread
{
	private TP tp;
	private Queue<Integer> referencias;
	private Queue<Integer> tlb;
	private int entradasTLB;
	private static int tiempo = 0;
	
	public Actualizador(Queue<Integer> referencias, TP tp, Queue<Integer> tlb, int entradasTLB) {
		this.tp = tp;
		this.referencias = referencias;
		this.tlb = tlb;
		this.entradasTLB = entradasTLB;
	}

    public void run() {
		for (Integer referencia: referencias)
		{
			if (!tlb.contains(referencia))
			{
				if (!tp.contains(referencia))
				{
					//Fallo de página
					tp.add(referencia);
					tiempo += 10000060;
				}
				else
				{
					tiempo += 30;
				}
				
				tp.registrar(referencia);
				
				if (tlb.size() == entradasTLB)
				{
					tlb.remove();
				}
				tlb.add(referencia);
				tiempo += 30;
			}
			else
			{
				tiempo += 2;
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }
}
