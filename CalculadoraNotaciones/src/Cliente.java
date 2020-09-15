import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculadora calc = new Calculadora();
		
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		System.out.println("Digite una operacion: ");
		
        String entrada = entradaEscaner.nextLine(); //Invocamos un método sobre un objeto Scanner
        String[] ab = entrada.split(" ");
        
		//String[] infijo = {"2", "+", "3", "*", "4", "+", "7", "#"};
		
        //System.out.println(infijo.length);
        /*
        if(ab[0].equals(infijo[0])) {
        	System.out.println("hola mundo");
        }
        */
		String[] posfijo = new String[ab.length+1];
		
		calc.inAPos(ab, posfijo);
		
		Pila operandos = new Pila();
		operandos.initPila();
		
		
		double resul;
		for(int i=0; i<posfijo.length; i++) {
			if(posfijo[i] != null) {
				if(isNumeric(posfijo[i])) {
					operandos.insPila(posfijo[i]);
				}
				else if(!operandos.pilaVacia()){
					if(posfijo[i].equals("+")) {
						resul = Double.parseDouble(operandos.retiraPila()) + Double.parseDouble(operandos.retiraPila());
						operandos.insPila(resul+"");
					}
					if(posfijo[i].equals("-")) {
						resul = (-1)*Double.parseDouble(operandos.retiraPila()) + Double.parseDouble(operandos.retiraPila());
						operandos.insPila(resul+"");					
					}
					if(posfijo[i].equals("*")) {
						resul = Double.parseDouble(operandos.retiraPila()) * Double.parseDouble(operandos.retiraPila());
						operandos.insPila(resul+"");
					}
					if(posfijo[i].equals("/")) {
						resul = 1/Double.parseDouble(operandos.retiraPila()) * Double.parseDouble(operandos.retiraPila());
						operandos.insPila(resul+"");
					}
					if(posfijo[i].equals("^")) {
						double a = Double.parseDouble(operandos.retiraPila());
						double b = Double.parseDouble(operandos.retiraPila());
						resul = Math.pow(b, a);
						operandos.insPila(resul+"");
					}
				}
			}
		}
		System.out.println();
		System.out.println("El resultado de la operacion es: "+operandos.retiraPila());
		
	}
	
	static boolean isNumeric(String op) {
		try {
			Double.parseDouble(op);
			return true;
		}catch(NumberFormatException nfe){
			return false;
		}
	}

}
