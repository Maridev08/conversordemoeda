package br.com.conversordemoeda.moeda;



public class Moeda {

    private String moedaSelecionada;
    private String mensagem;


    public String getMoedaSelecionada() {
        return moedaSelecionada;
    }

    public void exibeMenu(){


        System.out.println("*****************************************");
        System.out.println("Seja bem vindo(a) ao Conversor de Moeda :");
        System.out.println("*****************************************");
        System.out.println("""
                    1.Dólar =>>>Peso argentino
                    2.Peso argentino =>>>Dólar
                    3.Dólar =>>>Real brasileiro
                    4.Real Brasileiro =>>>Dólar
                    5.Dólar =>>Peso colombiano
                    6.Peso colombiano =>>>Dólar
                    7.sair
                    """);
        System.out.println("*****************************************");
        System.out.println("Escolha uma opção válida");
    }


    public void atribuiMoeda(int opcaoMenu) {
        switch (opcaoMenu) {
            case 1:
                this.moedaSelecionada = "USD/ARS/";
                break;
            case 2:
                this.moedaSelecionada= "ARS/USD/";
                break;
            case 3:
                this.moedaSelecionada = "USD/BRL/";
                break;
            case 4:
                this.moedaSelecionada= "BRL/USD/";
                break;
            case 5:
                this.moedaSelecionada = "USD/COP/";
                break;
            case 6:
                this.moedaSelecionada= "COP/USD/";
                break;
        }


    }
    public String informaValorConvertido(int opcaoMenu,ObjetoJson objetoJson,double valor){
     String mensagem="";
        switch (opcaoMenu) {
            case 1:
           mensagem="O valor de "+valor+"[USD] corresponde ao valor final de ===>>> "+objetoJson.conversion_result()+"[ARS]";
                break;
            case 2:
               mensagem="O valor de "+valor+"[ARS] corresponde ao valor final de ===>>> "+objetoJson.conversion_result()+"[USD]";
                break;
            case 3:
                 mensagem="O valor de "+valor+"[USD] corresponde ao valor final de ===>>> "+objetoJson.conversion_result()+"[BRL]";
                break;
            case 4:
               mensagem="O valor de "+valor+"[BRL] corresponde ao valor final de ===>>> "+objetoJson.conversion_result()+"[USD]";
                break;
            case 5:
               mensagem="O valor de "+valor+"[USD] corresponde ao valor final de ===>>> "+objetoJson.conversion_result()+"[COP]";
                break;
            case 6:
              mensagem="O valor de "+valor+"[COP] corresponde ao valor final de ===>>> "+objetoJson.conversion_result()+"[USD]";
                break;
        }
      return mensagem;
    }


}
