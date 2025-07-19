package Hilos;

import java.awt.*;

public class Square {
    private int x, y; // Posición del cuadrado
    private int size = 80; // Tamaño del cuadrado
    private double angle; // Ángulo de movimiento
    private double speed; // Velocidad del cuadrado

    Square(int x, int y, double angle, double speed) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.speed = speed;
    }

    public void move() {
        x += speed * Math.cos(angle);
        y += speed * Math.sin(angle);
    }

    // Método para detectar y manejar el rebote en los bordes de la ventana
    public void handleBoundaryCollision(int width, int height) {
        if (x <= 0 || x >= width - size) {
            angle = Math.PI - angle;
        }
        if (y <= 0 || y >= height - size) {
            angle = -angle;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }
}