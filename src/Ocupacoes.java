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
        boolean respostaMaisCurso = true;


        System.out.println("Nome do cargo: ");
        this.nomeCargo = scan.nextLine();

        System.out.println("Escolha o tipo do cargo: ");
        System.out.println("1 - empregado");
        System.out.println("2 - empregador");
        this.tipoCargo = scan.nextLine();

        //número inválido
        if (!(Objects.equals(tipoCargo, "1") || Objects.equals(tipoCargo, "2"))) {
            do {
                System.out.println("Comando inválido, igite '1' ou '2' para escolher a opção: ");
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
            respostaMaisCurso = false;
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
    }while(respostaMaisCurso);
}}


