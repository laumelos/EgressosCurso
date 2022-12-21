import java.util.ArrayList;
import java.util.Scanner;

public class Egressos {
    public int cpf;
    String formacoes;
    public String nomeEgresso;
    public String dataConclusao;
    //contatos
    public ArrayList <Cursos> listaCursos;
    ArrayList <String> ocupacoes;
    String depoimentos;


    public void CriarEgresso() {
        Scanner scan = new Scanner(System.in);

        System.out.println("nome do egresso: ");
        while (scan.hasNext()) scan.next();
        nomeEgresso = scan.next();

        System.out.println("cpf do egresso: ");
        while (!scan.hasNextInt()) scan.next();
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






        System.out.println("-adicionado-");
        Egressos criarEgresso = new Egressos();
        Coordenador.listaEgressos.add(criarEgresso);
        System.out.println("A lista tem " + Coordenador.listaEgressos.size() + " egressos");
    }
}
