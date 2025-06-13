/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: Pelicula.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_videotienda
 * Autor: Katalina Marcos - Diciembre 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.videotienda.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una película que se encuentra en la videotienda y
 * de la cual puede haber copias disponibles o prestadas.
 */ 
public class Pelicula
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Título de la película
     */
    private String titulo;

    /**
     * Lista de copias disponibles
     */
    private ArrayList<Copia> disponibles;

    /**
     * Lista de copias prestadas
     */
    private ArrayList<Copia> prestadas;

    /**
     * Número de la siguiente copia a adicionar
     */
    private int codigoSiguienteCopia;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea una película de la videotienda con el título dado.
     * <b>post: </b> La película se crea sin copias disponibles ni prestadas.
     * @param unTitulo Título de la película. unTitulo != null.
     */
    public Pelicula(String unTitulo)
    {
        this.titulo = unTitulo;
        this.disponibles = new ArrayList<Copia>();
        this.prestadas = new ArrayList<Copia>();
        this.codigoSiguienteCopia = 1;
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Adiciona una nueva copia de la película.
     * <b>post: </b>La lista de películas disponibles tiene una nueva copia.
     * @return código de la copia creada. código >= 1;
     */
    public int agregarCopia()
    {
        Copia nuevaCopia = new Copia(titulo, codigoSiguienteCopia);
        this.disponibles.add(nuevaCopia);
        int codigoCreado = codigoSiguienteCopia;
        this.codigoSiguienteCopia++;
        return codigoCreado;
    }

    /**
     * Retorna una copia de película para alquilar si hay disponibles.
     * <b>post: </b> la copia queda en la lista de prestadas.
     * @return Copia que ha sido alquilada o null si no hay disponibles.
     */
    public Copia alquilarCopia( )
    {
    	if (disponibles.size() > 0) {
            Copia copia = disponibles.remove(0);
            prestadas.add(copia);
            return copia;
        }
        return null;
    }

    /**
     * Devuelve una copia de la película y la coloca como disponible.
     * <b>post: </b> regresa la copia a la lista de disponibles, sólo si está prestada.
     * @param codigoCopia Código de la copia que se quiere devolver.
     * @throws Exception Si la copia a devolver no está prestada.
     */
    public void devolverCopia(int codigoCopia) throws Exception {
        Copia copia = null;
        for(Copia c : this.prestadas) {
            if(c.darCodigo() == codigoCopia) {
                copia = c;
                break;    
            }
        }
        
        if(copia == null) {
            throw new Exception("La copia con el código " + codigoCopia + " no está prestada");
        }
        this.prestadas.remove(copia);
        this.disponibles.add(copia);
    }

    /**
     * Retorna el título de la película.
     * @return título de la película.
     */    
    public String darTitulo()
    {
        return titulo;
    }

    /**
     * Retorna la cantidad total de copias que existen de la película en la videotienda
     * @return entero con la cantidad de copias que existen en la tienda
     */
    public int darTotalCopias() {
        return this.disponibles.size() + this.prestadas.size();
    }

    /**
     * Retorna el número de copias disponibles
     * @return número de copias disponibles
     */
    public int darNumeroDisponibles() {
        return this.disponibles.size();
    }
}