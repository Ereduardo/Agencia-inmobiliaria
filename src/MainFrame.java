import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

public void inicializar(){
//*******************CONSTRUCTORES *************
JPanel mainPanel = new JPanel();    
setTitle("Agencia inmobiliaria"); //SetTitle con los construct por organizacion
JButton boton = new JButton("Añadir cliente");
JLabel label1 = new JLabel("Bienvenido a la Agencia Inmobiliaria.");
// ************** ICONO DE LA VENTANA *************

    Toolkit toolkit=Toolkit.getDefaultToolkit();
    Image icon = toolkit.getImage("icon.png");
    setIconImage(icon);
// *********** PROPIEDADES DE VENTANA *************+
    //setLayout(null);
   
    setLayout(null);
    setResizable(false);
    
    // setLocation(200,300);
    setSize(500,600);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
// *************** BOTONES ************
    
    boton.setBounds(100,200,300,30);
    add(boton);
    ActionListener oyenteDeAccion = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            label1.setText("Acabas de seleccionar >Registrar Cliente< ");
        }
        
    };
    boton.addActionListener(oyenteDeAccion);
//***************** PANELES ***********
    
    //mainPanel.setBackground(new Color(128, 0, 255));
    mainPanel.setBackground(new Color(0,228,255));
    mainPanel.setVisible(true);
    mainPanel.setSize(1000,1000);
    
//**************** LABELES *******************/
add(label1);
add(mainPanel);
label1.setBounds(130,100,260,30);

setVisible(true);
  
    
}

}
