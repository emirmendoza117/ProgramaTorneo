import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Licencia extends JFrame implements ActionListener, ItemListener{

    private JLabel label1;
    private JScrollPane sb;
    private JTextArea textarea1;
    private JCheckBox check1;
    private JButton button1,button2;
    private JFrame v1;

    public Licencia(JFrame ventanaanterior){

        this.v1 = ventanaanterior;

        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Terminos y condiciones | Administrador: "+ Login.Sadmin);
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());

        label1 = new JLabel("Acepta las condiciones");
        label1.setForeground(new Color(0,0,0));
        label1.setFont(new Font("Andale Mono",1,16));
        label1.setBounds(180,0,200,40);
        add(label1);

        textarea1 = new JTextArea("\n\n                Terminos y condiciones."+
                                  "\n\n      1.- El uso de este programa es mero aprendizaje"+
                                  "\n      2.- Cualquier uso indebido de este programa esta estrictamentre prohibido"+
                                  "\n      3.- Uso totalmente libre con uso comercial bajo ciertas restricciones");
        textarea1.setFont(new Font("Andale Mono",1,13));
        textarea1.setForeground(new Color(0,0,0));
        textarea1.setEditable(false);
        sb = new JScrollPane(textarea1);
        sb.setBounds(10,40,500,300);
        add(sb);

        check1 = new JCheckBox("Yo Acepto");
        check1.setFont(new Font("Andale Mono",1,13));
        check1.setForeground(new Color(0,0,0));
        check1.setBounds(520,40,90,30);
        check1.addItemListener(this);
        add(check1);

        button1 = new JButton("Continuar");
        button1.setFont(new Font("Andale Mono",1,13));
        button1.setBounds(520,80,100,30);
        button1.addActionListener(this);
        button1.setEnabled(false);
        add(button1);

        button2 = new JButton("Rechazar");
        button2.setFont(new Font("Andale Mono",1,13));
        button2.setBounds(520,130,100,30);
        button2.addActionListener(this);
        button2.setEnabled(true);
        add(button2);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==button1){
            Principal ventanaPrincipal = new Principal();
            ventanaPrincipal.setBounds(0,0,800,750);
            ventanaPrincipal.setResizable(false);
            ventanaPrincipal.setLocationRelativeTo(null);
            ventanaPrincipal.setVisible(true);
            v1.dispose();
            dispose();
        }
        if (e.getSource()==button2){
            this.dispose();
        }
    }

    public void itemStateChanged(ItemEvent e){
        if (check1.isSelected()==false) {
            button1.setEnabled(false);
            button2.setEnabled(true);
        } else {
            button1.setEnabled(true);
            button2.setEnabled(false);            
        }
    }
}
