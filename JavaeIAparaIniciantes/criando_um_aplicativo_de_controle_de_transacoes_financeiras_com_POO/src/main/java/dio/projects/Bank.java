package dio.projects;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Bank {

    private Map<UUID, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getUuid(), account);
    }

    public Account findAccount(UUID uuid) {
        return accounts.get(uuid);
    }

    public void listAccounts() {
        for (Account account : accounts.values()) {
            System.out.println("UUID: " + account.getUuid() + " | Cliente: " + account.getClient().getName() + " | Saldo: " + account.getMoney());
        }
    }
}
