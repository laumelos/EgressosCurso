import java.util.Objects;
import java.util.Scanner;

public class Relatorio {
    String tipoRelatorio;

    public void CriarRelatorio() {
        Scanner scan = new Scanner(System.in);
        String resposta;

        //boolean respostaMaisCurso = true;


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
                System.out.println("2 - listagem de egresso e posições");
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
                System.out.println("anos:");
                for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                    System.out.println(x + Coordenador.listaEgressos.get(x).anoConclusao);
                }





                for (int x = 0; x < Coordenador.listaEgressos.size(); x++) {
                    System.out.println(Coordenador.listaEgressos.get(x).nomeEgresso + Coordenador.listaEgressos.get(x).anoConclusao);
                }
            }



        } else if (Objects.equals(tipoRelatorio, "2")) {
            System.out.println("-listagem de egresso e posições-");


        } else {
            System.out.println("-listagem de posições e salários (ordenada por salário)-");

        }
    }
}
