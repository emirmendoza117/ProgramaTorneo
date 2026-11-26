import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame implements ActionListener, ItemListener {

    private JMenuBar mb;
    private JMenu menuOpciones, menuTema, menuRegistro, menuAcerca;
    private JMenuItem menuItemRegistros, menuItemVerde, menuItemAzul, menuItemBlanco, menuItemColorPre, menuItemSalir,
            menuItemCerrarSesion, menuItemNuevo, menuItemAcerca, menuItemReiniciar,menuItemTorneo;
    private JTextField fieldNombreEquipo, fieldNombreCapitan, fieldCorreoCapitan;
    private JComboBox<String> comboVideojuego, comboPlataformaDisponible, comboIntegrantes;
    private JLabel lbEquipo, lbCapitan, lbCorreo, lbJuego, lbPlataforma, lbIntegrantes, lbtitle, lblogo, lbicon,
            lbadmin, lbNumRegistro;
    private String aNombrEquipo, aNombreCapitan, aCorreoCapitan, aVideojuego, aPlataforma, aIntegrantes;
    private JButton btregistro;
    private Color preback, premenu;
    private String[][] Datos = new String[10][12];
    private String Sadminname = Login.Sadmin;
    private int numregistro = 0, numintegrantes = 0, numPreciobase = 0, numDescuento = 0, numTotal = 0,
            numPrecioIntegrantes = 0;
    private Info vinfo;

    public Principal() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        setTitle("Registros");
        preback = getContentPane().getBackground();

        iniciarBaseDatos();

        // Menu de Barras configuración
        mb = new JMenuBar();
        setJMenuBar(mb);
        premenu = mb.getBackground();

        menuOpciones = new JMenu("Opciones");
        menuOpciones.setFont(new Font("Andale Mono", 0, 12));
        menuOpciones.setForeground(new Color(0, 0, 0));
        mb.add(menuOpciones);

        menuTema = new JMenu("Tema");
        menuTema.setFont(new Font("Andale Mono", 0, 12));
        menuTema.setForeground(new Color(0, 0, 0));
        mb.add(menuTema);

        menuRegistro = new JMenu("Operaciones");
        menuRegistro.setFont(new Font("Andale Mono", 0, 12));
        menuRegistro.setForeground(new Color(0, 0, 0));
        mb.add(menuRegistro);

        menuAcerca = new JMenu("Extra");
        menuAcerca.setFont(new Font("Andale Mono", 0, 12));
        menuAcerca.setForeground(new Color(0, 0, 0));
        mb.add(menuAcerca);

        menuItemNuevo = new JMenuItem("Nuevo");
        menuItemNuevo.setFont(new Font("Andale Mono", 0, 12));
        menuItemNuevo.setForeground(new Color(0, 0, 0));
        menuItemNuevo.addActionListener(this);
        menuOpciones.add(menuItemNuevo);

        menuItemReiniciar = new JMenuItem("Reiniciar");
        menuItemReiniciar.setFont(new Font("Andale Mono", 0, 12));
        menuItemReiniciar.setForeground(new Color(0, 0, 0));
        menuItemReiniciar.addActionListener(this);
        menuOpciones.add(menuItemReiniciar);

        menuItemCerrarSesion = new JMenuItem("Cerrar Sesion");
        menuItemCerrarSesion.setFont(new Font("Andale Mono", 0, 12));
        menuItemCerrarSesion.setForeground(new Color(0, 0, 0));
        menuOpciones.add(menuItemCerrarSesion);
        menuItemCerrarSesion.addActionListener(this);

        menuItemSalir = new JMenuItem("Salir");
        menuItemSalir.setFont(new Font("Andale Mono", 0, 12));
        menuItemSalir.setForeground(new Color(0, 0, 0));
        menuItemSalir.addActionListener(this);
        menuOpciones.add(menuItemSalir);

        menuItemBlanco = new JMenuItem("Blanco");
        menuItemBlanco.setFont(new Font("Andale Mono", 0, 12));
        menuItemBlanco.setForeground(new Color(0, 0, 0));
        menuItemBlanco.addActionListener(this);
        menuTema.add(menuItemBlanco);

        menuItemAzul = new JMenuItem("Azul");
        menuItemAzul.setFont(new Font("Andale Mono", 0, 12));
        menuItemAzul.setForeground(new Color(0, 0, 0));
        menuItemAzul.addActionListener(this);
        menuTema.add(menuItemAzul);

        menuItemVerde = new JMenuItem("Verde");
        menuItemVerde.setFont(new Font("Andale Mono", 0, 12));
        menuItemVerde.setForeground(new Color(0, 0, 0));
        menuItemVerde.addActionListener(this);
        menuTema.add(menuItemVerde);

        menuItemColorPre = new JMenuItem("Predeterminado");
        menuItemColorPre.setFont(new Font("Andale Mono", 0, 12));
        menuItemColorPre.setForeground(new Color(0, 0, 0));
        menuItemColorPre.addActionListener(this);
        menuTema.add(menuItemColorPre);

        menuItemRegistros = new JMenuItem("Base de Datos");
        menuItemRegistros.setFont(new Font("Andale Mono", 0, 12));
        menuItemRegistros.setForeground(new Color(0, 0, 0));
        menuItemRegistros.addActionListener(this);
        menuRegistro.add(menuItemRegistros);

        menuItemTorneo = new JMenuItem("Acerca del Torneo");
        menuItemTorneo.setFont(new Font("Andale Mono", 0, 12));
        menuItemTorneo.setForeground(new Color(0, 0, 0));
        menuItemTorneo.addActionListener(this);
        menuRegistro.add(menuItemTorneo);

        menuItemAcerca = new JMenuItem("Acerca de");
        menuItemAcerca.setFont(new Font("Andale Mono", 0, 12));
        menuItemAcerca.setForeground(new Color(0, 0, 0));
        menuItemAcerca.addActionListener(this);
        menuAcerca.add(menuItemAcerca);

        // Configuración de componentes de la pantalla

        fieldNombreEquipo = new JTextField("");
        fieldNombreEquipo.setFont(new Font("Andale Mono", 1, 14));
        fieldNombreEquipo.setForeground(new Color(0, 0, 0));
        fieldNombreEquipo.setBounds(30, 200, 200, 30);
        add(fieldNombreEquipo);

        fieldNombreCapitan = new JTextField("");
        fieldNombreCapitan.setFont(new Font("Andale Mono", 1, 14));
        fieldNombreCapitan.setForeground(new Color(0, 0, 0));
        fieldNombreCapitan.setBounds(30, 280, 200, 30);
        add(fieldNombreCapitan);

        fieldCorreoCapitan = new JTextField("");
        fieldCorreoCapitan.setFont(new Font("Andale Mono", 1, 14));
        fieldCorreoCapitan.setForeground(new Color(0, 0, 0));
        fieldCorreoCapitan.setBounds(30, 360, 200, 30);
        add(fieldCorreoCapitan);

        comboVideojuego = new JComboBox();
        comboVideojuego.setFont(new Font("Andale Mono", 1, 14));
        comboVideojuego.setForeground(new Color(0, 0, 0));
        comboVideojuego.setEditable(false);
        comboVideojuego.setBounds(30, 440, 200, 30);
        comboVideojuego.addItem("");
        comboVideojuego.addItem("Minecraft");
        comboVideojuego.addItem("Valorant");
        comboVideojuego.addItem("Fortnite");
        comboVideojuego.addItem("Roblox");
        comboVideojuego.addItemListener(this);
        add(comboVideojuego);

        comboPlataformaDisponible = new JComboBox();
        comboPlataformaDisponible.setFont(new Font("Andale Mono", 1, 14));
        comboPlataformaDisponible.setForeground(new Color(0, 0, 0));
        comboPlataformaDisponible.setEditable(false);
        comboPlataformaDisponible.setBounds(30, 520, 200, 30);
        comboPlataformaDisponible.addItem("");
        comboPlataformaDisponible.addItem("PC");
        comboPlataformaDisponible.addItem("Xbox");
        comboPlataformaDisponible.addItem("PlayStation");
        comboPlataformaDisponible.addItem("Nintendo Switch");
        comboPlataformaDisponible.addItemListener(this);
        add(comboPlataformaDisponible);

        comboIntegrantes = new JComboBox();
        comboIntegrantes.setFont(new Font("Andale Mono", 0, 12));
        comboIntegrantes.setForeground(new Color(0, 0, 0));
        comboIntegrantes.setEditable(false);
        comboIntegrantes.setBounds(30, 600, 200, 30);
        comboIntegrantes.addItem("");
        for (int i = 1; i <= 10; i++) {
            comboIntegrantes.addItem(String.valueOf(i));
        }
        comboIntegrantes.addItemListener(this);
        add(comboIntegrantes);

        btregistro = new JButton("Registrar");
        btregistro.setFont(new Font("Andale Mono", 1, 16));
        btregistro.setForeground(new Color(255, 255, 255));
        btregistro.setBackground(new Color(0, 128, 0));
        btregistro.setBounds(400, 600, 150, 30);
        btregistro.addActionListener(this);
        add(btregistro);

        lbEquipo = new JLabel("Nombre del Equipo:");
        lbEquipo.setFont(new Font("Andale Mono", 1, 14));
        lbEquipo.setForeground(new Color(0, 0, 0));
        lbEquipo.setBounds(30, 170, 150, 30);
        add(lbEquipo);

        lbCapitan = new JLabel("Nombre del Capitán:");
        lbCapitan.setFont(new Font("Andale Mono", 1, 14));
        lbCapitan.setForeground(new Color(0, 0, 0));
        lbCapitan.setBounds(30, 250, 150, 30);
        add(lbCapitan);

        lbCorreo = new JLabel("Correo del Capitán");
        lbCorreo.setFont(new Font("Andale Mono", 1, 14));
        lbCorreo.setForeground(new Color(0, 0, 0));
        lbCorreo.setBounds(30, 330, 150, 30);
        add(lbCorreo);

        lbJuego = new JLabel("Videojuego:");
        lbJuego.setFont(new Font("Andale Mono", 1, 14));
        lbJuego.setForeground(new Color(0, 0, 0));
        lbJuego.setBounds(30, 410, 150, 30);
        add(lbJuego);

        lbPlataforma = new JLabel("Plataforma de juego:");
        lbPlataforma.setFont(new Font("Andale Mono", 1, 14));
        lbPlataforma.setForeground(new Color(0, 0, 0));
        lbPlataforma.setBounds(30, 490, 150, 30);
        add(lbPlataforma);

        lbIntegrantes = new JLabel("Cantidad de integrantes:");
        lbIntegrantes.setFont(new Font("Andale Mono", 1, 14));
        lbIntegrantes.setForeground(new Color(0, 0, 0));
        lbIntegrantes.setBounds(30, 570, 180, 30);
        add(lbIntegrantes);

        lbtitle = new JLabel("Bienvenido");
        lbtitle.setFont(new Font("Andale Mono", 1, 64));
        lbtitle.setForeground(new Color(0, 0, 0));
        lbtitle.setBounds(310, 50, 400, 60);
        add(lbtitle);

        lbadmin = new JLabel("Administrador: " + Sadminname);
        lbadmin.setFont(new Font("Andale Mono", 1, 14));
        lbadmin.setForeground(new Color(0, 0, 0));
        lbadmin.setBounds(575, 650, 150, 30);
        add(lbadmin);

        lbNumRegistro = new JLabel("Numero de registro: " + (numregistro + 1));
        lbNumRegistro.setFont(new Font("Andale Mono", 1, 14));
        lbNumRegistro.setForeground(new Color(0, 0, 0));
        lbNumRegistro.setBounds(10, 650, 250, 30);
        add(lbNumRegistro);

        ImageIcon imageGetIcon = new ImageIcon("images/control.png");
        Image imageIconScaled = imageGetIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon imageIconSet = new ImageIcon(imageIconScaled);
        lblogo = new JLabel(imageIconSet);
        lblogo.setBounds(150, 20, 120, 120);
        add(lblogo);

        lbicon = new JLabel();
        lbicon.setBounds(290, 200, 360, 360);
        add(lbicon);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btregistro) {
            if (fieldNombreEquipo.getText().isBlank() || fieldNombreCapitan.getText().isBlank()
                    || fieldCorreoCapitan.getText().isBlank() || comboVideojuego.getSelectedItem().equals("")
                    || comboPlataformaDisponible.getSelectedItem().equals("")
                    || comboIntegrantes.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "Rellene correctamente los campos");
            } else {

                if (numregistro <=9) {

                    aNombrEquipo = fieldNombreEquipo.getText().toString();
                    aNombreCapitan = fieldNombreCapitan.getText().toString();
                    aCorreoCapitan = fieldCorreoCapitan.getText().toString();
                    aVideojuego = comboVideojuego.getSelectedItem().toString();
                    aPlataforma = comboPlataformaDisponible.getSelectedItem().toString();
                    aIntegrantes = comboIntegrantes.getSelectedItem().toString();
                    numintegrantes = Integer.parseInt(comboIntegrantes.getSelectedItem().toString());

                    Datos[numregistro][0] = aNombrEquipo;
                    Datos[numregistro][1] = aNombreCapitan;
                    Datos[numregistro][2] = aCorreoCapitan;
                    Datos[numregistro][3] = aVideojuego;
                    Datos[numregistro][4] = aPlataforma;
                    Datos[numregistro][5] = aIntegrantes;

                    /// Asignar tipo de equipo y el precio por integrante

                    if (numintegrantes == 1) {
                        Datos[numregistro][6] = "Individual";
                    } else if (numintegrantes >= 2 && numintegrantes <= 5) {
                        Datos[numregistro][6] = "Equipo";
                        numPrecioIntegrantes = (numintegrantes - 1) * 50;
                    } else if (numintegrantes > 5 && numintegrantes <= 10) {
                        Datos[numregistro][6] = "Profesional";
                        numPrecioIntegrantes = (numintegrantes - 5) * 75;
                    }

                    // Asignar precio total sin descuento

                    if (Datos[numregistro][6].equals("Individual")) {
                        Datos[numregistro][7] = "100";
                        numPreciobase = 100;
                        numTotal = numPreciobase + numPrecioIntegrantes;
                    } else if (Datos[numregistro][6].equals("Equipo")) {
                        Datos[numregistro][7] = "350";
                        numPreciobase = 350;
                        numTotal = numPreciobase + numPrecioIntegrantes;
                    } else if (Datos[numregistro][6].equals("Profesional")) {
                        Datos[numregistro][7] = "800";
                        numPreciobase = 800;
                        numTotal = numPreciobase + numPrecioIntegrantes;
                    }

                    // Asignar descuentos

                    if (numintegrantes > 5) {
                        numDescuento = (numTotal * 10) / 100;
                    }

                    if (aVideojuego.equals("Minecraft")) {
                        numDescuento += 50;
                    }

                    if (numDescuento != 0) {
                        Datos[numregistro][9] = "$ " + String.valueOf(numDescuento);
                    } else {
                        Datos[numregistro][9] = "Sin Descuento";
                    }

                    if (numDescuento < numTotal){
                        Datos[numregistro][10] = String.valueOf(numTotal - numDescuento);
                    } else {
                        Datos[numregistro][10] = String.valueOf((numTotal) + "El descuento no aplica");
                    }

                    Datos[numregistro][11] = "Pendiente de pago";
                    Datos[numregistro][8] = String.valueOf(numPrecioIntegrantes);

                    numregistro++;
                    numintegrantes = 0;
                    numPreciobase = 0;
                    numDescuento = 0;
                    numTotal = 0;
                    numPrecioIntegrantes = 0;

                    if (numregistro < Datos.length) {
                        lbNumRegistro.setText("Numero de registro: " + (numregistro + 1));
                    } else {
                        lbNumRegistro.setText("Numero de registro: Completo");
                    }

                    if (vinfo !=null && vinfo.isDisplayable()){
                        vinfo.actualizarTexto();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Numero de registro lleno");
                }
            }
        }

        if (e.getSource() == menuItemRegistros) {

            if (vinfo != null && vinfo.isDisplayable()) {
                vinfo.setVisible(true);
            } else {
                vinfo = new Info(this);
                vinfo.setBounds(0, 0, 540, 450);
                vinfo.setResizable(false);
                vinfo.setLocationRelativeTo(null);
                vinfo.setVisible(true);
            }
        }

        if (e.getSource() == menuItemBlanco) {
            getContentPane().setBackground(new Color(255, 255, 255));
            mb.setBackground(new Color(255, 255, 255));
            menuOpciones.setForeground(new Color(0, 0, 0));
            menuTema.setForeground(new Color(0, 0, 0));
            menuRegistro.setForeground(new Color(0, 0, 0));
            menuAcerca.setForeground(new Color(0, 0, 0));
            lbEquipo.setForeground(new Color(0, 0, 0));
            lbCapitan.setForeground(new Color(0, 0, 0));
            lbCorreo.setForeground(new Color(0, 0, 0));
            lbJuego.setForeground(new Color(0, 0, 0));
            lbPlataforma.setForeground(new Color(0, 0, 0));
            lbIntegrantes.setForeground(new Color(0, 0, 0));
            lbtitle.setForeground(new Color(0, 0, 0));
            lbadmin.setForeground(new Color(0, 0, 0));
            lbNumRegistro.setForeground(new Color(0, 0, 0));
        }

        if (e.getSource() == menuItemAzul) {
            getContentPane().setBackground(new Color(0, 0, 255));
            mb.setBackground(new Color(0, 0, 255));
            menuOpciones.setForeground(new Color(255, 255, 255));
            menuTema.setForeground(new Color(255, 255, 255));
            menuRegistro.setForeground(new Color(255, 255, 255));
            menuAcerca.setForeground(new Color(255, 255, 255));
            lbEquipo.setForeground(new Color(255, 255, 255));
            lbCapitan.setForeground(new Color(255, 255, 255));
            lbCorreo.setForeground(new Color(255, 255, 255));
            lbJuego.setForeground(new Color(255, 255, 255));
            lbPlataforma.setForeground(new Color(255, 255, 255));
            lbIntegrantes.setForeground(new Color(255, 255, 255));
            lbtitle.setForeground(new Color(255, 255, 255));
            lbadmin.setForeground(new Color(255, 255, 255));
            lbNumRegistro.setForeground(new Color(255, 255, 255));
        }

        if (e.getSource() == menuItemVerde) {
            getContentPane().setBackground(new Color(0, 255, 0));
            mb.setBackground(new Color(0, 255, 0));
            menuOpciones.setForeground(new Color(255, 255, 255));
            menuTema.setForeground(new Color(255, 255, 255));
            menuRegistro.setForeground(new Color(255, 255, 255));
            menuAcerca.setForeground(new Color(255, 255, 255));
            lbEquipo.setForeground(new Color(255, 255, 255));
            lbCapitan.setForeground(new Color(255, 255, 255));
            lbCorreo.setForeground(new Color(255, 255, 255));
            lbJuego.setForeground(new Color(255, 255, 255));
            lbPlataforma.setForeground(new Color(255, 255, 255));
            lbIntegrantes.setForeground(new Color(255, 255, 255));
            lbtitle.setForeground(new Color(255, 255, 255));
            lbadmin.setForeground(new Color(255, 255, 255));
            lbNumRegistro.setForeground(new Color(255, 255, 255));
        }

        if (e.getSource() == menuItemColorPre) {
            getContentPane().setBackground(preback);
            mb.setBackground(premenu);
            menuOpciones.setForeground(new Color(0, 0, 0));
            menuTema.setForeground(new Color(0, 0, 0));
            menuRegistro.setForeground(new Color(0, 0, 0));
            menuAcerca.setForeground(new Color(0, 0, 0));
            lbEquipo.setForeground(new Color(0, 0, 0));
            lbCapitan.setForeground(new Color(0, 0, 0));
            lbCorreo.setForeground(new Color(0, 0, 0));
            lbJuego.setForeground(new Color(0, 0, 0));
            lbPlataforma.setForeground(new Color(0, 0, 0));
            lbIntegrantes.setForeground(new Color(0, 0, 0));
            lbtitle.setForeground(new Color(0, 0, 0));
            lbadmin.setForeground(new Color(0, 0, 0));
            lbNumRegistro.setForeground(new Color(0, 0, 0));
        }

        if (e.getSource() == menuItemAcerca) {
            JOptionPane.showMessageDialog(null, "Emir Mendoza" +
                    "\n Correo: emirfernando29@gmail.com");
        }

        if (e.getSource() == menuItemNuevo) {
            fieldNombreEquipo.setText("");
            fieldNombreCapitan.setText("");
            fieldCorreoCapitan.setText("");
            comboVideojuego.setSelectedIndex(0);
            comboPlataformaDisponible.setSelectedIndex(0);
            comboIntegrantes.setSelectedIndex(0);
        }

        if (e.getSource() == menuItemReiniciar) {
            fieldNombreEquipo.setText("");
            fieldNombreCapitan.setText("");
            fieldCorreoCapitan.setText("");
            comboVideojuego.setSelectedIndex(0);
            comboPlataformaDisponible.setSelectedIndex(0);
            comboIntegrantes.setSelectedIndex(0);
            iniciarBaseDatos();
            numregistro=0;
            lbNumRegistro.setText("Numero de registro: " + (numregistro + 1));

            if (vinfo != null && vinfo.isDisplayable()) {
                vinfo.dispose();
            }
        }

        if (e.getSource()==menuItemCerrarSesion) {
            Login ventanaInicio = new Login();
            ventanaInicio.setBounds(0,0,650,600);
            ventanaInicio.setResizable(false);
            ventanaInicio.setLocationRelativeTo(null);
            ventanaInicio.setVisible(true);

            if (vinfo != null && vinfo.isDisplayable()) {
                vinfo.dispose();
            }
            dispose();
        }

        if (e.getSource()==menuItemSalir) {
            System.exit(0);
        }

        if (e.getSource()==menuItemTorneo) {
            JOptionPane.showMessageDialog(null, "Arena Masters" + 
            "\nTorneo presencial"+
            "\nMaximo de equipo:10"+
            "\nPremio: $20,000"+
            "\nOrganizador: " + Sadminname);
        }
    }

    public void iniciarBaseDatos(){
        for (int i = 0; i<Datos.length;i++){
            for (int j = 0;j<Datos[i].length;j++){
                Datos[i][j] = "";
            }
        }
    }

    public String getDatos(int number, int number2){
        if (number < 11 && number2 < 13) {
            return Datos[number][number2];
        }
        return null;
    }

    public void setDatos(int number, int number2, String Svalue){
        if (number < 11 && number2 < 13) {
            Datos[number][number2]=Svalue;
        }
    }

    public void itemStateChanged(ItemEvent e) {

        String ijuego = comboVideojuego.getSelectedItem().toString();

        ImageIcon gameimageget = new ImageIcon();
        Image gameimagescaled;
        ImageIcon gameimageset = new ImageIcon();

        if (!ijuego.equals("")) {
            if (ijuego.equals("Minecraft")) {
                gameimageget.setImage(new ImageIcon("images/minecraft.png").getImage());
                gameimagescaled = gameimageget.getImage().getScaledInstance(360, 360, Image.SCALE_SMOOTH);
                gameimageset.setImage(new ImageIcon(gameimagescaled).getImage());
                lbicon.setIcon(gameimageset);
            }

            if (ijuego.equals("Valorant")) {
                gameimageget.setImage(new ImageIcon("images/valorant.png").getImage());
                gameimagescaled = gameimageget.getImage().getScaledInstance(360, 360, Image.SCALE_SMOOTH);
                gameimageset.setImage(new ImageIcon(gameimagescaled).getImage());
                lbicon.setIcon(gameimageset);
            }

            if (ijuego.equals("Fortnite")) {
                gameimageget.setImage(new ImageIcon("images/fortnite.jpg").getImage());
                gameimagescaled = gameimageget.getImage().getScaledInstance(360, 360, Image.SCALE_SMOOTH);
                gameimageset.setImage(new ImageIcon(gameimagescaled).getImage());
                lbicon.setIcon(gameimageset);
            }

            if (ijuego.equals("Roblox")) {
                gameimageget.setImage(new ImageIcon("images/roblox.png").getImage());
                gameimagescaled = gameimageget.getImage().getScaledInstance(360, 360, Image.SCALE_SMOOTH);
                gameimageset.setImage(new ImageIcon(gameimagescaled).getImage());
                lbicon.setIcon(gameimageset);
            }
        } else {
            lbicon.setIcon(null);
        }
    }

    public static void main(String[] args) {
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setBounds(0, 0, 800, 750);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(true);
    }
}