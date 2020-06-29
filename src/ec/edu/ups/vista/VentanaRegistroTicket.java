/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import ec.edu.ups.controlador.*;
import ec.edu.ups.modelo.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anahi
 */
public class VentanaRegistroTicket extends javax.swing.JInternalFrame {
    private Calendar fechaActual;

    private ControladorTicket controladorTicket;
    private ControladorCliente controladorCliente;
    private ControladorVehiculo controladorVehiculo;

    private VentanaRegistroVehiculo ventanaRegistrarVehiculo;
    private VentanaRegistroCliente ventanaRegistarCliente;

    private Locale localizacion;
    private ResourceBundle recurso;
    /**
     * Creates new form VentanaRegistroTicket
     */
    public VentanaRegistroTicket(ControladorTicket controladorTicket, ControladorCliente controladorCliente,
            ControladorVehiculo controladorVehiculo, VentanaRegistroVehiculo ventanaRegistrarVehiculo,
            VentanaRegistroCliente ventanaRegistarCliente) {
        initComponents();

        this.ventanaRegistrarVehiculo = ventanaRegistrarVehiculo;
        this.ventanaRegistarCliente = ventanaRegistarCliente;

        this.controladorTicket = controladorTicket;
        this.controladorCliente = controladorCliente;
        this.controladorVehiculo = controladorVehiculo;
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
        this.setTitle(recurso.getString("ventanaRegistrarTicket"));
        labelNumero.setText(recurso.getString("labelNumero"));
        labelEntrada.setText(recurso.getString("labelFechaDeEntrada"));
        labelBuscar.setText(recurso.getString("labelParametroDeBusqueda"));
        labelIngresar.setText(recurso.getString("labelSeleccioneParametro"));
        btnCedula.setText(recurso.getString("radiobtnCedula"));
        btnPlaca.setText(recurso.getString("radiobtnPlaca"));
        btnBuscar.setText(recurso.getString("btnBuscar"));
        btnEmitir.setText(recurso.getString("btnEmitir"));
        btnLimpiar.setText(recurso.getString("btnLimpiar"));
        labelMensaje.setText(recurso.getString("labelMensajeSeleccion"));

    }

    public int cambiarJOptionCliente(String idioma, String localizacion) {

        int opcion = 0;
        if (idioma.equals("es")) {
            Object[] botones = {"Si", "No", "Cancelar"};
            opcion = JOptionPane.showOptionDialog(this, "Cliente no encontrado, "
                    + "¿Desea crear un nuevo cliente?", "Mensaje", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        } else {
            opcion = JOptionPane.showConfirmDialog(this, "The customer hasn't been found,"
                    + " do you want to create a new customer?");
        }

        return opcion;
    }

    public int cambiarJOptionVehiculo(String idioma, String localizacion) {

        int opcion = 0;
        if (idioma.equals("es")) {
            Object[] botones = {"Si", "No", "Cancelar"};
            opcion = JOptionPane.showOptionDialog(this, "Vehiculo no encontrado, "
                    + "¿Desea crear un nuevo vehiculo?", "Mensaje", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        } else {
            opcion = JOptionPane.showConfirmDialog(this, "The car hasn't been found, "
                    + "Do you want to create a new car?");
        }

        return opcion;
    }

    public void ponerFecha() {
        fechaActual = Calendar.getInstance();
        txtEntrada.setText(fechaActual.getTime().toString());
    }

    public void cargarNumero() {
        int num = controladorTicket.numeroTicket();
        String num2 = String.valueOf(num);
        txtNum.setText(num2);
    }

    public void llenartblInformacion(Cliente c) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);

        for (Vehiculo ve : c.getListaVehiculos()) {
            Object[] rowData = {c.getNombre(), c.getCedula(), ve.getPlaca(), ve.getMarca(),
                ve.getModelo()};
            modelo.addRow(rowData);
        }
        tabla.setModel(modelo);
    }

