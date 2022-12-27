import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Scanner;

public class Ocupacoes {

    public String nomeCargo;
    public String tipoCargo;
    public String salario;
    public String dataInicio;
    public String local;
    public String descricao;
    public String depoimentoOcupa;

    public void CriarOcupacao(){

        Scanner scan = new Scanner(System.in);
        String resposta;
        boolean respostaMaisOcupa = true;

        System.out.println("Nome do cargo: ");
        this.nomeCargo = scan.nextLine();

        System.out.println("Escolha o tipo do cargo: ");
        System.out.println("1 - empregado");
        System.out.println("2 - empregador");
        this.tipoCargo = scan.nextLine();

        //número inválido
        if (!(Objects.equals(tipoCargo, "1") || Objects.equals(tipoCargo, "2"))) {
            do {
                System.out.println("Comando inválido, digite '1' ou '2' para escolher a opção: ");
                System.out.println("1 - empregado");
                System.out.println("2 - empregador");

                tipoCargo = scan.nextLine();

            } while (!(Objects.equals(tipoCargo, "1") || Objects.equals(tipoCargo, "2")));
        }

        System.out.println("Salário: ");
        this.salario = scan.nextLine();

        System.out.println("Data de início: ");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.dataInicio = scan.nextLine();

        System.out.println("Local da ocupação: ");
        this.local = scan.nextLine();

        System.out.println("Descrição: ");
        this.descricao = scan.nextLine();

        System.out.println("Adicionar um depoimento?");
        System.out.println("1 - sim");
        System.out.println("2 - não");

        resposta = scan.nextLine();
        if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2"))) {
            do {
                System.out.println("Comando inválido, digite '1' ou '2' para escolher a opção: ");
                resposta = scan.nextLine();
            } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2")));
        }

        if (Objects.equals(resposta, "1")) {
            System.out.println("Depoimento: ");
            depoimentoOcupa = scan.nextLine();
        }

