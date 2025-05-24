import java.util.Scanner;

public class Email {
    private String getFirstName;
    private String getLastName;
    private String password;
    private String email;
    private String department;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "ominousniceguy.com";

        // construtor to recieve first and last name
        public Email(String FirstName, String LastName) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("what is your first name?");
            getFirstName = scanner.next();

            System.out.println("what is your last name?");
            getLastName = scanner.next();
            

            System.out.println("\nEmail Created: " + getFirstName + " " + getLastName + "\n".repeat(2));

            this.department = setDepartment();
         //   System.out.println("Department: " + this.department);

            this.password = randomPassword(defaultPasswordLength);
            System.out.println("Your password is: " + this.password);

            // combine elements to generate email
            email = getFirstName.toLowerCase() + getLastName.toLowerCase() + "@" + department + "." + companySuffix;
           // System.out.println("Your email is: " + email);

            }
        //ask for the department
        private String setDepartment() {
            System.out.print("Enter the department \n1 for Technology \n2 for Business Development \n3 for Accounting \n0 for none\n" +"\n".repeat(3) + "ENTER DEPARTMENT CODE: ");
            Scanner in = new Scanner(System.in);
            int deptChoice = in.nextInt();
            

            if (deptChoice == 1) { return "tech"; }
            else if (deptChoice == 2) { return "buis.dev."; }
            else if (deptChoice == 3) { return "acc"; }
            else { return " ";}
            


        }

        // generate a random password
        private String randomPassword(int length) {
            String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()=-/";
            char[] password = new char[length];
            for (int i=0; i<length; i++){
                int rand = (int) (Math.random() * passwordSet.length());
                password[i] = passwordSet.charAt(rand);
        }
        return "\n" + new String(password);
    }

        //set the mailbox capacity 
        public void setMailboxCapacity(int capacity) {
            this.mailboxCapacity = capacity;
        }

        // set the alternate email
        public void setAlternateEmail(String altEmail){
            this.alternateEmail = altEmail;
        }

        //change the password
        public void changePassword(String password) {
            this.password = password;
        }
        public int getMailboxCapacity() {return mailboxCapacity;}
        public String getAlternateEmail() {return alternateEmail;}
        public String getPassword() {return password;}


        public String showInfo() {
            return "\n".repeat(5) + "Display Name: " + getFirstName + " " + getLastName + 
                    "\nCompany Email: " + email + 
                    "\nMailbox Capacity " + mailboxCapacity + "mb" + "\nPassword: " + password;
            
        }
        
        
    }