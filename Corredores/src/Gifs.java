package Corredores;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;


public class Gifs extends Frame {

    public Gifs() {
        initUI();
    }

    private void initUI() {
        setTitle("Imágenes GIF en línea");
        setSize(300, 900);
        setLocationRelativeTo(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });

        GifPanel gifPanel = new GifPanel();
        add(gifPanel);

        int delay = 100; // milisegundos (100ms)
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                gifPanel.moveGIFs();
            }
        }, delay, delay);
        
        
    }
    
    

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Gifs frame = new Gifs();
            frame.setVisible(true);
        });
    }
}
