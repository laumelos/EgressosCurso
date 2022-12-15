import java.util.Scanner;

public class Contato {
    int telefone;
    String email;
    String redeSocial;

    public Contato(int telefone, String email, String redeSocial) {
        this.telefone = telefone;
        this.email = email;
        this.redeSocial = redeSocial;
    }

    public void CriarContato() {

        Scanner scan = new Scanner(System.in);

        boolean maisContato = true;
        boolean numeroInvalido = false;
        String resposta;

        while (!numeroInvalido) {

            System.out.println("Tipo de contato a ser adicionado: ");
            System.out.println("1 - telefone");
            System.out.println("2 - email");
            System.out.println("3 - rede social");

            while (scan.hasNextInt()) scan.next();
            resposta = scan.nextLine();

            if (resposta == "1") {
                System.out.println("telefone: ");
                while (scan.hasNextInt()) scan.next();
                this.telefone = scan.nextInt();
            } else if (resposta == "2") {
                System.out.println("email: ");
                while (scan.hasNextInt()) scan.next();
                this.email = scan.nextLine();
            } else if (resposta == "3") {
                System.out.println("rede social: ");
                while (scan.hasNextInt()) scan.next();
                this.redeSocial = scan.nextLine();
            } else {
                System.out.println("número inválido");
                numeroInvalido = true;
            }

        }

        while (maisContato) {
            System.out.println("adicionar outro contato do egresso? (s/n): ");
            while (scan.hasNextInt()) scan.next();
            resposta = scan.nextLine();
            if (resposta == "n"){
                maisContato = false;
            }
            else{
                numeroInvalido = false;

                while (!numeroInvalido) {

                    System.out.println("Tipo de contato a ser adicionado: ");
                    System.out.println("1 - telefone");
                    System.out.println("2 - email");
                    System.out.println("3 - rede social");

                    while (scan.hasNextInt()) scan.next();
                    resposta = scan.nextLine();

                    if (resposta == "1") {
                        System.out.println("telefone: ");
                        while (scan.hasNextInt()) scan.next();
                        this.telefone = scan.nextInt();
                    } else if (resposta == "2") {
                        System.out.println("email: ");
                        while (scan.hasNextInt()) scan.next();
                        this.email = scan.nextLine();
                    } else if (resposta == "3") {
                        System.out.println("rede social: ");
                        while (scan.hasNextInt()) scan.next();
                        this.redeSocial = scan.nextLine();
                    } else {
                        System.out.println("número inválido");
                        numeroInvalido = true;
                    }
                }
            }
        }
    }
}
