import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Administrador {
    public String nomeAdm = "ADM";
    public String senhaAdm = "123";
    public String testeNomeAdm = "ADM";
    public String testeSenhaAdm = "123";
    public static boolean verificarAdm = true;

    //static ArrayList<Coordenador> listaCoordenadores = new ArrayList<Coordenador>();

    public void VerificarAdm(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Nome: ");
        testeNomeAdm = scan.nextLine();

        System.out.println("senha: ");
        testeSenhaAdm = scan.nextLine();

        if (Objects.equals(testeNomeAdm, nomeAdm) && (Objects.equals(testeSenhaAdm, senhaAdm))){
            verificarAdm = true;
        }
        else{
            verificarAdm = false;
        }
    }
}
