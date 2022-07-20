import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String url = "https://api.mocki.io/v2/549a5d8b";
        URI adress = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(adress).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        JsonParser parse = new JsonParser();

        List<Map<String, String>> listaDeFilmes = parse.parse(body);

        for (Map<String,String> filme : listaDeFilmes) {

            String urlImagem = filme.get("image");
            String nomeFilme = filme.get("title");


            InputStream inputStream= new URL(urlImagem).openStream();
            String nomeArquivo = nomeFilme + ".png";

            GeradorDeFigurinhas.criar(inputStream, nomeArquivo);

            System.out.println(nomeFilme);
            System.out.println();

        }
    }
}