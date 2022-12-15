import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Coordenador {
    public static String nomeCoordenador;
    public static String senha;

    //ArrayList<String> cursos;
    //ArrayList <String> egressos;

    public void CriarCoordenador(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nome: ");
        nomeCoordenador = scan.nextLine();

        System.out.println("senha: ");
        senha = scan.nextLine();

    }
}