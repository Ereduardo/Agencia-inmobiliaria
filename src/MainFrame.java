import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

public void inicializar(){
//*******************CONSTRUCTORES *************
JPanel mainPanel = new JPanel();    
setTitle("Agencia inmobiliaria"); //SetTitle con los construct por organizacion
Font fuente = new Font("Arial", Font.BOLD, 14);
JButton boton = new JButton("Añadir cliente");

JLabel label1 = new JLabel("<html> Bienvenido a la Agencia Inmobiliaria. <p> <p> Escoja una opción.");
label1.setFont(fuente);
ImageIcon fondo1 = new ImageIcon("fondo2.png");
JLabel label2 = new JLabel(); 
label2.setBounds(0,0, 800, 600);
label2.setIcon(new ImageIcon(fondo1.getImage().getScaledInstance(label2.getWidth(), label2.getHeight(), Image.SCALE_SMOOTH)));

// ************** ICONO DE LA VENTANA *************

    ImageIcon icon = new ImageIcon("icon.png");
    setIconImage(icon.getImage());
// *********** PROPIEDADES DE VENTANA *************+
    
   
    setLayout(null);
    setResizable(true);
    setVisible(true);
    setLocation(450,100);
    setSize(800,600);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
// *************** BOTONES ************
    
    boton.setBounds(200,400,300,30);
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
    //mainPanel.setBackground(new Color(0,228,255));
    mainPanel.setVisible(true);
    mainPanel.setSize(1000,1000);
    
//**************** LABELES *******************/
label1.setBounds(250,100,500,50);
label2.setBounds(0,-100,800,800);

    add(label1);
    add(label2);
    add(mainPanel);
    
   
    
  
    
}

}
