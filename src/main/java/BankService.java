import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class BankService {
    private Map<String, Account> accounts = new HashMap<>();

    public String openAccount(Client[] client) {
        String accountNumber = Long.toString(System.currentTimeMillis());
        accounts.put(accountNumber, new Account(accountNumber, new BigDecimal("0.00"), client));
        return accountNumber;
    }

    public void transfer(String accountFrom, String accountTo, BigDecimal amount) {
        if(accounts.containsKey(accountFrom) && accounts.containsKey(accountTo)) {
            accounts.get(accountFrom).withdrawMoney(amount);
            accounts.get(accountTo).depositMoney(amount);
        }
    }

    public List<String> split(String accountNumber) {
        List<String> newAccounts = new ArrayList<>();
        BigDecimal originalBalance = accounts.get(accountNumber).getBalance();
        int numberOfClients = accounts.get(accountNumber).getClient().length;
        BigDecimal devidedBalance = originalBalance.divide(BigDecimal.valueOf(numberOfClients), 2, RoundingMode.DOWN);
        for(int i = 0; i < numberOfClients; i++) {
            newAccounts.add(openAccount(new Client[] {accounts.get(accountNumber).getClient()[i]}));
            transfer(accountNumber, newAccounts.get(i), devidedBalance);
        }
        return newAccounts;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "BankService{" +
                "accounts=" + accounts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankService that = (BankService) o;
        return Objects.equals(accounts, that.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts);
    }

    public void
}
