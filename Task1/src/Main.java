public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Даша");
        BankAccount account2 = new BankAccount("Таня");

        System.out.println("Имя первого владельца: " + account1.getOwnerName());
        System.out.println("Имя второго владельца: " + account2.getOwnerName());

        System.out.println("Пополнение счёта Даши: " + account1.deposit(2000));
        System.out.println("Перевод денег со счёта Даши на Тане: " + account1.transfer(account2, 500));

        System.out.println("Баланс счёт Тани: " + account2.getBalance() + " Снялось ли со счёта Тани 600:  " + account2.withdraw(600));
        System.out.println("Баланс счёт Даши: " + account1.getBalance() + " Снялось ли со счёта Даши 1000:  " + account1.withdraw(1000));

        System.out.println("Счёт Даши заблокирован");
        account1.setBlocked(true);
        System.out.println("Перевод Даши на счёт Тани в размере 200: " + account1.transfer(account2, 200));

        System.out.println();
        System.out.println("Доп. задания");
        System.out.println("Даша " + account1);
        System.out.println("Таня " + account2);

        System.out.println("Равны ли счета владельцев 1 и 2: " + account1.equals(account2));
        BankAccount account3 = new BankAccount("Даша");
        System.out.println("Равны ли счета владельцев 1 и 3: " + account1.equals(account3));

        System.out.println("hashCode Даши: " + account1.hashCode());
        System.out.println("hashCode Тани: " + account2.hashCode());
        System.out.println("hashCode ещё одной Даши: " + account3.hashCode());
    }
}