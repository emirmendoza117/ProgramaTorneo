import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Info extends JFrame implements ItemListener {

    private JLabel lb1, lb2;
    private JScrollPane sc;
    private JTextArea textarea1;
    private JComboBox cb;

    public Info() {
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Menu de información");
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());

        lb1 = new JLabel("Info de Registros");
        lb1.setForeground(new Color(0, 0, 0));
        lb1.setFont(new Font("Andale Mono", 1, 14));
        lb1.setBounds(25, 10, 150, 30);
        add(lb1);

        lb2 = new JLabel("# de Equipo:");
        lb2.setForeground(new Color(0, 0, 0));
        lb2.setFont(new Font("Andale Mono", 1, 14));
        lb2.setBounds(310, 10, 150, 30);
        add(lb2);

        textarea1 = new JTextArea(" Equipo: " +
                "\n Capitán: " +
                "\n Correo: " +
                "\n Videojuego: " +
                "\n Plataforma: " +
                "\n Integrantes: " +
                "\n Tipo: " +
                "\n\n Precio base: $350" +
                "\n Descuento:" +
                "\n Total:" +
                "\n\n Estado:");
        textarea1.setFont(new Font("Andale Mono", 0, 14));
        textarea1.setForeground(new Color(0, 0, 0));
        textarea1.setBackground(new Color(255, 255, 255));
        textarea1.setEditable(false);
        sc = new JScrollPane(textarea1);
        sc.setBounds(10, 50, 500, 300);
        add(sc);

        cb = new JComboBox();
        cb.setEditable(false);
        cb.setFont(new Font("Andale Mono", 1, 14));
        cb.setBackground(new Color(255, 255, 255));
        cb.setForeground(new Color(0, 0, 0));
        cb.setBounds(400, 10, 80, 30);
        cb.addItem("");
        for (int i = 1; i <= 10; i++) {
            cb.addItem(i);
        }
        cb.addItemListener(this);
        add(cb);
    }

    public void itemStateChanged(ItemEvent e) {
        String Snumber = cb.getSelectedItem().toString();

        if (Snumber.equals("")) {
            textarea1.setText(" Equipo: " +
                    "\n Capitán: " +
                    "\n Correo: " +
                    "\n Videojuego: " +
                    "\n Plataforma: " +
                    "\n Integrantes: " +
                    "\n Tipo: " +
                    "\n\n Precio base: $350" +
                    "\n Descuento:" +
                    "\n Total:" +
                    "\n\n Estado:");
        } else {
            int number = Integer.parseInt(Snumber) - 1;
            textarea1.setText(" Nombre del equipo: " + Principal.Datos[number][0] +
                    "\n Capitán: " + Principal.Datos[number][1] +
                    "\n Correo: " + Principal.Datos[number][2] +
                    "\n Videojuego: " + Principal.Datos[number][3] +
                    "\n Plataforma: " + Principal.Datos[number][4] +
                    "\n Integrantes: " + Principal.Datos[number][5] +
                    "\n Tipo: " + Principal.Datos[number][6] +
                    "\n\n Precio base: $350" +
                    "\n Descuento:" +
                    "\n Total:" +
                    "\n\n Estado:");

        }
    }

    public static void main(String[] args) {
        Info prueba = new Info();
        prueba.setBounds(0, 0, 540, 400);
        prueba.setResizable(false);
        prueba.setLocationRelativeTo(null);
        prueba.setVisible(true);
    }
}
