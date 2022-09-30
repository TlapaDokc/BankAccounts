package accounts;

import clients.MoneyTarget;

public abstract class Account implements MoneyTarget {
    protected String name;
    protected long balance;

    public Account(String name, long balance) {
        this.balance = balance;
        this.name = name;
    }

    public String toString() {
        return name + ": " + balance;
    }

    public abstract boolean pay(long amount);

    public boolean add(long amount) {
        if (balance + amount >= 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean transfer(Account accountTo, int amount) {
        if (accountTo.add(amount)) {
            if (this.pay(amount)) {
                return true;
            } else {
                accountTo.pay(amount);
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean accept(int money) {
        if (add(money)) {
            return true;
        } else {
            return false;
        }
    }
}
