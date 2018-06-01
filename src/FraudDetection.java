import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Transaction {
    static DateFormat df = new SimpleDateFormat("ddMMMyyy");
    private int score;
    private Date date;
    private boolean isFraud;
    private String country;
    private int amount;
    private long merchantId;

    public Transaction(String[] transactionInput) {
        this.score = Integer.parseInt(transactionInput[0]);
        try {
            this.date = df.parse(transactionInput[1]);
        } catch (Exception e) {}
        this.isFraud = (Integer.parseInt(transactionInput[2]) == 0) ? false : true;
        this.country = transactionInput[3];
        this.amount = Integer.parseInt(transactionInput[4]);
        this.merchantId = Long.parseLong(transactionInput[6]);
    }

    public long getMerchantId() {
        return this.merchantId;
    }
}

class Customer {

    private Long id;
    private List<Transaction> transactions;

    public Customer(Long id) {
        this.id = id;
        this.transactions = new ArrayList<Transaction>();
    }

    public void fraudCheck() {
        transactions.sort((t1,t2) -> (int) (t1.getMerchantId() - t2.getMerchantId()));
        Transaction curr = null;
        Iterator<Transaction> it = transactions.iterator();
        int counter = 1;
        while(it.hasNext()) {
            Transaction t = it.next();
            if (!t.equals(curr)) {
                curr = t;
                counter = 1;
            } else {
                counter++;
                if (counter >= 5) {
                    System.out.println(this.id);
                    break;
                }
            }
        }
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }
}

public class FraudDetection {

    static Customer findCustomer(List<Customer> list, Long id) {
        for (Customer c : list) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    static void removeDuplicates(List<Customer> customers) {
        Customer curr = null;
        Iterator<Customer> it = customers.iterator();
        while(it.hasNext()) {
            Customer c = it.next();
            if (!c.equals(curr)) {
                curr = c;
            } else {
                customers.remove(c);
            }
        }
    }

    static void parseInput(List<Customer> customers, String input) {
        String[] inputArr = input.split(",");
        Long customerId = Long.parseLong(inputArr[5]);
        Transaction t = new Transaction(inputArr);
        Customer c = findCustomer(customers, customerId);
        if (c == null) {
            c = new Customer(customerId);
            customers.add(c);
        }
        c.getTransactions().add(t);
    }

    static void printCustomerIds(List<Customer> customers) {
        customers.sort((c1,c2) -> (int) (c1.getId()-c2.getId()));
        for (Customer c : customers) {
            System.out.println(c.getId());
        }
    }

    public static void main(String[] args) throws Exception {
        List<Customer> customers = new ArrayList<>();
        Scanner scanner = new Scanner(new File("D:\\Repositories\\HackerRank\\src\\input.txt"));
        int scenario = scanner.nextInt();
        int input = scanner.nextInt();
        scanner.nextLine();
        while(input != 0) {
            String inputLine = scanner.nextLine();
            parseInput(customers, inputLine);
            input--;
        }
        switch (scenario) {
            case 1:
                printCustomerIds(customers);
            case 2:
                for (Customer c : customers) {
                    c.fraudCheck();
                }
        }
    }
}