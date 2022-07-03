import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidarRut extends JFrame implements ActionListener {
    JButton boton;
    JTextField txtRut;
    JLabel labRut;

    protected ValidarRut(String nombre, int largoX, int largoY) {
        super(nombre);
        super.setVisible(true);
        super.setDefaultCloseOperation(3);
        super.setSize(largoX, largoY);
        super.setLocationRelativeTo(null);
        super.setResizable(true);
        this.setLayout(null);
    }

    public ValidarRut() {

    }

    public void Pestaña() {
        ValidarRut v2 = new ValidarRut("Usuario", 500, 500);
        labRut = new JLabel("Rut");
        txtRut = new JTextField(20);
        txtRut.setText("11111111-1");
        boton = new JButton("Validar");
        labRut.setBounds(50,150,100,40);
        txtRut.setBounds(100,150,100,40);
        boton.setBounds(190,250,100,40);
        boton.addActionListener(this);
        v2.add(labRut);
        v2.add(txtRut);
        v2.add(boton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) {
            if (txtRut.getText().length() > 0) {
                String[] rut_dv = txtRut.getText().split("-");
                if (rut_dv.length == 2) {
                    try {
                        int rut = Integer.parseInt(rut_dv[0]);
                        char dv = rut_dv[1].charAt(0);

                        if (this.ValidarRut(rut, dv)) {
                            JOptionPane.showMessageDialog(rootPane, "Rut correcto");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Rut incorrecto");
                        }
                    } catch (Exception ex) {
                        System.out.println(" Error " + ex.getMessage());
                    }
                }
            }
        }
    }

    public static boolean ValidarRut(int rut, char dv) {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 75);
    }

}