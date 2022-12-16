import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean sistemaEgressos = true;
        Scanner scan = new Scanner (System.in);
        String resposta;

        ArrayList<Coordenador> listaCoord = new ArrayList<Coordenador>();


        while(sistemaEgressos) {
            System.out.println("Bem-vindo ao sistema de egressos do curso!");
            System.out.println("Como você deseja realizar o seu login?");
            System.out.println("1 - coordenador");
            System.out.println("2 - administrador");
            System.out.println("qualquer outra coisa - sair do programa");

            resposta = scan.nextLine();

            if (Objects.equals(resposta, "1")) {
                //login
                System.out.println("-login coordenador-");
                System.out.println("1 - entrar");
                System.out.println("2 - criar cadastro");
                resposta = scan.nextLine();

                //número inválido
                if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2"))) {
                    do {
                        System.out.println("Comando inválido, digite '1' ou '2' para escolher a opção: ");
                        System.out.println("1 - entrar");
                        System.out.println("2 - criar cadastro");
                        resposta = scan.nextLine();

                    } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2")));
                }

                Coordenador.CriarCoordenador();

                if (resposta.equals("1")) {
                    System.out.println("checar se existe");
                    //TODO
                }
                else{
                    Coordenador coordenador = new Coordenador();
                    listaCoord.add(coordenador);
                    System.out.println("-adicionado-");
                    System.out.println("A lista tem " + listaCoord.size() + " coordenadores");
                }

                boolean operacaoCoord = true;
                do {
                    //opções coordenador
                    System.out.println("Digite a operação que você deseja realizar");
                    System.out.println("1 - criar curso");
                    System.out.println("2 - gerenciar curso");
                    System.out.println("3 - cadastrar egresso");
                    System.out.println("4 - editar egresso");
                    System.out.println("5 - consultar egresso");
                    System.out.println("6 - logoff");

                    //scan
                    resposta = scan.nextLine();

                    //número inválido
                    if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6"))) {
                        do {
                            System.out.println("Comando inválido, igite '1' '2' '3' '4' '5' ou '6' para escolher a opção: ");
                            System.out.println("1 - criar curso");
                            System.out.println("2 - gerenciar curso");
                            System.out.println("3 - cadastrar egresso");
                            System.out.println("4 - editar egresso");
                            System.out.println("5 - consultar egresso");
                            System.out.println("6 - logoff");
                            resposta = scan.nextLine();

                        } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6")));
                    }

                    if (Objects.equals(resposta, "1")) {

                        System.out.println("-criar curso-");
                        Cursos.CriarCurso();

                    } else if (Objects.equals(resposta, "2")) {

                        System.out.println("-gerenciar curso-");
                        Cursos.GerenciarCurso();


                    } else if (Objects.equals(resposta, "3")) {

                        System.out.println("-cadastrar egresso-");
                        Egressos.CriarEgresso();

                    } else if (Objects.equals(resposta, "4")) {

                        System.out.println("-editar egresso-");

                    } else if (Objects.equals(resposta, "5")) {

                        System.out.println("-consultar egresso-");

                    } else {

                        System.out.println("-logoff-");

                    }
                }while (!(Objects.equals(resposta, "6")));

            } else if (Objects.equals(resposta, "2")) {
                System.out.println("-login administrador-");


            } else {
                System.out.println("-saindo do programa!-");
                sistemaEgressos = false;
            }
        }
    }
}