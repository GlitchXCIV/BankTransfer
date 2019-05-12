import java.util.ArrayList;

public class Register {
    private ArrayList<Bank> banks;

    public Register() {
        this.banks = new ArrayList<>();
    }

    public void insertBank(Bank bank) {
        this.banks.add(bank);
    }

    public Bank getBankById(String id) {
        for (int i = 0; i < this.banks.size(); i++) {
            if (this.banks.get(i).getIdBank().equals(id)) return this.banks.get(i);
        }
        return null;
    }

    public Bank getBankByIban(String iban) {
        String s = iban.substring(5, 15); //per predere la sotto stringa da un inizio ad una fine
        Bank b = this.getBankById(s);
        return b;
    }

    public Account getAccountByIban(String iban) {
        Bank b = this.getBankByIban(iban);
        return b.getAccountByIban(iban);
    }

    public String transfer(String iban1, String iban2, double tot) {
        Bank bank1 = this.getBankByIban(iban1);
        Bank bank2 = this.getBankByIban(iban2);
        Account account1 = this.getAccountByIban(iban1);
        Account account2 = this.getAccountByIban(iban2);
        double commission = 0;
        if (!(bank1.getIdBank().equals(bank2.getIdBank()))) commission = 1;
        account1.setCredit(account1.getCredit() - (tot + commission));
        account2.setCredit(account2.getCredit() + tot);
        bank1.setDepositBank(bank1.getDepositBank() + commission);
        return "Transazione effettuata da: " + iban1 + "a: " + iban2 + "di: €" + tot;
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }
}

