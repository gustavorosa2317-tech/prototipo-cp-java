import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    public int id;
    public String titulo;
    public boolean concluida;
    public Tarefa(int id, String titulo) { this.id = id; this.titulo = titulo; this.concluida = false; }
}

class TodoListApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        int proximoId = 1;
        while (true) {
            System.out.println("\n1.Adicionar 2.Listar 3.Concluir 4.Desmarcar 5.Remover 6.Sair");
            System.out.print("Opção: ");
            String opc = sc.nextLine();
            if (opc.equals("1")) {
                System.out.print("Título: ");
                String t = sc.nextLine().trim();
                if (!t.isEmpty()) { tarefas.add(new Tarefa(proximoId++, t)); System.out.println("Adicionada!"); }
                else System.out.println("Erro: título vazio.");
            } else if (opc.equals("2")) {
                if (tarefas.isEmpty()) System.out.println("Nenhuma tarefa.");
                else for (Tarefa x : tarefas) System.out.println(x.id + " [" + (x.concluida?"X":" ") + "] " + x.titulo);
            } else if (opc.equals("3") || opc.equals("4") || opc.equals("5")) {
                System.out.print("ID: ");
                try {
                    int id = Integer.parseInt(sc.nextLine());
                    Tarefa t = null;
                    for (Tarefa x : tarefas) if (x.id == id) t = x;
                    if (t == null) { System.out.println("Erro: ID não encontrado."); continue; }
                    if (opc.equals("3")) { t.concluida = true; System.out.println("Concluída!"); }
                    else if (opc.equals("4")) { t.concluida = false; System.out.println("Desmarcada!"); }
                    else { tarefas.remove(t); System.out.println("Removida!"); }
                } catch (Exception e) { System.out.println("Erro: ID inválido."); }
            } else if (opc.equals("6")) { System.out.println("Saindo..."); break; }
            else System.out.println("Opção inválida.");
        }
        sc.close();
    }
}