        System.out.println("-adicionado-");



/*
     do {
        System.out.println("adicionar outra ocupação?");
        System.out.println("1 - sim");
        System.out.println("2 - não");

        resposta = scan.next();

        if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2"))) {
            do {
                System.out.println("Comando inválido, digite '1' ou '2' para escolher a opção: ");
                System.out.println("1 - sim");
                System.out.println("2 - não");
                resposta = scan.next();

            } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2")));
        }


        if (resposta.equals("2")) {
            respostaMaisOcupa = false;
        } else {

            System.out.println("Nome do cargo: ");
            this.nomeCargo = scan.nextLine();

            System.out.println("Escolha o tipo do cargo: ");
            System.out.println("1 - empregado");
            System.out.println("2 - empregador");
            this.tipoCargo = scan.nextLine();

            //número inválido
            if (!(Objects.equals(tipoCargo, "1") || Objects.equals(tipoCargo, "2"))) {
                do {
                    System.out.println("Comando inválido, digite '1' ou '2' para escolher a opção: ");
                    System.out.println("1 - empregado");
                    System.out.println("2 - empregador");

                    tipoCargo = scan.nextLine();

                } while (!(Objects.equals(tipoCargo, "1") || Objects.equals(tipoCargo, "2")));
            }

            System.out.println("Salário: ");
            this.salario = scan.nextLine();

            System.out.println("Data de início: ");
            formatter = new SimpleDateFormat("dd/MM/yyyy");
            this.dataInicio = scan.nextLine();

            System.out.println("Local da ocupação: ");
            this.local = scan.nextLine();

            System.out.println("Descrição: ");
            this.descricao = scan.nextLine();

            System.out.println("Quer adicionar um depoimento?");
            System.out.println("1 - sim");
            System.out.println("2 - não");

            resposta = scan.nextLine();
            if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2"))) {
                do {
                    System.out.println("Comando inválido, digite '1' ou '2' para escolher a opção: ");
                    resposta = scan.nextLine();
                } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2")));
            }

            if (Objects.equals(resposta, "1")) {
                System.out.println("Depoimento: ");
                depoimentoOcupa = scan.nextLine();
            }

            System.out.println("-adicionado-");

        }
     }while(respostaMaisOcupa);

 */ }

    public void EditarOcupacao() {

        Scanner scan = new Scanner(System.in);
        String resposta;

        System.out.println("lista de ocupações:");
        System.out.println(" ");
        System.out.println(Egressos.listaOcupa);

        for (int x = 0; x < Egressos.listaOcupa.size(); x++) {
            System.out.println(x + " - " + Egressos.listaOcupa.get(x));
        }

        System.out.println("Selecione a ocupação que deseja editar: ");

        resposta = scan.nextLine();

        if (Integer.parseInt(resposta) > Egressos.listaOcupa.size()) {
            do {
                System.out.println("Comando inválido, digite o número referente a uma ocupação para escolher a opção: ");
                resposta = scan.nextLine();
            } while (Integer.parseInt(resposta) > Egressos.listaOcupa.size());
        }

        System.out.println(" -Selecionado- ");
        System.out.println(Egressos.listaOcupa.get(Integer.parseInt(resposta)));


        System.out.println("Selecione que informação deseja editar");
        System.out.println("1 - nome do cargo");
        System.out.println("2 - tipo do cargo");
        System.out.println("3 - salário");
        System.out.println("4 - data de início");
        System.out.println("5 - local");
        System.out.println("6 - descricao");
        System.out.println("7 - depoimento");
        resposta = scan.nextLine();


        if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6") || Objects.equals(resposta, "7"))) {
            do {
                System.out.println("Selecione que informação deseja editar");
                System.out.println("1 - nome do cargo");
                System.out.println("2 - tipo do cargo");
                System.out.println("3 - salário");
                System.out.println("4 - data de início");
                System.out.println("5 - local");
                System.out.println("6 - descricao");
                System.out.println("7 - depoimento");
                resposta = scan.nextLine();

            } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6") || Objects.equals(resposta, "7")));
        }
        if (Objects.equals(resposta, "1")) {

            System.out.println("-editar nome do cargo-");
            System.out.println("digite o novo nome do cargo: ");

            nomeCargo = scan.nextLine();
        }

        else if (Objects.equals(resposta, "2")) {

            System.out.println("-editar tipo do cargo-");
            System.out.println("Escolha o novo tipo do cargo: ");
            System.out.println("1 - empregado");
            System.out.println("2 - empregador");
            this.tipoCargo = scan.nextLine();

            //número inválido
            if (!(Objects.equals(tipoCargo, "1") || Objects.equals(tipoCargo, "2"))) {
                do {
                    System.out.println("Comando inválido, digite '1' ou '2' para escolher a opção: ");
                    System.out.println("1 - empregado");
                    System.out.println("2 - empregador");

                    tipoCargo = scan.nextLine();

                } while (!(Objects.equals(tipoCargo, "1") || Objects.equals(tipoCargo, "2")));
            }
        }

        else if (Objects.equals(resposta, "3")) {

            System.out.println("-editar salário-");
            System.out.println("digite o novo salário: ");

            while (scan.hasNextInt()) scan.next();
            salario = scan.nextLine();
        }

        else if (Objects.equals(resposta, "4")) {
            System.out.println("-editar data de início-");
            System.out.println("digite a nova data de início: ");

            dataInicio = scan.nextLine();
        }

        else if (Objects.equals(resposta, "5")) {
            System.out.println("-editar local-");
            System.out.println("digite o novo local: ");

            local = scan.nextLine();
        }

        else if (Objects.equals(resposta, "6")) {
            System.out.println("-editar descricao-");
            System.out.println("digite a nova descricao: ");

            descricao = scan.nextLine();
        }

        else{

            System.out.println("-editar depoimento-");
            System.out.println("digite o novo depoimento: ");

            while (scan.hasNextInt()) scan.next();
            depoimentoOcupa = scan.nextLine();
        }

        System.out.println("-edição realizada-");
        System.out.println(Egressos.listaOcupa);
    }

    @Override
    public String toString() {
        return "Ocupacoes{" +
                "nomeCargo='" + nomeCargo + '\'' +
                ", tipoCargo='" + tipoCargo + '\'' +
                ", salario='" + salario + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", local='" + local + '\'' +
                ", descricao='" + descricao + '\'' +
                ", depoimentoOcupa='" + depoimentoOcupa + '\'' +
                '}';
    }
}