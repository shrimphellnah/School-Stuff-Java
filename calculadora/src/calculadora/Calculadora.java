import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //Se usaran las librerias de Java Swing para el diseño y AWT para funciones

public class Calculadora extends JPanel{
    private JTextField pantalla;
    private double resultado;
    private String operacion;
    private String operacionPendiente = "";
    private boolean nuevaOperacion = true;
    
    public Calculadora() {
        setLayout(new BorderLayout());

        pantalla = new JTextField("0", 20); //La funcion JTextField crea un marco de texto para mostrar los caracteres
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false); //La edicion por teclado sera declinado para darle prioridad a los botones
        add(pantalla, BorderLayout.NORTH); //la pantalla se muestra en la parte de arriba de la ventana
    
    
        ActionListener insertar = new ActionListener() { //la funcion va a hacer que cualquier digito ingresado por los botones, sea ingresado en la pantalla
            public void actionPerformed(ActionEvent e) {
                String entrada = e.getActionCommand();
                if (nuevaOperacion) {
                    pantalla.setText(entrada);
                    nuevaOperacion = false;
                } else {
                    pantalla.setText(pantalla.getText() + entrada);
                }
            }
        };
    
        ActionListener operar = new ActionListener() { //la funcion va a hacer que si el texto coincide con la expresion regular, podra realizar el calculo
            public void actionPerformed(ActionEvent e) {
                String operador = e.getActionCommand();
                String textoPantalla = pantalla.getText();

                if (textoPantalla.matches("[+-]?[\\d]*[.]?[\\d]+")) { //la expresion regular acepta las condiciones dadas en la calculadora
                    if (!nuevaOperacion) {
                        operacionPendiente = operador;
                        calcular();
                        operacionPendiente = operador;
                        nuevaOperacion = true;
                    } else {
                        operacionPendiente = operador;
                    }
                } else {
                    JOptionPane.showMessageDialog(Calculadora.this, "Math Error.", "Error",
                            JOptionPane.ERROR_MESSAGE); //en caso de una excepcion especial, 
                }
            }
        };
    
        ActionListener igual = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!nuevaOperacion) {
                    calcular();
                    operacionPendiente = "";
                    nuevaOperacion = true;
                }
            }
        };
    
        JPanel panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4, 3));
        String[] botonesNumeros = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            ".", "0", 
        };
        
        for (String boton : botonesNumeros) {
        JButton b = new JButton(boton);
        b.addActionListener(insertar); // Asocia el ActionListener "insertar" a los botones numéricos
        panelNumeros.add(b);
        }


        JPanel panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(5, 1));
        String[] botonesOperaciones = {
            "+", "-", "*", "/"
        };
        
        JButton igualButton = new JButton("=");
        igualButton.addActionListener(igual);
        panelNumeros.add(igualButton);
        
        for (String boton : botonesOperaciones) {
            JButton b = new JButton(boton);
            b.addActionListener(operar);
            panelOperaciones.add(b);
        }

        JButton borrar = new JButton("C");
        borrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pantalla.setText("0");
                nuevaOperacion = true;
                operacionPendiente = "";
                resultado = 0;
            }
        });

        panelOperaciones.add(borrar);

        add(panelNumeros, BorderLayout.CENTER);
        add(panelOperaciones, BorderLayout.EAST);
    }

    private void calcular() {
        double numero = Double.parseDouble(pantalla.getText());
        switch (operacionPendiente) {
            case "+":
                resultado += numero; //CASE Sumar: al momento de realizar la operación de suma, el botón de "=" hará la ecuación establecida para el resultado.
                break;
            case "-":
                if (resultado == 0) {
                resultado = numero; // Si resultado es cero, simplemente establece el número ingresado como resultado
            } else {
                resultado -= numero; //CASE Restar: El número ingresado establecido hará que el resultado se mantenga en un estado fijo, por lo tanto, se podrá restar el número con otro.
            }
                break;
            case "*":
                if (resultado == 0) {
                resultado = numero; // Si resultado es cero, simplemente establece el número ingresado como resultado
            } else {
                resultado *= numero; //CASE Multiplicación: el resultado se mantendrá fijo; el número se podrá multiplicar con el siguiente dando el resultado.
            }
                break;
            case "/":
                if (resultado == 0) {
                resultado = numero; // Si resultado es cero, simplemente establece el número ingresado como resultado
            } else {
                resultado /= numero; //CASE División: el número se mantendrá fijo, el número se podrá dividir con otro número, dando como resultado números flotantes.
            }
                break;
            default:
                resultado = numero; //CASE Default: en caso de que no se realice ninguna operación, el numero se mantedrá igual si se pulsa el botón de "=".
                break;
        }
        pantalla.setText(String.valueOf(resultado)); //Si se realiza los CASE anteriores, el resultado se mostrará en la pantalla de texto.
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Calculadora");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new Calculadora());
                
                frame.setSize(320, 370);
                
                frame.setVisible(true);
            }
        });
    }
}
