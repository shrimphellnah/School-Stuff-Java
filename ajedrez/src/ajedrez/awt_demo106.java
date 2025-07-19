package ajedrez;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
/*Equipo:
Cortes Juarez Edson Albert
Perez Perez Evelyn Michelle
Solano Ortega Fernando
Vergara Alarcon Roberto
*/
public class awt_demo106 extends Frame implements ActionListener {
    private Button selectedButton = null;
    private Color originalColor = null;
    private Map<Button, Color> originalColorsMap = new HashMap<>();
    private Map<Button, String> buttonTextMap = new HashMap<>();

    public awt_demo106() {
        super("Tablero Ajedrez");
        setSize(300, 300);
        setLayout(new GridLayout(8, 8));

        // Restaurar los colores originales de los botones
        originalColor = Color.WHITE;

        // Agregar los botones al GridLayout principal con los textos correspondientes
        Color white = Color.WHITE;
        Color black = Color.BLACK;
        Color whiteText = Color.WHITE;

        add(createButton("Torre A8", white, black));
        add(createButton("Caballo B8", black, white));
        add(createButton("Alfil C8", white, black));
        add(createButton("Reina D8", black, white));
        add(createButton("Rey E8", white, black));
        add(createButton("Alfil F8", black, white));
        add(createButton("Caballo G8", white, black));
        add(createButton("Torre H8", black, white));

        add(createButton("Peon A7", black, white));
        add(createButton("Peon B7", white, black));
        add(createButton("Peon C7", black, white));
        add(createButton("Peon D7", white, black));
        add(createButton("Peon E7", black, white));
        add(createButton("Peon F7", white, black));
        add(createButton("Peon G7", black, white));
        add(createButton("Peon H7", white, black));

        add(createButton("", white, white));
        add(createButton("", black, white));
        add(createButton("", white, white));
        add(createButton("", black, white));
        add(createButton("", white, white));
        add(createButton("", black, white));
        add(createButton("", white, white));
        add(createButton("", black, white));

        add(createButton("", black, white));
        add(createButton("", white, white));
        add(createButton("", black, white));
        add(createButton("", white, white));
        add(createButton("Torre A1", black, white));
        add(createButton("", white, white));
        add(createButton("", black, white));
        add(createButton("", white, white));

        add(createButton("", white, white));
        add(createButton("", black, white));
        add(createButton("", white, white));
        add(createButton("", black, white));
        add(createButton("", white, white));
        add(createButton("", black, white));
        add(createButton("", white, white));
        add(createButton("", black, white));

        add(createButton("", black, white));
        add(createButton("", white, white));
        add(createButton("", black, white));
        add(createButton("", white, white));
        add(createButton("", black, white));
        add(createButton("", white, white));
        add(createButton("", black, white));
        add(createButton("", white, white));

        add(createButton("Peon A2", white, black));
        add(createButton("Peon B2", black, white));
        add(createButton("Peon C2", white, black));
        add(createButton("Peon D2", black, white));
        add(createButton("Peon E2", white, black));
        add(createButton("Peon F2", black, white));
        add(createButton("Peon G2", white, black));
        add(createButton("Peon H2", black, white));

        add(createButton("Torre A1", black, white));
        add(createButton("Caballo B1", white, black));
        add(createButton("Alfil C1", black, white));
        add(createButton("Reina D1", white, black));
        add(createButton("Rey E1", black, white));
        add(createButton("Alfil F1", white, black));
        add(createButton("Caballo G1", black, white));
        add(createButton("Torre H1", white, black));

        setVisible(true);
    }

    private Button createButton(String label, Color background, Color foreground) {
    Button boton = new Button(label);
    boton.setBackground(background);

    // Establecer el color del texto según el color de fondo del botón
    if (background == Color.WHITE) {
        boton.setForeground(Color.BLACK);
    } else {
        boton.setForeground(Color.WHITE);
    }

    boton.addActionListener(this);
    originalColorsMap.put(boton, background);
    buttonTextMap.put(boton, label); // Agregar el botón al mapa con su texto
    return boton;
}

