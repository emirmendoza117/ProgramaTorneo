import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{

    private JLabel llogo, label1, label2, labeltitle;
    private JTextField admin;
    private JButton button1;
    public static String Sadmin="";

    public Login(){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255,255,255));
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        setTitle("Pantalla de Inicio");

        ImageIcon imageget = new ImageIcon("images/logo.png"), imageset;
        Image imagescaled = imageget.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
        imageset = new ImageIcon(imagescaled);
        llogo = new JLabel(imageset);
        llogo.setBounds(80,80,140,140);
        add(llogo);

        label1 = new JLabel("Ingrese el nombre del organizador.");
        label1.setBounds(190,320,270,40);
        label1.setFont(new Font("Andale Mono",1,16));
        label1.setForeground(new Color(0,0,0));
        add(label1);

        labeltitle = new JLabel("Bienvenido");
        labeltitle.setBounds(240,120,300,60);
        labeltitle.setFont(new Font("Andale Mono",1,54));
        labeltitle.setForeground(new Color(0,0,0));
        add(labeltitle);

        button1 = new JButton("Ingresar");
        button1.setBounds(270,400,110,35);
        button1.setFont(new Font("Andale Mono",1,17));
        button1.addActionListener(this);
        add(button1);

        label2 = new JLabel("©Todos los derechos reservados.");
        label2.setBounds(205,520,250,40);
        label2.setFont(new Font("Andale Mono",1,14));
        label2.setForeground(new Color(0,0,0));
        add(label2);

        admin = new JTextField("");
        admin.setForeground(new Color(0,0,0));
        admin.setBounds(225,360,200,35);
        admin.setBackground(new Color(224,224,224));
        admin.setFont(new Font("Andale Mono",1,17));
        add(admin);
    }

    public void actionPerformed(ActionEvent e){
                
        if (e.getSource()==button1){

            Sadmin = admin.getText().trim();

            if (admin.getText().isEmpty() || admin.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre del organizador");
            return;
            }
           
            if (Sadmin=="" || Sadmin=="null") {
                JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre del organizador");
            } else{
                Licencia prueba = new Licencia(this);
                prueba.setBounds(0,0,650,400);
                prueba.setResizable(false);
                prueba.setLocationRelativeTo(null);
                prueba.setVisible(true);
            }

        }
    }

    public static void main(String[] args) {
        Login ventanaInicio = new Login();
        ventanaInicio.setBounds(0,0,650,600);
        ventanaInicio.setResizable(false);
        ventanaInicio.setLocationRelativeTo(null);
        ventanaInicio.setVisible(true);
    }
}