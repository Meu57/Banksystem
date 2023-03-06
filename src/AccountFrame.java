import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

/**Creating class with extension of JFrame*/
public class AccountFrame extends JFrame{
    /**JLabel Variables*/
    JLabel accNoLBL, ownerLBL, balanceLBL, cityLBL,genderLBL,amountLBL;
    /**JTextField Variables*/
    JTextField accNoTXT, ownerTXT, balanceTXT, amountTXT;
    /**JComboBox Variables*/
    JComboBox<City> citiesCMB;
    /**JButton Variables*/
    JButton newBTN,saveBTN,showBTN,quitBTN,depositBTN,withdrawBTN;
    /**JRadioButton Variables*/
    JRadioButton maleRDB, femaleRDM;
    /**ButtonGroup Variables*/
    ButtonGroup genderBTNGRP;
    /**JList Variables*/
    JList<Account> accountsList;
    /**JPanel Variables*/
    JPanel p1,p2,p3,p4,p5;
    /**Set Variable*/
    Set<Account> accountSet = new TreeSet<>();
    /**Account Class Variables*/
    Account acc,x;

    boolean newRec = true;
    /**ComboBox data*/
    DefaultComboBoxModel<City> citiesCMBMDL;
    DefaultListModel<Account> accountsLSTMDL;

    /**Table Data*/
    JTable table;


    /**table Creation using DefaultTableModel and JTable*/
    DefaultTableModel tableModel = new DefaultTableModel();
    ArrayList<Transaction> translist= new ArrayList<>();
/**Constructor*/
    public AccountFrame(){
       super("Account Operations");
       setLayout(null);
       setVisible(true);
       setSize(600,400);
    /**Adding Components to the Frame*/

        /**JLabels*/
        accNoLBL= new JLabel("Account No");
        ownerLBL= new JLabel("Owner");
        balanceLBL= new JLabel("Balance");
        cityLBL = new JLabel("City");
        genderLBL= new JLabel("Gender");
        amountLBL= new JLabel("Amount");

        /**JTextFields*/
        accNoTXT= new JTextField();accNoTXT.setEnabled(false);
        ownerTXT = new JTextField();
        balanceTXT= new JTextField();balanceTXT.setEnabled(false);
        amountTXT= new JTextField();
        amountTXT.setPreferredSize(new Dimension(150,25));

        /**ComboBoxModel*/
        citiesCMBMDL = new DefaultComboBoxModel<>();
        citiesCMBMDL.addElement(new City("Jaipur","Rajasthan"));
        citiesCMBMDL.addElement(new City("Tonk","Rajasthan"));
        citiesCMBMDL.addElement(new City("Jodhpur","Rajasthan"));
        citiesCMBMDL.addElement(new City("Jaisalmer","Rajasthan"));
        citiesCMBMDL.addElement(new City("Ajmer","Rajasthan"));
        citiesCMBMDL.addElement(new City("Karoli","Rajasthan"));
        citiesCMBMDL.addElement(new City("Bheelwadah","Rajasthan"));
        citiesCMBMDL.addElement(new City("SawaiMadhupur","Rajasthan"));

        /**Adding data to JComboBox*/
        citiesCMB= new JComboBox<City>(citiesCMBMDL);

        /**Radio Buttons*/
        maleRDB= new JRadioButton("Male",true);
        femaleRDM= new JRadioButton("Female");
        //assigning value to Button groups
        genderBTNGRP= new ButtonGroup();
        genderBTNGRP.add(maleRDB);
        genderBTNGRP.add(femaleRDM);

        /**Buttons newBTN,saveBTN,showBTN,quitBTN,depositBTN,withdrawBTN*/
        newBTN= new JButton("New");
        saveBTN= new JButton("Save");
        showBTN= new JButton("Show");
        quitBTN= new JButton("Quit");
        depositBTN= new JButton("Deposit");
        withdrawBTN= new JButton("Withdraw");

        /**DefaultListModel*/
        accountsLSTMDL= new DefaultListModel<>();
        accountsList= new JList<>(accountsLSTMDL);

        /**JPanels p1,p2,p3,p4,p5 */
        p1= new JPanel();p1.setBounds(5,5,300,150);
        p1.setLayout(new GridLayout(5,2));
        /**JPanel P2*/
        p2= new JPanel(); p2.setBounds(5,155,300,40);
        p2.setLayout(new FlowLayout());
        /**JPanel P3*/
        p3= new JPanel(); p3.setBounds(5,195,600,40);
        p3.setLayout(new FlowLayout());
        /**JPanel P4*/
        p4 = new JPanel(); p4.setBounds(305,5,300,190);
        p4.setLayout(new BorderLayout());
        /**Panel P5*/
        p5= new JPanel(); p5.setBounds(5,240,580,120);
        p5.setLayout(new BorderLayout());

    /**Adding components to Panel*/

        /**adding components to p1*/
        p1.add(accNoLBL);
        p1.add(accNoTXT);
        p1.add(ownerLBL);
        p1.add(ownerTXT);
        p1.add(balanceLBL);
        p1.add(balanceTXT);
        p1.add(cityLBL);
        p1.add(citiesCMB);
        p1.add(maleRDB);
        p1.add(femaleRDM);
        /**adding components to p2*/
        p2.add(newBTN);
        p2.add(saveBTN);
        p2.add(showBTN);
        p2.add(quitBTN);
        /**adding components to p3*/
        p3.add(amountLBL);
        p3.add(amountTXT);
        p3.add(depositBTN);
        p3.add(withdrawBTN);
        /**adding components to p4*/
        p4.add(accountsList);

        /**Adding Components to Frame*/
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);


