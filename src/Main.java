import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{

        String url = "https://api.mocki.io/v2/549a5d8b";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();


//        String url = "https://api.nasa.gov/planetary/apod?api_key=m8p5ZkyE3tbiqyUlbMr3ZgPkoGsKrQL0PLg91d0F&start_date=2022-06-12&end_date=2022-06-14";
//        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        for (Conteudo conteudo : conteudos) {

            InputStream inputStream= new URL(conteudo.getUrl()).openStream();
            String nomeArquivo = conteudo.getTitle() + ".png";

            GeradorDeFigurinhas.criar(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitle());
            System.out.println();

        }
    }
}