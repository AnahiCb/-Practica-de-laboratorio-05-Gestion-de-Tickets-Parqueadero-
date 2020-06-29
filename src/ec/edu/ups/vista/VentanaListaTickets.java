/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.*;
import ec.edu.ups.modelo.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anahi
 */
public class VentanaListaTickets extends javax.swing.JInternalFrame {
    private ControladorCliente controladorCliente;
    private ControladorVehiculo controladorVehiculo;
    private ControladorTicket controladorTicket;

    private Locale localizacion;
    private ResourceBundle recurso;

    private Set<Ticket> tickets;

    /**
     * Creates new form VentanaListaTickets
     */
    public VentanaListaTickets(ControladorCliente controladorCliente, ControladorVehiculo controladorVehiculo,
            ControladorTicket controladorTicket) {

        initComponents();

        this.controladorCliente = controladorCliente;
        this.controladorTicket = controladorTicket;
        this.controladorVehiculo = controladorVehiculo;

        tickets = new HashSet<>();
    }

    public Locale getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Locale localizacion) {
        this.localizacion = localizacion;
    }

    public ResourceBundle getRecurso() {
        return recurso;
    }

    public void setRecurso(ResourceBundle recurso) {
        this.recurso = recurso;
    }

    public void cambiarIdioma(String idioma, String localizacion) {
        this.setTitle(recurso.getString("ventanaListarTicket"));
        labelTicket.setText(recurso.getString("labelNumeroDeTicket"));
        btnBuscarTicket.setText(recurso.getString("btnBuscar"));
        btnLimpiarTicket.setText(recurso.getString("btnLimpiar"));

    }

    public void llenartblTickets() {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);

        tickets = controladorTicket.findAll();
        Iterator<Ticket> it = tickets.iterator();
        while (it.hasNext()) {
            Ticket t = it.next();
            Vehiculo ve = controladorVehiculo.buscarPorTicket(t);
            Cliente c = controladorCliente.buscarPorVehiculo(ve.getPlaca());

            Object[] rowData = {t.getNumero(), t.getFechaEntrada(), t.getFechaSalida(),
                t.getTiempo(), t.getTotal(), ve.getPlaca(), ve.getModelo(), ve.getMarca(),
                c.getNombre(), c.getCedula(), c.getTelefono().getNumero(), c.getDireccion().toString()};

            modelo.addRow(rowData);

        }

        tabla.setModel(modelo);

    }

    public void llenartblTicektsTicekt(Ticket ticket) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);

        Vehiculo ve = controladorVehiculo.buscarPorTicket(ticket);
        Cliente c = controladorCliente.buscarPorVehiculo(ve.getPlaca());

        Object[] rowData = {ticket.getNumero(), ticket.getFechaEntrada(), ticket.getFechaSalida(),
            ticket.getTiempo(), ticket.getTotal(), ve.getPlaca(), ve.getModelo(), ve.getMarca(),
            c.getNombre(), c.getCedula(), c.getTelefono().getNumero(), c.getDireccion().toString()};

        modelo.addRow(rowData);

        tabla.setModel(modelo);
    }

    public void cambiarJOptionPane1() {

        if (localizacion.getLanguage().equals("es")) {
            JOptionPane.showMessageDialog(this, "Llene el campo requerido para buscar un ticket");
        } else {
            JOptionPane.showMessageDialog(this, "Fill the required field to search a ticket");
        }

    }

    public void cambiarJOptionPane2() {

        if (localizacion.getLanguage().equals("es")) {
            JOptionPane.showMessageDialog(this, "Ticket no encontrado");
        } else {
            JOptionPane.showMessageDialog(this, "The ticket hasn't been found");
        }

    }
    public void limpiar() {
        txtNumTicket.setText("");
    }
    public VentanaListaTickets() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTicket = new javax.swing.JLabel();
        txtNumTicket = new javax.swing.JTextField();
        btnBuscarTicket = new javax.swing.JButton();
        btnLimpiarTicket = new javax.swing.JButton();
        JScrollPane = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        labelTicket.setText("Nro. de Ticket: ");

        btnBuscarTicket.setText("Buscar");
        btnBuscarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTicketActionPerformed(evt);
            }
        });

        btnLimpiarTicket.setText("Limpiar");
        btnLimpiarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(labelTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiarTicket)
                    .addComponent(btnBuscarTicket))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTicket)
                    .addComponent(txtNumTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarTicket))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiarTicket)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Número", "Entrada", "Salida", "Tiempo", "Valor", "Placa", "Marca", "Modelo", "Cliente", "Cédula", "Teléfono", "Dirección"
            }
        ));
        JScrollPane.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTicketActionPerformed
        String num = txtNumTicket.getText();

        if (num == null) {
            cambiarJOptionPane1();
        } else {
            int n = Integer.parseInt(num);
            Ticket t = controladorTicket.encontrarTicket(n);
            if (t == null) {
                cambiarJOptionPane2();
            } else {
                llenartblTicektsTicekt(t);
            }
        }
    }//GEN-LAST:event_btnBuscarTicketActionPerformed

    private void btnLimpiarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTicketActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarTicketActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        llenartblTickets();
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        limpiar();
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JButton btnBuscarTicket;
    private javax.swing.JButton btnLimpiarTicket;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelTicket;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtNumTicket;
    // End of variables declaration//GEN-END:variables
}
