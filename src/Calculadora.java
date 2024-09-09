import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha uma operação:");
            System.out.println("1 - Adição");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("5 - Módulo (resto da divisão)");
            System.out.println("6 - Sair");

            // Verificando se a escolha é um número inteiro
            if (!scanner.hasNextInt()) {
                System.out.println("Erro: Por favor, insira um número válido para a operação.");
                scanner.next();
                continue;
            }

            int escolha = scanner.nextInt();

            // Verificando se o usuário escolheu sair
            if (escolha == 6) {
                continuar = false;
                System.out.println("Saindo da calculadora...");
                break;
            }

            // Solicitando ao usuário para inserir dois números inteiros
            System.out.print("Digite o primeiro número: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Erro: Entrada inválida. Digite um número inteiro.");
                scanner.next();
                continue;
            }
            int num1 = scanner.nextInt();

            System.out.print("Digite o segundo número: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Erro: Entrada inválida. Digite um número inteiro.");
                scanner.next();
                continue;
            }
            int num2 = scanner.nextInt();

            // Executando a operação de acordo com a escolha do usuário
            switch (escolha) {
                case 1:
                    System.out.println("Resultado: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Resultado: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Resultado: " + (num1 * num2));
                    break;
                case 4:
                    if (num2 != 0) {
                        System.out.println("Resultado: " + (num1 / num2));
                    } else {
                        System.out.println("Erro: Divisão por zero não é permitida.");
                    }
                    break;
                case 5:
                    if (num2 != 0) {
                        System.out.println("Resultado: " + (num1 % num2));
                    } else {
                        System.out.println("Erro: Módulo por zero não é permitido.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
