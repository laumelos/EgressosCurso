import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean sistemaEgressos = true;
        boolean numeroInvalido = false;

        while(sistemaEgressos){
            System.out.println("Bem-vindo ao sistema de egressos do curso!");
            System.out.println("Como você deseja realizar o seu login?");
            System.out.println("1 - coordenador");
            System.out.println("2 - administrador");
            System.out.println("qualquer outra coisa - sair do programa");

            Scanner scan = new Scanner (System.in);
            String resposta = scan.nextLine();

            if (Objects.equals(resposta, "1")) {

                //login
                System.out.println("-login coordenador-");
                System.out.println("nome: ");
                while (scan.hasNextInt()) scan.next();
                Coordenador.nome = scan.nextLine();
                System.out.println("senha: ");
                while (scan.hasNextInt()) scan.next();
                Coordenador.senha = scan.nextLine();

                while (!numeroInvalido) {

                    System.out.println("Digite a operação que você deseja realizar");
                    System.out.println("1 - criar curso");
                    System.out.println("2 - gerenciar curso");
                    System.out.println("3 - cadastrar egresso");
                    System.out.println("4 - editar egresso");
                    System.out.println("5 - consultar egresso");
                    System.out.println("6 - logoff");

                    while (scan.hasNextInt()) scan.next();
                    resposta = scan.nextLine();

                    if (Objects.equals(resposta, "1")) {

                        System.out.println("-criar curso-");

                    } else if (Objects.equals(resposta, "2")) {

                        System.out.println("-gerenciar curso-");


                    } else if (Objects.equals(resposta, "3")) {

                        System.out.println("-cadastrar egresso-");

                    } else if (Objects.equals(resposta, "4")) {

                        System.out.println("-editar egresso-");

                    } else if (Objects.equals(resposta, "5")) {

                        System.out.println("-consultar egresso-");

                    } else if (Objects.equals(resposta, "6")) {

                        System.out.println("-logoff-");

                    } else {
                        System.out.println("número inválido");
                        numeroInvalido = true;
                    }

                }

            } else if (Objects.equals(resposta, "2")) {
                System.out.println("-login administrador-");



            } else {
                System.out.println("-saindo do programa!-");
                sistemaEgressos = false;
            }
        }
    }
}