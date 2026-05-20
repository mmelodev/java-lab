import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class MainPessoa{
    public static void main(String[] args)  {
        String json = """
        {
            "nome": "Murilo",
            "idade": 24,
            "cidade": "Belém",
            "nacionalidade":"brasileiro"
        }
        """;

        Gson gson = new Gson();

        Pessoa novaPessoa = gson.fromJson(json, Pessoa.class);

        //verificar se existe um campo que está vazio e caso houver um campo após devo acrescentar no json

        System.out.println(novaPessoa);
    }
}
