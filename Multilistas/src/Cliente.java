
public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Multilista multi = new Multilista("UD");
		
		multi.ingresarMateria("Calculo");
		multi.ingresarEstudiante("Calculo", "Andres");
		multi.ingresarEstudiante("Calculo", "Maria");
		multi.ingresarEstudiante("Calculo", "Leeynyker");
		multi.ingresarEstudiante("Calculo", "Diana");
		
		multi.ingresarMateria("Etica");
		multi.ingresarEstudiante("Etica", "Camila");
		multi.ingresarEstudiante("Etica", "Andres");
		multi.ingresarEstudiante("Etica", "Maria");
		
		multi.ingresarMateria("Ciencias");
		multi.ingresarEstudiante("Ciencias", "Andres");
		multi.ingresarEstudiante("Ciencias", "Maria");
				
		multi.ingresarEstudiante("Ciencias", "Fernando");
		
		multi.escribir_lista();
		
		multi.eliminarMateria("Ciencias");
		multi.eliminarEstudiante("Calculo", "Andres");
		
		
		multi.escribir_lista();

	}

}
