import java.util.*;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

class Employee
{
    String emp_code;
    String name;
    String basic_salary;
    String grade;
    String dept;
    public Employee(String s1,String s2,String s3,String s4,String s5)
    {
        emp_code=s1;
        name=s2;
        basic_salary=s3;
        grade=s4;
        dept=s5;
    }
    public Employee(String s1)
    {
        emp_code=s1;
    }
    public boolean equals(Object t)
    {
        if(t instanceof Employee)
        {
            Employee s1=(Employee)t;
            return emp_code.equals(s1.emp_code);


        }
        else{
            return false;
        }
    }
    public String toString()
    {
        return "Emp_code:"+emp_code+"\n"+"name:"+name+"\n"+"basic_salary:"+basic_salary+"\n"+"grade:"+grade+"\n"+"dept:"+dept;
    }
}

class Render extends JFrame
{
    JPanel p;
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4;
    JRadioButton rb1,rb2,rb3;
    ButtonGroup bg1;
    // JButton b;
    JList dept;
    JButton save,disp;
    ArrayList<Employee> arr;
    public Render()
    {
        super();
        arr=new ArrayList<Employee>();
        setSize(1000,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildPanel();
        add(p);
        setVisible(true);

    }
    class SaveListener implements ActionListener
    {
		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) {
            String s1,s2,s3,s4,s5;
            s1=t1.getText();
            s2=t2.getText();
            s3=t3.getText();
            s4="";
            if(rb1.isSelected()){
                s4="Grade A";
            }
            if(rb2.isSelected()){
                s4="Grade B";
            }
            if(rb3.isSelected()){
                s4="Grade C";
            }
            s5=(String)dept.getSelectedValue();
            if(arr.contains(new Employee(s1)))
            {
                JOptionPane.showMessageDialog(null,"Employee code taken");
            }
            else{
                Employee e1=new Employee(s1,s2,s3,s4,s5);
                arr.add(e1);
                JOptionPane.showMessageDialog(null,e1.toString());
            }
			
		}
    }
    class DispListener implements ActionListener{

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e){
            String empC= t4.getText();
            for(Employee emp: arr){
                if(emp.emp_code.equals(empC)){
                    JOptionPane.showMessageDialog(null, "Match found\n"+emp.toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null,"No Employee Found!!");
        }
    }
    public void buildPanel()
    {
        p=new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        l1=new JLabel("Employee Code");
        l2=new JLabel("Employee Name");
        l3=new JLabel("Basic Salary");
        t1=new JTextField("Code");
        t2=new JTextField("Name");
        t3=new JTextField("Salary");
        rb1=new JRadioButton("Grade A");
        rb2=new JRadioButton("Grade B");
        rb3=new JRadioButton("Grade C");
        bg1=new ButtonGroup();
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        bg1.add(rb1);
        bg1.add(rb2);
        bg1.add(rb3);
        p.add(rb1);
        p.add(rb2);
        p.add(rb3);
        String arr[]={"CSE","IT","ETCE","CHEM"};
        dept=new JList(arr);
        dept.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        l4=new JLabel("Department");
        p.add(l4);
        p.add(dept);
        save=new JButton("Save");
        save.addActionListener(new SaveListener());
        p.add(save);
        l6 = new JLabel("Search Employee");
        p.add(l6);
        t4= new JTextField("Enter employee code");
        p.add(t4);
        disp = new JButton("Display");
        disp.addActionListener(new DispListener());
        p.add(disp);
}

}

class Assign_4B
{
    public static void main(String[] args) {
        Render w=new Render();
    }
}