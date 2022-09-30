package clients;

import accounts.Account;

public class Client implements MoneyTarget {
    protected String name;
    protected int maxAccounts;
    protected Account[] accounts = new Account[maxAccounts];

    public Client(String name, int maxAccounts) {
        this.name = name;
        this.maxAccounts = maxAccounts;
        this.accounts = new Account[maxAccounts];
    }

    public void add(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return;
            }
        }
        System.out.println("Мест для добавления нового счёта нет! :(");
    }

    public boolean pay(long amount) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                boolean status = accounts[i].pay(amount);
                if (status) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean accept(int money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                if (accounts[i].add(money)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}