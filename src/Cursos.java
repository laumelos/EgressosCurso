import java.util.ArrayList;
import java.util.Scanner;

public class Cursos {
    static String nomeCurso;

    public static void CriarCurso(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Nome do curso: ");
        Cursos.nomeCurso = scan.nextLine();
        Cursos curso = new Cursos();
        Coordenador.listaCursos.add(curso);
        System.out.println("-adicionado-");
        System.out.println("A lista tem " + Coordenador.listaCursos.size() + " cursos");
    }

    public static void GerenciarCurso(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Cursos: ");
        System.out.println(Coordenador.listaCursos);
        System.out.println("Que curso você deseja gerenciar?: ");
        Cursos.nomeCurso = scan.nextLine();

        //TODO
        System.out.println("TODO (editar nome/ apagar curso");

        System.out.println("A lista tem " + Coordenador.listaCursos.size() + " cursos");
    }
}

