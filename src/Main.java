import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        boolean sistemaEgressos = true;
        Scanner scan = new Scanner (System.in);
        String resposta;

        //arquivos txt
        ArrayList<Coordenador> listaCoord = new ArrayList<Coordenador>();
        OutputStream os = new FileOutputStream("coordenadores.txt"); // nome do arquivo que será escrito
        Writer wr = new OutputStreamWriter(os); // criação de um escritor
        BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer
        br.write("NOME COORDENADORES:");//nome do arquivo txt

        OutputStream cursos = new FileOutputStream("cursos.txt"); // nome do arquivo que será escrito
        Writer wrCursos = new OutputStreamWriter(cursos); // criação de um escritor
        BufferedWriter brCursos = new BufferedWriter(wrCursos); // adiciono a um escritor de buffer
        brCursos.write("CURSOS:");//nome do arquivo txt

        OutputStream cursosEditados = new FileOutputStream("cursosEditados.txt"); // nome do arquivo que será escrito
        Writer wrCursosEditados = new OutputStreamWriter(cursosEditados); // criação de um escritor
        BufferedWriter brCursosEditados = new BufferedWriter(wrCursosEditados); // adiciono a um escritor de buffer
        brCursosEditados.write("CURSOS EDITADOS:");//nome do arquivo txt

        OutputStream egresso = new FileOutputStream("egressos.txt"); // nome do arquivo que será escrito
        Writer wrEgresso = new OutputStreamWriter(egresso); // criação de um escritor
        BufferedWriter brEgresso = new BufferedWriter(wrEgresso); // adiciono a um escritor de buffer
        brEgresso.write("EGRESSOS:");//nome do arquivo txt

        OutputStream egressoEditado = new FileOutputStream("egressosEditados.txt"); // nome do arquivo que será escrito
        Writer wrEgressoEditado = new OutputStreamWriter(egressoEditado); // criação de um escritor
        BufferedWriter brEgressoEditado = new BufferedWriter(wrEgressoEditado); // adiciono a um escritor de buffer
        brEgressoEditado.write("EGRESSOS EDITADOS:");//nome do arquivo txt


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

                //if (!(listaCoord.isEmpty())) {
                if (!(Administrador.listaCoord.isEmpty())) {
                    Coordenador criarCoordenador = new Coordenador();
                    criarCoordenador.Entrar();


                    if (resposta.equals("1")) {
                        //checar se coord está cadastrado
                        //for (int varCoord = 0; varCoord < listaCoord.size(); varCoord++) {
                        for (int varCoord = 0; varCoord < Administrador.listaCoord.size(); varCoord++) {

                            if (Administrador.listaCoord.get(varCoord).getNomeCoordenador().equals(criarCoordenador.getNomeCoordenador()) && (Administrador.listaCoord.get(varCoord).getSenhaCoordenador().equals(criarCoordenador.getSenhaCoordenador()))) {

                            //if (listaCoord.get(varCoord).getNomeCoordenador().equals(criarCoordenador.getNomeCoordenador()) && (listaCoord.get(varCoord).getSenhaCoordenador().equals(criarCoordenador.getSenhaCoordenador()))) {


                                Coordenador.coordLogado = Administrador.listaCoord.get(varCoord).getNomeCoordenador();
                                System.out.println("Coordenador.coordLogado"+Coordenador.coordLogado);

                                //System.out.println("x " + varCoord);
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
                                    System.out.println("6 - gerar relatórios");
                                    System.out.println("7 - logoff");

                                    //System.out.println("listaCoord "+listaCoord);
                                    //System.out.println("coord x "+listaCoord.get(varCoord));


                                    //scan
                                    resposta = scan.nextLine();

                                    //número inválido
                                    if (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6") || Objects.equals(resposta, "7"))) {
                                        do {
                                            System.out.println("Comando inválido, selecione '1' '2' '3' '4' '5' '6' ou '7' para escolher a opção: ");
                                            System.out.println("1 - criar curso");
                                            System.out.println("2 - gerenciar curso");
                                            System.out.println("3 - cadastrar egresso");
                                            System.out.println("4 - gerenciar egresso");
                                            System.out.println("5 - consultar egresso");
                                            System.out.println("6 - gerar relatórios");
                                            System.out.println("7 - logoff");
                                            resposta = scan.nextLine();

                                        } while (!(Objects.equals(resposta, "1") || Objects.equals(resposta, "2") || Objects.equals(resposta, "3") || Objects.equals(resposta, "4") || Objects.equals(resposta, "5") || Objects.equals(resposta, "6") || Objects.equals(resposta, "7")));
                                    }

                                    if (Objects.equals(resposta, "1")) {

                                        System.out.println("-criar curso-");

                                        Cursos criarCurso = new Cursos();
                                        criarCurso.CriarCurso();
                                        //brCursos.newLine();
                                        //brCursos.write(criarCurso.getNomeCurso() + ", " + criarCurso.getInstituicao());
                                        System.out.println(" ");
                                        System.out.println("cadastrado");
                                        System.out.println(" ");


                                        if (Objects.equals(criarCurso.instituicao, "UFMA") || Objects.equals(criarCurso.instituicao, "Ufma") || Objects.equals(criarCurso.instituicao, "ufma")) {
                                            Coordenador.listaCursos.add(criarCurso);
                                            Egressos.listaCursos.add(criarCurso);
                                            //System.out.println("Coordenador" + Coordenador.listaCursos);

                                        } else {
                                            Egressos.listaCursos.add(criarCurso);
                                            //System.out.println("Egresso" + Egressos.listaCursos);
                                        }
/*
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
                                                //brCursos.newLine();
                                                //brCursos.write(criarCurso.getNomeCurso() + ", " + criarCurso.getInstituicao());
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

 */

                                        brCursos.close();
                                    }else if (Objects.equals(resposta, "2")) {

                                        System.out.println("-gerenciar curso-");
                                        Cursos gerenciarCurso = new Cursos();
                                        //brCursosEditados.newLine();
                                        //brCursosEditados.write(gerenciarCurso.getNomeCurso()+ ", " + gerenciarCurso.getInstituicao());
                                        gerenciarCurso.GerenciarCurso();

                                        //brCursosEditados.close();
                                    } else if (Objects.equals(resposta, "3")) {

                                        System.out.println("-cadastrar egresso-");
                                        Egressos criarEgresso = new Egressos();
                                        criarEgresso.CriarEgresso();
                                        //brEgresso.newLine();
                                        //brEgresso.write(criarEgresso.getNomeEgresso() + ", " + criarEgresso.getCpf() + ", " + criarEgresso.getDataConclusao());
                                        System.out.println(criarEgresso);

                                        System.out.println(" ");
                                        System.out.println("cadastrado");
                                        System.out.println(" ");
                                        Coordenador.listaEgressos.add(criarEgresso);

                                        //System.out.println("A lista tem " + Coordenador.listaEgressos.size() + " egressos");

                                        Cursos criarCurso = new Cursos();
                                        if (Objects.equals(criarCurso.instituicao, "UFMA") || Objects.equals(criarCurso.instituicao, "Ufma") || Objects.equals(criarCurso.instituicao, "ufma")) {
                                            System.out.println(criarEgresso.nomeEgresso);
                                            Cursos.listaEgressosCurso.add(criarEgresso);
                                            //System.out.println("listaEgressosCurso" + Cursos.listaEgressosCurso);
                                        }

                                        //brEgresso.close();
                                    } else if (Objects.equals(resposta, "4")) {

                                        System.out.println("-gerenciar egresso-");
                                        Egressos gerenciarEgresso = new Egressos();
                                        //brEgressoEditado.newLine();
                                        //brEgressoEditado.write(gerenciarEgresso.getNomeEgresso() + ", "+ gerenciarEgresso.getCpf() + ", " + gerenciarEgresso.getDataConclusao());
                                        gerenciarEgresso.GerenciarEgresso();
                                        //brEgressoEditado.close();
                                    } else if (Objects.equals(resposta, "5")) {

                                        System.out.println("-consultar egresso-");
                                        Egressos consultarEgresso = new Egressos();
                                        consultarEgresso.ConsultarEgresso();

                                    } else if (Objects.equals(resposta, "6")) {

                                        System.out.println("-gerar relatórios-");
                                        Relatorio criarRelatorio = new Relatorio();
                                        criarRelatorio.CriarRelatorio();

                                    } else {

                                        System.out.println("-logoff-");

                                    }
                                } while (!(Objects.equals(resposta, "7")));
                            }else{
                                System.out.println(" ");
                                System.out.println(" OPS falha no login, coordenador não cadastrado");
                                System.out.println(" ");
                            }
                        }
                        br.close();
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
                verificarAdm.Entrar();

                if (Administrador.verificarAdm){
                    System.out.println(" ");
                    System.out.println("login realizado");
                    System.out.println(" ");
                    System.out.println("-criar coordenador-");
                    System.out.println(" ");

                    //criar coordenador
                    Coordenador criarCoordenador = new Coordenador();
                    criarCoordenador.Entrar();
                    //listaCoord.add(criarCoordenador);
                    Administrador.listaCoord.add(criarCoordenador);

                    System.out.println(" ");
                    System.out.println("cadastrado");
                    System.out.println(" ");
                    //System.out.println("A lista tem " + listaCoord.size() + " coordenadores cadastrados");
                    System.out.println("A lista tem " + Administrador.listaCoord.size() + " coordenadores cadastrados");
                    System.out.println(" ");


                    //br.newLine();
                    //br.write(criarCoordenador.getNomeCoordenador());

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
        br.close();
    }
}