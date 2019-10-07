
public class BankAccount {
    private String name;
    private double accountBalance;

    /**
     * Initializes a new BankAccount.
     *
     * @param in_name The name of the account owner.
     * @param in_accountBalance The starting balance for the account.
     */
    public BankAccount(String in_name, double in_accountBalance)
    {
        this.name = in_name;
        this.accountBalance = in_accountBalance;
    }

    /**
     * @return The name of the account owner.
     */
    public String GetName()
    {
        return this.name;
    }

    /**
     * @return The current account balance.
     */
    public double GetBalance()
    {
        return this.accountBalance;
    }

    /**
     * Deposits money into the account.
     * If the requested deposit amount is not a positive number, the account balance is unchanged
     * and the following error message is displayed to the user :
     *
     *   "Sorry, the amount deposited must be greater than 0."
     *
     * @param amount The amount to deposit into the account. Must be a positive number.
     * @return The amount deposited into the account. If no money could be deposited due to an error, return zero.
     */
    public double Deposit(double amount)
    {
        if (amount <= 0) {
            return 0;
        }

        this.accountBalance += amount;

        return amount;
    }

    /**
     * Withdraws money from the account. The user must withdraw a positive amount of money,
     * AND the user cannot withdraw more money than the current account balance, i.e. the user
     * cannot withdraw more money than they have. One of the following error messages is displayed
     * to the user, depending on the error reason:
     *
     *   "Sorry, the amount withdrawn must be greater than 0."
     *   "Sorry, you cannot withdraw more than the account balance."
     *
     * @param amount The amount to withdraw from the account. Must be a positive number.
     * @return The amount withdrawn from the account. If the requested amount could not be withdrawn due to an error,
     *   returns zero.
     */
    public double Withdraw(double amount)
    {
        if (amount <= 0) {
            return 0;
        }

        if (this.accountBalance < amount) {
            return 0;
        }

        this.accountBalance -= amount;
        return amount;
    }

    /**
     * Returns a string representation of a BankAccount object. The string looks like this:
     * 
     *      Name: Serena Williams
     *      Account Balance: 1000000.00
     * 
     * @return String
     */
    public String toString() {
        return String.format("Name: %s\nAccount balance: %.2f", this.name, this.accountBalance);
    }
}
