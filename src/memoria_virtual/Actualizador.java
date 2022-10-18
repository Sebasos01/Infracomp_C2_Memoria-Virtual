package memoria_virtual;

import java.util.ArrayList;

public class Actualizador extends Thread
{
	private TP tp;
	private ArrayList<Integer> referencias;
	private ArrayList<Integer> tlb;
	private int entradasTLB;
	
	public Actualizador(ArrayList<Integer> referencias, TP tp, ArrayList<Integer> tlb, int entradasTLB) {
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
					int pagina = tp.add(referencia);
					
					if (pagina >= 0 && tlb.contains(pagina))
					{
						tlb.remove(tlb.indexOf(pagina));
					}
					
					Principal.tiempoDirecciones += 60;
					Principal.tiempoDatos += 10000000;
				}
				else
				{
					Principal.tiempoDirecciones += 30;
					Principal.tiempoDatos += 30;
				}
				
				if (tlb.size() == entradasTLB)
				{
					tlb.remove(0);
				}
				
				tlb.add(referencia);
			}
			else
			{
				Principal.tiempoDirecciones += 2;
			}
			
			tp.registrar(referencia);
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }
}
