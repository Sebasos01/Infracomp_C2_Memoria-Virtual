package memoria_virtual;

import java.util.Queue;

public class Actualizador extends Thread
{
	private TP tp;
	private Queue<Integer> referencias;
	private Queue<Integer> tlb;
	private int entradasTLB;
	
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
					Principal.fallos += 1;
					tp.add(referencia);
					Principal.tiempoDirecciones += 60;
					Principal.tiempoDatos += 10000000;
				}
				else
				{
					Principal.tiempoDirecciones += 30;
					Principal.tiempoDatos += 30;
				}
				
				tp.registrar(referencia);
				
				if (tlb.size() == entradasTLB)
				{
					tlb.remove();
				}
				tlb.add(referencia);
			}
			else
			{
				Principal.tiempoDirecciones += 2;
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }
}
