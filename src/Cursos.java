import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Cursos {
    public String tipoCurso;
    public String nomeCurso;
    public String instituicao;
    public String depoimentoCurso;


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


        Cursos curso = new Cursos();
        Coordenador.listaCursos.add(curso);
        System.out.println("-adicionado-");
        System.out.println("Você tem " + Coordenador.listaCursos.size() + " curso(s) cadastrados");



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

                Coordenador.listaCursos.add(curso);
                System.out.println("-adicionado-");
                System.out.println("Você tem " + Coordenador.listaCursos.size() + " curso(s) cadastrados");


            }
        }while(respostaMaisCurso);
    }


    public void GerenciarCurso(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Cursos: ");
        System.out.println(Coordenador.listaCursos);
        System.out.println("Que curso você deseja gerenciar?: ");
        this.nomeCurso = scan.nextLine();

        //TODO
        System.out.println("TODO (editar nome/ apagar curso");

        System.out.println("A lista tem " + Coordenador.listaCursos.size() + " cursos");
    }


}





