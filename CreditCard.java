public class CreditCard{
    private String customer;
    private String bank;
    private string account;
    private int limit;
    protected double balance;
    
    public CreditCard(String cust,String bk,String acnt,int lim,double initial Bal){
        customer = cust;
        bank = bk;
        account = acnt;
        limit = lim;
        balance = initialBal;
    }
    public CreditCard(String cust,String bk,String acnt,int lim){
        this(cust,bk,acnt,lim,0.0);
    }
    public String getCustomer(){
        return customer;
    }
    public String getBank(){
        return bank;
    }
    public String getAccount(){
        return account;
    }
    public int getLimit(){
        return limit;
    } 
    public double getBalance(){
        return balance;
    }
    public boolean Charge(double price){
        if(balance + price <= limit){
            balance += price;
            return true;
            else{
                return false;
            }
        }
    }
     public void makePayment(double amount){
        balance -= amount;
    }   
}
public static void printSummery(CreditCard card){
    System.out.println("Customer = "+ card.customer);
    System.out.println("Bank = "+ card.bank);
    System.out.println("Account = "+ card.account);
    System.out.println("balance = "+ card.balance);
    System.out.println("Limit = "+ card.limit);
}
public static void main(String args[]){
    CreditCard[] wallet = new CreditCard[3];
    wallet[0] = new CreditCard ("Nimal","HNB","5391 0375 9387 5309",5000);
    wallet[1] = new CreditCard ("Malar","NSB","3485 0399 3395 1954",3000);
    wallet[2] = new CreditCard ("Vijaya","BOC","5391 0375 9387 5309",2500,300);
    
    for(int val = 1; val<= 16;val++){
        wallet[0].charge(3*val);
        wallet[1].charge(2*val);
        wallet[2].charge(val);
    }
    for(CreditCard card : wallet){
        CreditCard.printSummery(card);
        while(card.getBalance()>200.0){
            card.makePayment(200);
            System.out.println("New balance = "+ card.getBalance());
        }
    }
}