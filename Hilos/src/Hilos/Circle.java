package Hilos;

import java.awt.*;

public class Circle {
    private int x, y; // Posición del círculo
    private int radius = 15; // Radio del círculo
    private double angle; // Ángulo de movimiento
    private double speed; // Velocidad del círculo

    Circle(int x, int y, double angle, double speed) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.speed = speed;
    }

    // Método para mover el círculo en dirección circular
    public void move() {
        x += speed * Math.cos(angle);
        y += speed * Math.sin(angle);
    }

    // Método para detectar y manejar el rebote en los bordes de la ventana
    public void handleBoundaryCollision(int width, int height) {
        if (x <= radius || x >= width - radius) {
            angle = Math.PI - angle;
        }
        if (y <= radius || y >= height - radius) {
            angle = -angle;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}