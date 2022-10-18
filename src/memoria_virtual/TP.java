package memoria_virtual;

import java.util.ArrayList;

public class TP 
{
	private ArrayList<Integer> paginas;
	private ArrayList<Integer> historiales;
	private int marcosRAM;
	
	public TP(int marcosRAM)
	{
		this.paginas = new ArrayList<Integer>(marcosRAM);
		this.historiales = new ArrayList<Integer>(marcosRAM);
		this.marcosRAM = marcosRAM;
	}
	
	public synchronized boolean contains(int pagina)
	{
		return paginas.contains(pagina);
	}
	
	public synchronized int add(int pagina)
	{
		int paginaTLB = -1;
		
		if (paginas.size() == marcosRAM)
		{
			ArrayList<Integer> copia = new ArrayList<Integer>(historiales);
			copia.removeIf(n -> n<0);
			copia.sort(null);
			int indice = historiales.indexOf(copia.get(0));
			paginaTLB = paginas.get(indice);
			paginas.remove(indice);
			historiales.remove(indice);
		}
		
		paginas.add(pagina);
		historiales.add(0);
		
		return paginaTLB;
	}
	
	public synchronized void envejecer()
	{
		for (Integer historial: historiales)
		{
			historial >>= 1; 
		}
	}
	
	public synchronized void registrar(int pagina)
	{
		int historial = historiales.get(paginas.indexOf(pagina));
		historial |= ~(2^31-1);
	}
}
