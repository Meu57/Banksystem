import java.util.Date;

/**

 Represents an account object with basic information like account number, owner name, city, gender, and balance.
 */
public class Account implements Comparable {

    //Variables
    static int nextAccNo=10;
    int AccNo;
    String owner;
    City city;
    char gender;
    double balance;
    Date openDate;

    /**
     * Default constructor for the Account class.
     */
    public Account() {
    }

    /**
     * Constructor for the Account class that takes the owner's name, city, and gender as parameters.
     *
     * @param owner the name of the account owner
     * @param city the city where the account owner lives
     * @param gender the gender of the account owner
     */
    public Account(String owner, City city, char gender) {
        this.owner = owner;
        nextAccNo +=10;
        this.city = city;
        this.gender = gender;
        balance =0.0;
        openDate= null;
    }

    /**
     * Constructor for the Account class that takes the account number, owner's name, city, gender, and balance as parameters.
     *
     * @param accNo the account number
     * @param owner the name of the account owner
     * @param city the city where the account owner lives
     * @param gender the gender of the account owner
     * @param balance the account balance
     */
    public Account(int accNo, String owner, City city, char gender, double balance) {
        AccNo = accNo;
        this.owner = owner;
        this.city = city;
        this.gender = gender;
        this.balance = balance;
        setBalance(balance);
    }

    /**
     * Sets the account balance.
     *
     * @param balance the account balance
     */
    public void setBalance(double balance) {
        this.balance= balance>0.0 ? balance:0.0;
    }

    /**
     * Returns a string representation of the Account object.
     *
     * @return a string representation of the Account object
     */
    @Override
    public String toString() {
        return AccNo+" "+owner+" "+city.cityName+" "+gender+" "+balance;
    }

    /**
     * Compares this Account object with the specified object for order based on the account owner's name.
     *
     * @param o the object to be compared
     * @return a negative integer, zero, or a positive integer as this Account object is less than, equal to, or greater than the specified object
     */
    @Override
    public int compareTo(Object o) {
        return this.owner.compareTo(((Account) o).owner);
    }

    /**
     * Deposits the specified amount to the account.
     *
     * @param amount the amount to be deposited
     */
    public void deposit(double amount){
        if(amount>0){
            setBalance(balance + amount);
        }
    }

    /**
     * Withdraws the specified amount from the account.
     *
     * @param amount the amount to be withdrawn
     * @return the amount withdrawn from the account
     */
    public double withdraw(double amount){
        if(amount>0){
            if(amount<balance){
                setBalance(balance - amount);
            }else{
                amount = balance;
                setBalance(0.0);
            }
            return amount;
        }
        return 0.0;
    }
}
