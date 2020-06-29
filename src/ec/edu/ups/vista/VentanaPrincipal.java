/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.controlador.ControladorTicket;
import ec.edu.ups.controlador.ControladorVehiculo;
import ec.edu.ups.dao.ClienteDao;
import ec.edu.ups.dao.TicketDao;
import ec.edu.ups.dao.VehiculoDao;
import java.util.Locale;
import java.util.ResourceBundle;
import sun.security.tools.keytool.Resources;

/**
 *
 * @author Anahi
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private Locale localizacion;
    private ResourceBundle recurso;

    private ClienteDao clienteDAO;
    private VehiculoDao vehiculoDAO;
    private TicketDao ticketDAO;

    private ControladorCliente controladorCliente;
    private ControladorVehiculo controladorVehiculo;
    private ControladorTicket controladorTicket;

    private VentanaRegistroCliente ventanaRegistrarCliente;
    private VentanaRegistroVehiculo ventanaRegistrarVehiculo;
    private VentanaRegistroTicket ventanaRegistrarTicket;
    private VentanaSalida ventanaSalidaTicket;

    private VentanaListaTickets ventanaListarTickets;
    private VentanaListarClientes ventanaListarClientes;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        clienteDAO = new ClienteDao();
        vehiculoDAO = new VehiculoDao();
        ticketDAO = new TicketDao();

        controladorCliente = new ControladorCliente(clienteDAO, vehiculoDAO, ticketDAO);
        controladorVehiculo = new ControladorVehiculo(vehiculoDAO);
        controladorTicket = new ControladorTicket(clienteDAO, vehiculoDAO, ticketDAO);

        ventanaRegistrarCliente = new VentanaRegistroCliente(controladorCliente);
        ventanaRegistrarVehiculo = new VentanaRegistroVehiculo(controladorCliente, controladorVehiculo,
                ventanaRegistrarCliente);
        ventanaRegistrarTicket = new VentanaRegistroTicket(controladorTicket, controladorCliente,
                controladorVehiculo, ventanaRegistrarVehiculo, ventanaRegistrarCliente);
        ventanaSalidaTicket = new VentanaSalida(controladorTicket, controladorVehiculo,
                controladorCliente);

        ventanaListarTickets = new VentanaListaTickets(controladorCliente, controladorVehiculo,
                controladorTicket);
        ventanaListarClientes = new VentanaListarClientes(controladorCliente);

        desktopPane.add(ventanaRegistrarCliente);
        desktopPane.add(ventanaRegistrarTicket);
        desktopPane.add(ventanaRegistrarVehiculo);
        desktopPane.add(ventanaSalidaTicket);
        desktopPane.add(ventanaListarTickets);
        desktopPane.add(ventanaListarClientes);
    }
    public void cerrarVentanas() {
        ventanaRegistrarCliente.setVisible(false);
        ventanaRegistrarTicket.setVisible(false);
        ventanaRegistrarVehiculo.setVisible(false);
        ventanaSalidaTicket.setVisible(false);
        ventanaListarTickets.setVisible(false);
        ventanaListarClientes.setVisible(false);

    }
    public void cambiarIdioma(String idioma, String localidad) {
        //
        localizacion = new Locale(idioma, localidad);
        recurso = ResourceBundle.getBundle("ec.ups.edu.idioma.mensaje", localizacion);

        this.setTitle(recurso.getString("ventanaPrincipal"));
        //JmenuInicio
        inicioMenu.setText(recurso.getString("menuInicio"));
        //JmenuItems de el JmenuInicio
        registroCMenuItem.setText(recurso.getString("registrarCliente"));
        registroVMenuItem.setText(recurso.getString("registrarVehiculo"));
        ticketMenu.setText(recurso.getString("emitirTicket"));
        salidaMenu.setText(recurso.getString("salidaTicket"));
        exitMenuItem.setText(recurso.getString("salida"));

        //JmenuListar
        listarMenu.setText(recurso.getString("menuListar"));
        //JmenuItems de el JmenuListar
        clientesMenuItem.setText(recurso.getString("listarClientes"));
       // menuItemListarVehiculos.setText(recurso.getString("listarVehiculos"));
        ticketsMenuItem.setText(recurso.getString("listarTickets"));

        //JmenuIdiomas
        menuIdiomas.setText(recurso.getString("menuIdiomas"));
        //JmenusItem de el JmenuIdiomas
        menuItemEspañol.setText(recurso.getString("español"));
        menuItemIngles.setText(recurso.getString("ingles"));
        ventanaRegistrarVehiculo.setTitle(recurso.getString("tituloCliente"));

        //ventana listar clientes
        if (ventanaListarClientes != null) {
            ventanaListarClientes.setRecurso(recurso);
            ventanaListarClientes.setLocalizacion(localizacion);
            ventanaListarClientes.cambiarIdioma(idioma, localidad);
        }

        //ventanan listar Ticket
        if (ventanaListarTickets != null) {
            ventanaListarTickets.setRecurso(recurso);
            ventanaListarTickets.setLocalizacion(localizacion);
            ventanaListarTickets.cambiarIdioma(idioma, localidad);
        }

        // ventana registrar cliente
        if (ventanaRegistrarCliente != null) {
            ventanaRegistrarCliente.setRecurso(recurso);
            ventanaRegistrarCliente.setLocalizacion(localizacion);
            ventanaRegistrarCliente.cambiarIdioma(idioma, localidad);
        }

         //ventana registrar Ticket
        if (ventanaRegistrarTicket != null) {
            ventanaRegistrarTicket.setRecurso(recurso);
            ventanaRegistrarTicket.setLocalizacion(localizacion);
            ventanaRegistrarTicket.cambiarIdioma(idioma, localidad);
        }

        //Ventana Registrar Vehiculo
        if (ventanaRegistrarVehiculo != null) {
            ventanaRegistrarVehiculo.setRecurso(recurso);
            ventanaRegistrarVehiculo.setLocalizacion(localizacion);
            ventanaRegistrarVehiculo.cambiarIdioma(idioma, localidad);
        }

        //ventana  salida de ticket
        if (ventanaSalidaTicket != null) {
            ventanaSalidaTicket.setRecurso(recurso);
            ventanaSalidaTicket.setLocalizacion(localizacion);
            ventanaSalidaTicket.cambiarIdioma(idioma, localidad);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        inicioMenu = new javax.swing.JMenu();
        registroCMenuItem = new javax.swing.JMenuItem();
        registroVMenuItem = new javax.swing.JMenuItem();
        ticketMenu = new javax.swing.JMenuItem();
        salidaMenu = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        listarMenu = new javax.swing.JMenu();
        clientesMenuItem = new javax.swing.JMenuItem();
        ticketsMenuItem = new javax.swing.JMenuItem();
        menuIdiomas = new javax.swing.JMenu();
        menuItemEspañol = new javax.swing.JMenuItem();
        menuItemIngles = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inicioMenu.setMnemonic('f');
        inicioMenu.setText("Inicio");

        registroCMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        registroCMenuItem.setMnemonic('o');
        registroCMenuItem.setText("Registrar Cliente");
        registroCMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroCMenuItemActionPerformed(evt);
            }
        });
        inicioMenu.add(registroCMenuItem);

        registroVMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        registroVMenuItem.setMnemonic('s');
        registroVMenuItem.setText("Registrar Vehiculo");
        registroVMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroVMenuItemActionPerformed(evt);
            }
        });
        inicioMenu.add(registroVMenuItem);

        ticketMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        ticketMenu.setMnemonic('a');
        ticketMenu.setText("Ticket");
        ticketMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketMenuActionPerformed(evt);
            }
        });
        inicioMenu.add(ticketMenu);

        salidaMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        salidaMenu.setText("Salida");
        salidaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salidaMenuActionPerformed(evt);
            }
        });
        inicioMenu.add(salidaMenu);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        inicioMenu.add(exitMenuItem);

        menuBar.add(inicioMenu);

        listarMenu.setMnemonic('e');
        listarMenu.setText("Listar");

        clientesMenuItem.setMnemonic('t');
        clientesMenuItem.setText("Clientes");
        clientesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesMenuItemActionPerformed(evt);
            }
        });
        listarMenu.add(clientesMenuItem);

        ticketsMenuItem.setMnemonic('p');
        ticketsMenuItem.setText("Tickets");
        ticketsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketsMenuItemActionPerformed(evt);
            }
        });
        listarMenu.add(ticketsMenuItem);

        menuBar.add(listarMenu);

        menuIdiomas.setMnemonic('h');
        menuIdiomas.setText("Idioma");

        menuItemEspañol.setMnemonic('c');
        menuItemEspañol.setText("Español");
        menuIdiomas.add(menuItemEspañol);

        menuItemIngles.setMnemonic('a');
        menuItemIngles.setText("Inglés");
        menuIdiomas.add(menuItemIngles);

        menuBar.add(menuIdiomas);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void ticketsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketsMenuItemActionPerformed
        cerrarVentanas();
        ventanaListarTickets.setVisible(true);
    }//GEN-LAST:event_ticketsMenuItemActionPerformed

    private void registroCMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroCMenuItemActionPerformed
        cerrarVentanas();
        ventanaRegistrarCliente.setVisible(true);
    }//GEN-LAST:event_registroCMenuItemActionPerformed

    private void registroVMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroVMenuItemActionPerformed
        cerrarVentanas();
        ventanaRegistrarVehiculo.setVisible(true);
    }//GEN-LAST:event_registroVMenuItemActionPerformed

    private void ticketMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketMenuActionPerformed
        cerrarVentanas();
        ventanaRegistrarTicket.setVisible(true);
    }//GEN-LAST:event_ticketMenuActionPerformed

    private void salidaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salidaMenuActionPerformed
        cerrarVentanas();
        ventanaSalidaTicket.setVisible(true);
    }//GEN-LAST:event_salidaMenuActionPerformed

    private void clientesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesMenuItemActionPerformed
        cerrarVentanas();
        ventanaListarClientes.setVisible(true);
    }//GEN-LAST:event_clientesMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem clientesMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu inicioMenu;
    private javax.swing.JMenu listarMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuIdiomas;
    private javax.swing.JMenuItem menuItemEspañol;
    private javax.swing.JMenuItem menuItemIngles;
    private javax.swing.JMenuItem registroCMenuItem;
    private javax.swing.JMenuItem registroVMenuItem;
    private javax.swing.JMenuItem salidaMenu;
    private javax.swing.JMenuItem ticketMenu;
    private javax.swing.JMenuItem ticketsMenuItem;
    // End of variables declaration//GEN-END:variables

}
