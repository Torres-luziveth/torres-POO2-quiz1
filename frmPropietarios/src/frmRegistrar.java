import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class frmRegistrar extends JFrame implements ActionListener {
    static ImageIcon imgRegistrar, imgRegresar;
    static JButton btnRegresar,btnRegistrar;
    static JLabel lblIndicaciones, lblNombre, lblApellido, lbledad, lbldocumuento, lblId;
    static JTextField txtNombre, txtApellido, txtEdad, txtDocumento, txtIdPropietario;
    static ArrayList<Propietario> registroPropietarios; // ArrayList de propietarios

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)) {
            frmPropietarios.ventana.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(btnRegistrar)) {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            int documento = Integer.parseInt(txtDocumento.getText());
            String id = txtIdPropietario.getText();

            Propietario nuevoPropietario = new Propietario(nombre, apellido, edad, documento, id);
            registroPropietarios.add(nuevoPropietario);

            // limpiar los campos de texto después de registrar
            txtNombre.setText("");
            txtApellido.setText("");
            txtEdad.setText("");
            txtDocumento.setText("");
            txtIdPropietario.setText("");

        }
    }


    public frmRegistrar(ArrayList<Propietario> registroPropietarios) {
        this.registroPropietarios = registroPropietarios;

        // Jlabels
        lblIndicaciones = new JLabel("---Datos del propietario---");
        lblNombre =new JLabel("Nombre:");
        lblApellido = new JLabel("Apellido:");
        lbledad = new JLabel("Edad:");
        lbldocumuento = new JLabel("Documento:");
        lblId = new JLabel("Id propietario:");

        //Imagenes
        imgRegistrar = new ImageIcon(".\\img\\registrar.png");
        imgRegresar = new ImageIcon(".\\img\\regresar.png");

        //Botones
        btnRegresar = new JButton("Regresar", imgRegresar);
        btnRegistrar = new JButton("Registrar", imgRegistrar);

        //campos de texto
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtEdad = new JTextField();
        txtDocumento = new JTextField();
        txtIdPropietario= new JTextField();



        // setBuonds
        btnRegresar.setBounds(50, 250, 125, 25);
        btnRegistrar.setBounds(260,250,125,25);

        lblIndicaciones.setBounds(145, 10, 225, 60);

        lblNombre.setBounds(50, 70, 80,20);
        txtNombre.setBounds(110, 70, 100, 25);

        lblApellido.setBounds(220,70,80,20);
        txtApellido.setBounds(280, 70, 100, 25);

        lbledad.setBounds(50, 110, 80, 20 );
        txtEdad.setBounds(90, 110, 100, 25);

        lbldocumuento.setBounds(50, 150,180,20);
        txtDocumento.setBounds(130, 150, 115, 25);

        lblId.setBounds(50,190,210,20);
        txtIdPropietario.setBounds(140, 190, 105, 25);

        //actionListen
        btnRegresar.addActionListener(this);
        btnRegistrar.addActionListener(this);

        // adicionar
        add(btnRegresar);
        add(btnRegistrar);

        add(lblIndicaciones);

        add(lblNombre);
        add(txtNombre);

        add(lblApellido);
        add(txtApellido);

        add(lbledad);
        add(txtEdad);

        add(lbldocumuento);
        add(txtDocumento);

        add(lblId);
        add(txtIdPropietario);

        // configuracion ventana
        Color c = new Color(150, 182, 178);
        getContentPane().setBackground(c);

        setLayout(null);
        setSize(450,350);
        setTitle("Registro");

        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocation(400,170);
    }
}
