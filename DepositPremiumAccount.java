
    public class DepositPremiumAccount extends Account {
        private int installmentsPaid = 0;
        private final int totalInstallments = 5;

        public DepositPremiumAccount(String id, String name, int balance) {
            super(id, name, balance);
        }

        @Override
        public void credit(int amount) {
            super.credit(amount);
            installmentsPaid++;
            System.out.println("Installment " + installmentsPaid + "/5 paid.");
        }

        @Override
        public void debit(int amount) {
            if (installmentsPaid >= totalInstallments) {
                if (amount <= balance) {
                    balance -= amount;
                } else {
                    System.out.println("Insufficient balance.");
                }
            } else {
                System.out.println("Cannot withdraw before all 5 installments are paid.");
            }
        }

        @Override
        public boolean canTransfer() {
            return installmentsPaid >= totalInstallments;
        }

        @Override
        public void applyInterest() {
            balance += (int)(balance * 0.07);
        }
    }


