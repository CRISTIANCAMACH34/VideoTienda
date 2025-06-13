package uniandes.cupi2.videotienda.mundo;

import java.util.ArrayList;

public class Cliente {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    private String cedula;
    private String nombre;
    private String direccion;
    private int saldo;
    private ArrayList<Copia> alquiladas;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo cliente con los datos dados
     * @param laCedula Cedula del cliente
     * @param elNombre Nombre del cliente
     * @param laDireccion Dirección del cliente
     */
    public Cliente(String laCedula, String elNombre, String laDireccion) {
        cedula = laCedula;
        nombre = elNombre;
        direccion = laDireccion;
        saldo = 0;
        alquiladas = new ArrayList<Copia>();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la cédula del cliente
     */
    public String darCedula() {
        return cedula;
    }

    /**
     * Retorna el saldo del cliente
     */
    public int darSaldo() {
        return saldo;
    }

    /**
     * Retorna el nombre del cliente
     */
    public String darNombre() {
        return nombre;
    }

    /**
     * Retorna la dirección del cliente
     */
    public String darDireccion() {
        return direccion;
    }

    /**
     * Agrega una copia alquilada al cliente
     * @param copia Copia alquilada
     */
    public void alquilarCopia(Copia copia) {
        alquiladas.add(copia);
    }

    /**
     * Carga saldo al cliente
     * @param monto Monto a cargar
     */
    public void cargarSaldo(int monto) {
        saldo += monto;
    }

    /**
     * Descarga saldo al cliente (cuando alquila una película)
     * @param monto Monto a descontar
     */
    public void descargarSaldo(int monto) {
        saldo -= monto;
    }

    /**
     * Retorna el número de películas alquiladas actualmente por el cliente
     * @return número de películas alquiladas
     */
    public int darNumeroAlquiladas() {
        return alquiladas.size();
    }

    /**
     * Retorna la lista de copias alquiladas
     * @return lista de copias alquiladas
     */
    public ArrayList<Copia> darAlquiladas() {
        return alquiladas;
    }

    /**
     * Busca una copia alquilada por título y código
     * @param pelicula Título de la película
     * @param codigo Código de la copia
     * @return La copia si la encuentra, null en caso contrario
     */
    public Copia buscarPeliculaAlquilada(String pelicula, int codigo) {
        for (Copia c : alquiladas) {
            if (c.darTituloPelicula().equals(pelicula) && c.darCodigo() == codigo) {
                return c;
            }
        }
        return null;
    }
    /**
     * Devuelve una copia alquilada por el cliente
     * @param pelicula Título de la película
     * @param codigo Código de la copia
     * @throws Exception si la copia no está alquilada
     */
    public void devolverCopia(String pelicula, int codigo) throws Exception {
        Copia copia = buscarPeliculaAlquilada(pelicula, codigo);
        if (copia != null) {
            alquiladas.remove(copia);
        } else {
            throw new Exception("La copia no está alquilada por este cliente");
        }
    }

}
