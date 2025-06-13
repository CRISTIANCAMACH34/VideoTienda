package uniandes.cupi2.videotienda.mundo;

public class Copia {
	
	private String tituloPelicula;
	
	private int codigo;

	public Copia(String laPelicula, int elCodigo) {
		tituloPelicula = laPelicula.trim();
		codigo = elCodigo;
	}
	
	public int darCodigo() {
		return codigo;
	}
	
	public String darTituloPelicula() {
		return tituloPelicula;
	}
	
	public boolean esIgualA(Copia otra) throws Exception {
	    if (otra == null) {
	        throw new Exception("No ingreso una copia valida");
	    }

	    return  this.darTituloPelicula().equals(otra.darTituloPelicula());
	}

}
