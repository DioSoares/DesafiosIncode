import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeTarefas {

    private static ArrayList<String> tarefas = new ArrayList<>();
    private static ArrayList<String> tarefasConcluidas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("---- Gerenciador de Tarefas ----");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Marcar tarefa como concluída");
            System.out.println("3. Listar Tarefas");
            System.out.println("4. Sair");
            System.out.println("!!!! Escolha uma opção !!!!");

            // Verifica se a entrada é um número inteiro
            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                // Processa a escolha do usuário
                switch (opcao) {
                    case 1:
                        adicionarTarefa(scanner);
                        break;

                    case 2:
                        marcarTarefaComoConcluida(scanner);
                        break;

                    case 3:
                        listarTarefas();
                        break;

                    case 4:
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opção inválida, tente novamente!");
                        break;
                }
            } else {
                // Se a entrada não for um número, mostra uma mensagem de erro
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next();
            }
        }

        scanner.close();
        System.out.println("=== Fim do Programa ===");
    }

    // Função para adicionar uma tarefa
    private static void adicionarTarefa(Scanner scanner) {
        System.out.println("Digite a descrição da tarefa:");
        String tarefa = scanner.nextLine();
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso.");
    }

    // Função para marcar uma tarefa como concluída
    private static void marcarTarefaComoConcluida(Scanner scanner) {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas pendentes para concluir.");
            return;
        }

        listarTarefasPendentes();
        System.out.println("Digite o número da tarefa que deseja marcar como concluída:");

        // Verifica se a entrada é um número inteiro
        if (scanner.hasNextInt()) {
            int numeroTarefa = scanner.nextInt();

            if (numeroTarefa > 0 && numeroTarefa <= tarefas.size()) {
                String tarefaConcluida = tarefas.remove(numeroTarefa - 1);
                tarefasConcluidas.add(tarefaConcluida);
                System.out.println("Tarefa marcada como concluída.");
            } else {
                System.out.println("Número inválido.");
            }
        } else {
            // Se a entrada não for um número, mostra uma mensagem de erro
            System.out.println("Entrada inválida. Por favor, insira um número.");
            scanner.next();
        }
    }

    // Função para listar todas as tarefas, tanto pendentes quanto concluídas
    private static void listarTarefas() {
        System.out.println("---- Tarefas Pendentes ----");
        listarTarefasPendentes();

        System.out.println("---- Tarefas Concluídas ----");
        if (tarefasConcluidas.isEmpty()) {
            System.out.println("Nenhuma tarefa concluída.");
        } else {
            for (int i = 0; i < tarefasConcluidas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefasConcluidas.get(i));
            }
        }
    }

    // Função auxiliar para listar apenas as tarefas pendentes
    private static void listarTarefasPendentes() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa pendente.");
        } else {
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }
}