        table= new JTable(tableModel);
        tableModel.addColumn("Trans.No.");
        tableModel.addColumn("Trans.Data");
        tableModel.addColumn("Trans.Type");
        tableModel.addColumn("Trans.Amount");
/**creating JScrollPane for JTable*/
        JScrollPane scrollPane = new JScrollPane(table);
        /**adding JScrollPane to Panel p5*/
        p5.add(scrollPane);

        /****************Functionality****************/
        /**Functionality of newBTN
         * ActionListener
         * newBTNListener
         * */
newBTN.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        accNoTXT.setText("");
        ownerTXT.setText("");
        citiesCMB.setSelectedIndex(0);
        maleRDB.setSelected(true);
        balanceTXT.setText("");
        amountTXT.setText("");
        newRec= true;

    }
});
/**Functionality of saveBTN.
 * ActionListener
 * saveBTNListener
 * */
saveBTN.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(newRec){
            if(ownerTXT.getText().length()!=0){
acc = new Account(ownerTXT.getText(),(City) citiesCMB.getSelectedItem(),maleRDB.isSelected()?'M':'F');
accNoTXT.setText(String.valueOf(acc.AccNo));
accountSet.add(acc);
accountsLSTMDL.addElement(acc);
newRec = false;
}else{
                JOptionPane.showMessageDialog(null,"Please Fill All Fields");
            }
        }else{
accountSet.remove(acc);
int account = Integer.parseInt(accNoTXT.getText());
String owner = ownerTXT.getText();
City city =(City) citiesCMB.getSelectedItem();
char gender = maleRDB.isSelected()?'M':'F';
double balance = Double.parseDouble(balanceTXT.getText());
acc = new Account(account,owner,city,gender,balance);
accountSet.add(acc);
accountsLSTMDL.setElementAt(acc,accountsList.getSelectedIndex());
newRec= false;
        }
    }
});

/**Functionality of showBTN.
 * ActionListener
 * showBTNListener
 * */
showBTN.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String s= "";
        Iterator<Account> iterator = accountSet.iterator();
        while(iterator.hasNext()){
            s+=iterator.next().toString()+"\n";
            JOptionPane.showMessageDialog(null,s);
        }
    }
});
/**Functionality of depositBTN.
 * ActionListener
 * depositBTNListener
 * */
depositBTN.addActionListener(new ActionListener() {
    /**
     * @param e the event to be processed 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!newRec && amountTXT.getText().length() !=0){
            /**Adding Transaction to table*/
            Transaction transaction= new Transaction(acc, LocalDate.now(),"Deposit",Double.parseDouble(amountTXT.getText()));
            DisplayTransactionInTable(transaction);

            /**perform deposit from account*/
            acc.deposit(Double.parseDouble(amountTXT.getText()));
            balanceTXT.setText(String.valueOf(acc.balance));
        }
    }
});
    }
    /**
     * Displays the given transaction in the transaction table.
     *
     * @param transaction the transaction to display in the table
     */

    private void DisplayTransactionInTable(Transaction transaction) {
        /**Displaying data into the table*/
        tableModel.addRow(new Object[]{
                transaction.getTrsNo(),
                transaction.getDate(),
                transaction.getOperation(),
                transaction.getAmount()

        });
        withdrawBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!newRec &&amountTXT.getText().length()!=0){
                    /**Adding Transaction */
                    Transaction transaction1= new Transaction(
                            acc, LocalDate.now(),"Withdrawal",Double.parseDouble(amountTXT.getText()));
                DisplayTransactionInTable(transaction1);

                /**perform withdrawal on account*/
                acc.withdraw(Double.parseDouble(amountTXT.getText()));
                balanceTXT.setText(String.valueOf(acc.balance));
                }
            }
        });

        accountsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                acc= x=accountsList.getSelectedValue();
                accNoTXT.setText(String.valueOf(acc.AccNo));
                ownerTXT.setText(acc.owner);
                if(acc.gender == 'M')maleRDB.setSelected(true);
                else femaleRDM.setSelected(true);
                balanceTXT.setText(String.valueOf(acc.balance));
                amountTXT.setEnabled(true);
                depositBTN.setEnabled(true);
                newRec = false;

                /**Clear Table*/
                for(int i= tableModel.getRowCount()-1;i>=0;i--){
                    tableModel.removeRow(i);
                }
                /**Get Transactions to selected Account*/
                SearchTransactionList(acc.AccNo);
            }
        });
    }
    /**

     Searches for all transactions in the transaction list that belong to the specified account number and displays the data in a table.

     @param accNo The account number to search for.
     */
    private void SearchTransactionList(int accNo) {
        List<Transaction> filteredList = new ArrayList<>();

        /**Iterate through List*/
        for (Transaction transaction : translist) {
            /**filter values that contains trsNo*/
            if (transaction.getAcc().AccNo == accNo) {
                filteredList.add(transaction);
            }
        }
        /**Displaying data into table*/
        for (int i = 0; i < filteredList.size(); i++) {
            tableModel.addRow(new Object[]{
                    filteredList.get(i).getTrsNo(),
                    filteredList.get(i).getDate(),
                    filteredList.get(i).getOperation(),
                    filteredList.get(i).getAmount()
            });
        }
    }
    /**

     This is the main method of the program. It creates an instance of the AccountFrame class
     and sets the default close operation for the frame.
     @param args The command line arguments.
     */
    public static void main(String[] args){
        AccountFrame af= new AccountFrame();
        af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
