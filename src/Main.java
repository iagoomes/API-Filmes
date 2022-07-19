import java.io.IOException;
import java.net.URI;
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
            System.out.println(filme.get("title"));
            System.out.println(filme.get("imDbRating"));

            Double rating = Double.parseDouble(filme.get("imDbRating"));

            for (int i = 0; i < rating.intValue(); i++){
                System.out.print("\u2B50");
            }

            System.out.println("\n");
        }
    }
}