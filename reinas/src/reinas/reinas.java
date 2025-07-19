package reinas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
/*Equipo:
Cortes Juarez Edson Albert
Perez Perez Evelyn Michelle
Solano Ortega Fernando
Vergara Alarcon Roberto
*/
public class reinas extends Frame implements ActionListener {
    private Button selectedButton = null;
    private Color originalColor = null;
    private Set<Integer> queensPositions = new HashSet<>();
    private int placedQueens = 0;


    public reinas() {
        super("Las 8 Reinas");
        setSize(300, 300);
        setLayout(new GridLayout(8, 8));

        // Restaurar los colores originales de los botones
        originalColor = Color.WHITE;

        // Agregar los botones al GridLayout principal con los textos correspondientes
        Color white = Color.WHITE;
        Color black = Color.BLACK;
        Color whiteText = Color.WHITE;

        //Sustitucion de add()
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                String label = "";
                Color bg = (row + col) % 2==0 ? white : black;
                Color fg = bg == white ? black : whiteText;
                add(createButton(label, bg, fg));
            }
        }
        setVisible(true);
    }

    private Button createButton(String label, Color background, Color foreground) {
    Button boton = new Button(label);
    boton.setBackground(background);
    boton.setForeground(foreground);
    boton.addActionListener(this);
    
    if (background == Color.WHITE) { //Cambia el texto de color invertido dependiendo la casilla
        boton.setForeground(Color.BLACK);
    } else {
        boton.setForeground(Color.WHITE);
    }
    return boton;
}

    public void actionPerformed(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();

        if (selectedButton != null) {
            // Reset the color of the previously selected cell
            selectedButton.setBackground(originalColor);
        }

        if (selectedButton == clickedButton) {
            // Si el mismo botón es seleccionado nuevamente, se establece selectedButton como null
            selectedButton = null;
        } else {
            
            // Verificar si se usaron todas las reinas
            if (placedQueens == 8) {
                System.out.println("Has ganado!!");
            }

            // checa si la casilla esta vacia y haya menos de 8
            if (clickedButton.getLabel().isEmpty() && queensPositions.size() < 8 && isValidMove(clickedButton)) {

                // Set the clicked button to red (selected) and store its original color
                selectedButton = clickedButton;
                originalColor = clickedButton.getBackground();
                clickedButton.setBackground(Color.RED);

                // Asigna un nombre único a la reina
                int queenNumber = queensPositions.size() + 1;
                clickedButton.setLabel("Reina " + queenNumber);

                // Agregar la posición de la reina colocada al conjunto
                queensPositions.add(getButtonPosition(clickedButton));

                // Agregar la posición de la reina colocada al conjunto
                queensPositions.add(getButtonPosition(clickedButton));
                queenNumber++;
                placedQueens++;
                
                // Verificar si se cruza con otra reina
            if (queensCollision()) {
            System.out.println("Perdiste.");
            System.out.println("Puntaje total: "+ placedQueens);
            System.exit(0);
            }
            
            //Verifica si se logro hacer el puzzle
             if (placedQueens == 8) {
                System.out.println("Has ganado!!");
            }
        }
    }
}
    
    
    private boolean isValidMove(Button button) {
        // Obtener la posición de la casilla seleccionada
        int row = -1;
        int col = -1;
        for (int i = 0; i < 64; i++) {
            if (getComponent(i) == button) {
                row = i / 8;
                col = i % 8;
                break;
            }
        }
        // Verificar si hay una reina en la misma fila o columna
        for (int i = 0; i < 8; i++) {
            Button rowButton = (Button) getComponent(row * 8 + i);
            Button colButton = (Button) getComponent(i * 8 + col);
            if (rowButton.getLabel().equals("Reina") || colButton.getLabel().equals("Reina")) {
                return false;
            }
        }

        // Verificar si hay una reina en la misma diagonal
        for (int i = -Math.min(row, col); row + i < 8 && col + i < 8; i++) {
            Button diagonalButton = (Button) getComponent((row + i) * 8 + col + i);
            if (diagonalButton.getLabel().equals("Reina")) {
                return false;
            }
        }
        //Verifica si hay reina en diagonal opuesta
        for (int i = -Math.min(row, 7 - col); row + i < 8 && col - i >= 0; i++) {
            Button diagonalButton = (Button) getComponent((row + i) * 8 + col - i);
            if (diagonalButton.getLabel().equals("Reina")) {
                return false;
            }
        }
        //El movimiento lo hace valido
        return true;
    }

    
    private boolean queensCollision() {
        // Verificar si alguna reina colocada se cruza con otra reina
        for (int queenPosition : queensPositions) {
            int row1 = queenPosition / 8;
            int col1 = queenPosition % 8;

            for (int queenPosition2 : queensPositions) {
                if (queenPosition != queenPosition2) {
                    int row2 = queenPosition2 / 8;
                    int col2 = queenPosition2 % 8;

                    // Verificar si las reinas se cruzan en fila, columna o diagonal
                    if (row1 == row2 || col1 == col2 || Math.abs(row1 - row2) == Math.abs(col1 - col2)) {
                        return true;
                    }
                }
            }
        }
        //En caso de que no, se coloca la reina
        return false;
    }

    private int getButtonPosition(Button button) {
        // Obtener la posición de una casilla en el GridLayout
        for (int i = 0; i < 64; i++) {
            if (getComponent(i) == button) {
                return i;
            }
        }
        return -1;
    }

    
    public static void main(String[] args) {
        reinas f = new reinas();
    }
}
