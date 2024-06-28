import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class calculadora {
    // Definición de componentes de la interfaz de usuario
    public JPanel mainPanel;
    private JTextField textoTF;
    private JButton resetear;
    private JButton cero;
    private JButton uno;
    private JButton dos;
    private JButton tres;
    private JButton cuatro;
    private JButton siete;
    private JButton ocho;
    private JButton nueve;
    private JButton seis;
    private JButton punto;
    private JButton sen;
    private JButton cos;
    private JButton tan;
    private JButton raiz;
    private JButton potencia;
    private JButton suma;
    private JButton multiplicacion;
    private JButton resta;
    private JButton divicion;
    private JButton igual;
    private JButton eliminar;
    private JButton cinco;
    // Variables para la operación
    private double num1 = 0;
    private double num2 = 0;
    private String operador = "";
    private boolean nuevaOperacion = true;

    // Formato decimal para mostrar resultados con dos decimales
    private DecimalFormat df = new DecimalFormat("#.##");

    public calculadora() {
        // ActionListener para los botones numéricos (excepto cero)
        ActionListener numberListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nuevaOperacion) {
                    nuevaOperacion = false;
                }
                String command = e.getActionCommand();
                if (textoTF.getText().equals("0")) {
                    textoTF.setText(command); // Reemplazar "0" inicial
                } else {
                    textoTF.setText(textoTF.getText() + command);
                }
            }
        };

        // ActionListener para el botón cero
        cero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textoTF.getText().equals("0")) {
                    textoTF.setText(textoTF.getText() + "0");
                }
            }
        });

        // Asignar el mismo ActionListener a los botones numéricos
        uno.addActionListener(numberListener);
        dos.addActionListener(numberListener);
        tres.addActionListener(numberListener);
        cuatro.addActionListener(numberListener);
        cinco.addActionListener(numberListener);
        seis.addActionListener(numberListener);
        siete.addActionListener(numberListener);
        ocho.addActionListener(numberListener);
        nueve.addActionListener(numberListener);
    }


}
