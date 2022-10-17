package memoria_virtual;

public class Envejecimiento extends Thread
{
	private TP tp;
	private boolean continuar;
	
	public Envejecimiento(TP tp)
	{
		this.tp = tp;
		this.continuar = true;
	}

    public void run()
    {
        while (continuar)
        {
    		tp.envejecer();	
        	try {
    			Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
    
    public void kill()
    {
        continuar = false;
    }
	
}
