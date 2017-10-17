package assignment8_2;//package name
import java.util.Scanner;//Scanner package


class PrimewithThread extends Thread{//PrimeThread class extends thread
	
	private int primeNum;//Declaring primeNumber instance variable
	
	public PrimewithThread(int num){//Single argument constructor to accept the number input passed by user
		this.primeNum=num;
		
	}
	
	@Override
    public void run() {//implementing run method
        System.out.println("MyThread - START "+Thread.currentThread().getName());
        Assignment8_2.evaluatePrime(primeNum);//calling static method in other class to evaluate prime number or not
        System.out.println("MyThread - END "+Thread.currentThread().getName());
    }
	
}

class Prime implements Runnable
{
	private int primeNum;//Declaring primeNumber instance variable
	
	public Prime(int num){//Single argument constructor to accept the number input passed by user
		this.primeNum=num;
	}
	
	@Override
    public void run()//implementing run method
    {
    	Assignment8_2.evaluatePrime(primeNum);//calling static method in other class to evaluate prime number or not
              
        
    }
}

public class Assignment8_2 {
	 
	//method to evaluate prime number
	public static void evaluatePrime(int num){
		int cnt=0;//declaring local variable count
	    //logic to find out the prime number
		
		for(int i=2;i<=num/2;i++)
	         if(num%i==0)
	         {
	             cnt++;
	             break;
	         }
	     if(cnt==0)//print statement to print prime
	         System.out.println(num+" Number is Prime");
	     else{//print statement to print not prime
	     	System.out.println(num+" is not Prime");
	     }
	}
	 
	public static void main(String args[])
    {
		Scanner inpVar = new Scanner(System.in);
		System.out.println("Please enter number to find whether prime or not with runnable interface");
        try
        {           
            Prime p1=new Prime(inpVar.nextInt());
            Thread t1=new Thread(p1);//instantiating thread
            System.out.println("Please enter number to find whether prime or not by extending thread class");
            PrimewithThread p2=new PrimewithThread(inpVar.nextInt());
            Thread t2=new Thread(p2);//instantiating thread
            
            t1.start();//calling  start method which executes a class implementing runnable interface
            t2.start();//calling start method which executes a  class extending thread
        }
        catch(Exception e1){//catch and print the exception if any
        	e1.printStackTrace();
        }
        finally{
        	inpVar.close();
        }
    }

}
