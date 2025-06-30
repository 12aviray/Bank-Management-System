public class CurrentAccount extends Account {
    public CurrentAccount(String id, String name, int balance) {
        super(id, name, balance);
    }

    @Override
    public void debit(int amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public boolean canTransfer() {
        return true;
    }

    @Override
    public void applyInterest() {
        // No interest
    }
}


