import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Administrador extends Login{
    public String testeNomeAdm = "ADM";
    public String testeSenhaAdm = "123";
    public static boolean verificarAdm = true;

    //static ArrayList<Coordenador> listaCoordenadores = new ArrayList<Coordenador>();

    public void VerificarAdm(){

        this.FazerLogin();

        /*
        System.out.println("Nome: ");
        testeNomeAdm = scan.nextLine();

        System.out.println("senha: ");
        testeSenhaAdm = scan.nextLine();
        */

        if (Objects.equals(testeNomeAdm, nome) && (Objects.equals(testeSenhaAdm, nome))){
            verificarAdm = true;
        }
        else{
            verificarAdm = false;
        }
    }
}
