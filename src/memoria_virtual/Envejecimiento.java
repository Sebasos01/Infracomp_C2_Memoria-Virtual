package memoria_virtual;

public class Envejecimiento extends Thread
{
	private TP tablaPaginas;
	
	public Envejecimiento(TP tablaPaginas) {
		this.tablaPaginas = tablaPaginas;
	}

    public void run() {
        while (true)
        {
    		try
    		{
				Thread.sleep(1);
			}
    		catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
	
}
