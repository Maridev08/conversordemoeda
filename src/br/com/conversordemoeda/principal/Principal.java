package br.com.conversordemoeda.principal;

import br.com.conversordemoeda.moeda.Moeda;
import br.com.conversordemoeda.moeda.ObjetoJson;
import br.com.conversordemoeda.moeda.RequisitaApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




import java.util.Scanner;

public class Principal {
    public static void main(String[] args)  {
        Scanner leitor=new Scanner(System.in);

        Moeda moeda =new Moeda();
        RequisitaApi api=new RequisitaApi();

        System.out.println("*****************************************");
        System.out.println("Seja bem vindo(a) ao Conversor de Moeda :");
        System.out.println("*****************************************");

        var continua=true;
        var valor=0.0;


        while (continua) {
            moeda.exibeMenu();

            var opcaoMenu = Integer.parseInt(leitor.nextLine());

            if (opcaoMenu == 7) {
                continua = false;
                break;
            }

            moeda.atribuiMoeda(opcaoMenu);
            System.out.println("Digite o valor que deseja converter");
            valor = Double.parseDouble(leitor.nextLine());
            api.criaUrl(moeda, valor);
            api.fazRequisicaoApi();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ObjetoJson objetoJson = gson.fromJson(api.getJson(), ObjetoJson.class);

            String mensagem = moeda.informaValorConvertido(opcaoMenu, objetoJson, valor);
            System.out.println(mensagem);

        }
    }
}
