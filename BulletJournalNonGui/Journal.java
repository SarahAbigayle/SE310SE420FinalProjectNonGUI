/* 
* Journal Class
* 
* Description:
*   - holds a vector of Pages
*
* Restrictions:
*   - can only be a total of 5 journals
*   - only a total of 150 pages over all journals
*
* Issues: 
*   - no page vector or category vector sort
*   - if journal name is not chosen, then what happens?
* 
* Changes made because of non-GUI:
*   -
*
* Version: 1.0
*/
import java.util.Vector;

public class Journal {
    private String journalName;
    private String journalCoverColour;
    private Vector<Page> pageVector = new Vector<Page>(0);
    private int numberOfPages = 0;
    private int closePageMenu = 0;

    public Journal(String journalName, String journalCoverColour) {
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

    public String returnCoverColour() {
        return journalCoverColour;
    }

    public void createPage() {
        System.out.println("Enter page name: ");
        String name = System.console().readLine();
        System.out.println("Enter page type (p - planner, g - grid, c - collection, b - blank)");
        String type = System.console().readLine();
        System.out.println("Enter page category: ");
        String category = System.console().readLine();

        pageVector.add(new Page(name, type, category, numberOfPages));
        numberOfPages++;
    }

    public void openJournal() {
        while (closePageMenu == 0){
            pageMenu();
        }

        closePageMenu = 0;
    }

    public void pageMenu() {
        System.out.println("What would you like to do?");
        for (int i = 1; i <= pageVector.size(); i++) {
            System.out.println("   " + i + " - edit " + pageVector.get(i - 1).returnPageDetails());
        }
        System.out.println("   d - Delete a page");
        System.out.println("   c - create a new page");
        System.out.println("   e - exit to journals screen");

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
                System.out.println("Which page would you like to delete? (enter the page number)");
                decision = System.console().readLine();
                pageVector.remove(Integer.parseInt(decision) - 1);
                numberOfPages--;
                break;
            case "c":
                createPage();
                break;
            case "e":
                closePageMenu = 1;
                MainActivity.viewJournalsMenu();
                break;
        }
    }

}