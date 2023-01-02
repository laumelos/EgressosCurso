import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Cursos {
    public String tipoCurso;
    public String nomeCurso;
    public String instituicao;
    public String depoimentoCurso;
    public String coordCurso;
    public static ArrayList <Egressos> listaEgressosCurso = new ArrayList<Egressos>();


    public void CriarCurso() throws IOException {
        Scanner scan = new Scanner(System.in);
        String resposta;
        boolean respostaMaisCurso = true;

        coordCurso = Coordenador.coordLogado;
/*
        System.out.println("Escolha o tipo do curso: ");
        System.out.println("1 - curso Complementar");
        System.out.println("2 - Especialização");
        System.out.println("3 - Graduação");
        System.out.println("4 - Pós-graduação");

        resposta = scan.nextLine();

        //número inválido
        if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4"))) {
            do {
                System.out.println("Comando inválido, digite '1' '2' '3' ou '4' para escolher a opção: ");
                System.out.println("1 - Curso Complementar");
                System.out.println("2 - Especialização");
                System.out.println("3 - Graduação");
                System.out.println("4 - Pós-graduação");

                tipoCurso = scan.nextLine();

            } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4")));
        }

        if (Objects.equals(resposta, "1")){
            this.tipoCurso = "Curso Complementar";
        }else if (Objects.equals(resposta, "2")){
            this.tipoCurso = "Especialização";
        }else if (Objects.equals(resposta, "3")){
            this.tipoCurso = "Graduação";
        }else{
            this.tipoCurso = "Pós-graduação";
        }

 */

        System.out.println("nome do curso: ");
        nomeCurso = scan.nextLine();


        System.out.println("instituição: ");
        instituicao = scan.nextLine();
/*
        System.out.println("adicionar depoimento?");
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

 */

    }

    public void GerenciarCurso() throws IOException {

        OutputStream cursosEditados = new FileOutputStream("cursosEditados.txt"); // nome do arquivo que será escrito
        Writer wrCursosEditados = new OutputStreamWriter(cursosEditados); // criação de um escritor
        BufferedWriter brCursosEditados = new BufferedWriter(wrCursosEditados); // adiciono a um escritor de buffer
        brCursosEditados.write("CURSOS EDITADOS:");//nome do arquivo txt

        Scanner scan = new Scanner(System.in);
        String resposta;
        int respostaCurso;

        if (!(Coordenador.listaCursos.isEmpty())) {

            System.out.println("lista de cursos:");

            for (int x = 0; x < Coordenador.listaCursos.size(); x++) {
                if (Objects.equals(Coordenador.listaCursos.get(x).coordCurso, Coordenador.coordLogado)) {
                    System.out.println(Coordenador.listaCursos.get(x));
                }
            }

            //digitar nome para buscar
            System.out.println("nome do curso: ");
            nomeCurso = scan.nextLine();

            //buscar no array
            for (int x = 0; x < Coordenador.listaCursos.size(); x++) {
                if (Objects.equals(Coordenador.listaCursos.get(x).coordCurso, Coordenador.coordLogado)) {

                    //curso encontrado
                    if (Coordenador.listaCursos.get(x).getNomeCurso().equals(nomeCurso)) {
                        System.out.println(" ");
                        System.out.println("curso encontrado");
                        System.out.println(" ");

                        System.out.println(Coordenador.listaCursos.get(x));

                        System.out.println("Selecione que informação deseja editar");
                        System.out.println("1 - tipo do curso");
                        System.out.println("2 - nome do curso");
                        System.out.println("3 - instituicao");
                        System.out.println("4 - depoimento");
                        //resposta = scan.nextLine();
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

                            System.out.println(" ");
                            System.out.println("-editar tipo do curso-");
                            System.out.println(" ");

                            System.out.println("escolha o novo tipo do curso: ");
                            System.out.println("1 - curso Complementar");
                            System.out.println("2 - Especialização");
                            System.out.println("3 - Graduação");
                            System.out.println("4 - Pós-graduação");

                            resposta = scan.nextLine();
                            String novotipoCurso;


                            //número inválido
                            if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4"))) {
                                do {
                                    System.out.println("Comando inválido, digite '1' '2' '3' ou '4' para escolher a opção: ");
                                    System.out.println("1 - curso Complementar");
                                    System.out.println("2 - Especialização");
                                    System.out.println("3 - Graduação");
                                    System.out.println("4 - Pós-graduação");

                                    resposta = scan.nextLine();
                                    if (Objects.equals(resposta, "1")){
                                        novotipoCurso = "Curso Complementar";
                                    }else if (Objects.equals(resposta, "2")){
                                        novotipoCurso = "Especialização";
                                    }else if (Objects.equals(resposta, "3")){
                                        novotipoCurso = "Graduação";
                                    }else{
                                        novotipoCurso = "Pós-graduação";
                                    }
                                    Coordenador.listaCursos.get(x).setTipoCurso(novotipoCurso);
                                    brCursosEditados.newLine();
                                    brCursosEditados.write(novotipoCurso);
                                    brCursosEditados.close();

                                } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4")));
                            }
                        }

                        String novotipoCurso;
                        if (Objects.equals(resposta, "1")){
                            novotipoCurso = "Curso Complementar";
                        }else if (Objects.equals(resposta, "2")){
                            novotipoCurso = "Especialização";
                        }else if (Objects.equals(resposta, "3")){
                            novotipoCurso = "Graduação";
                        }else{
                            novotipoCurso = "Pós-graduação";
                        }
                        Coordenador.listaCursos.get(x).setTipoCurso(novotipoCurso);
                        brCursosEditados.newLine();
                        brCursosEditados.write(novotipoCurso);
                        brCursosEditados.close();
                        if (Objects.equals(resposta, "2")) {

                            System.out.println(" ");
                            System.out.println("-editar nome do curso-");
                            System.out.println(" ");

                            System.out.println("digite o novo nome do curso: ");

                            String novoNomeCurso = scan.nextLine();
                            Coordenador.listaCursos.get(x).setNomeCurso(novoNomeCurso);
                            brCursosEditados.newLine();
                            brCursosEditados.write(novoNomeCurso);
                        }
                        brCursosEditados.close();
                        if (Objects.equals(resposta, "3")) {

                            System.out.println(" ");
                            System.out.println("-editar instituição-");
                            System.out.println(" ");

                            System.out.println("digite a nova instituição: ");

                            String novaInstituicao = scan.nextLine();
                            Coordenador.listaCursos.get(x).setInstituicao(novaInstituicao);
                            brCursosEditados.newLine();
                            brCursosEditados.write(novaInstituicao);
                        }
                            brCursosEditados.close();

                        if (Objects.equals(resposta, "4")) {

                            System.out.println(" ");
                            System.out.println("-editar depoimento-");
                            System.out.println(" ");

                            System.out.println("digite o novo depoimento: ");

                            String novoDepoimentoCurso = scan.nextLine();
                            Coordenador.listaCursos.get(x).setDepoimentoCurso(novoDepoimentoCurso);
                            brCursosEditados.newLine();
                            brCursosEditados.write(novoDepoimentoCurso);
                        }
                        brCursosEditados.close();
                        System.out.println(" ");
                        System.out.println("edição realizada");
                        System.out.println(" ");

                        System.out.println(Coordenador.listaCursos);
                    }
                }
            }
        }else{
            System.out.println(" ");
            System.out.println("nenhum curso cadastrado");
            System.out.println(" ");
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
        return  "Nome do curso: " + nomeCurso +
                " Tipo do curso: " + tipoCurso +
                " Instituição='" + instituicao +
                " Depoimento do curso='" + depoimentoCurso;
    }
}





