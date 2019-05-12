public class Main {
    public static void main(String[] args) {
        Register register = new Register();

        Bank bank1 = new Bank("0103016917", 150);
        Bank bank2 = new Bank("0301046820", 500);
        Bank bank3 = new Bank("0602094678", 350);

        register.insertBank(bank1);
        register.insertBank(bank2);
        register.insertBank(bank3);

        bank1.insertAccount("12345010301691756789012", 20);
        bank1.insertAccount("56787010301691756789023", 250);
        bank2.insertAccount("56782030104682056789023", 100);
        bank3.insertAccount("91011060209467856789023", 500);

        System.out.println(bank1.getTotalCostumersCredit());
        System.out.println(bank2.getTotalCostumersCredit());
        System.out.println(bank3.getTotalCostumersCredit());

        register.transfer("12345010301691756789012", "56782030104682056789023", 10);
    }
}