public class Bank {
     public static void main(String[] args)
     {
    	 BankAccount amount = new BankAccount("John","1000254",1000.0);
    	 amount.deposit(500.0);
    	 amount.withdraw(300.0);
    	 amount.display();
    	 System.out.println("Current Balance: "+amount.getBalance());
     }
}
