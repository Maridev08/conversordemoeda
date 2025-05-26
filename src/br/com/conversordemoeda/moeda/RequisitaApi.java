package br.com.conversordemoeda.moeda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequisitaApi {

    private String url;
    private String json;


    public String getUrl() {
        return url;
    }

    public String getJson() {
        return json;
    }


    public void criaUrl(Moeda moeda, double valor){
        this.url="https://v6.exchangerate-api.com/v6/2533323d019fe6e589648052/pair/"+moeda.getMoedaSelecionada()+valor;
    }

    public void fazRequisicaoApi()  {

            try {
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(this.url))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                this.json= response.body();
            }catch (IllegalArgumentException | IOException | InterruptedException e){
                System.out.println("Erro!,não consegui acessar os dados");
            }

    }


}
