package memoria_virtual;

public class Util {
	
	private static int proximoMultiplo(int a, int b)
	{
		while (a % b != 0) {
			a++;
		}
		return a;
	}

}
