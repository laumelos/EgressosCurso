import java.io.*;
import java.util.*;
import java.io.IOException;

public class Relatorio {
    String tipoRelatorio;
    public ArrayList<String> egressosAnoFiltro = new ArrayList<String>();
    public ArrayList<String> egressosAno = new ArrayList<String>();
    public ArrayList<String> egressosPosFiltro = new ArrayList<String>();
    public ArrayList<String> egressosPos = new ArrayList<String>();
    public ArrayList<String> posicaoSalarioFiltro = new ArrayList<String>();
    public ArrayList<String> posicaoSalario = new ArrayList<String>();


    public void CriarRelatorio() throws IOException {

        OutputStream relatorios = new FileOutputStream("relatorios.txt"); // nome do arquivo que será escrito
        Writer wrRelatorios = new OutputStreamWriter(relatorios); // criação de um escritor
        BufferedWriter brRelatorios = new BufferedWriter(wrRelatorios); // adiciono a um escritor de buffer
        brRelatorios.write("RELATORIOS:");//nome do arquivo txt

        Scanner scan = new Scanner(System.in);
        String resposta;

        //boolean respostaMaisCurso = true;
        if (!(Coordenador.listaEgressos.isEmpty())) {

            System.out.println("Escolha o tipo de listagem do relatório: ");
            System.out.println("1 - listagem de egressos por ano (ordenado pelo nome do egresso)");
            System.out.println("2 - listagem de egresso e posições");
            System.out.println("3 - listagem de posições e salários (ordenada por salário)");
            this.tipoRelatorio = scan.nextLine();

            //número inválido
            if (!(Objects.equals(tipoRelatorio, "1") || Objects.equals(tipoRelatorio, "2") || Objects.equals(tipoRelatorio, "3"))) {
                do {
                    System.out.println("Comando inválido, digite '1' '2' ou '3' para escolher a opção: ");
                    System.out.println("1 - listagem de egressos por ano (ordenado pelo nome do egresso)");
                    System.out.println("2 - listagem de egresso e posições (ordenado pelo intervalo de tempo da ocupação)");
                    System.out.println("3 - listagem de posições e salários (ordenada por salário)");

                    tipoRelatorio = scan.nextLine();

                } while (!(Objects.equals(tipoRelatorio, "1") || Objects.equals(tipoRelatorio, "2") || Objects.equals(tipoRelatorio, "3")));
            }
            if (Objects.equals(tipoRelatorio, "1")) {
                System.out.println(" ");
                System.out.println("-listagem de egressos por ano (ordenado pelo nome do egresso)-");
                System.out.println(" ");
                System.out.println("filtrar por ano?");
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
                    System.out.println("egressos e seus anos de conclusão:");
                    for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                        System.out.println(Coordenador.listaEgressos.get(x).nomeEgresso + " - " + Coordenador.listaEgressos.get(x).anoConclusao);
                    }
                    System.out.println(" ");
                    System.out.println("ano desejado: ");

                    resposta = scan.nextLine();
                    boolean anoExiste = true;

                    for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                        if (!Objects.equals(Coordenador.listaEgressos.get(x).anoConclusao, resposta)) {
                            anoExiste = false;
                        }
                    }

                    if (anoExiste) {
                        System.out.println(" ");
                        System.out.println("relatório: ");


                        ArrayList<String> listaNomes = new ArrayList<String>();
                        //fazer lista dos nomes filtrados por ano
                        for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                            if (Objects.equals(Coordenador.listaEgressos.get(x).anoConclusao, resposta)) {

                                String testeNome = Coordenador.listaEgressos.get(x).nomeEgresso;
                                listaNomes.add(testeNome);

                            }
                        }
                        Collections.sort(listaNomes);

                        ArrayList<String> listaNomesEgressos = new ArrayList<String>();

                        for (int y = 0; y < Coordenador.listaEgressos.size(); y++) {
                            for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                                if (Objects.equals(Coordenador.listaEgressos.get(x).nomeEgresso, listaNomes.get(y))) {
                                    listaNomesEgressos.add("nome do egresso: " + listaNomes.get(y) + " - " + "ano de conclusão do curso: " + Coordenador.listaEgressos.get(x).anoConclusao);
                                }
                            }
                        }
                        for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                            //listagem de egressos por ano (ordenado pelo nome do egresso) (filtrados por ano)-
                            //System.out.println(listaNomesEgressos.get(x));
                            egressosAnoFiltro.add(listaNomesEgressos.get(x));
                            brRelatorios.newLine();
                            brRelatorios.write(String.valueOf(listaNomesEgressos.get(x)));
                        }
                        brRelatorios.close();
                        System.out.println(egressosAnoFiltro);

                    }else{
                        do {
                            System.out.println("Comando inválido, selecione um ano existente: ");
                            resposta = scan.nextLine();

                            for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                                if (!Objects.equals(Coordenador.listaEgressos.get(x).anoConclusao, resposta)) {
                                    anoExiste = false;
                                }else{
                                    anoExiste = true;
                                }
                            }
                        } while (!anoExiste);
                    }
                }else{

                    System.out.println(" ");
                    System.out.println("relatório: ");

                    ArrayList<String> listaNomes = new ArrayList<String>();
                    //fazer lista dos nomes
                    for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                        String testeNome = Coordenador.listaEgressos.get(x).nomeEgresso;
                        listaNomes.add(testeNome);
                    }
                    Collections.sort(listaNomes);

                    ArrayList<String> listaNomesEgressos = new ArrayList<String>();

                    for (int y = 0; y < Coordenador.listaEgressos.size(); y++) {
                        for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                            if (Objects.equals(Coordenador.listaEgressos.get(x).nomeEgresso, listaNomes.get(y))) {
                                listaNomesEgressos.add("nome do egresso: " + listaNomes.get(x) + " - " + "ano de conclusão do curso: " + Coordenador.listaEgressos.get(x).anoConclusao);
                            }
                        }
                    }
                    for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                        //AQUI!!!!!!!!!!!!!!
                        //listagem de egressos por ano (ordenado pelo nome do egresso) (SEM FILTRO)-
                        //System.out.println(listaNomesEgressos.get(x));
                        egressosAno.add(listaNomesEgressos.get(x));
                        brRelatorios.newLine();
                        brRelatorios.write(String.valueOf(listaNomesEgressos.get(x)));
                    }
                    System.out.println(egressosAno);

                    brRelatorios.close();
                }

            }else if (Objects.equals(tipoRelatorio, "2")) {
                System.out.println(" ");
                System.out.println("-listagem de egresso e posições-");
                System.out.println(" ");

                System.out.println("filtrar pelo intervalo de tempo da ocupação?");
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
                    System.out.println("egressos e seus intervalos de tempo da ocupação:");
                    for (int y = 0; y < Coordenador.listaEgressos.size(); y++) {
                        System.out.println("egresso: " + Coordenador.listaEgressos.get(y));
                        for (int x = 0; x < (Egressos.listaOcupa.size()); x++) {
                            System.out.println("intervalos de tempo da ocupação: ");
                            System.out.println(Coordenador.listaEgressos.get(y).nomeEgresso + " - " + (Integer.parseInt(Egressos.listaOcupa.get(x).anoFim) - Integer.parseInt(Egressos.listaOcupa.get(x).anoInicio)));
                        }
                        System.out.println(" ");
                        System.out.println("intervalos de tempo desejado: ");

                        resposta = scan.nextLine();
                        boolean intervaloExiste = true;

                        for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                            if (!Objects.equals(Integer.parseInt(Egressos.listaOcupa.get(x).anoFim) - Integer.parseInt(Egressos.listaOcupa.get(x).anoInicio), Integer.parseInt(resposta))) {
                                intervaloExiste = false;
                            }
                        }

                        if (intervaloExiste) {
                            System.out.println(" ");
                            System.out.println("relatório: ");

                            ArrayList<String> listaNomeOcupa = new ArrayList<String>();
                            //fazer lista do nome das ocupações
                            for (y = 0; y < Coordenador.listaEgressos.size(); y++) {
                                for (int x = 0; x < Egressos.listaOcupa.size(); x++) {
                                    if (Objects.equals(Integer.parseInt(Egressos.listaOcupa.get(x).anoFim) - Integer.parseInt(Egressos.listaOcupa.get(x).anoInicio), Integer.parseInt(resposta))) {

                                        String testeNome = Egressos.listaOcupa.get(x).nomeCargo;
                                        String testeDesc = Egressos.listaOcupa.get(x).descricao;
                                        String testeSal = Egressos.listaOcupa.get(x).salario;


                                        listaNomeOcupa.add("ocupações: " + testeNome + " descrição: " + testeDesc + " salário: " + testeSal);
                                    }
                                }
                            }

                            //for (y = 0; y < Coordenador.listaEgressos.size(); y++) {
                            //    System.out.println("nome do egresso: " + Coordenador.listaEgressos.get(y).getNomeEgresso() + " - " + listaNomeOcupa.get(y));
                            //}


                            for (y = 0; y < Coordenador.listaEgressos.size(); y++) {
                                for (int x = 0; x < Egressos.listaOcupa.size(); x++) {

                                    //AQUI!!!!!!!!!!!!!!
                                    //-listagem de egresso e posições (filtrar pelo intervalo de tempo da ocupação)-
                                    //System.out.println("nome do egresso: " + Coordenador.listaEgressos.get(y).getNomeEgresso() + " - " + listaNomeOcupa.get(x));
                                    egressosPosFiltro.add("nome do egresso: " + Coordenador.listaEgressos.get(y).getNomeEgresso() + " - " + listaNomeOcupa.get(x));
                                    brRelatorios.newLine();
                                    brRelatorios.write(String.valueOf("nome do egresso: " + Coordenador.listaEgressos.get(y).getNomeEgresso() + " - " + listaNomeOcupa.get(x)));
                                }
                            }
                            brRelatorios.close();
                            System.out.println(egressosPosFiltro);

                        }else{

                            do {
                                System.out.println("Comando inválido, selecione um ano existente: ");
                                resposta = scan.nextLine();

                                for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                                    if (!Objects.equals(Integer.parseInt(Egressos.listaOcupa.get(x).anoFim) - Integer.parseInt(Egressos.listaOcupa.get(x).anoInicio), Integer.parseInt(resposta))) {
                                        intervaloExiste = false;
                                    }else{
                                        intervaloExiste = true;
                                    }
                                }
                            } while (!intervaloExiste);

                        }
                    }
                }else{
                    System.out.println(" ");
                    System.out.println("relatório: ");

                    ArrayList<String> listaNomeOcupa = new ArrayList<String>();
                    //fazer lista do nome das ocupações
                    for (int y = 0; y < Coordenador.listaEgressos.size(); y++) {
                        for (int x = 0; x < Egressos.listaOcupa.size(); x++) {
                            String testeNome = Egressos.listaOcupa.get(x).nomeCargo;
                            String testeDesc = Egressos.listaOcupa.get(x).descricao;
                            String testeSal = Egressos.listaOcupa.get(x).salario;

                            listaNomeOcupa.add("ocupações: " + testeNome + " descrição: " + testeDesc + " salário: " + testeSal);
                        }
                    }

                    //for (int y = 0; y < Coordenador.listaEgressos.size(); y++) {
                    //    System.out.println("nome do egresso: " + Coordenador.listaEgressos.get(y).getNomeEgresso() + " - " + listaNomeOcupa.get(y));
                    //}

                    for (int y = 0; y < Coordenador.listaEgressos.size(); y++) {
                        for (int x = 0; x < Egressos.listaOcupa.size(); x++) {
                            //AQUI!!!!!!!!!!!!!!
                            //-listagem de egresso e posições-
                            //System.out.println("nome do egresso: " + Coordenador.listaEgressos.get(y).getNomeEgresso() + " - " + listaNomeOcupa.get(x));
                            egressosPos.add("nome do egresso: " + Coordenador.listaEgressos.get(y).getNomeEgresso() + " - " + listaNomeOcupa.get(x));
                            brRelatorios.newLine();
                            brRelatorios.write(String.valueOf("nome do egresso: " + Coordenador.listaEgressos.get(y).getNomeEgresso() + " - " + listaNomeOcupa.get(x)));
                        }
                    }
                    System.out.println(egressosPos);
                }
            }else{
                System.out.println(" ");
                System.out.println("-listagem de posições e salários (ordenada por salário)-");
                System.out.println(" ");

                System.out.println("filtrar pelo intervalo de tempo da ocupação?");
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
                    System.out.println("egressos e seus intervalos de tempo da ocupação:");
                    for (int y = 0; y < Coordenador.listaEgressos.size(); y++) {
                        for (int x = 0; x < (Egressos.listaOcupa.size()); x++) {
                            System.out.println(Coordenador.listaEgressos.get(y).nomeEgresso + " - " + (Integer.parseInt(Egressos.listaOcupa.get(x).anoFim) - Integer.parseInt(Egressos.listaOcupa.get(x).anoInicio)));
                        }
                        System.out.println(" ");
                        System.out.println("intervalos de tempo desejado: ");

                        resposta = scan.nextLine();
                        boolean intervaloExiste = true;

                        for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                            if (!Objects.equals(Integer.parseInt(Egressos.listaOcupa.get(x).anoFim) - Integer.parseInt(Egressos.listaOcupa.get(x).anoInicio), Integer.parseInt(resposta))) {
                                intervaloExiste = false;
                            }
                        }

                        if (intervaloExiste) {

                            System.out.println(" ");
                            System.out.println("relatório: ");


                            for (int x = 0; x < Egressos.listaOcupa.size(); x++) {

                                System.out.println("nome dos cursos e salários: " + Egressos.listaOcupa.get(x).nomeCargo +" " +Egressos.listaOcupa.get(x).salario);

                            }

                            ArrayList<String> listaSalarios = new ArrayList<String>();

                            //fazer lista dos salários
                            for (y = 0; y < Egressos.listaOcupa.size(); y++) {
                                if (Objects.equals(Integer.parseInt(Egressos.listaOcupa.get(y).anoFim) - Integer.parseInt(Egressos.listaOcupa.get(y).anoInicio), Integer.parseInt(resposta))) {


                                    String testeSal = Egressos.listaOcupa.get(y).salario;
                                    listaSalarios.add(testeSal);
                                }

                            }

                            Collections.sort(listaSalarios);
                            System.out.println(listaSalarios);

                            //organizar lista ordenada pelo salário
                            ArrayList<String> listaEgressosSalarios = new ArrayList<String>();

                            for (y = 0; y < Egressos.listaOcupa.size(); y++) {
                                for (int x = 0; x < Egressos.listaOcupa.size(); x++) {
                                    if (Objects.equals(listaSalarios.get(y), Egressos.listaOcupa.get(x).salario)) {
                                        listaEgressosSalarios.add("ocupações: " + Egressos.listaOcupa.get(x).nomeCargo + " descrição: " + Egressos.listaOcupa.get(x).descricao + " salário: " + listaSalarios.get(y));
                                    }
                                }
                            }
                            for (int x = 0; x < listaEgressosSalarios.size(); x++) {
                                //AQUI!!!!!!!!!!!!!!
                                //-listagem de posições e salários (ordenada por salário) (filtrado pelo intervalo de tempo da ocupação)-
                                //System.out.println(listaEgressosSalarios.get(x));
                                posicaoSalarioFiltro.add(listaEgressosSalarios.get(x));
                                brRelatorios.newLine();
                                brRelatorios.write(String.valueOf(listaEgressosSalarios.get(x)));
                            }
                            brRelatorios.close();
                            System.out.println(posicaoSalarioFiltro);


                        }else{

                            do {
                                System.out.println("Comando inválido, selecione um ano existente: ");
                                resposta = scan.nextLine();

                                for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                                    if (!Objects.equals(Integer.parseInt(Egressos.listaOcupa.get(x).anoFim) - Integer.parseInt(Egressos.listaOcupa.get(x).anoInicio), Integer.parseInt(resposta))) {
                                        intervaloExiste = false;
                                    }else{
                                        intervaloExiste = true;
                                    }
                                }
                            } while (!intervaloExiste);

                        }
                    }
                }else{
                    System.out.println(" ");
                    System.out.println("relatório: ");


                    for (int x = 0; x < Egressos.listaOcupa.size(); x++) {

                        System.out.println("nome dos cursos e salários: " + Egressos.listaOcupa.get(x).nomeCargo +" " +Egressos.listaOcupa.get(x).salario);

                    }

                    ArrayList<String> listaSalarios = new ArrayList<String>();

                    //fazer lista dos salários
                    for (int y = 0; y < Egressos.listaOcupa.size(); y++) {

                        String testeSal = Egressos.listaOcupa.get(y).salario;
                        listaSalarios.add(testeSal);


                    }

                    Collections.sort(listaSalarios);
                    System.out.println(listaSalarios);

                    //organizar lista ordenada pelo salário
                    ArrayList<String> listaEgressosSalarios = new ArrayList<String>();

                    for (int y = 0; y < Egressos.listaOcupa.size(); y++) {
                        for (int x = 0; x < Egressos.listaOcupa.size(); x++) {
                            if (Objects.equals(listaSalarios.get(y), Egressos.listaOcupa.get(x).salario)) {
                                listaEgressosSalarios.add("ocupações: " + Egressos.listaOcupa.get(x).nomeCargo + " descrição: " + Egressos.listaOcupa.get(x).descricao + " salário: " + listaSalarios.get(y));
                            }
                        }
                    }
                    for (int x = 0; x < listaEgressosSalarios.size(); x++) {
                        //AQUI!!!!!!!!!!!!!!
                        //-listagem de posições e salários (ordenada por salário)-
                        //System.out.println(listaEgressosSalarios.get(x));
                        posicaoSalario.add(listaEgressosSalarios.get(x));
                        brRelatorios.newLine();
                        brRelatorios.write(String.valueOf(listaEgressosSalarios.get(x)));
                    }
                    System.out.println(posicaoSalario);
                }
            }
        }else{
            System.out.println("nenhum egresso cadastrado");
        }
    }

}
