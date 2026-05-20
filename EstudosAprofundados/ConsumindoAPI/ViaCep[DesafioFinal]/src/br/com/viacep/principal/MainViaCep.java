package br.com.viacep.principal;

import br.com.viacep.exceptions.ErroDeDigitacaoCep;
import br.com.viacep.exceptions.ErroDeServidor;
import br.com.viacep.modelos.Pessoa;
import br.com.viacep.records.PessoaComApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainViaCep {
    public static void main(String[] args) throws IOException, InterruptedException, ErroDeDigitacaoCep {
        System.out.println("\n**********Busca de CEP (ViaCep)**********\n");

        Scanner n = new Scanner (System.in);
        Scanner p = new Scanner (System.in);
        Scanner c = new Scanner (System.in);

        String novaPessoa = "";

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        List<Pessoa> listaDePessoas = new ArrayList<>();

        while (!novaPessoa.equalsIgnoreCase("sair")){
            try {
                System.out.println("\nDigite seu nome: \n");
                novaPessoa = n.nextLine();

                if (novaPessoa.equalsIgnoreCase("sair")){
                    break;
                }

                System.out.println("\nDigite sua profissão: \n");
                String profissao = p.nextLine();

                System.out.println("\nDigite seu CEP: (apenas o números e sem espaços)\n");
                String cep = c.nextLine();

                String endereco = "https://viacep.com.br/ws/" + cep + "/json/";

                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                int statusCode = response.statusCode();

                String json = response.body();

                PessoaComApi novaPessoaComApi = gson.fromJson(json, PessoaComApi.class);

                Pessoa pessoa = new Pessoa(novaPessoa, profissao, novaPessoaComApi);

                if (statusCode >= 400 && statusCode < 500) {
                    throw new ErroDeDigitacaoCep("\nErro! Digite o CEP corretamente!");
                } else if (statusCode >= 500) {
                    throw new ErroDeServidor("\nErro no Servidor, tente mais tarde");
                } else if (json.contains("true")) {
                    throw new ErroDeDigitacaoCep("\nErro! CEP Inválido!");
                }

                System.out.println(pessoa);
                listaDePessoas.add(pessoa);

                FileWriter escrita = new FileWriter("listaDePessoas.json");
                escrita.write(gson.toJson(listaDePessoas));
                escrita.close();
                //Como estou transformando para Json, o toString em Pessoa acaba que nem é aplicado;
            } catch (ErroDeDigitacaoCep e){
                System.out.println(e.getMessage());
            } catch (ErroDeServidor e) {
                System.out.println(e.getMessage());;
            } catch (JsonSyntaxException e){
                System.out.println("\nExiste algum elemento faltando no cep digitado...");
            }
        }
    }
}
