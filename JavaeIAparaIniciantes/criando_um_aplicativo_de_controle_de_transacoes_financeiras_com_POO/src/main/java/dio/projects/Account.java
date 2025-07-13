package dio.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Account {

    private UUID uuid;
    private long money;
    private Client client;
    private AccountType accountType;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(Client client, AccountType accountType) {
        this.uuid = UUID.randomUUID();
        this.client = client;
        this.money = 0;
        this.accountType = accountType;
    }

    public void deposit(long amount) {
        this.money += amount;
        transactions.add(new Transaction("DEPOSIT", amount));
    }

    public abstract void withdraw(long amount);

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void showExtract() {
        System.out.println("=== Extrato ===");
        System.out.println("Titular: " + client.getName());
        System.out.println("UUID: " + uuid);
        System.out.println("Tipo: " + accountType);
        System.out.println("Saldo: " + money);
        System.out.println("--- Transações ---");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }


    public AccountType getAccountType() {
        return accountType;
    }

    // Getters
    public long getMoney() { return money; }
    public UUID getUuid() { return uuid; }
    public Client getClient() { return client; }

    // Setter protegido se precisar
    protected void setMoney(long money) { this.money = money; }
}