    public void llenartblInformacionPorPlaca(Cliente c, Vehiculo ve) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);

        Object[] rowData = {c.getNombre(), c.getCedula(), ve.getPlaca(), ve.getMarca(),
            ve.getModelo()};
        modelo.addRow(rowData);

        tabla.setModel(modelo);
    }

    public void cambiarJOptionPane1() {

        if (localizacion.getLanguage().equals("es")) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos");
        } else {
            JOptionPane.showMessageDialog(this, "Fill the required fields");
        }

    }

    public void cambiarJOptionPane2() {

        if (localizacion.getLanguage().equals("es")) {
            JOptionPane.showMessageDialog(this, "Ticket emitido");
        } else {
            JOptionPane.showMessageDialog(this, "The ticket has been issued");
        }

    }
    public void limpiar() {
        labelIngresar.setText("Seleccione parámetro:");
        btnCedula.setSelected(false);
        btnPlaca.setSelected(false);
        txtFormatoParametro.setValue("");
        txtFormatoParametro.setEditable(false);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        tabla.setModel(modelo);
        btnEmitir.setEnabled(false);
    }
    public VentanaRegistroTicket() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        labelNumero = new javax.swing.JLabel();
        labelEntrada = new javax.swing.JLabel();
        labelBuscar = new javax.swing.JLabel();
        btnCedula = new javax.swing.JRadioButton();
        btnPlaca = new javax.swing.JRadioButton();
        labelIngresar = new javax.swing.JLabel();
        txtFormatoParametro = new javax.swing.JFormattedTextField();
        btnEmitir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        labelMensaje = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        txtEntrada = new javax.swing.JTextField();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
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

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre del Cliente", "Cédula", "Placa", "Marca", "Modelo"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        labelNumero.setText("Número");

        labelEntrada.setText("Fecha de Entrada:");

        labelBuscar.setText("Buscar por:");

        btnCedula.setText("Cédula");
        btnCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCedulaActionPerformed(evt);
            }
        });

        btnPlaca.setText("Placa");
        btnPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlacaActionPerformed(evt);
            }
        });

        labelIngresar.setText("Ingrese cédula/placa");

        btnEmitir.setText("Emitir");
        btnEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        labelMensaje.setForeground(new java.awt.Color(51, 51, 51));
        labelMensaje.setText("Asignación de Tickets");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMensaje)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelBuscar)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPlaca)
                            .addComponent(btnCedula)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelIngresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEmitir)
                                .addGap(52, 52, 52)
                                .addComponent(btnLimpiar)
                                .addGap(49, 49, 49)
                                .addComponent(btnBuscar))
                            .addComponent(txtFormatoParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNumero)
                            .addComponent(labelEntrada))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNum)
                            .addComponent(txtEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(labelMensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumero)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEntrada)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBuscar)
                    .addComponent(btnCedula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPlaca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIngresar)
                    .addComponent(txtFormatoParametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmitir)
                    .addComponent(btnLimpiar)
                    .addComponent(btnBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        ponerFecha();
        cargarNumero();
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCedulaActionPerformed
        try {
            txtFormatoParametro.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(
                            new javax.swing.text.MaskFormatter("UUUUUUUUUU")
                    )
            );
        } catch (java.text.ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato erroneo");
            ex.printStackTrace();
        }

        btnPlaca.setSelected(false);
        labelIngresar.setText("Cédula:");
        txtFormatoParametro.setEditable(true);

    }//GEN-LAST:event_btnCedulaActionPerformed

    private void btnPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlacaActionPerformed
        try {
            txtFormatoParametro.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(
                            new javax.swing.text.MaskFormatter("UUU-####")
                    )
            );
        } catch (java.text.ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato del número de placa erroneo");
            ex.printStackTrace();
        }

        btnCedula.setSelected(false);
        labelIngresar.setText("Placa:");
        txtFormatoParametro.setEditable(true);
    }//GEN-LAST:event_btnPlacaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
        ponerFecha();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String buscars = txtFormatoParametro.getText();

        String numero = txtNum.getText();
        String fecha = txtEntrada.getText();

        if (buscars == null) {
            cambiarJOptionPane1();

        } else {
            if (btnCedula.isSelected()) {
                Cliente c = controladorCliente.buscarCliente(buscars);
                if (c == null) {
                    int op = cambiarJOptionCliente(localizacion.getLanguage(), localizacion.getCountry());
                    if (op == JOptionPane.YES_OPTION) {
                        ventanaRegistarCliente.setVisible(true);
                        this.hide();
                    }
                } else {
                    labelMensaje.setEnabled(true);
                    llenartblInformacion(c);
                    btnEmitir.setEnabled(true);
                }
            } else if (btnPlaca.isSelected()) {
                Vehiculo v = controladorVehiculo.buscarVehiculo(buscars);
                if (v == null) {
                    int op = cambiarJOptionVehiculo(localizacion.getLanguage(), localizacion.getCountry());
                    if (op == JOptionPane.YES_OPTION) {
                        ventanaRegistrarVehiculo.setVisible(true);
                        this.hide();
                    }
                } else {
                    Cliente c = controladorCliente.buscarPorVehiculo(v.getPlaca());
                    labelMensaje.setEnabled(true);
                    llenartblInformacionPorPlaca(c, v);
                    btnEmitir.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirActionPerformed
                String num = txtNum.getText();
        int num2 = Integer.parseInt(num);
        Date entrada = fechaActual.getTime();

        Ticket t = controladorTicket.crear(num2, entrada);

        int row = tabla.getSelectedRow();

        String placa = tabla.getValueAt(row, 2).toString();
        String cedulas = tabla.getValueAt(row, 1).toString();

        Vehiculo ve = controladorVehiculo.buscarVehiculo(placa);
        ve.agregarTicket(t);
        Cliente c = controladorCliente.buscarCliente(cedulas);

        controladorCliente.actualizarVehiculo(c, ve);
        cambiarJOptionPane2();

        limpiar();
        this.hide();
    }//GEN-LAST:event_btnEmitirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JRadioButton btnCedula;
    private javax.swing.JButton btnEmitir;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JRadioButton btnPlaca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JLabel labelEntrada;
    private javax.swing.JLabel labelIngresar;
    private javax.swing.JLabel labelMensaje;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JFormattedTextField txtFormatoParametro;
    private javax.swing.JTextField txtNum;
    // End of variables declaration//GEN-END:variables
}
