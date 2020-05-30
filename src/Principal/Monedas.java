package Principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Monedas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Digite el numero de monedas: ");
		int n = Integer.parseInt(br.readLine());
		
		System.out.print("Digite el numero de vueltas: ");
		int vueltas = Integer.parseInt(br.readLine());
		
		int monedas[] = new int[n+1];
		int matriz[][] = new int[n+1][vueltas+1];
		String imprimir[][] = new String[n+1][vueltas+1];
		
		monedas[0] = 0;
		for(int i=1; i<n+1; i++) {
			System.out.print("Digite valor de la moneda "+(i)+": ");
			monedas[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=i+1; j<n+1; j++) {
				if(monedas[i] > monedas[j]) {
					int temp = monedas[i];
					monedas[i] = monedas[j];
					monedas[j] = temp;
				}
			}
		}
		
		for(int i=0; i<vueltas+1; i++) {
			matriz[0][i] = 32797;
			imprimir[0][i] = "inf";
		}
		
		for(int i=0; i<n+1; i++) {
			imprimir[i][0]="0  0:0";
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<vueltas+1; j++) {
				if(i==1 && j<monedas[i]){
					matriz[i][j] = 32797;
					imprimir[i][j] = "inf";
				}
				else if(i==1){
					matriz[i][j] = 1 + matriz[i][j-monedas[i]];
					if(matriz[i][j] < 32790) {
						imprimir[i][j] = ""+matriz[i][j];
						for(int z=0; z<matriz[i][j]; z++) {
							imprimir[i][j] += "  1:"+monedas[i];	
						}
					}
					else {
						imprimir[i][j] = "inf";
					}
				}
				else if(j < monedas[i]) {
					matriz[i][j] = matriz[i-1][j];
					if(matriz[i][j] < 32790) {
						imprimir[i][j] = imprimir[i-1][j];
					}
					else
						imprimir[i][j] = "inf";
				}
				else {
					matriz[i][j] = minimo(matriz[i-1][j], 1+matriz[i][j-monedas[i]]);
					if(matriz[i][j] == 1+matriz[i][j-monedas[i]]) {
						
						imprimir[i][j] = matriz[i][j]+" "+imprimir[i][j-monedas[i]]+" 1:"+monedas[i];
					}
					else {
						imprimir[i][j] = matriz[i][j]+" "+imprimir[i-1][j];
					}
				}
			}
		}
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<vueltas+1; j++) {
				System.out.print(imprimir[i][j]+"           ");
			}
			System.out.println("");
			System.out.println("");
			System.out.println("");
		}
	}
	
	public static int minimo(int a, int b) {
		
		int min = a<b ? a:b;
		return min;
	}

}
