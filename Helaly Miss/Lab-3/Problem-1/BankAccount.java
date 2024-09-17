public class BankAccount {
   public String name,id;
   public double balance;
   
   public BankAccount(String name,String id,double balance)
   {
	   this.name=name;
	   this.id=id;
	   this.balance=balance;
   }
   
   public void deposit(double depAmount)
   {
	   balance+=depAmount;
   }
   public void withdraw(double withAmount)
   {
	   if(withAmount<=balance)
	   {
		   balance-=withAmount;
	   }
	   else
	   {
		   System.out.println("Insuficient Balance");
	   }
   }
   public void display()
   {
	   System.out.println("Name:"+name+"\nId:"+id+"\nBalance:"+balance);
   }
   public double getBalance()
   {
	   return balance;
   }
   
}
