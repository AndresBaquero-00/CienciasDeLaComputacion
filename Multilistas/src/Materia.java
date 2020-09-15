
public class Materia {
	String nombre;
	Materia sig;
	Estudiante estu;
	int inscritos;
	
	Materia(String n){
		this.nombre = n;
		this.sig = null;
	}
	
	void inscribirEstudiante(String n) {
		Estudiante q = estu;
		boolean inscrito = false;
		while(q != null && inscrito == false) {
			inscrito = n.equals(q.nombre);
			q = q.abajo;
		}
		if(inscrito == false) {
			Estudiante p = new Estudiante(n);
			q = estu;
			Estudiante s = null;
			while(q != null) {
				s = q;
				q = q.abajo;
			}
			if(s == null) {
				estu = p;
			}
			else {
				s.abajo = p;
			}
			inscritos++;
		}
		else {
			System.out.println("El estudiante "+n+" se encuentra inscrito");
		}
	}
	
	void eliminar_estudiante(String n) {
		Estudiante q = estu;
		Estudiante k = null;
		while(q != null && n.equals(q.nombre) == false){
			k = q;
			q = q.abajo;
		}
		
		if(q != estu) {
			k.abajo = q.abajo;
		}else {
			estu = q.abajo;
		}
		
		System.out.println("El estudiante "+q.nombre+" ha cancelado la materia "+nombre);
	}
	void ordenar_lista() {
		Estudiante p, q;
		String temp;
		for(q = estu; q != null; q = q.abajo) {
			for(p = q; p != null; p = p.abajo) {
				int comp = q.nombre.compareTo(p.nombre);
				if(comp > 0) {
					temp = q.nombre;
					q.nombre = p.nombre;
					p.nombre = temp;
				}
			}
		}
	}
	
	void listarEstudiante() {
		Estudiante p = estu;
		while(p != null) {
			System.out.print(p.nombre+" ");
			p = p.abajo;
		}
		System.out.println();
	}
}
