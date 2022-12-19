import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Cursos {
    private String tipoCurso;
    private String nomeCurso;
    private String instituicao;



    public void CriarCurso(){
        Scanner scan = new Scanner(System.in);
        String resposta;

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

        Cursos curso = new Cursos();
        Coordenador.listaCursos.add(curso);
        System.out.println("-adicionado-");
        System.out.println("Você tem " + Coordenador.listaCursos.size() + " curso(s) cadastrados");

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





