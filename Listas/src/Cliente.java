import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Listas_Simples obj = new Listas_Simples();
		Scanner sc = new Scanner(System.in);
		int n = 0;
		
		System.out.println("Digite un numero: ");
		n = sc.nextInt();
		while(n != -1){
			obj.ins_final(n);
			System.out.println("Digite un numero: ");
			n = sc.nextInt();
		}
		obj.escribir_lista();
		obj.ordenar_lista();
		obj.escribir_lista();
	}

}
