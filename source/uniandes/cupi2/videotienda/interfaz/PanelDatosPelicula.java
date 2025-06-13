/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PanelDatosPelicula.java,v 1.1 2005/12/16 15:13:33 k-marcos Exp $ 
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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel para presentar los datos de una pel�cula
 */
public class PanelDatosPelicula extends JPanel implements ActionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    private static final long serialVersionUID = 1L;

	/**
     * Comando aceptar
     */
    private static final String ACEPTAR = "aceptar";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Di�logo donde se ubica el panel
     */
    private DialogoPelicula dialogo;

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    private JLabel labTitulo;
    private JTextField txtTitulo;
    private JLabel labDisponibles;
    private JTextField txtDisponibles;
    private JLabel labPrestadas;
    private JTextField txtPrestadas;
    private JButton botonAceptar;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea el panel para los datos de una pel�cula
     * @param elDialogo Di�logo donde se ubica el panel. elDialogo != null.
     */
    public PanelDatosPelicula( DialogoPelicula elDialogo )
    {
        dialogo = elDialogo;

        setBorder( BorderFactory.createTitledBorder( "Datos B�sicos" ) );
        setLayout( new BorderLayout( ) );

        labTitulo = new JLabel( "T�tulo de la pel�cula:" );
        labDisponibles = new JLabel( "N�mero Copias Disponibles:" );
        labPrestadas = new JLabel( "N�mero Copias Prestadas:" );
        txtTitulo = new JTextField( dialogo.darTitulo( ) );
        txtTitulo.setEditable( false );
        txtDisponibles = new JTextField( "" + dialogo.darNumeroDisponibles( ) );
        txtDisponibles.setEditable( false );
        txtPrestadas = new JTextField( "" + dialogo.darNumeroPrestadas( ) );
        txtPrestadas.setEditable( false );

        JPanel panel = new JPanel( new GridLayout( 3, 2, 1, 5 ) );
        panel.add( labTitulo );
        panel.add( txtTitulo );
        panel.add( labDisponibles );
        panel.add( txtDisponibles );
        panel.add( labPrestadas );
        panel.add( txtPrestadas );

        add( panel, BorderLayout.CENTER );

        botonAceptar = new JButton( );
        botonAceptar.setText( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );

        add( botonAceptar, BorderLayout.SOUTH );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Responde a los eventos de los botones del panel
     * @param evento Evento generado por un bot�n. evento != null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        if( comando.equals( ACEPTAR ) )
        {
            dialogo.aceptar( );
        }
    }
}
