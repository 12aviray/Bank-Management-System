import java.util.*;

public class AccountManager {
    private List<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        // Add default accounts
        accounts.add(new CurrentAccount("A001", "Alice", 5000));
        accounts.add(new SavingsAccount("A002", "Bob", 3000));
        accounts.add(new DepositPremiumAccount("A003", "Charlie", 0));

        while (true) {
            System.out.println("\nChoose option:");
            System.out.println("1. Create Account");
            System.out.println("2. Debit");
            System.out.println("3. Credit");
            System.out.println("4. Transfer");
            System.out.println("5. Show Accounts");
            System.out.println("6. Apply Interest");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> debit();
                case 3 -> credit();
                case 4 -> transfer();
                case 5 -> showAccounts();
                case 6 -> applyInterest();
                case 7 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void createAccount() {
        System.out.println("Enter type (1. Current, 2. Savings, 3. Deposit Premium): ");
        int type = sc.nextInt();
        sc.nextLine();
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Initial balance: ");
        int bal = sc.nextInt();

        Account acc = switch (type) {
            case 1 -> new CurrentAccount(id, name, bal);
            case 2 -> new SavingsAccount(id, name, bal);
            case 3 -> new DepositPremiumAccount(id, name, bal);
            default -> null;
        };

        if (acc != null) {
            accounts.add(acc);
            System.out.println("Account created.");
        } else {
            System.out.println("Invalid account type.");
        }
    }

    private void debit() {
        System.out.print("Account ID: ");
        String id = sc.nextLine();
        Account acc = findAccount(id);
        if (acc != null) {
            System.out.print("Amount to debit: ");
            int amt = sc.nextInt();
            acc.debit(amt);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void credit() {
        System.out.print("Account ID: ");
        String id = sc.nextLine();
        Account acc = findAccount(id);
        if (acc != null) {
            System.out.print("Amount to credit: ");
            int amt = sc.nextInt();
            acc.credit(amt);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void transfer() {
        System.out.print("From Account ID: ");
        String fromID = sc.nextLine();
        System.out.print("To Account ID: ");
        String toID = sc.nextLine();
        System.out.print("Amount: ");
        int amt = sc.nextInt();

        Account from = findAccount(fromID);
        Account to = findAccount(toID);

        if (from != null && to != null) {
            if (from.canTransfer()) {
                from.debit(amt);
                to.credit(amt);
                System.out.println("Transfer complete.");
            } else {
                System.out.println("Transfer not allowed from this account type.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    private void applyInterest() {
        for (Account acc : accounts) {
            acc.applyInterest();
        }
        System.out.println("Interest applied to all accounts.");
    }

    private void showAccounts() {
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }

    private Account findAccount(String id) {
        for (Account acc : accounts) {
            if (acc.getID().equalsIgnoreCase(id)) return acc;
        }
        return null;
    }

    public static void main(String[] args) {
        new AccountManager().start();
    }
}
