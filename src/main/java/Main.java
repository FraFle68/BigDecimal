import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankService nepperBank = new BankService();
        Client[] client01 = {new Client("Frank", "Fleischer", new BigDecimal("123"))};
        Client[] client02 = {new Client("Axel", "Schweiss", new BigDecimal("456")),
                new Client("Rainer", "Zufall", new BigDecimal("678"))};

        String account01 = nepperBank.openAccount(client01);
        nepperBank.getAccounts().get(account01).depositMoney(new BigDecimal("1256.45"));
        System.out.println(account01);

        String account02 = nepperBank.openAccount(client02);
        nepperBank.getAccounts().get(account02).depositMoney(new BigDecimal("34698.96"));
        System.out.println(account02);

        System.out.println(nepperBank);

        List<String> splittedAccounts = new ArrayList<>();
        splittedAccounts = nepperBank.split(account02);
        System.out.println(splittedAccounts);
        System.out.println(nepperBank.getAccounts().get(splittedAccounts.get(0)).getBalance());
    }
}
