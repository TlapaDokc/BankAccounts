import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingsAccount;
import clients.Client;

public class Main {
    public static void main(String[] args) {
        Client clientPetya = new Client("Petya", 3);
        SavingsAccount savingsAccountOfPetya = new SavingsAccount("Сберегательный счет Пети", 100, 15);
        CheckingAccount checkingAccountOfPetya = new CheckingAccount("Расчетный счет Пети", 100);
        System.out.println(savingsAccountOfPetya.toString() + "\n" + checkingAccountOfPetya.toString());

        clientPetya.add(savingsAccountOfPetya);
        clientPetya.add(checkingAccountOfPetya);

        boolean status = savingsAccountOfPetya.transfer(checkingAccountOfPetya, 50);
        System.out.println(savingsAccountOfPetya.toString() +
                "\n" + checkingAccountOfPetya.toString() + "\n" + status); //  Успешный трансфер

        CreditAccount creditAccountOFPetya = new CreditAccount("Кредитный счет Пети", 0);
        clientPetya.add(creditAccountOFPetya);

        status = checkingAccountOfPetya.transfer(creditAccountOFPetya, 15);
        System.out.println(checkingAccountOfPetya.toString() +
                "\n" + creditAccountOFPetya.toString() +
                "\n" + status);  //  Не корректный трансфер

        status = clientPetya.accept(17);
        System.out.println(savingsAccountOfPetya.toString() +
                "\n" + checkingAccountOfPetya.toString() +
                "\n" + creditAccountOFPetya.toString() +
                "\n" + status);  //  Принятие денег клиентом

        status = checkingAccountOfPetya.accept(15);
        System.out.println(savingsAccountOfPetya.toString() +
                "\n" + checkingAccountOfPetya.toString() +
                "\n" + creditAccountOFPetya.toString() +
                "\n" + status);  // Принятие денег счетом

        status = creditAccountOFPetya.accept(200);
        System.out.println(savingsAccountOfPetya.toString() +
                "\n" + checkingAccountOfPetya.toString() +
                "\n" + creditAccountOFPetya.toString() +
                "\n" + status);   // Не корректное принятие денег
    }
}
