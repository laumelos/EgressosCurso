import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Coordenador {
    public String nomeCoordenador;
    public String senha;
    static ArrayList<Cursos> listaCursos = new ArrayList<Cursos>();
    static ArrayList<Egressos> listaEgressos = new ArrayList<Egressos>();


    public void CriarCoordenador(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Nome: ");
        nomeCoordenador = scan.nextLine();

        System.out.println("senha: ");
        senha = scan.nextLine();
    }

    public String getNomeCoordenador() {
        return nomeCoordenador;
    }

    public void setNomeCoordenador(String nomeCoordenador) {
        this.nomeCoordenador = nomeCoordenador;
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
                "nomeCoordenador='" + nomeCoordenador + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}