public class SavingsAccount extends Account {
    public SavingsAccount(String id, String name, int balance) {
        super(id, name, balance);
    }

    @Override
    public void debit(int amount) {
        if ((balance - amount) >= 1000) {
            balance -= amount;
        } else {
            System.out.println("Cannot withdraw. Minimum balance of 1000 must be maintained.");
        }
    }

    @Override
    public boolean canTransfer() {
        return (balance >= 1000);
    }

    @Override
    public void applyInterest() {
        balance += (int)(balance * 0.025);
    }
}


