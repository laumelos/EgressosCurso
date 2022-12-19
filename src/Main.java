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

                Coordenador criarCoordenador = new Coordenador();
                criarCoordenador.CriarCoordenador();

                if (resposta.equals("1")) {

                    //checar se coord está cadastrado
                    for (Coordenador coordenador:listaCoord){
                        if (Objects.equals(coordenador.getNomeCoordenador(), criarCoordenador.nomeCoordenador)){
                            System.out.println("-login realizado-");
                            listaCoord.add(coordenador);

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
                                    Cursos criarCurso = new Cursos();
                                    criarCurso.CriarCurso();

                                } else if (Objects.equals(resposta, "2")) {

                                    System.out.println("-gerenciar curso-");
                                    Cursos gerenciarCurso = new Cursos();
                                    gerenciarCurso.GerenciarCurso();


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
                        }
                        else if (listaCoord.size() == 0){
                            System.out.println("-falha no login, nenhum coordenador cadastrado-");
                        }
                        else{
                            System.out.println("-falha no login, coordenador não cadastrado-");

                        }
                    }
                }


            } else if (Objects.equals(resposta, "2")) {
                System.out.println("-login administrador-");

                //verificar adm
                Administrador verificarAdm = new Administrador();
                verificarAdm.VerificarAdm();

                if (Administrador.verificarAdm == true){
                    System.out.println("-login realizado-");

                    //criar coordenador
                    Coordenador criarCoordenador = new Coordenador();
                    criarCoordenador.CriarCoordenador();

                    Coordenador coordenador = new Coordenador();
                    listaCoord.add(coordenador);
                    System.out.println("-adicionado-");
                    System.out.println("A lista tem " + listaCoord.size() + " coordenadores cadastrados");
                }else{
                    System.out.println("-nome ou senha incorretos-");
                }


            } else {
                System.out.println("-saindo do programa!-");
                sistemaEgressos = false;
            }
        }
    }
}