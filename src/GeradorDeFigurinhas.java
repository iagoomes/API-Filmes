import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public abstract class GeradorDeFigurinhas {

    public static void criar(InputStream inputStream, String nomeArquivo) throws IOException {

        //leitura da imagem
        //InputStream inputStream= new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();

        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //criar nova imagem com trânsparencia e com nova dimensão
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para a nova imagem em memória
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar fonte
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        //escrever uma frase na imagem
        graphics.drawString("TOPZERA", 100, novaAltura - 100);


        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem,"png", new File("C:/Users/INTEL/OneDrive/Imagens/API/" + nomeArquivo));

    }
}
