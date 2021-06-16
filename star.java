import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Star {
    boolean check_if_id_exists = true;
    int star_id;
    String star_name;
    Scanner scannerObj = new Scanner(System.in);

    public void addStar() {
        // Assign a random value to the ID
        while(check_if_id_exists) {
            star_id = ThreadLocalRandom.current().nextInt(1000, 10000);
            // Check if ID already exists
            File star_file = new File("./database/"+star_id+".txt");
            if(!star_file.exists()) {
                check_if_id_exists = false;
            }
        }

        // Get the info of the star
        System.out.println("What's the name of the star?");
        star_name = scannerObj.nextLine();

        // Write to database
        try {
            FileWriter fileWriter = new FileWriter("./database/"+star_id+".txt");
            fileWriter.write("ID: " + star_id + "\nName: " + star_name);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\nStar Created-");
        System.out.println("ID: " + star_id + "\nName: " + star_name + "\n");

    }
}
