
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EstadoPagos extends JFrame implements ActionListener, ItemListener {

    private Info vinfo;
    private JButton bt1;
    private JLabel lb1, lb2, lb3;
    private JComboBox<String> cb1;
    private JComboBox<Integer> cb2;
    private Principal datewindow;
    private int numteam = -1;

    public EstadoPagos(Info vinfo, Principal datewindow) {
        this.vinfo = vinfo;
        this.datewindow = datewindow;

        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Menú de pagos");
        setIconImage(new ImageIcon(
                getClass().getResource("images/logo.png")
        ).getImage());

        lb1 = new JLabel("Elige # de equipo para cambiar su estado:");
        lb1.setForeground(Color.BLACK);
        lb1.setFont(new Font("Andale Mono", Font.BOLD, 14));
        lb1.setBounds(10, 50, 350, 30);
        add(lb1);

        lb2 = new JLabel("Interfaz de cambio de estado de pagos.");
        lb2.setForeground(Color.BLACK);
        lb2.setFont(new Font("Andale Mono", Font.BOLD, 18));
        lb2.setBounds(80, 10, 400, 30);
        add(lb2);

        lb3 = new JLabel("Elige el nuevo estado:");
        lb3.setForeground(Color.BLACK);
        lb3.setFont(new Font("Andale Mono", Font.BOLD, 14));
        lb3.setBounds(10, 100, 350, 30);
        add(lb3);

        cb1 = new JComboBox();
        cb1.setEditable(false);
        cb1.setFont(new Font("Andale Mono", Font.BOLD, 14));
        cb1.setBackground(Color.WHITE);
        cb1.setForeground(Color.BLACK);
        cb1.setBounds(180, 100, 210, 30);

        cb1.addItem("Pendiente de pago");
        cb1.addItem("Inscripción aceptada.");
        cb1.addItem("Pago confirmado.");
        cb1.addItem("Registro cancelado.");

        add(cb1);

        cb2 = new JComboBox();
        cb2.setEditable(false);
        cb2.setFont(new Font("Andale Mono", Font.BOLD, 14));
        cb2.setBackground(Color.WHITE);
        cb2.setForeground(Color.BLACK);
        cb2.setBounds(340, 50, 130, 30);

        cb2.addItem(null);

        for (int i = 1; i <= 10; i++) {
            cb2.addItem(i);
        }

        cb2.addItemListener(this);
        add(cb2);

        bt1 = new JButton("Cambiar");
        bt1.setBounds(180, 150, 150, 30);
        bt1.setFont(new Font("Andale Mono", Font.BOLD, 13));
        bt1.setBackground(Color.BLUE);
        bt1.setForeground(Color.WHITE);
        bt1.addActionListener(this);
        add(bt1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bt1) {

            if (datewindow == null || numteam < 0) {
                JOptionPane.showMessageDialog(this, "Selecciona un equipo válido.");
                return;
            }

            String nombreEquipo = datewindow.getDatos(numteam, 0);

            if (nombreEquipo == null || nombreEquipo.isBlank()) {
                JOptionPane.showMessageDialog(this, "El equipo seleccionado no está registrado.");
                return;
            }

            String nuevoEstado = cb1.getSelectedItem().toString();

            datewindow.setDatos(numteam, 11, nuevoEstado);

            if (vinfo != null && vinfo.isDisplayable()) {
                vinfo.actualizarTexto();
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Estado de pago actualizado correctamente."
            );
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource() != cb2 || e.getStateChange() != ItemEvent.SELECTED) {
            return;
        }

        Integer equipoSeleccionado = (Integer) cb2.getSelectedItem();

        if (equipoSeleccionado == null) {
            numteam = -1;
            cb1.setSelectedIndex(0);
            return;
        }

        numteam = equipoSeleccionado - 1;

        if (datewindow == null) {
            cb1.setSelectedIndex(0);
            return;
        }

        String nombreEquipo = datewindow.getDatos(numteam, 0);

        if (nombreEquipo == null || nombreEquipo.isBlank()) {
            cb1.setSelectedIndex(0);
            return;
        }

        String estadoActual = datewindow.getDatos(numteam, 11);

        if (estadoActual == null || estadoActual.isBlank()) {
            cb1.setSelectedIndex(0);
            return;
        }

        cb1.setSelectedItem(estadoActual);

        if (estadoActual.equals("Pendiente de pago.")) {
            cb1.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            EstadoPagos test = new EstadoPagos(null, null);
            test.setSize(540, 250);
            test.setResizable(false);
            test.setLocationRelativeTo(null);
            test.setVisible(true);
        });
    }
}
