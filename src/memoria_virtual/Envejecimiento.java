package memoria_virtual;

public class Envejecimiento extends Thread
{
	private int[][] tp;
	
	public Envejecimiento(int[][] tp) {
		this.tp = tp;
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
