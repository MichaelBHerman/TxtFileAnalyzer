import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TxtReader {

    public static void main(String[] args) {

        //fields//

        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        int listCounter = 0;

        try {
            System.out.println("Analyzing the provided .txt file for duplicate entries...\n");
//            List<String> allLines = Files.readAllLines(Paths.get("\\Users\\hrmmi\\Desktop\\Seating_Chart\\Seating Chart1.txt")); //reads .txt file into list of strings
            List<String> allLines = Files.readAllLines(Paths.get("\\Users\\hrmmi\\Desktop\\Seating_Chart\\names_test.txt"));

                Set<String> set = new HashSet<>(allLines);
                if(set.size() < allLines.size()){  //hashset automatically removes duplicates, so if the set size is less than original list, duplicates were removed
                    System.out.println(ANSI_RED + "There were duplicates detected" + ANSI_RESET);
                    System.out.println("Here is the new list with all duplicate items removed: \n");
                    System.out.println(set.stream().toList());
                    System.out.println();
                    System.out.println("New list size: " +ANSI_GREEN + set.size() + ANSI_RESET);
                    for (String s : set){
                        if (allLines.contains(s)){  //compare previous list with new set
                            allLines.remove(s);     //remove the entire set, only duplicates remain in original list (allLines)
                        }
                    }
                    for (String lines : allLines){
                        System.out.println(ANSI_RED + "Duplicates found: " + ANSI_RESET + lines );  //prints each remaining string in the list after set removal
                    }
                }
                else {
                    System.out.println(ANSI_GREEN + "No duplicates were detected in the provided list" + ANSI_RESET);
                    System.out.println("New list size: " + ANSI_GREEN + set.size() + ANSI_RESET);
                    System.out.println(set.stream().toList());
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("\nWould you like to see a reader-friendly version of this list? [Y] \n>>>");
                    String userInput = scanner.nextLine().toLowerCase();

                    if (userInput.equalsIgnoreCase("y")) {
                        for (String s : set) {
                            listCounter++;
                            System.out.println(listCounter + ": " + s);
                        }
                    }
                    else{
                        System.out.println();
                        }
                    }


        } catch (IOException e) {
            System.out.println("There was an error reading the .txt file.");
            e.printStackTrace();
        }
    }
}

