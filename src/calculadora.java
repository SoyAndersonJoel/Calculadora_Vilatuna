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
        // ActionListener para el botón de punto decimal
        punto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textoTF.getText().contains(".")) {
                    textoTF.setText(textoTF.getText() + ".");
                }
            }
        });

        // ActionListener para el botón de suma
        suma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textoTF.getText());
                operador = "+";
                textoTF.setText("");
            }
        });

        // ActionListener para el botón de resta
        resta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textoTF.getText());
                operador = "-";
                textoTF.setText("");
            }
        });

        // ActionListener para el botón de multiplicación
        multiplicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textoTF.getText());
                operador = "*";
                textoTF.setText("");
            }
        });

        // ActionListener para el botón de división
        divicion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textoTF.getText());
                operador = "/";
                textoTF.setText("");
            }
        });
        // ActionListener para el botón de resetear
        resetear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoTF.setText("");
                num1 = 0;
                num2 = 0;
                operador = "";
            }
        });

        // ActionListener para el botón de eliminar el último carácter
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = textoTF.getText();
                if (currentText.length() > 0) {
                    textoTF.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });

        // ActionListener para el botón de seno
        sen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador = "sen";
                textoTF.setText("");
            }
        });

        // ActionListener para el botón de coseno
        cos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador = "cos";
                textoTF.setText("");
            }
        });

        // ActionListener para el botón de tangente
        tan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador = "tan";
                textoTF.setText("");
            }
        });
        // ActionListener para el botón de raíz cuadrada
        raiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operador = "√";
                textoTF.setText("");
            }
        });

        // ActionListener para el botón de potencia
        potencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textoTF.getText());
                operador = "^";
                textoTF.setText("");
            }
        });

        // ActionListener para el botón de igual
        igual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (operador) {
                    case "+":
                        num2 = Double.parseDouble(textoTF.getText());
                        textoTF.setText(df.format(num1 + num2));
                        break;
                    case "-":
                        num2 = Double.parseDouble(textoTF.getText());
                        textoTF.setText(df.format(num1 - num2));
                        break;
                    case "*":
                        num2 = Double.parseDouble(textoTF.getText());
                        textoTF.setText(df.format(num1 * num2));
                        break;
                    case "/":
                        num2 = Double.parseDouble(textoTF.getText());
                        if (num2 != 0) {
                            textoTF.setText(df.format(num1 / num2));
                        } else {
                            textoTF.setText("Error");
                        }
                        break;
                    case "^":
                        num2 = Double.parseDouble(textoTF.getText());
                        textoTF.setText(df.format(Math.pow(num1, num2)));
                        break;
                    case "sen":
                        num1 = Double.parseDouble(textoTF.getText());
                        textoTF.setText(df.format(Math.sin(Math.toRadians(num1))));
                        break;
                    case "cos":
                        num1 = Double.parseDouble(textoTF.getText());
                        textoTF.setText(df.format(Math.cos(Math.toRadians(num1))));
                        break;
                    case "tan":
                        num1 = Double.parseDouble(textoTF.getText());
                        textoTF.setText(df.format(Math.tan(Math.toRadians(num1))));
                        break;
                    case "√":
                        num1 = Double.parseDouble(textoTF.getText());
                        textoTF.setText(df.format(Math.sqrt(num1)));
                        break;
                }
                nuevaOperacion = true;
                operador = "";
            }
        });



    }





}
