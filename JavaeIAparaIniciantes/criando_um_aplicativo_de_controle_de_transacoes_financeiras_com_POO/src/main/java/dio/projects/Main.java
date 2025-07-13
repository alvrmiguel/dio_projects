package dio.projects;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Acessar conta existente");
            System.out.println("0. Sair do programa");

            int mainOption = readInt(scanner, "Escolha uma opção válida: ");

            switch (mainOption) {
                case 1 -> {
                    System.out.println("Nome:");
                    String name = readNonEmptyLine(scanner);

                    System.out.println("CPF:");
                    String cpf = readNonEmptyLine(scanner);

                    System.out.println("Pix:");
                    String pix = readNonEmptyLine(scanner);

                    Client client = new Client(name, cpf, pix);

                    System.out.println("Escolha o tipo de conta: 1 - Corrente, 2 - Poupança");
                    int tipoConta = readInt(scanner, "Escolha uma opção válida (1 ou 2): ");
                    Account account;
                    if (tipoConta == 1) {
                        account = new CheckingAccount(client);
                    } else if (tipoConta == 2) {
                        account = new SavingAccount(client);
                    } else {
                        System.out.println("Tipo inválido. Criando Conta Corrente por padrão.");
                        account = new CheckingAccount(client);
                    }
                    bank.addAccount(account);
                    System.out.println("Conta criada com sucesso! UUID: " + account.getUuid());
                }
                case 2 -> {
                    System.out.println("Digite o UUID da conta para acessar:");
                    String uuidStr = scanner.nextLine();
                    try {
                        UUID uuid = UUID.fromString(uuidStr);
                        Account account = bank.findAccount(uuid);

                        if (account == null) {
                            System.out.println("Conta não encontrada.");
                            break;
                        }

                        boolean inAccount = true;

                        while (inAccount) {
                            System.out.println("\n=== MENU CONTA ===");
                            System.out.println("1. Depositar");
                            System.out.println("2. Sacar");
                            System.out.println("3. Mostrar Extrato");
                            System.out.println("4. Listar Contas");
                            System.out.println("0. Sair da conta");

                            int accOption = readInt(scanner, "Escolha uma opção válida: ");

                            switch (accOption) {
                                case 1 -> {
                                    System.out.print("Valor a depositar: ");
                                    long value = readPositiveLong(scanner);
                                    account.deposit(value);
                                }
                                case 2 -> {
                                    System.out.print("Valor a sacar: ");
                                    long value = readPositiveLong(scanner);
                                    account.withdraw(value);
                                }
                                case 3 -> account.showExtract();
                                case 4 -> bank.listAccounts();
                                case 0 -> {
                                    inAccount = false;
                                    System.out.println("Saindo da conta...");
                                }
                                default -> System.out.println("Opção inválida");
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("UUID inválido.");
                    }
                }
                case 0 -> {
                    running = false;
                    System.out.println("Saindo do programa...");
                }
                default -> System.out.println("Opção inválida");
            }
        }
    }

    // Lê um int válido, repetindo até o usuário digitar certo
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // limpar buffer
                return value;
            } else {
                System.out.print(prompt);
                scanner.nextLine(); // descarta entrada inválida
            }
        }
    }

    // Lê um long positivo válido, repetindo até o usuário digitar certo
    private static long readPositiveLong(Scanner scanner) {
        while (true) {
            if (scanner.hasNextLong()) {
                long value = scanner.nextLong();
                scanner.nextLine(); // limpar buffer
                if (value >= 0) {
                    return value;
                } else {
                    System.out.print("Valor deve ser positivo. Tente novamente: ");
                }
            } else {
                System.out.print("Entrada inválida. Digite um número: ");
                scanner.nextLine(); // descarta entrada inválida
            }
        }
    }

    // Lê uma linha não vazia
    private static String readNonEmptyLine(Scanner scanner) {
        while (true) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            } else {
                System.out.print("Entrada não pode ser vazia. Tente novamente: ");
            }
        }
    }
}
