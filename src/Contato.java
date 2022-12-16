import java.util.Objects;
import java.util.Scanner;

public class Contato {
    protected static int telefone;
    protected static String email;
    protected static String redeSocial;

    public static void CriarContato() {

        Scanner scan = new Scanner(System.in);

        boolean maisContato = true;
        String resposta;



        System.out.println("Tipo de contato a ser adicionado: ");
        System.out.println("1 - telefone");
        System.out.println("2 - email");
        System.out.println("3 - rede social");

        resposta = scan.nextLine();
        if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3"))){
            do {
                System.out.println("Comando inválido, digite '1', '2' ou '3' para escolher a opção: ");
                resposta = scan.nextLine();
            }while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3")));
        }


        if (Objects.equals(resposta, "1")) {
            System.out.println("telefone: ");
            telefone = scan.nextInt();
            System.out.println("-cadastrado-");

        } else if (Objects.equals(resposta, "2")) {
            System.out.println("email: ");
            email = scan.nextLine();
            System.out.println("-cadastrado-");

        } else if (Objects.equals(resposta, "3")) {
            System.out.println("rede social: ");
            redeSocial = scan.nextLine();
            System.out.println("-cadastrado-");

        } else {
            System.out.println("número inválido");
        }


        do {
            System.out.println("adicionar outro contato do egresso? (s/n): ");
            while (scan.hasNextInt()) scan.next();
            resposta = scan.nextLine();
            if (Objects.equals(resposta, "n")){
                maisContato = false;
            }
            else{
                System.out.println("Tipo de contato a ser adicionado: ");
                System.out.println("1 - telefone");
                System.out.println("2 - email");
                System.out.println("3 - rede social");

                resposta = scan.nextLine();
                if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3"))){
                    do {
                        System.out.println("Comando inválido, digite '1', '2' ou '3' para escolher a opção: ");
                        resposta = scan.nextLine();
                    }while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3")));
                }


                if (Objects.equals(resposta, "1")) {
                    System.out.println("telefone: ");
                    telefone = scan.nextInt();
                    System.out.println("-cadastrado-");

                } else if (Objects.equals(resposta, "2")) {
                    System.out.println("email: ");
                    email = scan.nextLine();
                    System.out.println("-cadastrado-");

                } else if (Objects.equals(resposta, "3")) {
                    System.out.println("rede social: ");
                    redeSocial = scan.nextLine();
                    System.out.println("-cadastrado-");

                } else {
                    System.out.println("número inválido");
                }
            }
        }while (maisContato);
    }
}
