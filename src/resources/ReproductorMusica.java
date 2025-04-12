package resources;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;


public class ReproductorMusica {

    private Clip clip;
    private FloatControl volumen;

    public void reproducirMusica(String rutaRecurso) {
        detenerMusica();

        try {
            // Carga del recurso desde dentro del .jar
            InputStream input = getClass().getResourceAsStream(rutaRecurso);
            if (input == null) {
                System.out.println("No se encontró el archivo de música: " + rutaRecurso);
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(input));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            volumen = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            setVolumen(-30f); // Volumen inicial para crossfade

            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            fadeIn(); // Subir volumen progresivamente

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error al reproducir música: " + e.getMessage());
        }
    }

    public void detenerMusica() {
        if (clip != null) {
            fadeOut(); // Suaviza la salida
            clip.stop();
            clip.close();
        }
    }

    private void setVolumen(float db) {
        if (volumen != null) {
            volumen.setValue(db); // Rango típico: -80 (mín) a 6 (máx)
        }
    }

    private void fadeIn() {
        new Thread(() -> {
            for (float v = -30f; v <= 0f; v += 2f) {
                setVolumen(v);
                esperar(100);
            }
        }).start();
    }

    private void fadeOut() {
        if (volumen == null) return;
        for (float v = volumen.getValue(); v >= -30f; v -= 2f) {
            setVolumen(v);
            esperar(80);
        }
    }

    private void esperar(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
