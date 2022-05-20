import java.util.Scanner;

public class EnhancedRoster extends Roster {
    static LinkedList<String> students = new LinkedList<>();
    static Roster waitlist = new LinkedList<>();

    // constructor
    public EnhancedRoster() {
    }

    public static void main(String args[]) {
        // asking the user to specify the maxsize
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the maximum size for your roster?");
        int maxSize = Integer.parseInt(scanner.nextLine());

        while (students.size() <= maxSize) {

            // getting a command from the user
            if (students.size() < maxSize){
                System.out.println("Enter [a/r/d/q]: (a)dd, (r)emove, (d)isplay, (q)uit");
                String command = scanner.nextLine(); // reads string

                // if the command is legal;
                // adding a student to the class
                if (command.equals("a")) {
                    // get the name from user to add
                    System.out.println("Enter the name you want to add.");
                    String nameToBeAdded = scanner.nextLine();
                    adding(nameToBeAdded);
                }

                // removing a student from the class
                else if (command.equals("r")) {
                // get the name from user to remove
                    System.out.println("What name do you want to remove?");
                    String nameToBeRemoved = scanner.nextLine();
                    // finding the index of the name
                    removing(nameToBeRemoved);
                }

                // displaying the roster
                else if (command.equals("d")) {
                    displaying();
                }

                // quitting the program
                else if (command.equals("q")) {
                    System.exit(0);
                }

            else if (students.size() == maxSize) {
                System.out.println("Your roster is full.");
                System.out.println("Enter the name you want to add on waitlist.");
                //receive name from user and add it to the waitlist
                String name = scanner.nextLine(); // reads string
                adding(name);
                System.out.println("This is the waitlist");
                System.out.print(waitlist);    
            }
            // if the command is illegal, give the user warning message
            else {
                System.out.println("Bad input; please try again");
            }
        }

        // if the roster is full, end the program
        
        scanner.close();

    }

    public static void adding(String name) {

        // adding the name on the waitlist
        if (students.size == maxsize) {
            waitlist.add(name);
        } else { // adding the name to the roster
            boolean hasAdded = false;
            if (!hasAdded) {
                for (int i = 0; i < students.size(); i++) {
                    String temp = students.get(i);
                    // keeping the roster in alphabetic order by last name
                    // if the name comes before temp
                    if (name.compareTo(temp) < 0) {
                        // add the student name at position i
                        students.add(i, name);
                        hasAdded = true;
                        break;

                        // if the name already exists, do not add the name
                    } else if (name.equals(temp)) {
                        hasAdded = true;
                        break;
                    }
                }
                // if the name still hasn't been added, add it to the end
                if (!hasAdded) {
                    students.add(name);
                }
            }
        }
    }

    public static void removing(String name) {
        for (int j = 0; j < students.size(); j++) {
            if (students.get(j).equals(name)) {
                // delete the name from the roster
                students.delete(j);
            }
        }
    }

    public static void displaying() {
        System.out.println("Display so far:");
        for (int n = 0; n < students.size(); n++) {
            System.out.println(students.get(n));
        }
    }

    public static void waiting(String name) {
        waitlist.add(name);
        System.out.println("This is the waitlist.");
        System.out.println(waitlist);
    }

}
