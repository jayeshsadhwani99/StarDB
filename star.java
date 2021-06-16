import java.util.Scanner;

public class Star {
    String name;
    Scanner scannerObj = new Scanner(System.in);

    public void addStar() {
        // Get the name of the star
        System.out.println("What's the name of the star?");
        name = scannerObj.nextLine();

        // Clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\nStar Created!\n");

    }
}
