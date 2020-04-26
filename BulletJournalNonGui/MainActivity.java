/* 
* MainActivity Class
* 
* Description:
*   - represents the main activity of the app that would be simulated with a GUI
*
* Version: 1.0
*/

import java.util.Vector;

public class MainActivity {

    // Variables that belong to the main activity
    private static Vector<Journal> journalVector = new Vector<Journal>(0); 

    private static int totalJournalNumber = 0;
    private static int totalPageNumber = 0;
    private static int closeApp = 0;

    public static void main(String[] args) {
        // Infinite loop through the menu until the user chooses to exit
        while (closeApp == 0) {
            viewJournalsMenu();
        }
    }

    public static void viewJournalsMenu()
    {
        // Menu for terminal commands and user decision
        System.out.println("What would you like to do?");
        for (int i = 1; i <= journalVector.size(); i++) { // prints the journals that have been created
            System.out.println("   " + i + " - open " + journalVector.get(i - 1).returnJournalName());
        }
        System.out.println("   c - create a new journal");
        System.out.println("   h - change the colour of a journal");
        System.out.println("   n - change the name of a journal");
        System.out.println("   d - Delete a journal");
        System.out.println("   e - exit app");

        // Reads in the decision for the menu
        String decision = System.console().readLine();

        switch (decision) {
            case "1":
                // Open Journal 1
                journalVector.get(0).openJournal();
                break;
            case "2":
                // Open Journal 2
                journalVector.get(1).openJournal();
                break;
            case "3":
                // Open Journal 3 
                journalVector.get(2).openJournal();
                break;
            case "4":
                // Open Journal 4 
                journalVector.get(3).openJournal();
                break;
            case "5":
                // Open Journal 5
                journalVector.get(4).openJournal();
                break;
            case "d":
                // Ability for the user to delete a journal 
                System.out.println("Which journal would you like to delete? 1/2/3/4/5");
                decision = System.console().readLine();
                journalVector.remove(Integer.parseInt(decision) - 1);
                totalJournalNumber--;
                break;
            case "h":
                // Ability for the user to change the journal's colour
                System.out.println("Which journal's colour would you like to change? 1/2/3/4/5");
                decision = System.console().readLine();
                System.out.println("Enter new cover colour: (r = red/y = yellow/g = green/c = cyan/b = blue/p = purple)");
                String colourChange = System.console().readLine();
                colourChange = Colour.convertColour(colourChange);
                journalVector.get(Integer.parseInt(decision) - 1).changeCoverColour(colourChange);
                break;
            case "n":
                // Ability for the user to change the journal's name
                System.out.println("Which journal's name would you like to change? 1/2/3/4/5");
                decision = System.console().readLine();
                System.out.println("Enter new journal name:");
                String nameChange = System.console().readLine();
                journalVector.get(Integer.parseInt(decision) - 1).changeJournalName(nameChange);
                break;
            case "c":
                // Ability for the user to create a journal
                createJournal();
                break;
            case "e":
                // If the user wants to exit the app, this will break out of the infinite loop in main 
                closeApp = 1;
                break;

        }
    }

    public static void createJournal() {
        // Limits the amount of journals that can be created to 5
        if (totalJournalNumber < 5)
        {
            // Prompts user to enter journal name and colour
            System.out.println("Enter journal name: ");
            String name = System.console().readLine();
            System.out.println("Enter cover colour: (r = red/y = yellow/g = green/c = cyan/b = blue/p = purple)");
            String colour = System.console().readLine();
            colour = Colour.convertColour(colour);

            // Adds the journal to the vector
            journalVector.add(new Journal(name, colour));
            
            totalJournalNumber++;
        }
        else
        {
            System.out.println(Colour.ANSI_RED + "Maximum number of journals reached" + Colour.ANSI_RESET);
        }
    }

    public static void incrementPageCounter() {
        totalPageNumber++;
    }

    public static void decrementPageCounter() {
        totalPageNumber--;
    }

    public static int returnPageCount() {
        return totalPageNumber;
    }
}