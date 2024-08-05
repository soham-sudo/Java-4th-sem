import java.util.Scanner;
class Customer{
	String name,ph;
	int id;
	double loan_taken;
	static double credit_limit=30000;
	static int id_gen=0;
	//java does not support default parameters
	Customer(String name,String phone_no,double loan){
		this.name=name;
		this.ph=phone_no;
		id=id_gen++;
		loan_taken=loan;
	}

	
	static double get_credit_limit(){
		return credit_limit;
	}
	double currentLoan(){
		return loan_taken;
	}
	double LoanSeek(){
		return credit_limit-loan_taken;
	}
	void setName(String name){
		this.name=name;
	}
	void setPhone(String phone){
		this.ph=phone;
	}
	void req_loan(double ammount){
		if(ammount+loan_taken>credit_limit){
			System.out.println("Your loan cant be granted!!");
		}
		else{
			loan_taken+=ammount;
			System.out.println("loan granted of rs: "+ ammount);
		}
		
	}
	
}
class Previleged extends Customer{
	//due to no polymorphic nature in data variable.
	static double credit_limit=45000;
	static double get_credit_limit(){
		return credit_limit;
	}

	Previleged(String name,String phone_no,double loan){
		super(name, phone_no, loan);
	}
	void req_loan(double ammount){
		if(ammount+loan_taken>credit_limit){
			System.out.println("Your loan cant be granted!!");
		}
		else{
			loan_taken+=ammount;
			System.out.println("loan granted of rs: "+ ammount);
		}
		
	}
	double LoanSeek(){
		return Math.max(credit_limit-loan_taken,0);
	}
}

class Assign
{
	public static void main(String args[]){

		String name,phone;
		double loan;
		Scanner sc = new Scanner(System.in);


		System.out.println("Customer name,phone,loan");
		name=sc.next();
		phone=sc.next();
		loan=sc.nextDouble();


		Customer c1=new Customer(name, phone, loan);

		System.out.println("Priveledge name,phone,loan");
		name=sc.next();
		phone=sc.next();
		loan=sc.nextDouble();

		Previleged p1=new Previleged(name, phone, loan);


		c1.req_loan(2000);
		System.out.println("credit limit of customer 1 "+Customer.get_credit_limit()+" | Loan taken: "+c1.currentLoan()+ " | Max Seekable Loan: "+c1.LoanSeek());
		p1.req_loan(7500);
		System.out.println("credit limit of Previleged customer 1 "+Previleged.get_credit_limit()+" | Loan taken: "+p1.currentLoan()+ " | Max Seekable Loan: "+p1.LoanSeek());
		
		System.out.println("\nagain loan request\n");
		c1.req_loan(20000);
		System.out.println("Loan seek limit of customer 1 "+c1.LoanSeek());
		p1.req_loan(75000);
		System.out.println("Loan seek limit of Previleged customer 1 "+p1.LoanSeek());

		sc.close();
	}
}