import java.util.Scanner;

class BankAcct {
    String acc_num;
    double balance;
    static double interestRate;

    BankAcct(String num, double balance) {
        this.acc_num = num;
        this.balance = balance;
    }

    static void setInterest(double rate) {
        interestRate = rate;
    }

    static double getInterest() {
        return interestRate;
    }

    double interest() {
        return balance * interestRate / 100;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String acc;
        double balance,interest;
        
        BankAcct bk1,bk2;

        System.out.println("Add bank account1(acc_no., balance): ");
        acc=sc.next();
        balance=sc.nextDouble();
        bk1 = new BankAcct(acc, balance);

        System.out.println("Add bank account2(acc_no., balance): ");
        acc=sc.next();
        balance=sc.nextDouble();
        bk2 = new BankAcct(acc, balance);


        int choice;
        while(true){
            System.out.println("1.Add interest \n2.Change interest \n3.Display interest \n4.Calculate interest  \n5.Dispaly balance \n6.ext");
            choice=sc.nextInt();
            //add if for breaking
            switch(choice){
                case 1 ->{
                    System.out.println("Interest: ");
                    interest=sc.nextDouble();
                    BankAcct.setInterest(interest);
                }

                case 2->{
                    System.out.println("Change Interest: ");
                    interest=sc.nextDouble();
                    BankAcct.setInterest(interest);
                }

                case 3->{
                    System.out.println("Display Interest: "+BankAcct.getInterest());
                }

                case 4->{
                    System.out.println("Calculated interest1: "+bk1.interest());
                    
                    System.out.println("Calculated interest2: "+bk2.interest());    
                }

                case 5->{
                    System.out.println("Display balance1: "+bk1.balance);
                    System.out.println("Display balance2: "+bk2.balance);
                }
                
            }
        }

    }
}
