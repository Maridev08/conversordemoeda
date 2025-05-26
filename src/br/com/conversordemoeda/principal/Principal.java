package br.com.conversordemoeda.principal;

import br.com.conversordemoeda.exception.VallorInvalidoException;
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

        var continua=true;
        var valor=0.0;
        var opcaoMenu=0;

        while (continua) {
            moeda.exibeMenu();

            try {
                opcaoMenu = Integer.parseInt(leitor.nextLine());
                if (opcaoMenu == 7) {
                    continua = false;
                    break;
                }
                if (opcaoMenu<1 || opcaoMenu>7){
                 throw new VallorInvalidoException("Essa opção não existe!, escolha uma das opções .");
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

            }catch (NumberFormatException e ){
                System.out.println("Formato inválido!,digite uma das opções .");
            }catch (VallorInvalidoException e){
                System.out.println(e.getLocalizedMessage());
            }


        }
        leitor.close();
    }
}
