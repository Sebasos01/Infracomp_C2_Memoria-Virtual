package memoria_virtual;

public class Envejecimiento extends Thread
{
	private TP tp;
	
	public Envejecimiento(TP tp)
	{
		this.tp = tp;
	}

    public void run()
    {
        while (true)
        {
    		tp.envejecer();	
        	try {
    			Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
	
}
