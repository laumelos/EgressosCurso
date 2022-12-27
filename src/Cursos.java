import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Cursos {
    public String tipoCurso;
    public String nomeCurso;
    public String instituicao;
    public String depoimentoCurso;
    public static ArrayList <Egressos> listaEgressosCurso = new ArrayList<Egressos>();


    public void CriarCurso(){
        Scanner scan = new Scanner(System.in);
        String resposta;
        boolean respostaMaisCurso = true;


        System.out.println("Escolha o tipo do curso: ");
        System.out.println("1 - curso Complementar");
        System.out.println("2 - Especialização");
        System.out.println("3 - Graduação");
        System.out.println("4 - Pós-graduação");

        this.tipoCurso = scan.nextLine();

        //número inválido
        if (!(Objects.equals(tipoCurso, "1") || Objects.equals(tipoCurso, "2") || Objects.equals(tipoCurso, "3") || Objects.equals(tipoCurso, "4"))) {
            do {
                System.out.println("Comando inválido, igite '1' '2' '3' ou '4' para escolher a opção: ");
                System.out.println("1 - curso Complementar");
                System.out.println("2 - Especialização");
                System.out.println("3 - Graduação");
                System.out.println("4 - Pós-graduação");

                tipoCurso = scan.nextLine();

            } while (!(Objects.equals(tipoCurso, "1") || Objects.equals(tipoCurso, "2") || Objects.equals(tipoCurso, "3") || Objects.equals(tipoCurso, "4")));
        }

        System.out.println("Nome do curso: ");
        nomeCurso = scan.nextLine();

        System.out.println("Instituição: ");
        instituicao = scan.nextLine();

        System.out.println("Adicionar depoimento?");
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
            depoimentoCurso = scan.nextLine();
        }



/*
        do {
            System.out.println("adicionar outro curso?");
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

                System.out.println("Escolha o tipo do curso: ");
                System.out.println("1 - curso Complementar");
                System.out.println("2 - Especialização");
                System.out.println("3 - Graduação");
                System.out.println("4 - Pós-graduação");

                this.tipoCurso = scan.nextLine();

                //número inválido
                if (!(Objects.equals(tipoCurso, "1") || Objects.equals(tipoCurso, "2") || Objects.equals(tipoCurso, "3") || Objects.equals(tipoCurso, "4"))) {
                    do {
                        System.out.println("Comando inválido, digite '1' '2' '3' ou '4' para escolher a opção: ");
                        System.out.println("1 - curso Complementar");
                        System.out.println("2 - Especialização");
                        System.out.println("3 - Graduação");
                        System.out.println("4 - Pós-graduação");

                        tipoCurso = scan.nextLine();

                    } while (!(Objects.equals(tipoCurso, "1") || Objects.equals(tipoCurso, "2") || Objects.equals(tipoCurso, "3") || Objects.equals(tipoCurso, "4")));
                }

                System.out.println("Nome do curso: ");
                nomeCurso = scan.nextLine();

                System.out.println("Instituição: ");
                instituicao = scan.nextLine();

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
                    System.out.println("depoimento: ");
                    depoimentoCurso = scan.nextLine();
                }


                criarCurso = new Cursos();
                criarCurso.CriarCurso();

                Coordenador.listaCursos.add(criarCurso);

 */
    }
        //}while(respostaMaisCurso);

    public void GerenciarCurso(){
        Scanner scan = new Scanner(System.in);
        String resposta;

        if (!(Coordenador.listaCursos.isEmpty())) {

            System.out.println("lista de cursos:");
            System.out.println(" ");
            //System.out.println(Egressos.listaCursos);

            for (int x = 0; x < Egressos.listaCursos.size(); x++) {
                System.out.println(x + " - " + Egressos.listaCursos.get(x));
            }

            System.out.println("Selecione o curso que deseja editar: ");

            resposta = scan.nextLine();


            if (Integer.parseInt(resposta) >= Egressos.listaCursos.size()) {
                do {
                    System.out.println("Comando inválido, digite o número referente a um curso para escolher a opção: ");
                    resposta = scan.nextLine();
                } while (Integer.parseInt(resposta) > Egressos.listaCursos.size());
            }

            System.out.println(" -Selecionado- ");
            System.out.println(Egressos.listaCursos.get(Integer.parseInt(resposta)));


            System.out.println("Selecione que informação deseja editar");
            System.out.println("1 - tipo do curso");
            System.out.println("2 - nome do curso");
            System.out.println("3 - instituicao");
            System.out.println("4 - depoimento");
            resposta = scan.nextLine();


            if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4"))) {
                do {
                    System.out.println("Selecione que informação deseja editar");
                    System.out.println("1 - tipo do curso");
                    System.out.println("2 - nome do curso");
                    System.out.println("3 - instituição");
                    System.out.println("4 - depoimento");
                    resposta = scan.nextLine();

                } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4")));
            }
            if (Objects.equals(resposta, "1")) {

                System.out.println("-editar tipo do curso-");
                System.out.println("escolha o novo tipo do curso: ");
                System.out.println("1 - curso Complementar");
                System.out.println("2 - Especialização");
                System.out.println("3 - Graduação");
                System.out.println("4 - Pós-graduação");

                String novotipoCurso = scan.nextLine();
                Egressos.listaCursos.get(Integer.parseInt(resposta)).setTipoCurso(novotipoCurso);

                //número inválido
                if (!(Objects.equals(novotipoCurso, "1") || Objects.equals(novotipoCurso, "2") || Objects.equals(novotipoCurso, "3") || Objects.equals(novotipoCurso, "4"))) {
                    do {
                        System.out.println("Comando inválido, digite '1' '2' '3' ou '4' para escolher a opção: ");
                        System.out.println("1 - curso Complementar");
                        System.out.println("2 - Especialização");
                        System.out.println("3 - Graduação");
                        System.out.println("4 - Pós-graduação");

                        novotipoCurso = scan.nextLine();
                        Egressos.listaCursos.get(Integer.parseInt(resposta)).setTipoCurso(novotipoCurso);

                    } while (!(Objects.equals(novotipoCurso, "1") || Objects.equals(novotipoCurso, "2") || Objects.equals(novotipoCurso, "3") || Objects.equals(novotipoCurso, "4")));
                }
            }

            if (Objects.equals(resposta, "2")) {

                System.out.println("-editar nome do curso-");
                System.out.println("digite o novo nome do curso: ");

                String novoNomeCurso = scan.nextLine();
                Egressos.listaCursos.get(Integer.parseInt(resposta)).setNomeCurso(novoNomeCurso);
            }

            if (Objects.equals(resposta, "3")) {

                System.out.println("-editar instituição-");
                System.out.println("digite a nova instituição: ");

                String novaInstituicao = scan.nextLine();
                Egressos.listaCursos.get(Integer.parseInt(resposta)).setInstituicao(novaInstituicao);
            }


            if (Objects.equals(resposta, "4")) {

                System.out.println("-editar depoimento-");
                System.out.println("digite o novo depoimento: ");

                depoimentoCurso = scan.nextLine();

                String novoDepoimentoCurso = scan.nextLine();
                Egressos.listaCursos.get(Integer.parseInt(resposta)).setDepoimentoCurso(novoDepoimentoCurso);
            }

            System.out.println("-edição realizada-");
            System.out.println(Egressos.listaCursos);
        }else{
            System.out.println("nenhum curso cadastrado");
        }
    }


    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getDepoimentoCurso() {
        return depoimentoCurso;
    }

    public void setDepoimentoCurso(String depoimentoCurso) {
        this.depoimentoCurso = depoimentoCurso;
    }

    public static ArrayList<Egressos> getListaEgressosCurso() {
        return listaEgressosCurso;
    }

    public static void setListaEgressosCurso(ArrayList<Egressos> listaEgressosCurso) {
        Cursos.listaEgressosCurso = listaEgressosCurso;
    }

    @Override
    public String toString() {
        return "Cursos{" +
                "tipoCurso='" + tipoCurso + '\'' +
                ", nomeCurso='" + nomeCurso + '\'' +
                ", instituicao='" + instituicao + '\'' +
                ", depoimentoCurso='" + depoimentoCurso + '\'' +
                '}';
    }
}





