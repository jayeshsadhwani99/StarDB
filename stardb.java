import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        int choice;
        boolean check = true;
        Scanner scannerObj = null;
        Star star = new Star();

        // We do try-finally to close the scanner
        // ( The class using which we get input )
        try {
            // We declare a scanner object to get user input
            scannerObj = new Scanner(System.in);

            System.out.println("\n*********Welcome to StarDB**********\n");

            // Only run this code if the user
            // enters a valid choice
            while(check) {
                check = false;

                // Options
                System.out.println(
                        "1. Add A Star\n2. View A Star\n3. Update Details of a star\n4. Delete A Star\n5. View All Stars\n6. Exit");

                System.out.println("Enter your choice: ");

                // Get the user input
                choice = scannerObj.nextInt();

                switch (choice) {
                    // Add a star
                    case 1:
                        star.addStar();
                        check = true;
                        break;

                    // View a star
                    case 2:
                        System.out.println("View");
                        break;

                    // Update a star
                    case 3:
                        System.out.println("update");
                        break;

                    // Delete a star
                    case 4:
                        System.out.println("del");
                        break;

                    // Read from the DB
                    case 5:
                        System.out.println("All");
                        break;

                    // Exit
                    case 6:
                        System.out.println("Bye. Thanks for Coming!");
                        break;

                    default:
                        // Clear the console
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        
                        System.out.println("Invalid choice. Try Again!");
                        check = true;
                        break;
                }
            }
        } finally {
            if (scannerObj != null)
                scannerObj.close();
        }
    }
}