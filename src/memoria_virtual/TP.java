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
	
	public synchronized void add(int pagina)
	{
		if (paginas.size() == marcosRAM)
		{
			//PROCESO ELIMINAR MÁS VIEJO
		}
		paginas.add(pagina);
		historiales.add(0);
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
		//PONERLE EL 1 A historial
	}
}
