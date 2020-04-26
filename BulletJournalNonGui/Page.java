/* 
* Page Class
* 
* Description:
*   - represents the pages of the journal
*
* Restrictions:
*   - only a total of 150 pages over all total journals
*
* Issues: 
*   - 
*
* Changes made because of non-GUI:
*   - 
*
* Version: 1.0
*/

public class Page {
    // Variables that belong to the Page class
    private String pageName;
    private String pageType;
    private String pageCategory;
    private int pageNumber;

    public Page (String pageName, String pageType, String pageCategory, int pageNumber)
    {
        // If no page is entered, the page is named "My Page" by default
        if (pageName.equals(""))
            this.pageName = "My Page";
        else
            this.pageName = pageName;

        // Converts the single letter that the user entered into a page type for convenience
        pageType = convertPageType(pageType);
        this.pageType = pageType;

        // If no page category is entere, the page is placed under the "Undefined" category
        if (pageCategory.equals(""))
            this.pageCategory = "Undefined";
        else
            this.pageCategory = pageCategory;

        this.pageNumber = pageNumber;
        System.out.println("Page Created.");
    }

    public String returnPageDetails() {
        return ((pageNumber + 1) + ". " + pageName + " - " + pageType + " - " + pageCategory);
    }

    public String convertPageType(String type) {
        // Converts the user's entry of a single letter into a full string
        if (type.equals("p"))
            type = "Planner";
        else if (type.equals("g"))
            type = "Grid";
        else if (type.equals("c"))
            type = "Collection";
        else if (type.equals("b"))
            type = "Blank";
        else
            type = "Blank"; // if the user enters a letter not allowed, defaults to the Blank type of page

        return type;
    }

}