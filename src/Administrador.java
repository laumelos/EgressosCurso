import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Administrador extends Login implements IUsuario{
    public String testeNomeAdm = "ADM";
    public String testeSenhaAdm = "123";
    public static boolean verificarAdm = true;

    static ArrayList<Coordenador> listaCoord = new ArrayList<Coordenador>();


    //static ArrayList<Coordenador> listaCoordenadores = new ArrayList<Coordenador>();
    @Override
    public void Entrar(){

        this.FazerLogin();

        /*
        System.out.println("Nome: ");
        testeNomeAdm = scan.nextLine();

        System.out.println("senha: ");
        testeSenhaAdm = scan.nextLine();
        */

        if (Objects.equals(testeNomeAdm, nome) && (Objects.equals(testeSenhaAdm, senha))){
            verificarAdm = true;
        }
        else{
            verificarAdm = false;
        }
    }
}
