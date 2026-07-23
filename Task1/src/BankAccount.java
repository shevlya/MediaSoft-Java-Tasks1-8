import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class BankAccount {
    private String ownerName;
    private int balance;
    private LocalDateTime openDate;
    private boolean isBlocked;
    private final String number;

    public BankAccount(String ownerName){
        this.ownerName = ownerName;
        this.balance = 0;
        this.openDate = LocalDateTime.now();
        this.isBlocked = false;
        this.number = generateRandomNumber();
    }

    private String generateRandomNumber(){
        Random random = new Random();
        StringBuilder numberStr = new StringBuilder();
        for(int i = 0; i < 8; i++){
            int number = random.nextInt(10);
            numberStr.append(number);
        }
        return numberStr.toString();
    }

    public boolean deposit(int amount){
        if(amount <= 0){
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(int amount){
        if(isBlocked || amount <= 0 || balance < amount){
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transfer(BankAccount otherAccount, int amount){
        if(isBlocked || amount <= 0 || balance < amount || otherAccount.isBlocked){
            return false;
        }
        this.balance -= amount;
        otherAccount.balance += amount;
        return true;
    }

    @Override
    public String toString(){
        return "Информация о счёте{\n" +
                "\tимя владельца:'" + ownerName + "'\n" +
                "\tбаланс:'" + balance + "'\n" +
                "\tдата открытия:'" + openDate + "'\n" +
                "\tзаблокирован:'" + isBlocked + "'\n" +
                "\tномер счёта:'" + number + "'\n" + '}';
    }

    @Override
    public boolean equals(Object newObject){
        if (this == newObject) return true;
        if(!(newObject instanceof BankAccount bankAccount)) return false;
        return Objects.equals(number, bankAccount.number);
    }

    @Override
    public int hashCode(){
        return Objects.hash(number);
    }

    public String getOwnerName(){
        return ownerName;
    }
    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }
    public int getBalance(){
        return balance;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public LocalDateTime getOpenDate(){
        return openDate;
    }
    public void setOpenDate(LocalDateTime openDate){
        this.openDate = openDate;
    }
    public boolean isBlocked(){
        return isBlocked;
    }
    public void setBlocked(boolean isBlocked){
        this.isBlocked = isBlocked;
    }
    public String getNumber(){
        return number;
    }
}