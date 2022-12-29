import java.util.*;

public class Relatorio {
    String tipoRelatorio;

    public void CriarRelatorio() {
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

                        ArrayList<String> listaNomeEgressos = new ArrayList<String>();
                        //fazer lista dos nomes filtrados por ano
                        for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                            if (Objects.equals(Coordenador.listaEgressos.get(x).anoConclusao, resposta)) {

                                String testeNome = Coordenador.listaEgressos.get(x).nomeEgresso;
                                listaNomeEgressos.add(testeNome);

                            }
                        }
                        for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                            Collections.sort(listaNomeEgressos);

                            System.out.println("nome do egresso: " + listaNomeEgressos.get(x) + " - " + "ano de conclusão do curso: " + Coordenador.listaEgressos.get(x).anoConclusao);
                        }
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

                    ArrayList<String> listaNomeEgressos = new ArrayList<String>();
                    //fazer lista dos nomes
                    for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {

                        String testeNome = Coordenador.listaEgressos.get(x).nomeEgresso;
                        listaNomeEgressos.add(testeNome);

                    }
                    for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                        Collections.sort(listaNomeEgressos);

                        System.out.println("nome do egresso: " + listaNomeEgressos.get(x) + " - " + "ano de conclusão do curso: " + Coordenador.listaEgressos.get(x).anoConclusao);
                    }
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
                                    System.out.println("nome do egresso: " + Coordenador.listaEgressos.get(y).getNomeEgresso() + " - " + listaNomeOcupa.get(x));

                                }
                            }


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
                            System.out.println("nome do egresso: " + Coordenador.listaEgressos.get(y).getNomeEgresso() + " - " + listaNomeOcupa.get(x));
                        }
                    }

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

                            ArrayList<String> listaSalarios = new ArrayList<String>();

                            //fazer lista dos salários


                            for (y = 0; y < Coordenador.listaEgressos.size(); y++) {
                                for (int x = 0; x < Egressos.listaOcupa.size(); x++) {
                                    if (Objects.equals(Integer.parseInt(Egressos.listaOcupa.get(x).anoFim) - Integer.parseInt(Egressos.listaOcupa.get(x).anoInicio), Integer.parseInt(resposta))) {

                                        String testeSal = Egressos.listaOcupa.get(x).salario;
                                        listaSalarios.add(testeSal);

                                    }
                                }
                            }

                            Collections.sort(listaSalarios);

                            //fazer lista do nome das ocupações
                            for (y = 0; y < Coordenador.listaEgressos.size(); y++) {
                                for (int x = 0; x < Egressos.listaOcupa.size(); x++) {
                                    if (Objects.equals(Integer.parseInt(Egressos.listaOcupa.get(x).anoFim) - Integer.parseInt(Egressos.listaOcupa.get(x).anoInicio), Integer.parseInt(resposta))) {

                                        String testeNome = Egressos.listaOcupa.get(x).nomeCargo;
                                        String testeDesc = Egressos.listaOcupa.get(x).descricao;

                                        System.out.println("ocupações: " + testeNome + " descrição: " + testeDesc + " salário: " + listaSalarios.get(x));
                                    }
                                }
                            }

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

                    ArrayList<String> listaSortSalarios = new ArrayList<String>();
                    String testeSal;

                    //fazer lista ordenada por salario
                    for (int y = 0; y < Coordenador.listaEgressos.size(); y++) {
                        for (int x = 0; x < Egressos.listaOcupa.size(); x++) {

                            String testeNome = Egressos.listaOcupa.get(x).nomeCargo;
                            String testeDesc = Egressos.listaOcupa.get(x).descricao;

                            testeSal = Egressos.listaOcupa.get(x).salario;
                            listaSortSalarios.add(testeNome + testeDesc + testeSal);

                        }

                        //listaSortSalarios.sort(Comparator.comparing(listaSortSalarios::gettesteSal));


                        //Collections.sort(listaSortSalarios, testeSal);
                    }












/*
                    ArrayList<String> listaSalarios = new ArrayList<String>();

                    //fazer lista do nome das ocupações
                    for (int y = 0; y < Coordenador.listaEgressos.size(); y++) {
                        for (int x = 0; x < Egressos.listaOcupa.size(); x++) {

                            String testeSal = Egressos.listaOcupa.get(x).salario;
                            listaSalarios.add(testeSal);
                        }
                    }

                    Collections.sort(listaSalarios);

                    //fazer lista do nome das ocupações
                    for (int y = 0; y < Coordenador.listaEgressos.size(); y++) {
                        for (int x = 0; x < Egressos.listaOcupa.size(); x++) {
                            if (Objects.equals(Integer.parseInt(Egressos.listaOcupa.get(x).anoFim) - Integer.parseInt(Egressos.listaOcupa.get(x).anoInicio), Integer.parseInt(resposta))) {

                                String testeNome = Egressos.listaOcupa.get(x).nomeCargo;
                                String testeDesc = Egressos.listaOcupa.get(x).descricao;

                                System.out.println("ocupações: " + testeNome + " descrição: " + testeDesc + " salário: " + listaSalarios.get(x));
                            }
                        }
                    }

 */

                }
            }
        }else{
            System.out.println("nenhum egresso cadastrado");
        }
    }
}
