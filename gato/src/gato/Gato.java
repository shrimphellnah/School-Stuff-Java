/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

/**
 *
 * Cortez Juearez Edson Alberti
 * Vergara Alarcon Roberto
 * Perez Perez Michelle
 * Solano Ortega Fernando
 * 
 * 
 */
import java.awt.*;
import java.awt.event.*;

public class Gato extends Canvas {
    private char jugador = 'X';
    private char[][] cordenadas;
    private int cellSize;
    private int rows;
    private int cols;

    private Button restartButton;
    private Button switchPlayerButton;
    private Label currentPlayerLabel;

    public Gato(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        cordenadas = new char[rows][cols];
        cellSize = 300;
        setSize(cols * cellSize, rows * cellSize);

        restartButton = new Button("Reiniciar");
        switchPlayerButton = new Button("Cambiar Jugador");
        currentPlayerLabel = new Label("Jugador actual: " + jugador);

        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                initializeGame();
            }
        });

        switchPlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugador = (jugador == 'X') ? 'O' : 'X';
                currentPlayerLabel.setText("Jugador actual: " + jugador);
            }
        });

        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(restartButton);
        buttonPanel.add(switchPlayerButton);
        buttonPanel.add(currentPlayerLabel);

        Panel mainPanel = new Panel(new BorderLayout());
        mainPanel.add(this, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = e.getY() / cellSize;
                int col = e.getX() / cellSize;
                onCellClicked(row, col);
            }
        });

        initializeGame();

        Frame frame = new Frame("Gato");
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void initializeGame() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cordenadas[i][j] = ' ';
            }
        }
        jugador = 'X';
        currentPlayerLabel.setText("Jugador actual: " + jugador);
        repaint();
    }

    private void onCellClicked(int row, int col) {
        if (cordenadas[row][col] == ' ') {
            cordenadas[row][col] = jugador;

            if (checkForWin()) {
                showWinMessage();
                initializeGame();
            } else if (checkForDraw()) {
                showDrawMessage();
                initializeGame();
            } else {
                jugador = (jugador == 'X') ? 'O' : 'X';
                currentPlayerLabel.setText("Jugador actual: " + jugador);
            }
            repaint();
        }
    }

    private boolean checkForWin() {
        // Check rows
        for (int i = 0; i < rows; i++) {
            if (cordenadas[i][0] == cordenadas[i][1] && cordenadas[i][1] == cordenadas[i][2] && cordenadas[i][0] != ' ') {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < cols; i++) {
            if (cordenadas[0][i] == cordenadas[1][i] && cordenadas[1][i] == cordenadas[2][i] && cordenadas[0][i] != ' ') {
                return true;
            }
        }

        // Check diagonals
        if (cordenadas[0][0] == cordenadas[1][1] && cordenadas[1][1] == cordenadas[2][2] && cordenadas[0][0] != ' ') {
            return true;
        }
        if (cordenadas[0][2] == cordenadas[1][1] && cordenadas[1][1] == cordenadas[2][0] && cordenadas[0][2] != ' ') {
            return true;
        }

        return false;
    }

    private boolean checkForDraw() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cordenadas[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }


    private void showWinMessage() {
        System.out.println("Gano  " + jugador );
    }

    private void showDrawMessage() {
        System.out.println("Fue empate");
    }

    private void drawX(Graphics g, int row, int col) {
        int x = col * cellSize;
        int y = row * cellSize;

        g.setColor(Color.RED);
        g.drawLine(x, y, x + cellSize, y + cellSize);
        g.drawLine(x, y + cellSize, x + cellSize, y);
    }

    private void drawO(Graphics g, int row, int col) {
        int x = col * cellSize;
        int y = row * cellSize;

        g.setColor(Color.BLUE);
        g.drawOval(x + 10, y + 10, cellSize - 20, cellSize - 20);
    }

     public void paint(Graphics g) {
        // Draw the grid
        g.setColor(Color.BLACK);
        for (int i = 1; i < rows; i++) {
            g.drawLine(0, i * cellSize, cols * cellSize, i * cellSize);
        }
        for (int i = 1; i < cols; i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, rows * cellSize);
        }

        // Draw X and O
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cordenadas[i][j] == 'X') {
                    drawX(g, i, j);
                } else if (cordenadas[i][j] == 'O') {
                    drawO(g, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Gato canvas = new Gato(3, 3);
        Frame frame = new Frame("Gato");
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

