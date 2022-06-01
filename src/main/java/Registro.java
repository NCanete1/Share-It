import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
public class Registro implements ActionListener{


    JFrame frame = new JFrame();
    JButton crearUsuario = new JButton("Crear usuario");
    JTextField campoNombreNuevo = new JTextField();
    JPasswordField campoContraseñaNueva = new JPasswordField();
    JLabel nuevoUsuario = new JLabel("Usuario");
    JLabel nuevaContraseña = new JLabel("Contraseña");
    JLabel mensaje = new JLabel();

    //HashMap<String, String> loginInfo = new HashMap<String, String>();

    Registro(){
        //loginInfo = CrearInformacionDeLogeo;

        nuevoUsuario.setBounds(50, 100, 75, 25);
        nuevaContraseña.setBounds(50, 150, 75, 25);

        mensaje.setBounds(125, 250, 250, 35);
        mensaje.setFont(new Font(null,Font.ITALIC, 25));

        campoNombreNuevo.setBounds(125, 100, 200, 25);
        campoContraseñaNueva.setBounds(125, 150, 200, 25);

        crearUsuario.setBounds(125, 200, 150,25);
        crearUsuario.addActionListener(this);

        frame.add(nuevoUsuario);
        frame.add(nuevaContraseña);
        frame.add(mensaje);
        frame.add(campoNombreNuevo);
        frame.add(campoContraseñaNueva);
        frame.add(crearUsuario);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()== crearUsuario){
            String nombreNuevo = campoNombreNuevo.getText();
            String contraseñaNueva = String.valueOf(campoContraseñaNueva.getPassword());
        }
    }
}
