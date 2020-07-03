import java.util.ArrayList;

public class Reinas {
	
	private static boolean q[] = new boolean[1];
	private static boolean[]a = new boolean[9];
	private static boolean[]b = new boolean[17];
	private static boolean[]c = new boolean[16];
	private static int[]x = new int[9];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<9; i++) {
			a[i] = true;
		}
		for(int i=0; i<17; i++) {
			b[i] = true;
		}
		for(int i=0; i<16; i++) {
			c[i] = true;
		}
		
		q[0] = true;
		intentar(1, q);
		
		for(int i=1; i<9; i++) {
			System.out.println("("+(i)+", "+x[i]+")");
		}
	}
	
	public static void intentar(int i, boolean q[]) {
		int j=0;
		do {
			j++;
			q[0] = false;
			if(a[j] && b[i+j] && c[i-j+7]){
				x[i] = j;
				a[j] = false;
				b[i+j] = false;
				c[i-j+7] = false;
				
				if(i < 8) {
					intentar(i+1, q);
					if(q[0] == false) {
						a[j] = true;
						b[i+j] = true;
						c[i-j+7] = true;
					}
				}
				else {
					q[0] = true;
				}
			}
			
		}while(j != 8  && q[0] == false);
	}
}
