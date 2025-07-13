package dio.projects;

public class CheckingAccount extends Account {
    public CheckingAccount(Client client) {
        super(client, AccountType.CHECKING);
    }

    @Override
    public void withdraw(long amount) {
        if (getMoney() >= amount) {
            setMoney(getMoney() - amount);
            getTransactions().add(new Transaction("WITHDRAW", amount));
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

}

