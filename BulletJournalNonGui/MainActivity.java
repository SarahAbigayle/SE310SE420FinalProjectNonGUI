/* 
* MainActivity Class
* 
* Description:
*   - represents the main activity of the app that would be simulated with a GUI
*
* Restrictions:
*   - only a total of five journals should be created within the app
*   - only a total of 150 pages should be created within the app
*
* Issues: 
*   - in viewJournalsMenu(), a journal can be technically "opened" even if it is not created yet
*
* Changes made because of non-GUI:
*   - this entire class, basically
*
* Version: 1.0
*/

import java.util.Vector;

public class MainActivity {
    private static int totalJournalNumber = 0;
    private static int totalPageNumber = 0;
    private static Vector<Journal> journalVector = new Vector<Journal>(0);
    private static int closeApp = 0;

    public static void main(String[] args) {

        while (closeApp == 0) {
            viewJournalsMenu();
        }
    }

    public static void viewJournalsMenu()
    {
        System.out.println("What would you like to do?");
        for (int i = 1; i <= journalVector.size(); i++) {
            System.out.println("   " + i + " - open " + journalVector.get(i - 1).returnJournalName());
        }
        System.out.println("   d - Delete a journal");
        System.out.println("   c - create a new journal");
        System.out.println("   e - exit app");

        String decision = System.console().readLine();

        switch (decision) {
            case "1":
                System.out.println("Open Journal 1");
                journalVector.get(0).openJournal();
                break;
            case "2":
                System.out.println("Open Journal 2");
                journalVector.get(1).openJournal();
                break;
            case "3":
                System.out.println("Open Journal 3");
                journalVector.get(2).openJournal();
                break;
            case "4":
                System.out.println("Open Journal 4");
                journalVector.get(3).openJournal();
                break;
            case "5":
                System.out.println("Open Journal 5");
                journalVector.get(4).openJournal();
                break;
            case "d":
                System.out.println("Which journal would you like to delete? 1/2/3/4/5");
                decision = System.console().readLine();
                journalVector.remove(Integer.parseInt(decision) - 1);
                totalJournalNumber--;
                break;
            case "c":
                createJournal();
                break;
            case "e":
                closeApp = 1;
                
                break;

        }
    }

    public static void createJournal() {
        if (totalJournalNumber < 5)
        {
            System.out.println("Enter journal name: ");
            String name = System.console().readLine();
            System.out.println("Enter cover colour: (r = red/y = yellow/g = green/c = cyan/b = blue/p = purple)");
            String colour = System.console().readLine();
            colour = Colour.convertColour(colour);

            journalVector.add(new Journal(name, colour));
            
            journalVector.get(0).returnJournalName();
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
}