    public void actionPerformed(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();

        if (clickedButton.getLabel().isEmpty() || clickedButton.getBackground() == Color.GREEN) {
            return; // Si no es seleccionable o ya ha sido seleccionado, no se hace nada
        }

        if (selectedButton != null) {
            // Reset the color of the previously selected cell
            selectedButton.setBackground(originalColor);

            // Reset the color of all highlighted buttons
            for (Button button : originalColorsMap.keySet()) {
                if (button.getLabel().isEmpty()) {
                    button.setBackground(originalColorsMap.get(button));
                }
            }
        }

        if (selectedButton == clickedButton) {
            // Si el mismo botón es seleccionado nuevamente, se establece selectedButton como null
            selectedButton = null;
        } else {
            // Set the clicked button to red (selected) and store its original color
            selectedButton = clickedButton;
            originalColor = clickedButton.getBackground();
            clickedButton.setBackground(Color.RED);

            // Highlight valid moves for the selected piece
            highlightValidMoves(clickedButton);
        }
    }
    
    private void highlightValidMoves(Button clickedButton) {
    int row = -1;
    int col = -1;

    // Find the row and column of the clickedButton
    for (int i = 0; i < 64; i++) {
        if (getComponent(i) == clickedButton) {
            row = i / 8;
            col = i % 8;
            break;
        }
    }

    if (row >= 0 && col >= 0) {
        String pieceName = buttonTextMap.get(clickedButton);
        
        
        //Torre
        if (pieceName.startsWith("Torre")) {
            // Highlight valid horizontal moves
            for (int c = 0; c < 8; c++) {
                if (c != col) {
                    highlightGreen(row, c);
                }
            }

            // Highlight valid vertical moves
            for (int r = 0; r < 8; r++) {
                if (r != row) {
                    highlightGreen(r, col);
                }
            }
        }  
        
        //Peon
     else if (pieceName.startsWith("Peon")) {
            // Lógica de movimiento para el peón
            int moveDirection = pieceName.contains("2") ? -1 : 1; // Dirección hacia arriba para peones blancos, hacia abajo para peones negros
            highlightGreen(row + moveDirection, col); // Una casilla hacia adelante

            // Permitir que todos los peones se muevan dos casillas hacia adelante desde cualquier posición
            highlightGreen(row + 2 * moveDirection, col); // Dos casillas hacia adelante desde cualquier posición
        }
     
        //Caballo
        else if (pieceName.startsWith("Caballo")) {
            // Lógica de movimiento para el caballo
            int[][] knightMoves = {
                    {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
                    {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
            };

            for (int[] move : knightMoves) {
                int newRow = row + move[0];
                int newCol = col + move[1];
                highlightGreen(newRow, newCol);
            }
        }
        
        //Alfil
        else if (pieceName.startsWith("Alfil")) {
    // Lógica de movimiento para el alfil
    int[][] bishopMoves = {
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };
    
    
    for (int[] move : bishopMoves) {
        int newRow = row + move[0];
        int newCol = col + move[1];

        while (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
            highlightGreen(newRow, newCol);

            // Si hay una pieza enemiga, no podemos seguir avanzando en esa dirección
            Button button = (Button) getComponent(newRow * 8 + newCol);
            if (!button.getLabel().isEmpty()) {
                break;
            }

            newRow += move[0];
            newCol += move[1];
        }
    }
    
    //Reina
    } else if (pieceName.startsWith("Reina")) {
    // Lógica de movimiento para la reina
    int[][] queenMoves = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, // Movimientos de la torre (horizontal y vertical)
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Movimientos del alfil (diagonales)
    };
    
    for (int[] move : queenMoves) {
        int newRow = row + move[0];
        int newCol = col + move[1];

        while (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
            highlightGreen(newRow, newCol);

            // Si hay una pieza enemiga, no podemos seguir avanzando en esa dirección
            Button button = (Button) getComponent(newRow * 8 + newCol);
            if (!button.getLabel().isEmpty()) {
                break;
            }

            newRow += move[0];
            newCol += move[1];
        }
    } 
    
    //Rey
    }else if (pieceName.startsWith("Rey")) {
    // Lógica de movimiento para el rey
    int[][] kingMoves = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, // Movimientos de la torre (horizontal y vertical)
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // Movimientos del alfil (diagonales)
    };

    for (int[] move : kingMoves) {
        int newRow = row + move[0];
        int newCol = col + move[1];

        if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
            highlightGreen(newRow, newCol);
        }
    }
    }
    }
    }

    private void highlightGreen(int row, int col) {
        if (row >= 0 && row < 8 && col >= 0 && col < 8) {
            Button button = (Button) getComponent(row * 8 + col);
            if (button.getLabel().isEmpty()) {
                button.setBackground(Color.GREEN);
            } 
        }
    }

    public static void main(String[] args) {
        awt_demo106 f = new awt_demo106();
    }
}
