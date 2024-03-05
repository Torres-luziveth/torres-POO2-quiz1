import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class frmBuscar extends JFrame implements ActionListener {
    static ImageIcon imgRegresar, imgBuscar;
    static JButton btnRegresar, btnBuscar;
    static JLabel lblIndicaciones;
    static JTextField txtNombre;
    static ArrayList<Propietario> registroPropietarios; // ArrayList de propietarios

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)) {
            frmPropietarios.ventana.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(btnBuscar)){

            String nombreBuscado = txtNombre.getText();
            boolean encontrado = false;
            
            StringBuilder sb = new StringBuilder();
            for (Propietario propietario : registroPropietarios) {
                if (propietario.getNombre().equals(nombreBuscado)) {
                    sb.append("Propietario encontrado:\n");
                    sb.append("Nombre: ").append(propietario.getNombre()).append("\nApellido: ").append(propietario.getApellido()).append("\nId propietario:").append(propietario.getId_Propietario()).append("\n");
                    encontrado = true;
                }
            }
            if (!encontrado) {
                sb.append("Propietario no encontrado.");
            }
            
            JOptionPane.showMessageDialog(null, sb.toString());
        }

    }
    public frmBuscar(ArrayList<Propietario> registroPropietarios){
        this.registroPropietarios = registroPropietarios;


        imgRegresar = new ImageIcon(".\\img\\regresar.png");
        imgBuscar = new ImageIcon(".\\img\\buscar.png");


        btnRegresar = new JButton("Regresar", imgRegresar);
        btnBuscar = new JButton("Buscar", imgBuscar);

        lblIndicaciones = new JLabel("Ingrese en el nombre del propietario que desee buscar:");
        txtNombre = new JTextField();

        //setbounds
        btnRegresar.setBounds(50, 180, 125, 25);
        btnBuscar.setBounds(250, 180, 125, 25);

        lblIndicaciones.setBounds(55,  50, 350, 80);
        txtNombre.setBounds(150, 120, 130, 25);

        //actionlisten
        btnRegresar.addActionListener(this);
        btnBuscar.addActionListener(this);

        //adicionar
        add(btnRegresar);
        add(btnBuscar);

        add(lblIndicaciones);
        add(txtNombre);


        // configuracion ventana
        Color c = new Color(150, 182, 178);
        getContentPane().setBackground(c);

        setLayout(null);
        setSize(450,350);
        setTitle("Buscador");

        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocation(400,170);
    }
}

    
