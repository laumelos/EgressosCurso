import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Coordenador extends Login implements IUsuario{


    public static String coordLogado;
    static ArrayList<Cursos> listaCursos = new ArrayList<Cursos>();
    static ArrayList<Egressos> listaEgressos = new ArrayList<Egressos>();

    /*
    public void CriarCoordenador(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Nome: ");
        nome = scan.nextLine();

        System.out.println("senha: ");
        senha = scan.nextLine();
    }*/
    @Override
    public void Entrar() {
        this.FazerLogin();
    }

    public String getNomeCoordenador() {
        return nome;
    }

    public void setNomeCoordenador(String nomeCoordenador) {
        this.nome = nomeCoordenador;
    }

    public String getSenhaCoordenador() {
        return senha;
    }

    public void setSenhaCoordenador(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return  "Nome coordenador: " + nome +
                " Senha: " + senha;
    }
}