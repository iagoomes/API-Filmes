import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoImdb implements ExtratorDeConteudo{

    @Override
    public List<Conteudo> extraiConteudos(String json) {

        JsonParser parse = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parse.parse(json);
        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributo : listaDeAtributos) {
            conteudos.add(new Conteudo(atributo.get("title"), atributo.get("image")));
        }

        return conteudos;
    }
}
