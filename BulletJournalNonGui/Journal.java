/* 
* Journal Class
* 
* Description:
*   - holds a vector of Pages
*
* Version: 1.0
*/
import java.util.Vector;

public class Journal {
    // Variables that belong to a journal
    private Vector<Page> pageVector = new Vector<Page>(0);

    private String journalName;
    private String journalCoverColour;
    private int numberOfPages = 0;
    private int closePageMenu = 0;

    public Journal(String journalName, String journalCoverColour) {
        // If no journal name is entered, defaults to "My Journal"
        if (journalName.equals(""))
            this.journalName = "My Journal";
        else
            this.journalName = journalName;
        
        this.journalCoverColour = journalCoverColour;
        System.out.println("Journal Created.");
    }

    public String returnJournalName() {
        return (journalCoverColour + journalName + Colour.ANSI_RESET);
    }

    public void changeCoverColour(String newColour) {
        this.journalCoverColour = newColour;
    }

    public void changeJournalName(String newName) {
        // If no journal name is entered, default to "My Journal"
        if (newName.equals("")) {
            System.out.println(Colour.ANSI_RED + "No journal name entered. Journal name is defaulting to: 'My Journal'" + Colour.ANSI_RESET);
            this.journalName = "My Journal";
        }
        else
        {
            this.journalName = newName;
        }
    }

    public void createPage() {
        // limit the amount of total pages that the app can have to 150
        if (MainActivity.returnPageCount() < 150)
        {
            // Prompt the user to enter information for the page
            System.out.println("Enter page name: ");
            String name = System.console().readLine();
            System.out.println("Enter page type (p - planner, g - grid, c - collection, b - blank)");
            String type = System.console().readLine();
            System.out.println("Enter page category: ");
            String category = System.console().readLine();

            pageVector.add(new Page(name, type, category, numberOfPages));
            numberOfPages++;
            MainActivity.incrementPageCounter();
        }
        else
        {
            System.out.println(Colour.ANSI_RED + "Maximum number of pages reached" + Colour.ANSI_RESET);

        }

    }

    public void openJournal() {
        // Infinite loop until user wants to go back to the main menu of the app
        while (closePageMenu == 0){
            pageMenu();
        }

        // Resets the closePageMenu variable so that if a journal is closed, it can be reopened
        closePageMenu = 0;
    }

    public void pageMenu() {
        // Menu for terminal commands and user decision
        System.out.println("What would you like to do?");
        for (int i = 1; i <= pageVector.size(); i++) { // prints the pages that have been created
            System.out.println("   " + i + " - edit " + pageVector.get(i - 1).returnPageDetails());
        }
        System.out.println("   c - create a new page");
        System.out.println("   d - Delete a page");
        System.out.println("   e - exit to journals screen");

        // Reads in the decision for the menu
        String decision = System.console().readLine();

        switch (decision) {
            case "1":
                System.out.println("edit page 1");
                break;
            case "2":
                System.out.println("edit page 2");
                break;
            case "3":
                System.out.println("edit page 3");
                break;
            case "4":
                System.out.println("edit page 4");
                break;
            case "5":
                System.out.println("edit page 5");
                break;
            case "d":
                // Ability to allow user to delete a page
                System.out.println("Which page would you like to delete? (enter the page number)");
                decision = System.console().readLine();
                pageVector.remove(Integer.parseInt(decision) - 1);
                numberOfPages--;
                MainActivity.decrementPageCounter();
                break;
            case "c":
                // Ability to allow user to create a page
                createPage();
                break;
            case "e":
                // Ability to allow user to exit a journal and go back to the main menu
                closePageMenu = 1;
                MainActivity.viewJournalsMenu();
                break;
        }
    }

}