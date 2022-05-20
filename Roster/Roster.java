import java.util.*;

public class Roster {
    static LinkedList<String> students = new LinkedList<>();

    // constructor
    public Roster() {
    }

    public static void main(String args[]) {
        // asking the user to specify the maxsize
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the maximum size for your roster?");
        int maxSize = Integer.parseInt(scanner.nextLine());

        while (students.size() <= maxSize) {
            // if the roster is full, end the program
            if (students.size() == maxSize) {
                System.out.println("Your roster is full.");
                return;
            }

            // getting a command from the user
            System.out.println("Enter [a/r/d/q]: (a)dd, (r)emove, (d)isplay, (q)uit");
            String command = scanner.nextLine(); // reads string

            // if the command is legal;
            // adding a student to the class
            if (command.equals("a")) {
                // keeping the roster in alphabetic order by last name
                boolean hasAdded = false;
                // get the name from user to add
                System.out.println("Enter the name you want to add.");
                String nameToBeAdded = scanner.nextLine();

                // keeping the roster in alphabetic order by last name
                for (int i = 0; i < students.size(); i++) {
                    String temp = students.get(i);
                    // if nameToBeAdded should come before temp,
                    if (nameToBeAdded.compareTo(temp) < 0) {
                        // add the student name at position i
                        students.add(i, nameToBeAdded);
                        hasAdded = true;
                        break;
                    }
                }
                // if nameToBeAdded need to be added at the end, add it to the end
                if (!hasAdded) {
                    students.add(nameToBeAdded);
                }
            }

            // removing a student from the class
            else if (command.equals("r")) {
                // get the name from user to remove
                System.out.println("What name do you want to remove?");
                String nameToBeRemoved = scanner.nextLine();
                // finding the index of the name
                for (int j = 0; j < students.size(); j++) {
                    if (students.get(j).equals(nameToBeRemoved)) {
                        // delete the name from the roster
                        students.delete(j);
                    }
                }
            }

            // displaying the roster
            else if (command.equals("d")) {
                System.out.println("Display so far:");
                for (int n = 0; n < students.size(); n++) {
                    System.out.println(students.get(n));
                }
            }

            // quit the program
            else if (command.equals("q")) {
                System.exit(0);
            }

            // if the command is illegal, give the user warning message
            else {
                System.out.println("Bad input; please try again");
            }

        }

    }
}
