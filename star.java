import java.io.IOException;
import java.io.FileNotFoundException;
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

    public void viewStar(int id) {
        File directory = new File("./database");
        int flag = 0;
        String[] stars_list = directory.list();
        if (stars_list.length == 0) {
            System.out.println("There are no stars to show.");
        } else {
            // Linear search in the array
            for (int i = 0; i < stars_list.length; i++) {
                String filename = stars_list[i];
                if (filename.equalsIgnoreCase(id + ".txt")) {
                    // Clear the console
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("**********STAR FOUND************");
                    flag = 1;
                    // Read the file
                    try {
                        File fileObj = new File("./database/" + filename);
                        Scanner fileReader = new Scanner(fileObj);
                        while (fileReader.hasNextLine()) {
                            String data = fileReader.nextLine();
                            System.out.println(data);
                        }
                        System.out.println("**********************************\n");
                        fileReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
            }

            // If file not found
            if (flag == 0) {
                System.out.println("Could not find any star with the ID " + id);
            }
        }
    }

    public void updateStar(int id) {
        File directory = new File("./database");
        int flag = 0;
        String[] stars_list = directory.list();
        if (stars_list.length == 0) {
            System.out.println("There are no stars in the Database.");
        } else {
            // Linear search in the array
            for (int i = 0; i < stars_list.length; i++) {
                String filename = stars_list[i];
                if (filename.equalsIgnoreCase(id + ".txt")) {
                    // Clear the console
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("**********STAR FOUND************\nCurrent Details: ");
                    flag = 1;
                    // Read the file
                    try {
                        File fileObj = new File("./database/" + filename);
                        Scanner fileReader = new Scanner(fileObj);
                        while (fileReader.hasNextLine()) {
                            String data = fileReader.nextLine();
                            System.out.println(data);
                        }
                        System.out.println("\nEdit Details:");
                        
                        // Edit the file
                        System.out.println("What's the name of the star?");
                        star_name = scannerObj.nextLine();

                        // Write to database
                        try {
                            FileWriter fileWriter = new FileWriter("./database/"+id+".txt");
                            fileWriter.write("ID: " + id + "\nName: " + star_name);
                            fileWriter.close();
                        } catch (IOException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                        
                        fileReader.close();

                        // Clear the console
                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        System.out.println("Star with the ID " + id + " was updated.\n");
                        
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
            }

            // If file not found
            if (flag == 0) {
                System.out.println("Could not find any star with the ID " + id);
            }
        }
    }

    public void deleteStar(int id) {
        File directory = new File("./database");
        int flag = 0;
        String[] stars_list = directory.list();
        if (stars_list.length == 0) {
            System.out.println("There are no stars to show.");
        } else {
            // Linear search in the array
            for (int i = 0; i < stars_list.length; i++) {
                String filename = stars_list[i];
                if (filename.equalsIgnoreCase(id + ".txt")) {
                    // Clear the console
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    flag = 1;
                    // Delete the file
                    File fileObj = new File("./database/" + filename);
                    if(fileObj.delete()) {
                        System.out.println("Star with the id " + id + "deleted.\n");
                    } else {
                        System.out.println("Could not delete file.");
                    }
                }
            }

            // If file not found
            if (flag == 0) {
                System.out.println("Could not find any star with the ID " + id);
            }
        }
    }

    public void viewAllStars() {
        File directory = new File("./database");
        String[] stars_list = directory.list();
        if (stars_list.length == 0) {
            System.out.println("There are no stars to show.\n");
        } else {
            // Clear the console
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("**********" + stars_list.length + " STARS FOUND************");
            
            // Linear search in the array
            for (int i = 0; i < stars_list.length; i++) {
                String filename = stars_list[i];

                // Read the files
                try {
                    File fileObj = new File("./database/" + filename);
                    Scanner fileReader = new Scanner(fileObj);
                    while (fileReader.hasNextLine()) {
                        String data = fileReader.nextLine();
                        System.out.println(data);
                    }
                    System.out.println("**********************************\n");
                    fileReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                
            }
        }
    }
}
