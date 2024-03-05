import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class frmListar extends JFrame implements ActionListener {
    static ImageIcon imgRegresar;
    static JButton btnRegresar;
    static JTable tabla;
    static DefaultTableModel model;
    static JScrollPane scrollpane;
    static JLabel lblTitulo;
    static ArrayList<Propietario> registroPropietarios;


    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)){
            frmPropietarios.ventana.setVisible(true);
            this.setVisible(false);
            limpiarRegistros();
        }
    }
    public frmListar(ArrayList<Propietario> registroPropietarios){
        this.registroPropietarios = registroPropietarios;

        //imagenes
        imgRegresar = new ImageIcon(".\\img\\regresar.png");

        //instanciar
        btnRegresar = new JButton("Regresar", imgRegresar);
        model = new DefaultTableModel();
        tabla = new JTable(model);
        scrollpane = new JScrollPane(tabla);
        lblTitulo = new JLabel("Propietarios registrados:");

        //bounds
        btnRegresar.setBounds(155, 275, 125, 25);
        lblTitulo.setBounds(140, 10, 230, 25);

        //tamaño tabla
        scrollpane.setLocation(33,40);
        scrollpane.setSize(370,227);

        //action listen
        btnRegresar.addActionListener(this);

        //add columnas
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Edad");
        model.addColumn("Documento");
        model.addColumn("ID");

        // adicionar
        add(btnRegresar);
        add(scrollpane, BorderLayout.CENTER);
        add(lblTitulo);

        /// ventana
        Color c = new Color(150, 182, 178);
        getContentPane().setBackground(c);

        setLayout(null);
        setSize(450,350);
        setTitle("Revision de registros");

        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocation(400,170);;

    }
    static public void listar(){

        for (Propietario propietario : registroPropietarios){
            model.addRow(propietario.getInformacion(propietario));
        }

    }

    static public void limpiarRegistros() {
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

}