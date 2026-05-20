package br.com.livraria;
import br.com.livraria.modelos.ApiResponse;
import br.com.livraria.modelos.Titulo;
import br.com.livraria.modelos.TituloOmdb;
import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class MainLivraria {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner e = new Scanner(System.in);

        System.out.println("*********************************" +
                "\nBEM-VINDO A LIVRARIA ONLINE, " +
                "\n*********************************");

        System.out.println("\nDigite o nome do livro que deseja:\n>> ");
        String busca = e.nextLine();

        String endereco = "https://openlibrary.org/search.json?q=" + busca.replace(" ","+");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

//      client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join(); sendAsync(...).thenAccept(System.out::println)
//
//                → imprime o JSON. Depois você chama send(...) (requisição síncrona) → converte JSON → cria objetos → imprime toString(). Se tirar o sendAsync(...). Vai imprimir somente os títulos formatados (Titulo.toString()).

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new GsonBuilder().create();
        //Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create(); -> Para caso o Json tiver letras maiusculas camel case

        ApiResponse apiResponse = gson.fromJson(json, ApiResponse.class);

        List<TituloOmdb> titulosOmdbs = apiResponse.docs();
        List<Titulo> titulos = titulosOmdbs.stream().map(Titulo::new).toList();

        titulos.forEach(System.out::println);

    }
}
