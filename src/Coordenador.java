import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Coordenador extends Login{

    static ArrayList<Cursos> listaCursos = new ArrayList<Cursos>();
    static ArrayList<Egressos> listaEgressos = new ArrayList<Egressos>();

    public void CriarCoordenador() {
        this.FazerLogin();
    }


    /*
    public void CriarCoordenador(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Nome: ");
        nome = scan.nextLine();

        System.out.println("senha: ");
        senha = scan.nextLine();
    }*/

    public String getNomeCoordenador() {
        return nome;
    }

    public void setNomeCoordenador(String nomeCoordenador) {
        this.nome = nomeCoordenador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "nomeCoordenador='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}