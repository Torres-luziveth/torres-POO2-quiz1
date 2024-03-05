import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class frmPropietarios extends JFrame implements ActionListener {
    // definir ventanas
    static frmRegistrar ventanaRegistrar;
    static frmListar ventanaListar;
    static frmPropietarios ventana;
    static frmBuscar ventanaBuscar;

    //definir imagenes
    static ImageIcon imgListar,imgRegistrar, imgbuscar, imgSalir, imgHome;

    // definir botones
    static JLabel instruccionMenu, lblHome;
    static JButton btnRegistrarPropietario, btnListarPropietarios, btnBuscarPropietarios, btnSalir;

    //array
    static ArrayList<Propietario> registroPropietarios = new ArrayList();

    //metodos listen
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegistrarPropietario)){
            ventanaRegistrar.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(btnListarPropietarios)){
            ventanaListar.setVisible(true);
            this.setVisible(false);
            frmListar.listar();
        }
        if (e.getSource().equals(btnBuscarPropietarios)){
            ventanaBuscar.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(btnSalir)) {
            this.dispose();
        }
    }

    public frmPropietarios(){
        //ventanas
        ventanaBuscar = new frmBuscar(registroPropietarios);
        ventanaListar = new frmListar(registroPropietarios);
        ventanaRegistrar = new frmRegistrar(registroPropietarios);

        // imagenes
        imgRegistrar = new ImageIcon(".\\img\\registrar.png");
        imgListar = new ImageIcon(".\\img\\listar.png");
        imgbuscar = new ImageIcon(".\\img\\buscar.png");
        imgSalir = new ImageIcon(".\\img\\salir.png");

        imgHome = new ImageIcon(".\\img\\home.png");
        lblHome = new JLabel(imgHome);
        lblHome.setLocation(205,30);
        lblHome.setSize(48,48);
        add(lblHome);

        // botones
        instruccionMenu = new JLabel("MENÚ PRINCIPAL:");
        btnRegistrarPropietario= new JButton("Registrar propietarios", imgRegistrar);
        btnListarPropietarios = new JButton("Revisar lista de propietarios", imgListar);
        btnBuscarPropietarios = new JButton("Buscar propietario", imgbuscar);
        btnSalir = new JButton("Salir", imgSalir);

        // setBounds
        instruccionMenu.setBounds(180, 80, 250, 25);
        btnRegistrarPropietario.setBounds(100, 120, 250, 25);
        btnListarPropietarios.setBounds(100, 150, 250, 25);
        btnBuscarPropietarios.setBounds(100, 180, 250, 25);
        btnSalir.setBounds(170, 210, 100, 25);


        //adicionar
        add(instruccionMenu);
        add(btnRegistrarPropietario);
        add(btnListarPropietarios);
        add(btnBuscarPropietarios);
        add(btnSalir);


        // adicionar actionListen
        btnRegistrarPropietario.addActionListener(this);
        btnListarPropietarios.addActionListener(this);
        btnBuscarPropietarios.addActionListener(this);
        btnSalir.addActionListener(this);

        /// configuracion ventana
        Color c = new Color(150, 182, 178);
        getContentPane().setBackground(c);

        setLayout(null);
        setSize(450,350);
        setTitle("Menú");

        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocation(400,170);

    }



    public static void main(String[] args) {
        ventana = new frmPropietarios();
        ventana.setVisible(true);
    }

}
