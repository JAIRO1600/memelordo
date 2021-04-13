import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        File fichero = new File("foto.png");
        File fusion = new File("combined.png");
        String formato = "png";
        int ancho;
        int alto;
        ancho = in.nextInt();
        alto = in.nextInt();
        try {
            // creamos una nueva imagen transparente con los valores de ancho y alto
            // recogidos por pantalla
            BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TRANSLUCENT);
            // cargamos la imagen qr;
            BufferedImage qr = ImageIO.read(new File("qr.png"));
            // creamos otra nueva imagen llamada combined con los valores de ancho y alto
            // recogidos por pantalla
            BufferedImage combined = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
            // pintamos ambas imágenes
            Graphics g = combined.getGraphics();
            g.drawImage(qr, 0, 0, qr.getWidth(), qr.getHeight(), null);
            g.drawImage(combined, 0, 0, ancho, alto, null);
            // guardamos ambas imágenes
            ImageIO.write(imagen, formato, fichero);
            ImageIO.write(combined, formato, fusion);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
