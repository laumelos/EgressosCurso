import java.util.Scanner;

public class Login {
    public String nome;
    public String senha;

    public void FazerLogin() {
        Scanner scan = new Scanner(System.in);

        System.out.println("nome: ");
        nome = scan.nextLine();

        System.out.println("senha: ");
        senha = scan.nextLine();
    }
}