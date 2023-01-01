import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Scanner;

public class Ocupacoes {

    public String nomeCargo;
    public String tipoCargo;
    public String salario;
    public String dataInicio;
    public String anoInicio;
    public String dataFim;
    public String anoFim;
    public String local;
    public String descricao;
    public String depoimentoOcupa;

    public void CriarOcupacao() {

        Scanner scan = new Scanner(System.in);
        String resposta;
        boolean respostaMaisOcupa = true;

        System.out.println("nome do cargo: ");
        this.nomeCargo = scan.nextLine();
/*
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

 */

        System.out.println("salário: ");
        this.salario = scan.nextLine();

        System.out.println("data de início: (dia/mês/ano)");
        this.dataInicio = scan.nextLine();
        this.anoInicio = dataInicio.substring(6);


        System.out.println("data final: (dia/mês/ano)");
        this.dataFim = scan.nextLine();
        this.anoFim = dataFim.substring(6);

        System.out.println("local da ocupação: ");
        this.local = scan.nextLine();


        System.out.println("descrição: ");
        this.descricao = scan.nextLine();

        System.out.println("adicionar um depoimento?");
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
            System.out.println("depoimento: ");
            depoimentoOcupa = scan.nextLine();
        }

        System.out.println(" ");
        System.out.println("cadastrado");
        System.out.println(" ");
    }

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

        System.out.println("selecionado");
        System.out.println(Egressos.listaOcupa.get(Integer.parseInt(resposta)));


        System.out.println("Selecione que informação deseja editar");
        System.out.println("1 - nome do cargo");
        System.out.println("2 - tipo do cargo");
        System.out.println("3 - salário");
        System.out.println("4 - data de início");
        System.out.println("5 - data final");
        System.out.println("6 - local");
        System.out.println("7 - descricao");
        System.out.println("8 - depoimento");
        resposta = scan.nextLine();


        if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6") || Objects.equals(resposta, "7") || Objects.equals(resposta, "8"))) {
            do {
                System.out.println("Selecione que informação deseja editar");
                System.out.println("1 - nome do cargo");
                System.out.println("2 - tipo do cargo");
                System.out.println("3 - salário");
                System.out.println("4 - data de início");
                System.out.println("5 - data final");
                System.out.println("6 - local");
                System.out.println("7 - descricao");
                System.out.println("8 - depoimento");
                resposta = scan.nextLine();

            } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6") || Objects.equals(resposta, "7") || Objects.equals(resposta, "8")));
        }
        if (Objects.equals(resposta, "1")) {

            System.out.println(" ");
            System.out.println("-editar nome do cargo-");
            System.out.println(" ");

            System.out.println("digite o novo nome do cargo: ");

            String novoNomeCargo = scan.nextLine();
            Egressos.listaOcupa.get(Integer.parseInt(resposta)).setNomeCargo(novoNomeCargo);
        }

        else if (Objects.equals(resposta, "2")) {

            System.out.println(" ");
            System.out.println("-editar tipo do cargo-");
            System.out.println(" ");

            System.out.println("Escolha o novo tipo do cargo: ");
            System.out.println("1 - empregado");
            System.out.println("2 - empregador");
            String novoTipoCargo = scan.nextLine();
            Egressos.listaOcupa.get(Integer.parseInt(resposta)).setTipoCargo(novoTipoCargo);

            //número inválido
            if (!(Objects.equals(tipoCargo, "1") || Objects.equals(tipoCargo, "2"))) {
                do {
                    System.out.println("Comando inválido, digite '1' ou '2' para escolher a opção: ");
                    System.out.println("1 - empregado");
                    System.out.println("2 - empregador");

                    novoTipoCargo = scan.nextLine();
                    Egressos.listaOcupa.get(Integer.parseInt(resposta)).setTipoCargo(novoTipoCargo);

                } while (!(Objects.equals(tipoCargo, "1") || Objects.equals(tipoCargo, "2")));
            }
        }

        else if (Objects.equals(resposta, "3")) {

            System.out.println(" ");
            System.out.println("-editar salário-");
            System.out.println(" ");

            System.out.println("digite o novo salário: ");

            while (scan.hasNextInt()) scan.next();
            salario = scan.nextLine();

            String novoSalario = scan.nextLine();
            Egressos.listaOcupa.get(Integer.parseInt(resposta)).setSalario(novoSalario);
        }

        else if (Objects.equals(resposta, "4")) {

            System.out.println(" ");
            System.out.println("-editar data de início-");
            System.out.println(" ");

            System.out.println("digite a nova data de início: ");


            String novaDataInicio = scan.nextLine();
            Egressos.listaOcupa.get(Integer.parseInt(resposta)).setDataInicio(novaDataInicio);
            String novoAnoInicio = novaDataInicio.substring(6);
            Egressos.listaOcupa.get(Integer.parseInt(resposta)).setAnoInicio(novoAnoInicio);
            int novoInvervaloOcupa = Integer.parseInt(anoFim) - Integer.parseInt(novoAnoInicio);
        }

        else if (Objects.equals(resposta, "5")) {

            System.out.println(" ");
            System.out.println("-editar data final-");
            System.out.println(" ");

            System.out.println("digite a nova data final: (dia/mês/ano)");


            String novaDataFim = scan.nextLine();
            Egressos.listaOcupa.get(Integer.parseInt(resposta)).setDataFim(novaDataFim);
            String novoAnoFim = novaDataFim.substring(6);
            Egressos.listaOcupa.get(Integer.parseInt(resposta)).setAnoFim(novoAnoFim);
            int novoInvervaloOcupa = Integer.parseInt(novoAnoFim) - Integer.parseInt(anoInicio);

        }

        else if (Objects.equals(resposta, "6")) {

            System.out.println(" ");
            System.out.println("-editar local-");
            System.out.println(" ");

            System.out.println("digite o novo local: ");

            String novoLocal = scan.nextLine();
            Egressos.listaOcupa.get(Integer.parseInt(resposta)).setLocal(novoLocal);
        }

        else if (Objects.equals(resposta, "7")) {

            System.out.println(" ");
            System.out.println("-editar descrição-");
            System.out.println(" ");

            System.out.println("digite a nova descricao: ");

            String novaDescricao = scan.nextLine();
            Egressos.listaOcupa.get(Integer.parseInt(resposta)).setDescricao(novaDescricao);
        }

        else{

            System.out.println(" ");
            System.out.println("-editar depoimento-");
            System.out.println(" ");

            System.out.println("digite o novo depoimento: ");


            String novoDepoimentoOcupa = scan.nextLine();
            Egressos.listaOcupa.get(Integer.parseInt(resposta)).setDepoimentoOcupa(novoDepoimentoOcupa);
        }

        System.out.println(" ");
        System.out.println("-edição realizada-");
        System.out.println(" ");

        System.out.println(Egressos.listaOcupa);
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(String anoInicio) {
        this.anoInicio = anoInicio;
    }

    public String getAnoFim() {
        return anoFim;
    }

    public void setAnoFim(String anoFim) {
        this.anoFim = anoFim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDepoimentoOcupa() {
        return depoimentoOcupa;
    }

    public void setDepoimentoOcupa(String depoimentoOcupa) {
        this.depoimentoOcupa = depoimentoOcupa;
    }

    @Override
    public String toString() {

        return  "Nome do cargo: " + nomeCargo +
                "Tipo do cargo: " + tipoCargo +
                "Salário: " + salario +
                "Data de início: " + dataInicio +
                "Local: " + local +
                "Descrição do cargo: " + descricao +
                "Depoimento da ocupação: " + depoimentoOcupa;
    }
}