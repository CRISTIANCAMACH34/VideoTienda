/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: DialogoConsultaCliente.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_videotienda
 * Autor: Katalina Marcos - Diciembre 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.videotienda.interfaz;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import uniandes.cupi2.videotienda.mundo.Cliente;

/**
 * Di�logo para mostrar los datos de un cliente
 */
public class DialogoConsultaCliente extends JDialog
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    private static final long serialVersionUID = 1L;

	/**
     * Ventana principal de la aplicaci�n
     */
    private InterfazVideotienda ventanaPrincipal;

    /**
     * Cliente a mostrar en el panel
     */
    private Cliente cliente;

    /**
     * Panel de datos del cliente
     */
    private PanelDatosCliente panelDatos;

    /**
     * Panel con los datos de las pel�culas alquiladas del cliente
     */
    private PanelAlquiladasCliente panelAlquiladas;

    /**
     * Panel con las opciones del di�logo
     */
    private PanelBotonesCliente panelBotones;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
    /**
     * Crea el di�logo para mostrar la informaci�n del cliente dado
     * @param elCliente Cliente a mostrar. elCliente != null.
     * @param ventana Ventana principal de la aplicaci�n. ventana != null.
     */
    public DialogoConsultaCliente( Cliente elCliente, InterfazVideotienda ventana )
    {
        cliente = elCliente;
        ventanaPrincipal = ventana;

        setLayout( new BorderLayout( ) );
        panelDatos = new PanelDatosCliente( this );
        add( panelDatos, BorderLayout.NORTH );
        panelAlquiladas = new PanelAlquiladasCliente( this );
        panelAlquiladas.actualizarAlquiladas( cliente.darAlquiladas( ) );
        add( panelAlquiladas, BorderLayout.CENTER );
        panelBotones = new PanelBotonesCliente( this );
        add( panelBotones, BorderLayout.SOUTH );

        pack( );
        setTitle( "Informaci�n del Cliente" );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Retorna el nombre del cliente
     * @return nombre
     */
    public String darNombre( )
    {
        return cliente.darNombre( );
    }

    /**
     * Retorna la c�dula del cliente
     * @return c�dula
     */
    public String darCedula( )
    {
        return cliente.darCedula( );
    }

    /**
     * Retorna la direcci�n del cliente
     * @return direcci�n
     */
    public String darDireccion( )
    {
        return cliente.darDireccion( );
    }

    /**
     * Retorna el saldo del cliente
     * @return saldo
     */
    public int darSaldo( )
    {
        return cliente.darSaldo( );
    }

    /**
     * incrementa el saldo del cliente
     * @param incremento para el saldo
     */
    public void incrementarSaldo( int incremento )
    {
        ventanaPrincipal.cargarSaldo( cliente.darCedula( ), incremento );
    }

    /**
     * Devuelve la pel�cula seleccionada
     * @param pelicula T�tulo de la pel�cula. pelicula != null.
     * @param copia Copia de la pel�cula.
     */
    public void devolver( String pelicula, int copia )
    {
        try
        {
            ventanaPrincipal.devolverCopia( cliente.darCedula( ), pelicula, copia );
            panelAlquiladas.actualizarAlquiladas( cliente.darAlquiladas( ) );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Devolver Pel�cula", JOptionPane.ERROR_MESSAGE );
        }
    }
    /**
     * Sale del di�logo
     */
    public void aceptar( )
    {
        dispose( );
    }
}
