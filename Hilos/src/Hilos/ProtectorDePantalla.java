package Hilos;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
/*
*Cortez Juearez Edson Alberti
*Vergara Alarcon Roberto
*Perez Perez Michelle
*Solano Ortega Fernando
*/
public class ProtectorDePantalla {
    public static void main(String[] args) {
        ProtectorFrame frame = new ProtectorFrame();
        frame.setVisible(true);
    }
}

class ProtectorFrame extends Frame implements Runnable {
    private Thread thread;
    private boolean running = true;
    private int centerX, centerY; // Coordenadas del centro
    private int radius = 100; // Radio del círculo
    private double angleIncrement; // Incremento del ángulo
    private double rotationAngle = 0; // Ángulo de rotación

    // Variables para el movimiento de los círculos
    private Circle[] circles;
    private int numCircles = 20; // Número de círculos
    private double circleSpeed = 10.0; // Velocidad de los círculos
    
    //Variables para el movimiento de los cuadrados
    private Square[] squares;
    private int numSquares = 20; //numero de cuadradosa
    private double squareSpeed = 10.0; //velocidad de los cuadrados
    
    //cualquier otra figura >>>>>>>
    

    ProtectorFrame() {
        super("Protector de Pantalla");
        this.setSize(900, 600); // Tamaño de ventana
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0)); //color de fondo

        this.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                running = false; // Detenemos el bucle del hilo
                System.exit(0); // Cierra al pulsar la tecla Esc
            }
        }
    });

        this.setFocusable(true);
        

        this.centerX = this.getWidth() / 2; // Coordenada x del centro del círculo
        this.centerY = this.getHeight() / 2; // Coordenada y del centro del círculo
        this.angleIncrement = 2 * Math.PI / numCircles; // Dividimos el círculo en numCircles partes para los círculos
        this.angleIncrement = 2 * Math.PI / numSquares;

        // Inicializar círculos en posición aleatoria alrededor del centro
        circles = new Circle[numCircles];
        Random random = new Random(); //Figuras aparecen en posiciones diferentes 
        for (int i = 0; i < numCircles; i++) {
            int x = random.nextInt(this.getWidth());
            int y = random.nextInt(this.getHeight());
            double angle = random.nextDouble() * 2 * Math.PI; //angulos aleatorios
            circles[i] = new Circle(x, y, angle, circleSpeed);
        }
        
        
        //"" "" "" Cuadrados
        squares = new Square[numSquares];
        for (int i = 0; i < numSquares; i++){
            int x = random.nextInt(this.getWidth());
            int y = random.nextInt(this.getHeight());
            double angle = Math.atan2(centerY - y, centerX - x);
            squares[i] = new Square(x, y, angle, squareSpeed);
        }
        
        
        //Cualquier otra figura >>>>>>>>

        this.thread = new Thread(this);
        this.thread.start();
    }

    public void run() {
        while (running) {
            moveCircles();
            moveSquares();// Movimiento de figuras deseadas, si se agrega una
            //Cualquier otra figura >>>>>>>>
            

            // Actualizar la posición de los círculos en el hilo de la interfaz gráfica
            EventQueue.invokeLater(() -> repaint());

            rotationAngle += Math.PI / 180; // Incrementar el ángulo de rotación en 1 grado
            try {
                Thread.sleep(25); // Reducimos el retraso para una animación más rápida
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.dispose();
    }

    // Método para mover figuras en dirección Random
    private void moveCircles() {
        for (Circle circle : circles) {
            circle.move();
            circle.handleBoundaryCollision(this.getWidth(), this.getHeight());
        }
    }
    
    private void moveSquares() {
        for (Square square : squares) {
            square.move();
            square.handleBoundaryCollision(this.getWidth(), this.getHeight());
        }
    }
    
    //Cualquier otra figura >>>>>>
    

    // Método para dibujar formas en la ventana, con respectivos valores de su clase
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        for (Circle circle : circles) {
            g.drawOval(circle.getX() - circle.getRadius(), circle.getY() - circle.getRadius(), 2 * circle.getRadius(), 2 * circle.getRadius());
        }

        g.setColor(Color.RED);
        for (Square square : squares) {
            g.drawRect(square.getX(), square.getY(), square.getSize(), square.getSize());
        }
        
        //Cualquier otra figura >>>>>>>>>
    }
}

