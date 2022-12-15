import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Coordenador {
    public static String nomeCoordenador;
    public static String senha;

    static ArrayList<Cursos> listaCursos = new ArrayList<Cursos>();

    //ArrayList <String> egressos;

    public static void CriarCoordenador(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Nome: ");
        nomeCoordenador = scan.nextLine();

        System.out.println("senha: ");
        senha = scan.nextLine();
    }

    public static void CriarCurso(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Nome do curso: ");
        Cursos.nomeCurso = scan.nextLine();
        Cursos curso = new Cursos();
        listaCursos.add(curso);
        System.out.println("-adicionado-");
        System.out.println("A lista tem " + listaCursos.size() + " cursos");
    }

    public static void GerenciarCurso(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Cursos: ");
        System.out.println(listaCursos);
        System.out.println("Que curso você deseja gerenciar?: ");
        Cursos.nomeCurso = scan.nextLine();

        //TODO
        System.out.println("TODO (editar nome/ apagar curso");

        System.out.println("A lista tem " + listaCursos.size() + " cursos");
    }

}