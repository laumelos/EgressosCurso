import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Coordenador {
    public static String nomeCoordenador;
    public static String senha;
    static ArrayList<Cursos> listaCursos = new ArrayList<Cursos>();
    static ArrayList<Egressos> listaEgressos = new ArrayList<Egressos>();


    public static void CriarCoordenador(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Nome: ");
        nomeCoordenador = scan.nextLine();

        System.out.println("senha: ");
        senha = scan.nextLine();
    }



}