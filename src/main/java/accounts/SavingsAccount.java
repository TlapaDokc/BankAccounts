package accounts;

public class SavingsAccount extends Account {
    protected long minBalance;

    public SavingsAccount(String name, long balance, long minBalance) {
        super(name, balance);
        this.minBalance = minBalance;
    }

    @Override
    public boolean pay(long amount) {
        if (balance - amount > minBalance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
