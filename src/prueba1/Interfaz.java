
package prueba1;

import com.mysql.jdbc.Connection;
import com.panamahitek.*;
import java.awt.Component;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.YIntervalSeriesCollection;





/**
 *
 * @author ROMARIO
 */
public class Interfaz extends javax.swing.JFrame {
    
    //BASE DE DATOS
    

     
     public static final String URL ="jdbc:mysql://";
     public static final String USERNAME ="";
     public static final String PASSSWORD ="";
     
     
     
     //CREAR TABLA
     
     DefaultTableModel Modelo;
     
    
    //CONECTAR ARDUINO

    PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();
    final XYSeries serie = new XYSeries("Distancia");
    final XYSeriesCollection coleccion = new XYSeriesCollection();
    JFreeChart grafica;
    //declaramos contador
    int i=0;
    int distancia=0;
    int lecturas=0;
    boolean State;
    SerialPortEventListener evento = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {

            try {
                if (arduino.isMessageAvailable() == true) {
                    
                 
                    //********
                    
                    if(lecturas>1){
                    tablaAct();
                    }
                    
                    
                    distancia=Integer.parseInt(arduino.printMessage()); 
                    lecturas++;
                    //********
                    
                    
                    i++;
                    serie.add(i, distancia);
                    
                     
                    

                    if (i == 20) {
                        i = 0;
                        serie.clear();
                        System.out.println("**SERIE REINICIADA**");
                    }
                    
                    
                      
                    
                }

            } catch (SerialPortException | ArduinoException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    };
    
    //METODO ACTUALIZAR TABLA
    
    public void tablaAct(){
    
        Modelo.addRow(new Object[]{distancia});
    
    }
    
    
    public Interfaz() {
        initComponents();
        
        serie.add(0, 0);
        coleccion.addSeries(serie);
        grafica = ChartFactory.createXYLineChart("Distancia vs. Tiempo",
                "Tiempo", "Distancia", coleccion,
                PlotOrientation.VERTICAL, true, true, false);
        grafica = ChartFactory.createXYLineChart("Distancia vs. Tiempo",
                "Tiempo", "Distancia", coleccion,
                PlotOrientation.VERTICAL, true, true, false);

        Modelo = (DefaultTableModel) tblModelo.getModel();
    }

    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGraficar = new javax.swing.JButton();
        BtnDetener = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblModelo = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGraficar.setText("Graficar");
        btnGraficar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });

        BtnDetener.setText("Detener Sensor");
        BtnDetener.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDetenerActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Internet de las Cosas: Parcial 1");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblModelo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Distancia (cm)"
            }
        ));
        tblModelo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tblModelo);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnIniciar.setText("Iniciar Sensor");
        btnIniciar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar Datos");
        btnMostrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BtnDetener, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGraficar, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        // TODO add your handling code here:
        ChartPanel Panel;
        Panel = new ChartPanel(grafica);
        JFrame Ventana = new JFrame("Graficador Serial");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);
        //Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }//GEN-LAST:event_btnGraficarActionPerformed

    private void BtnDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDetenerActionPerformed
        // TODO add your handling code here:
//        try {
//            Connection con = null;
//            con = getConection();
//            //variables para hacer transaccion a la base de datos
//            PreparedStatement ps;
//            ResultSet res;
//            ps = con.prepareStatement("SELECT * FROM datos " );
//            res = ps.executeQuery();
//
//            if (res.next()) {
//                JOptionPane.showMessageDialog(null, res.getInt("distancia"));
//                System.out.println(res.toString());
//            } else {
//
//                JOptionPane.showMessageDialog(null, "¡NO EXISTEN DATOS!");
//            }
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        try {

            arduino.killArduinoConnection();
        } catch (ArduinoException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_BtnDetenerActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
      
          // TODO add your handling code here:   
        try {
            Connection con = null;
            con = getConection();
            //variables para hacer transaccion a la base de datos

            Statement stmt;
            String Query = "INSERT INTO datos (distancia) values('" + distancia + "') ";
            stmt = con.prepareStatement(Query);
            stmt.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
        } catch (Exception e) {
            System.out.println("Error al guardar datos");
            System.out.println(e);
        }

// Modelo.addRow(new Object[]{"1","2"});
        


        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
          // TODO add your handling code here:
        
             
        
         try {
          while(i>=0){
            Modelo.removeRow(0);
          }
        } catch (Exception e) {
            System.out.println("¡¡Tabla limpia!!");
            System.out.println(e);
        }
          
       
  
      
       
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        
        EncenderArduino();
        
        
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        
        
        JTable tabla = new JTable();
        tabla.setBounds(0, 0, 1, 1);
        JFrame ventanaTabla = new JFrame("Datos guardados");
         
        
      

//*****************************************************************

                 try {
            Connection con = null;
            con = getConection();
            //variables para hacer transaccion a la base de datos
            PreparedStatement ps;
            ResultSet res;
            ps = con.prepareStatement("SELECT * FROM datos " );
            res = ps.executeQuery();
            ventanaTabla.getContentPane().add(tabla);

        DefaultTableModel model = new DefaultTableModel();
       model.addColumn("No. Intento");
       model.addColumn("Distancia Almacenada (cm)");
        tabla.setModel(model);
                     String[] dato = new String[3];

                     dato[0] = "No. Intento";
                     dato[1] = "Distancia Almacenada (cm)";
                     model.addRow(dato);
        
        
            while (res.next()) {
//                JOptionPane.showMessageDialog(null, res.getInt("distancia"));
//                System.out.println(res.toString());
             dato[0]=res.getString(1);
             dato[1]=res.getString(2);
             model.addRow(dato);
            }
            tabla.setModel(model);
//            else {
//
//                JOptionPane.showMessageDialog(null, "¡NO EXISTEN DATOS!");
//            }
//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        ventanaTabla.pack();
        ventanaTabla.setSize(400,300);
        ventanaTabla.setVisible(true);

         
        
        
        
        
    }//GEN-LAST:event_btnMostrarActionPerformed

    
    public void EncenderArduino(){
    
    try {
            arduino.arduinoRXTX("COM7", 9600, evento);
        } catch (ArduinoException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("¡¡Error al iniciar el Arduino!!");
            
        }
    
    }
    
    
    
    
    public static Connection getConection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSSWORD);
            JOptionPane.showMessageDialog(null, "¡CONEXION EXITOSA!");

        } catch (Exception e) {
            System.out.println(e);
        }
        
        return con;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDetener;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGraficar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblModelo;
    // End of variables declaration//GEN-END:variables

}
