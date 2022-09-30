import accounts.CreditAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тестирование: CreditAccount")
class CreditAccountTest {
    @Test
    @DisplayName("Тестирование: метода pay при true")
    void payTrue() {
        CreditAccount creditAccount = new CreditAccount("Lida", -50);
        Assertions.assertEquals(true, creditAccount.pay(150));
    }

    @Test
    @DisplayName("Тестирование: метода pay при false")
    void payFalse() {
        CreditAccount creditAccount = new CreditAccount("Lida", 100);
        Assertions.assertEquals(false, creditAccount.pay(50));
    }

    @Test
    @DisplayName("Тестирование: метода add при true")
    void addTrue() {
        CreditAccount creditAccount = new CreditAccount("Tata", -100);
        Assertions.assertEquals(true, creditAccount.add(50));
    }

    @Test
    @DisplayName("Тестирование: метода add при false")
    void addFalse() {
        CreditAccount creditAccount = new CreditAccount("Tata", -100);
        Assertions.assertEquals(false, creditAccount.add(150));
    }
}
