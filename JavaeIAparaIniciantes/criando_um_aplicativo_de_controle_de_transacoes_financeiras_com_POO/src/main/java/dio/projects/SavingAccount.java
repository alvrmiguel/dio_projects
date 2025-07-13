package dio.projects;

public class SavingAccount extends Account {

    public SavingAccount(Client client) {
        super(client, AccountType.SAVINGS);
    }

    @Override
    public void withdraw(long amount) {
        if (getMoney() >= amount) {
            setMoney(getMoney() - amount);
            getTransactions().add(new Transaction("WITHDRAW", amount));
        } else {
            System.out.println("Saldo insuficiente para saque na poupança.");
        }
    }
}
