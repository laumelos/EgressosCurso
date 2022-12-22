import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Egressos {
    public int cpf;
    String formacoes;
    public String nomeEgresso;
    public String dataConclusao;
    //contatos
    public ArrayList <Cursos> listaCursos;
    public ArrayList <Ocupacoes> listaOcupa;
    String depoimentoEgresso;


    public void CriarEgresso() {
        Scanner scan = new Scanner(System.in);
        String resposta;

        System.out.println("nome do egresso: ");
        while (scan.hasNext()) scan.next();
        nomeEgresso = scan.nextLine();

        System.out.println("cpf do egresso: ");
        while (!scan.hasNextInt()) scan.nextInt();
        cpf = scan.nextInt();

        System.out.println("data de conclusão do egresso: ");
        while (scan.hasNextInt()) scan.next();
        dataConclusao = scan.nextLine();

        System.out.println("contato do egresso: ");
        Contato criarContato = new Contato();
        criarContato.CriarContato();

        System.out.println("curso do egresso: ");
        Cursos criarCurso = new Cursos();
        criarCurso.CriarCurso();
        listaCursos.add(criarCurso);

        System.out.println("ocupações do egresso: ");
        Ocupacoes criarOcupacao = new Ocupacoes();
        criarOcupacao.CriarOcupacao();
        listaOcupa.add(criarOcupacao);

        System.out.println("Quer adicionar um depoimento?");
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
            System.out.println("depoimento: ");
            depoimentoEgresso = scan.nextLine();
        }

        System.out.println("-adicionado-");
        Egressos criarEgresso = new Egressos();
        Coordenador.listaEgressos.add(criarEgresso);
        System.out.println("A lista tem " + Coordenador.listaEgressos.size() + " egressos");
    }
}
