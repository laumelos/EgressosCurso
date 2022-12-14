import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Egressos {
    public String cpf;
    String formacoes;
    public String nomeEgresso;
    public String dataConclusao;
    public String coordEgresso;
    public static ArrayList<Cursos> listaCursos = new ArrayList<Cursos>();
    public static ArrayList<Ocupacoes> listaOcupa = new ArrayList<Ocupacoes>();
    public static ArrayList <Egressos> listaEgressosEditados = new ArrayList<Egressos>();

    String depoimentoEgresso;
    String anoConclusao;


    public void CriarEgresso() throws IOException {
        Scanner scan = new Scanner(System.in);
        String resposta;
        coordEgresso = Coordenador.coordLogado;

        System.out.println("nome do egresso: ");
        nomeEgresso = scan.nextLine();

        System.out.println("cpf do egresso: ");
        cpf = scan.nextLine();
        do{
            if (!(cpf.length() == 11)) {
                System.out.println("cpf inválido, digite novamente:");
                cpf = scan.nextLine();
            }
        }while (!(cpf.length() == 11));

        System.out.println("data de conclusão do egresso: ");
        System.out.println("Digite a data (dd/mm/aaaa)");
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //dataConclusao = scan.nextLine();
        dataConclusao = scan.nextLine();
        do{
            if (!(dataConclusao.length() == 10)) {
                System.out.println("data inválida, digite novamente: (dd/mm/aaaa)");
                dataConclusao = scan.nextLine();
            }
        }while (!(dataConclusao.length() == 10));


        anoConclusao = dataConclusao.substring(6);

        System.out.println("contato do egresso: ");
        Contato criarContato = new Contato();
        criarContato.CriarContato();

        System.out.println("curso do egresso: ");
        Cursos criarCurso = new Cursos();
        criarCurso.CriarCurso();

        if (Objects.equals(criarCurso.instituicao, "UFMA") || Objects.equals(criarCurso.instituicao, "Ufma") || Objects.equals(criarCurso.instituicao, "ufma") ) {
            //System.out.println(criarCurso.nomeCurso);
            //System.out.println(criarCurso);
            Coordenador.listaCursos.add(criarCurso);
            listaCursos.add(criarCurso);
            //System.out.println("Coordenador" + Coordenador.listaCursos);
        }
        else {
            listaCursos.add(criarCurso);
            System.out.println("Egresso" + listaCursos);
        }

        System.out.println("ocupações do egresso: ");
        Ocupacoes criarOcupacao = new Ocupacoes();
        criarOcupacao.CriarOcupacao();
        listaOcupa.add(criarOcupacao);
        System.out.println(listaOcupa);

        boolean MaisOcupa = true;
        do{
            System.out.println("Adicionar outra ocupação?");
            System.out.println("1 - sim");
            System.out.println("2 - não");

            String respostaMaisOcupa = scan.nextLine();


            if (!(Objects.equals(respostaMaisOcupa, "1") || Objects.equals(respostaMaisOcupa, "2"))) {
                do {
                    System.out.println("Comando inválido, digite '1' ou '2' para escolher a opção: ");
                    respostaMaisOcupa = scan.nextLine();
                } while (!(Objects.equals(respostaMaisOcupa, "1") || Objects.equals(respostaMaisOcupa, "2")));
            }
            if (Objects.equals(respostaMaisOcupa, "1")) {
                criarOcupacao = new Ocupacoes();
                criarOcupacao.CriarOcupacao();
                listaOcupa.add(criarOcupacao);
                System.out.println(listaOcupa);
            }else{
                MaisOcupa = false;
            }
        }while(MaisOcupa);

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
            System.out.println("depoimento: ");
            depoimentoEgresso = scan.nextLine();
        }
    }

    public void GerenciarEgresso() throws IOException {

        OutputStream egressoEditado = new FileOutputStream("egressosEditados.txt"); // nome do arquivo que será escrito
        Writer wrEgressoEditado = new OutputStreamWriter(egressoEditado); // criação de um escritor
        BufferedWriter brEgressoEditado = new BufferedWriter(wrEgressoEditado); // adiciono a um escritor de buffer
        brEgressoEditado.write("EGRESSOS EDITADOS:");//nome do arquivo txt

        Scanner scan = new Scanner(System.in);
        String resposta;
        //se tiver egresso cadastrado
        if (!(Coordenador.listaEgressos.isEmpty())){

            //buscar
            System.out.println("Selecione a forma de busca");
            System.out.println("1 - nome");
            System.out.println("2 - cpf");

            resposta = scan.nextLine();
            if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2"))) {
                do {
                    System.out.println("Comando inválido, digite '1' ou '2' para escolher a opção: ");
                    resposta = scan.nextLine();
                } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2")));
            }

            //buscar por nome
            if (Objects.equals(resposta, "1")) {

                //print lista de nomes
                System.out.println("lista de egressos: ");

                for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                    if (Objects.equals(Coordenador.listaEgressos.get(x).coordEgresso, Coordenador.coordLogado)) {
                        System.out.println(Coordenador.listaEgressos.get(x).getNomeEgresso());
                    }
                }

                //digitar nome para buscar
                System.out.println("nome do egresso: ");
                nomeEgresso = scan.nextLine();

                //buscar no array
                for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                    if (Objects.equals(Coordenador.listaEgressos.get(x).coordEgresso, Coordenador.coordLogado)) {

                        //egresso encontrado
                        if (Coordenador.listaEgressos.get(x).getNomeEgresso().equals(nomeEgresso)) {
                            System.out.println(" ");
                            System.out.println("egresso encontrado");
                            System.out.println(" ");
                            //System.out.println(Coordenador.listaEgressos.get(x));

                            System.out.println("Selecione a operação que você deseja realizar");
                            System.out.println("1 - editar");
                            System.out.println("2 - apagar egresso");

                            resposta = scan.nextLine();
                            if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2"))) {
                                do {
                                    System.out.println("Comando inválido, selecione '1' ou '2' para escolher a opção: ");
                                    resposta = scan.nextLine();
                                } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2")));
                            }

                            //editar
                            if (Objects.equals(resposta, "1")) {
                                System.out.println("Selecione que informação deseja editar");
                                System.out.println("1 - cpf");
                                System.out.println("2 - nome");
                                System.out.println("3 - data de conclusão");
                                System.out.println("4 - contatos");
                                System.out.println("5 - ocupações");
                                System.out.println("6 - cursos");
                                System.out.println("7 - depoimento");
                                resposta = scan.nextLine();


                                if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6") || Objects.equals(resposta, "7"))) {
                                    do {
                                        System.out.println("Selecione que informação deseja editar");
                                        System.out.println("1 - cpf");
                                        System.out.println("2 - nome");
                                        System.out.println("3 - data de conclusão");
                                        System.out.println("4 - contatos");
                                        System.out.println("5 - ocupações");
                                        System.out.println("6 - cursos");
                                        System.out.println("7 - depoimento");
                                        resposta = scan.nextLine();

                                    } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6") || Objects.equals(resposta, "7")));
                                }

                                //opções editar
                                if (Objects.equals(resposta, "1")) {

                                    System.out.println("-editar cpf-");
                                    System.out.println("digite o novo cpf: ");

                                    String novoCpf = scan.nextLine();

                                    novoCpf = scan.nextLine();
                                    do{
                                        if (!(novoCpf.length() == 11)) {
                                            System.out.println("cpf inválido, digite novamente:");
                                            novoCpf = scan.nextLine();
                                        }
                                    }while (!(novoCpf.length() == 11));

                                    Coordenador.listaEgressos.get(x).setCpf(novoCpf);
                                } else if (Objects.equals(resposta, "2")) {

                                    System.out.println("-editar nome-");
                                    System.out.println("digite o novo nome: ");

                                    String novoNomeEgresso = scan.nextLine();
                                    Coordenador.listaEgressos.get(x).setNomeEgresso(novoNomeEgresso);
                                } else if (Objects.equals(resposta, "3")) {

                                    System.out.println("-editar data de conclusão-");
                                    System.out.println("digite a nova data de conclusão (dd/mm/aaaa): ");

                                    String novaDataConclusao = scan.nextLine();

                                    do{
                                        if (!(novaDataConclusao.length() == 10)) {
                                            System.out.println("data inválida, digite novamente: (dd/mm/aaaa)");
                                            novaDataConclusao = scan.nextLine();
                                        }
                                    }while (!(novaDataConclusao.length() == 10));

                                    Coordenador.listaEgressos.get(x).setDataConclusao(novaDataConclusao);
                                } else if (Objects.equals(resposta, "4")) {
                                    Contato editarContato = new Contato();
                                    editarContato.EditarContato();
                                } else if (Objects.equals(resposta, "5")) {
                                    Ocupacoes editarOcupacao = new Ocupacoes();
                                    editarOcupacao.EditarOcupacao();
                                } else if (Objects.equals(resposta, "6")) {
                                    Cursos gerenciarCurso = new Cursos();
                                    gerenciarCurso.GerenciarCurso();
                                } else {

                                    System.out.println("-editar depoimento-");
                                    System.out.println("digite o novo depoimento: ");

                                    String novoDepoimentoEgresso = scan.nextLine();
                                    Coordenador.listaEgressos.get(x).setDepoimentoEgresso(novoDepoimentoEgresso);
                                }
                                listaEgressosEditados.add(Coordenador.listaEgressos.get(x));
                            }

                            //apagar
                            else {
                                System.out.println("-apagar egresso-");
                                Coordenador.listaEgressos.remove(Coordenador.listaEgressos.get(x));
                            }
                        //egresso NAO encontrado
                        }else {
                            System.out.println("egresso não encontrado");
                        }
                    }
                    listaEgressosEditados.add(Coordenador.listaEgressos.get(x));
                    // insere txt editado
                    for (int i=0; i < listaEgressosEditados.size(); i++ ){
                        brEgressoEditado.newLine();
                        brEgressoEditado.write(String.valueOf(listaEgressosEditados.get(x)));
                    }
                    brEgressoEditado.close();
                }

            //buscar por cpf
            }else{

                //print lista de cpf
                System.out.println("lista de egressos: ");

                for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                    if (Objects.equals(Coordenador.listaEgressos.get(x).coordEgresso, Coordenador.coordLogado)) {
                        System.out.println(Coordenador.listaEgressos.get(x).getCpf());
                    }
                }

                //digitar cpf para buscar
                System.out.println("cpf do egresso: ");
                //cpf = scan.nextInt();
                cpf = scan.nextLine();

                //buscar no array
                for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                    if (Objects.equals(Coordenador.listaEgressos.get(x).coordEgresso, Coordenador.coordLogado)) {

                        //egresso encontrado
                        if (Objects.equals(Coordenador.listaEgressos.get(x).getCpf(), cpf)) {
                            System.out.println("egresso encontrado");
                            System.out.println(" ");
                            //System.out.println(Coordenador.listaEgressos.get(x));

                            System.out.println("Selecione a operação que você deseja realizar");
                            System.out.println("1 - editar");
                            System.out.println("2 - apagar egresso");

                            resposta = scan.nextLine();
                            if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2"))) {
                                do {
                                    System.out.println("Comando inválido, selecione '1' ou '2' para escolher a opção: ");
                                    resposta = scan.nextLine();
                                } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2")));
                            }

                            //editar
                            if (Objects.equals(resposta, "1")) {
                                System.out.println("Selecione que informação deseja editar");
                                System.out.println("1 - cpf");
                                System.out.println("2 - nome");
                                System.out.println("3 - data de conclusão");
                                System.out.println("4 - contatos");
                                System.out.println("5 - ocupações");
                                System.out.println("6 - cursos");
                                System.out.println("7 - depoimento");
                                resposta = scan.nextLine();


                                if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6") || Objects.equals(resposta, "7"))) {
                                    do {
                                        System.out.println("Selecione que informação deseja editar");
                                        System.out.println("1 - cpf");
                                        System.out.println("2 - nome");
                                        System.out.println("3 - data de conclusão");
                                        System.out.println("4 - contatos");
                                        System.out.println("5 - ocupações");
                                        System.out.println("6 - cursos");
                                        System.out.println("7 - depoimento");
                                        resposta = scan.nextLine();

                                    } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6") || Objects.equals(resposta, "7")));
                                }

                                //opções editar
                                if (Objects.equals(resposta, "1")) {
                                    System.out.println(" ");
                                    System.out.println("-editar cpf-");
                                    System.out.println(" ");
                                    System.out.println("cpf atual: " + Coordenador.listaEgressos.get(x).getCpf());

                                    System.out.println("digite o novo cpf: ");

                                    while (!scan.hasNextInt()) scan.nextInt();
                                    cpf = scan.nextLine();
                                } else if (Objects.equals(resposta, "2")) {
                                    System.out.println(" ");
                                    System.out.println("-editar nome-");
                                    System.out.println(" ");
                                    System.out.println("nome atual: " + Coordenador.listaEgressos.get(x).getNomeEgresso());

                                    System.out.println("digite o novo nome: ");

                                    nomeEgresso = scan.nextLine();
                                } else if (Objects.equals(resposta, "3")) {
                                    System.out.println(" ");
                                    System.out.println("-editar data de conclusão-");
                                    System.out.println(" ");
                                    System.out.println("data de conclusão atual: " + Coordenador.listaEgressos.get(x).getDataConclusao());

                                    System.out.println("digite a nova data de conclusão: ");

                                    while (scan.hasNextInt()) scan.next();
                                    dataConclusao = scan.nextLine();
                                } else if (Objects.equals(resposta, "4")) {
                                    Contato editarContato = new Contato();
                                    editarContato.EditarContato();
                                } else if (Objects.equals(resposta, "5")) {
                                    Ocupacoes editarOcupacao = new Ocupacoes();
                                    editarOcupacao.EditarOcupacao();
                                } else if (Objects.equals(resposta, "6")) {
                                    Cursos gerenciarCurso = new Cursos();
                                    gerenciarCurso.GerenciarCurso();
                                } else {
                                    System.out.println(" ");
                                    System.out.println("-editar depoimento-");
                                    System.out.println(" ");
                                    System.out.println("depoimento atual: " + Coordenador.listaEgressos.get(x).getDepoimentoEgresso());

                                    System.out.println("digite o novo depoimento: ");

                                    depoimentoEgresso = scan.nextLine();
                                }
                            }
                            //apagar
                            else {
                                System.out.println(" ");
                                System.out.println("-apagar egresso-");
                                System.out.println(" ");
                                System.out.println("egresso excluído");
                                System.out.println(" ");
                                Coordenador.listaEgressos.remove(Coordenador.listaEgressos.get(x));
                            }
                        //egresso NAO encontrado
                        }else {
                            System.out.println(" ");
                            System.out.println("egresso não encontrado");
                            System.out.println(" ");
                        }
                    }
                }
            }
        }else{        //se NAO tiver coord cadastrado
            System.out.println("nenhum egresso cadastrado");
        }
    }



    public void ConsultarEgresso(){
        Scanner scan = new Scanner(System.in);
        String resposta;


        //se tiver egresso cadastrado
        if (!(Coordenador.listaEgressos.isEmpty())){

            //buscar
            System.out.println("Selecione a forma de busca");
            System.out.println("1 - nome");
            System.out.println("2 - cpf");

            resposta = scan.nextLine();
            if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2"))) {
                do {
                    System.out.println("Comando inválido, digite '1' ou '2' para escolher a opção: ");
                    resposta = scan.nextLine();
                } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2")));
            }

            //buscar por nome
            if (Objects.equals(resposta, "1")) {

                //print lista de nomes

                for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                    if (Objects.equals(Coordenador.listaEgressos.get(x).coordEgresso, Coordenador.coordLogado)) {
                        System.out.println(Coordenador.listaEgressos.get(x).getNomeEgresso());
                    }
                }

                //digitar nome para buscar
                System.out.println("nome do egresso: ");
                nomeEgresso = scan.nextLine();

                //buscar no array
                for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                    if (Objects.equals(Coordenador.listaEgressos.get(x).coordEgresso, Coordenador.coordLogado)) {

                        //egresso encontrado
                        if (Coordenador.listaEgressos.get(x).getNomeEgresso().equals(nomeEgresso)) {
                            System.out.println(" ");
                            System.out.println("egresso encontrado");
                            System.out.println(" ");
                            System.out.println(Coordenador.listaEgressos.get(x));

                            //egresso NAO encontrado
                        } else {
                            System.out.println(" ");
                            System.out.println("egresso não encontrado");
                            System.out.println(" ");
                        }
                    }
                }
            //buscar por cpf
            }else{

                //print lista de cpf
                System.out.println("lista de egressos: ");

                for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                    if (Objects.equals(Coordenador.listaEgressos.get(x).coordEgresso, Coordenador.coordLogado)) {
                        System.out.println(Coordenador.listaEgressos.get(x).getCpf());
                    }
                }

                //digitar cpf para buscar
                System.out.println("cpf do egresso: ");
                while (scan.hasNext()) scan.next();
                cpf = scan.nextLine();

                //buscar no array
                for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                    if (Objects.equals(Coordenador.listaEgressos.get(x).coordEgresso, Coordenador.coordLogado)) {

                        //egresso encontrado
                        if (Objects.equals(Coordenador.listaEgressos.get(x).getCpf(), cpf)) {
                            System.out.println(" ");
                            System.out.println("egresso encontrado");
                            System.out.println(" ");
                            System.out.println(Coordenador.listaEgressos.get(x));

                        } else {
                            System.out.println(" ");
                            System.out.println("egresso não encontrado");
                            System.out.println(" ");
                        }
                    }
                }
            }
        }else{        //se NAO tiver coord cadastrado
            System.out.println("nenhum egresso cadastrado");
        }
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(String formacoes) {
        this.formacoes = formacoes;
    }

    public String getNomeEgresso() {
        return nomeEgresso;
    }

    public void setNomeEgresso(String nomeEgresso) {
        this.nomeEgresso = nomeEgresso;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public static ArrayList<Cursos> getListaCursos() {
        return listaCursos;
    }

    public static void setListaCursos(ArrayList<Cursos> listaCursos) {
        Egressos.listaCursos = listaCursos;
    }

    public static ArrayList<Ocupacoes> getListaOcupa() {
        return listaOcupa;
    }

    public static void setListaOcupa(ArrayList<Ocupacoes> listaOcupa) {
        Egressos.listaOcupa = listaOcupa;
    }

    public String getDepoimentoEgresso() {
        return depoimentoEgresso;
    }

    public void setDepoimentoEgresso(String depoimentoEgresso) {
        this.depoimentoEgresso = depoimentoEgresso;
    }

    @Override
    public String toString() {
        return "Nome: " + nomeEgresso +
                " CPF: " + cpf +
                " Formações: " + formacoes +
                " Data de conclusão: " + dataConclusao +
                " Lista de cursos: " + listaCursos +
                " Lista de ocupações: " + listaOcupa +
                " Depoimento: " + depoimentoEgresso;
    }
}
