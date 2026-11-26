import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Info extends JFrame implements ActionListener, ItemListener {

    private JLabel lb1, lb2;
    private JScrollPane sc;
    private JTextArea textarea1;
    private JComboBox cb;
    private Principal Principal;
    private JButton button1;

    public Info(Principal Principal) {
        this.Principal = Principal;
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
                "\n\n Precio base:" +
                "\n Precio de Integrantes:"+
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

        button1 = new JButton("Estados Pagos");
        button1.setBounds(10,360,150,30);
        button1.setFont(new Font("Andale Mono",1,13));
        button1.setBackground(new Color(255,255,255));
        button1.setForeground(new Color(0,0,0));
        button1.addActionListener(this);
        add(button1);
    }

    public void actualizarTexto(){

        String Snumber=cb.getSelectedItem().toString();
        int number=0;

        if (Snumber.equals("")) {
            number = 0;
        } else {
            number = Integer.parseInt(Snumber) - 1;
        }

        if (Principal.getDatos(number, 0)==null || Snumber.equals("") || Principal.getDatos(number,0).equals("")) {
            textarea1.setText(" Equipo: " +
                    "\n Capitán: " +
                    "\n Correo: " +
                    "\n Videojuego: " +
                    "\n Plataforma: " +
                    "\n Integrantes: " +
                    "\n Tipo: " +
                    "\n\n Precio base:" +
                    "\n Precio de Integrantes:"+
                    "\n Descuento:" +
                    "\n Total:" +
                    "\n\n Estado:");
        } else {
            textarea1.setText(" Equipo: " + Principal.getDatos(number, 0) +
                    "\n Capitán: " + Principal.getDatos(number, 1) +
                    "\n Correo: " + Principal.getDatos(number, 2) +
                    "\n Videojuego: " + Principal.getDatos(number, 3) +
                    "\n Plataforma: " + Principal.getDatos(number, 4) +
                    "\n Integrantes: " + Principal.getDatos(number, 5) +
                    "\n Tipo: " + Principal.getDatos(number, 6) +
                    "\n\n Precio base: $"+ Principal.getDatos(number, 7) +
                    "\n Precio de Integrantes: $"+ Principal.getDatos(number, 8) +
                    "\n Descuento: " + Principal.getDatos(number, 9) +
                    "\n Total: $" + Principal.getDatos(number, 10) +
                    "\n\n Estado: " + Principal.getDatos(number, 11));

        }
    }

    public Info(){
        this(null);
    }

    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {
            actualizarTexto();
        }
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==button1){
            EstadoPagos ventanapagos = new EstadoPagos(this, Principal);
            ventanapagos.setBounds(0, 0, 540, 250);
            ventanapagos.setResizable(false);
            ventanapagos.setLocationRelativeTo(null);
            ventanapagos.setVisible(true);
        }
    }

    public static void main(String[] args) {
        Info prueba = new Info();
        prueba.setBounds(0, 0, 540, 450);
        prueba.setResizable(false);
        prueba.setLocationRelativeTo(null);
        prueba.setVisible(true);
    }
}
