import java.io.Serializable;
import java.time.LocalDate;
/**

 The Transaction class represents a transaction performed on an account, such as a deposit or withdrawal.

 Each transaction is identified by a unique transaction number, and contains information such as the date,

 the account object, the type of operation (Deposit or Withdrawal), and the amount of money involved.
 */
public class Transaction implements Comparable<Transaction>, Serializable {

    // Variables
    private static int next = 1;
    int trsNo;
    Account acc;
    LocalDate date;
    String operation;
    double amount;

    /**
     * Constructs a new Transaction object.
     *
     * @param acc The account object for this transaction.
     * @param date The date of this transaction.
     * @param operation The type of operation being performed ('Deposit' for deposit or 'Withdrawal' for withdrawal).
     * @param amount The amount of money involved in this transaction.
     */
    public Transaction(Account acc, LocalDate date, String operation, double amount) {
        this.trsNo = next++;
        this.acc = acc;
        this.date = date;
        this.operation = operation;
        this.amount = amount;
    }

    /**
     * Compares this Transaction object with another Transaction object based on the transaction number.
     *
     * @param o The other Transaction object to compare to.
     * @return An integer value indicating the comparison result.
     */
    @Override
    public int compareTo(Transaction o) {
        return this.trsNo - o.trsNo;
    }

    /**
     * Returns a string representation of this Transaction object.
     *
     * @return A string representation of this Transaction object.
     */
    @Override
    public String toString() {
        return "Transaction{" +
                "trsNo=" + trsNo +
                ", acc=" + acc +
                ", date=" + date +
                ", operation=" + operation +
                ", amount=" + amount +
                '}';
    }

    /**
     * Returns the transaction number of this Transaction object.
     *
     * @return The transaction number of this Transaction object.
     */
    public int getTrsNo() {
        return trsNo;
    }

    /**
     * Returns the account object of this Transaction object.
     *
     * @return The account object of this Transaction object.
     */
    public Account getAcc() {
        return acc;
    }

    /**
     * Returns the date of this Transaction object.
     *
     * @return The date of this Transaction object.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns the type of operation being performed in this Transaction object.
     *
     * @return The type of operation being performed in this Transaction object ('D' for deposit or 'W' for withdrawal).
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Returns the amount of money involved in this Transaction object.
     *
     * @return The amount of money involved in this Transaction object.
     */
    public double getAmount() {
        return amount;
    }
}