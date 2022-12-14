import java.util.ArrayList;
import java.util.Scanner;

public class Egressos {
    int cpf;
    String nome;
    String dataConclusao;
    String contato;
    ArrayList <String> formacoes;
    ArrayList <String> ocupacoes;
    String depoimentos;

    ArrayList<Contato> listaContato = new ArrayList<Contato>();

    public Egressos(int cpf, String nome, String dataConclusao, String contato, ArrayList<String> formacoes, ArrayList<String> ocupacoes, String depoimentos) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataConclusao = dataConclusao;
        this.contato = contato;
        this.formacoes = formacoes;
        this.ocupacoes = ocupacoes;
        this.depoimentos = depoimentos;
    }

    public void CriarEgresso() {
        Scanner scan = new Scanner(System.in);

        System.out.println("nome do egresso: ");
        while (scan.hasNextInt()) scan.next();
        this.nome = scan.nextLine();

        System.out.println("cpf do egresso: ");
        while (!scan.hasNextInt()) scan.next();
        this.cpf = scan.nextInt();

        System.out.println("data de conclusão do egresso: ");
        while (scan.hasNextInt()) scan.next();
        this.nome = scan.nextLine();





    }
}
