import java.util.ArrayList;

public class Bank {
    private String idBank;
    private double depositBank;
    private ArrayList<Account> accounts;

    public Bank(String idBank, double depositBank) {
        this.idBank = idBank;
        this.depositBank = depositBank;
        this.accounts = new ArrayList<>();
    }

    public double getTotalCostumersCredit() {
        double s = 0;
        for (int i = 0; i < this.accounts.size(); i++) {
            s += this.accounts.get(i).getCredit();
        }
        return s;
    }

    public Account getAccountByIban(String ibanAccount) {
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).getIban().equals(ibanAccount)) return this.accounts.get(i);
        }
        return null;
    }

    public String getIdBank() {
        return idBank;
    }

    public double getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(double depositBank) {
        this.depositBank = depositBank;
    }

    public void insertAccount(String iban, double credit) {
        Account account = new Account(iban, credit);
        this.accounts.add(account);
    }
}