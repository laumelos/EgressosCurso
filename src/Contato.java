import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Contato {
    public String telefone;
    public String email;
    public String redeSocial;
    ArrayList<String> listaContato = new ArrayList<String>();


    public void CriarContato() {

        Scanner scan = new Scanner(System.in);

        boolean respostaMaisContato = true;
        String resposta;

        System.out.println("Tipo de contato a ser adicionado: ");
        System.out.println("1 - telefone");
        System.out.println("2 - email");
        System.out.println("3 - rede social");

        resposta = scan.nextLine();
        if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3"))) {
            do {
                System.out.println("Comando inválido, digite '1', '2' ou '3' para escolher a opção: ");
                resposta = scan.nextLine();
            } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3")));
        }

        if (Objects.equals(resposta, "1")) {
            System.out.println("telefone: ");
            telefone = scan.nextLine();
            listaContato.add(telefone);

            System.out.println(" ");
            System.out.println("cadastrado");
            System.out.println(" ");


        } else if (Objects.equals(resposta, "2")) {
            System.out.println("email: ");
            email = scan.nextLine();
            listaContato.add(email);

            System.out.println(" ");
            System.out.println("cadastrado");
            System.out.println(" ");

        } else {
            System.out.println("rede social: ");
            redeSocial = scan.nextLine();
            listaContato.add(redeSocial);

            System.out.println(" ");
            System.out.println("cadastrado");
            System.out.println(" ");        }


        do {
            System.out.println("adicionar outro contato do egresso?");
            System.out.println("1 - sim");
            System.out.println("2 - não");

            resposta = scan.next();

            if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2"))) {
                do {
                    System.out.println("Comando inválido, digite '1' ou '2' para escolher a opção: ");
                    System.out.println("1 - sim");
                    System.out.println("2 - não");
                    resposta = scan.next();

                } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2")));
            }


            if (resposta.equals("2")) {
                respostaMaisContato = false;
            } else {
                System.out.println("Tipo de contato a ser adicionado: ");
                System.out.println("1 - telefone");
                System.out.println("2 - email");
                System.out.println("3 - rede social");

                resposta = scan.next();
                if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3"))) {
                    do {
                        System.out.println("Comando inválido, digite '1', '2' ou '3' para escolher a opção: ");
                        resposta = scan.next();
                    } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3")));
                }

                if (Objects.equals(resposta, "1")) {
                    System.out.println("telefone: ");
                    telefone = scan.nextLine();
                    listaContato.add(telefone);

                    System.out.println(" ");
                    System.out.println("cadastrado");
                    System.out.println(" ");

                } else if (Objects.equals(resposta, "2")) {
                    System.out.println("email: ");
                    email = scan.next();
                    listaContato.add(email);

                    System.out.println(" ");
                    System.out.println("cadastrado");
                    System.out.println(" ");

                } else {
                    System.out.println("rede social: ");
                    redeSocial = scan.next();
                    listaContato.add(redeSocial);

                    System.out.println(" ");
                    System.out.println("cadastrado");
                    System.out.println(" ");

                }
            }
        } while (respostaMaisContato);
    }

    public void EditarContato() {

        Scanner scan = new Scanner(System.in);
        String resposta;

        System.out.println("lista de contatos:");
        System.out.println(" ");
        System.out.println(listaContato);

        for (int x = 0; x < listaContato.size(); x++) {
            System.out.println(x + " - " + listaContato.get(x));
        }

        System.out.println("Selecione o contato que deseja editar: ");

        resposta = scan.nextLine();

        if (Integer.parseInt(resposta) > listaContato.size()) {
            do {
                System.out.println("Comando inválido, digite o número referente a um contato para escolher a opção: ");
                resposta = scan.nextLine();
            } while (Integer.parseInt(resposta) > listaContato.size());
        }
        System.out.println(" ");
        System.out.println("selecionado");
        System.out.println(" ");
        System.out.println(listaContato.get(Integer.parseInt(resposta)));
        String editarContato = scan.nextLine();
        listaContato.set(Integer.parseInt(resposta),editarContato);

        System.out.println(" ");
        System.out.println("edição realizada");
        System.out.println(" ");
        System.out.println(listaContato);
    }

    @Override
    public String toString() {

        return  "Telefone: " + telefone +
                " Email: " + email +
                " Redes sociais: " + redeSocial +
                " Lista de contato: " + listaContato;
    }
}