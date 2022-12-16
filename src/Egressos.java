import java.util.ArrayList;
import java.util.Scanner;

public class Egressos {
    static int cpf;
    static String nomeEgresso;
    static String dataConclusao;
    static String contato;
    ArrayList <String> formacoes;
    ArrayList <String> ocupacoes;
    String depoimentos;

    ArrayList<Contato> listaContato = new ArrayList<Contato>();

    public static void CriarEgresso() {
        Scanner scan = new Scanner(System.in);

        System.out.println("nome do egresso: ");
        while (scan.hasNextInt()) scan.next();
        Egressos.nomeEgresso = scan.nextLine();

        System.out.println("cpf do egresso: ");
        while (!scan.hasNextInt()) scan.next();
        Egressos.cpf = scan.nextInt();

        System.out.println("data de conclusão do egresso: ");
        while (scan.hasNextInt()) scan.next();
        Egressos.dataConclusao = scan.nextLine();

        System.out.println("contato do egresso: ");
        Contato.CriarContato();

        System.out.println("-adicionado-");
        System.out.println("A lista tem " + Coordenador.listaEgressos.size() + " egressos");
    }
}
