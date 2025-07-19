package Corredores;
import java.awt.*;
import java.util.*;
import java.util.Collections;
import java.util.HashMap;

public class GifPanel extends Panel implements Runnable {

    private GifLabel[] etiquetasGIF;
    private int[] gifXPositions;
    private int[] gifSpeeds;
    private final int gifYPosition = 0;
    private final int maxGifSpeed = 24;
    private boolean raceOver = false;
    private ArrayList<Integer> finalPositions;
    private String[] nombresCorredores = {"Juan", "María", "Carlos", "Ana"};


    public GifPanel() {
        setLayout(new GridBagLayout());
        etiquetasGIF = new GifLabel[4];
        gifXPositions = new int[4];
        gifSpeeds = new int[4];
        finalPositions = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            gifSpeeds[i] = random.nextInt(maxGifSpeed) + 1;
        }

        agregarGIF("/Runner4.gif", 0, 0);
        agregarGIF("/Runner4.gif", 2, 0);
        agregarGIF("/Runner4.gif", 1, 0);
        agregarGIF("/Runner4.gif", 3, 0);
    }

    private void agregarGIF(String rutaImagen, int index, int initialX) {
        Image gifImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource(rutaImagen));
        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(gifImage, 0);
        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        etiquetasGIF[index] = new GifLabel(gifImage, nombresCorredores[index]); // Asignar el nombre del corredor
        etiquetasGIF[index].setPreferredSize(new Dimension(gifImage.getWidth(null), gifImage.getHeight(null)));
        etiquetasGIF[index].setLocation(initialX, gifYPosition);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = index;
        gbc.anchor = GridBagConstraints.CENTER;
        add(etiquetasGIF[index], gbc);
    }

    @Override
    public void run() {
        while (true) {
            moveGIFs();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveGIFs() {

        for (int i = 0; i < 4; i++) {
            gifXPositions[i] += gifSpeeds[i];
            etiquetasGIF[i].setLocation(gifXPositions[i], etiquetasGIF[i].getY());

            if (gifXPositions[i] + etiquetasGIF[i].getWidth() >= getParent().getWidth()) {
                finalPositions.add(4 - i);
                gifSpeeds[i] = 0;
                etiquetasGIF[i].setImage(null); // Detener la reproducción del gif cuando llega a la meta
            }
        }

        boolean allFinished = true;
        for (int speed : gifSpeeds) {
            if (speed != 0) {
                allFinished = false;
                break;
            }
        }

        if (allFinished) {
            raceOver = true;
            showResults();
        }
    }

    private void showResults() {
    System.out.println("Resultados:");

    for (int i = 0; i < 4; i++) {
        int posicion = finalPositions.get(i);
        String nombreCorredor = nombresCorredores[posicion - 1];

        System.out.println("Puesto " + (i + 1) + ": " + nombreCorredor);
    }

    ((Frame) getParent()).dispose();
    System.exit(0);
}

    private class GifLabel extends Label {
        private Image image;
        private String nombreCorredor; // Agregamos un atributo para almacenar el nombre del corredor

        public GifLabel(Image image, String nombreCorredor) {
            this.image = image;
            this.nombreCorredor = nombreCorredor;
        }

        public void setImage(Image image) {
            this.image = image;
        }

        @Override
        public void paint(Graphics g) {
            if (image != null) {
                g.drawImage(image, 0, 0, this);
            }
        }
    }
}