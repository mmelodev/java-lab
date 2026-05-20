import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exceptions.ErroConsultaGitHubException;
import modelos.Usuario;
import records.UsuarioComApi;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainBuscaApiGitHub {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("\n**********Busca de usuário no Github**********\n");
        Scanner en = new Scanner(System.in);
        String novoUsuario = "";
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        List <Usuario> listaDeUsuarios = new ArrayList<>();


        while (!novoUsuario.equalsIgnoreCase("sair")){
            try {
                System.out.println("\nDigite o nome do usuário que deseja mais informações: \n");
                novoUsuario = en.nextLine();

                if (novoUsuario.equalsIgnoreCase("sair")){
                    break;
                }

                String endereco = "https://api.github.com/users/" + novoUsuario;

                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();


                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                if (json.contains("Not Found")) {
                    throw new ErroConsultaGitHubException("\nUsuário não encontrado!\n");
                }

                UsuarioComApi meuUsuarioAPI = gson.fromJson(json, UsuarioComApi.class);

                Usuario meuUsuario = new Usuario(meuUsuarioAPI);
                System.out.println(meuUsuario);

                //Cada vez que eu rodar o projeto, o arquivo txt vai ser sobrescrito com a saida a partir da minha requisição

                listaDeUsuarios.add(meuUsuario);

                FileWriter listaDeUsuariosTxt = new FileWriter("listaDeUsuarios.txt");
                listaDeUsuariosTxt.write(gson.toJson(listaDeUsuarios));
                listaDeUsuariosTxt.close();
            } catch (ErroConsultaGitHubException e){
                System.out.println(e.getMessage());
            }
        }


    }
}
