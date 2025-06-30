public abstract class Account {
    protected String id;
    protected String name;
    protected int balance;

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getBalance() {
        return balance;
    }

    public void credit(int amount) {
        balance += amount;
    }

    public abstract void debit(int amount);

    public abstract boolean canTransfer();

    public abstract void applyInterest();

    public String toString() {
        return this.getClass().getSimpleName() + "[id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}
