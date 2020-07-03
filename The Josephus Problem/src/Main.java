import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lista obj = new Lista();
		Scanner sc = new Scanner(System.in);
		String n = "";
		while(n.equals("final") == false){
			System.out.print("Digite un nombre: ");
			n = sc.next();
			obj.ins_final(n);
		}
		
		int tam = obj.size;
		obj.escribir_lista(obj.size);
		for(int i = 0; i < tam; i++) {
			obj.eliminar(3);
			obj.escribir_lista(obj.size);
		}

	}

}