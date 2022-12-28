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
                System.out.println(" ");
                System.out.println("-login coordenador-");
                System.out.println(" ");

                if (!(listaCoord.isEmpty())) {


                    Coordenador criarCoordenador = new Coordenador();
                    criarCoordenador.CriarCoordenador();

                    if (resposta.equals("1")) {

                        //checar se coord está cadastrado
                        for (int x = 0; x < listaCoord.size(); x++) {

                            if (listaCoord.get(x).getNomeCoordenador().equals(criarCoordenador.getNomeCoordenador()) && (listaCoord.get(x).getSenhaCoordenador().equals(criarCoordenador.getSenhaCoordenador()))) {

                                System.out.println("x " + x);
                                System.out.println(" ");
                                System.out.println("login realizado");
                                System.out.println(" ");


                                boolean operacaoCoord = true;
                                do {
                                    //opções coordenador
                                    System.out.println("Selecione a operação que você deseja realizar");
                                    System.out.println("1 - criar curso");
                                    System.out.println("2 - gerenciar curso");
                                    System.out.println("3 - cadastrar egresso");
                                    System.out.println("4 - gerenciar egresso");
                                    System.out.println("5 - consultar egresso");
                                    System.out.println("6 - logoff");

                                    System.out.println("listaCoord "+listaCoord);

                                    System.out.println("coord x "+listaCoord.get(x));


                                    //scan
                                    resposta = scan.nextLine();

                                    //número inválido
                                    if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6"))) {
                                        do {
                                            System.out.println("Comando inválido, selecione '1' '2' '3' '4' '5' ou '6' para escolher a opção: ");
                                            System.out.println("1 - criar curso");
                                            System.out.println("2 - gerenciar curso");
                                            System.out.println("3 - cadastrar egresso");
                                            System.out.println("4 - gerenciar egresso");
                                            System.out.println("5 - consultar egresso");
                                            System.out.println("6 - logoff");
                                            resposta = scan.nextLine();

                                        } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6")));
                                    }

                                    if (Objects.equals(resposta, "1")) {

                                        System.out.println("-criar curso-");

                                        Cursos criarCurso = new Cursos();
                                        criarCurso.CriarCurso();
                                        System.out.println(" ");
                                        System.out.println("cadastrado");
                                        System.out.println(" ");

                                        //System.out.println("Você tem " + Coordenador.listaCursos.size() + " curso(s) cadastrados");

                                        if (Objects.equals(criarCurso.instituicao, "UFMA") || Objects.equals(criarCurso.instituicao, "Ufma") || Objects.equals(criarCurso.instituicao, "ufma")) {
                                            Coordenador.listaCursos.add(criarCurso);
                                            Egressos.listaCursos.add(criarCurso);
                                            //System.out.println("Coordenador" + Coordenador.listaCursos);

                                        } else {
                                            Egressos.listaCursos.add(criarCurso);
                                            //System.out.println("Egresso" + Egressos.listaCursos);
                                        }

                                        //add outro curso
                                        boolean respostaMaisCurso = true;

                                        do {
                                            System.out.println("Adicionar outro curso?");
                                            System.out.println("1 - sim");
                                            System.out.println("2 - não");
                                            resposta = scan.nextLine();

                                            if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2"))) {
                                                do {
                                                    System.out.println("Comando inválido, digite '1' ou '2' para escolher a opção: ");
                                                    resposta = scan.nextLine();
                                                } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2")));
                                            }
                                            if (Objects.equals(resposta, "1")) {
                                                System.out.println("-criar curso-");

                                                criarCurso = new Cursos();
                                                criarCurso.CriarCurso();
                                                System.out.println(" ");
                                                System.out.println("cadastrado");
                                                System.out.println(" ");
                                                //System.out.println("Você tem " + Coordenador.listaCursos.size() + " curso(s) cadastrados");

                                                if (Objects.equals(criarCurso.instituicao, "UFMA") || Objects.equals(criarCurso.instituicao, "Ufma") || Objects.equals(criarCurso.instituicao, "ufma")) {
                                                    System.out.println(criarCurso.nomeCurso);
                                                    System.out.println(criarCurso);
                                                    //Coordenador.listaCursos.add(criarCurso);
                                                    Coordenador.listaCursos.add(criarCurso);
                                                    Egressos.listaCursos.add(criarCurso);
                                                    //System.out.println("Coordenador" + Coordenador.listaCursos);

                                                } else {
                                                    Egressos.listaCursos.add(criarCurso);
                                                    //System.out.println("Egresso" + Egressos.listaCursos);
                                                }
                                            } else {
                                                respostaMaisCurso = false;
                                            }
                                        } while (respostaMaisCurso);


                                    } else if (Objects.equals(resposta, "2")) {

                                        System.out.println("-gerenciar curso-");
                                        Cursos gerenciarCurso = new Cursos();
                                        gerenciarCurso.GerenciarCurso();


                                    } else if (Objects.equals(resposta, "3")) {

                                        System.out.println("-cadastrar egresso-");
                                        Egressos criarEgresso = new Egressos();
                                        criarEgresso.CriarEgresso();
                                        System.out.println(criarEgresso);

                                        System.out.println(" ");
                                        System.out.println("cadastrado");
                                        System.out.println(" ");
                                        Coordenador.listaEgressos.add(criarEgresso);
                                        System.out.println("A lista tem " + Coordenador.listaEgressos.size() + " egressos");

                                        Cursos criarCurso = new Cursos();
                                        if (Objects.equals(criarCurso.instituicao, "UFMA") || Objects.equals(criarCurso.instituicao, "Ufma") || Objects.equals(criarCurso.instituicao, "ufma")) {
                                            System.out.println(criarEgresso.nomeEgresso);
                                            Cursos.listaEgressosCurso.add(criarEgresso);
                                            //System.out.println("listaEgressosCurso" + Cursos.listaEgressosCurso);
                                        }


                                    } else if (Objects.equals(resposta, "4")) {

                                        System.out.println("-gerenciar egresso-");
                                        Egressos gerenciarEgresso = new Egressos();
                                        gerenciarEgresso.GerenciarEgresso();

                                    } else if (Objects.equals(resposta, "5")) {

                                        System.out.println("-consultar egresso-");
                                        Egressos consultarEgresso = new Egressos();
                                        consultarEgresso.ConsultarEgresso();

                                    } else {

                                        System.out.println("-logoff-");

                                    }
                                } while (!(Objects.equals(resposta, "6")));
                            } else if (x == listaCoord.size() - 1) {
                                System.out.println(" ");
                                System.out.println("falha no login, coordenador não cadastrado");
                                System.out.println(" ");
                            }
                        }
                    }
                }else{
                    System.out.println(" ");
                    System.out.println("nenhum coordenador cadastrado");
                    System.out.println(" ");
                }


            } else if (Objects.equals(resposta, "2")) {
                System.out.println("-login administrador-");

                //verificar adm
                Administrador verificarAdm = new Administrador();
                verificarAdm.VerificarAdm();

                if (Administrador.verificarAdm == true){
                    System.out.println(" ");
                    System.out.println("login realizado");
                    System.out.println(" ");
                    System.out.println("-criar coordenador-");
                    System.out.println(" ");

                    //criar coordenador
                    Coordenador criarCoordenador = new Coordenador();
                    criarCoordenador.CriarCoordenador();

                    listaCoord.add(criarCoordenador);

                    System.out.println(" ");
                    System.out.println("cadastrado");
                    System.out.println(" ");
                    System.out.println("A lista tem " + listaCoord.size() + " coordenadores cadastrados");


                    /*
                    boolean respostaMaisContato = true;

                    do {
                        System.out.println("adicionar outro coordenador?");
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

                            System.out.println("-criar coordenador-");

                            //criar coordenador
                            criarCoordenador = new Coordenador();
                            criarCoordenador.CriarCoordenador();

                            listaCoord.add(criarCoordenador);

                            System.out.println("-adicionado-");
                            System.out.println("A lista tem " + listaCoord.size() + " coordenadores cadastrados");
                            }

                    }while(respostaMaisContato);
                    /*
                     */

                }else{
                    System.out.println(" ");
                    System.out.println("-nome ou senha incorretos-");
                    System.out.println(" ");
                }

            } else {
                System.out.println(" ");
                System.out.println("saindo do programa!");
                System.out.println(" ");
                sistemaEgressos = false;
            }
        }
    }
}