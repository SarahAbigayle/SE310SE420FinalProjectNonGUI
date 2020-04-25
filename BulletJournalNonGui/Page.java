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
    private String pageName;
    private String pageType;
    private String pageCategory;
    private int pageNumber;

    public Page (String pageName, String pageType, String pageCategory, int pageNumber)
    {
        if (pageName.equals(""))
            this.pageName = "My Page";
        else
            this.pageName = pageName;

        pageType = convertPageType(pageType);
        this.pageType = pageType;

        if (pageName.equals(""))
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
        if (type.equals("p"))
            type = "Planner";
        else if (type.equals("g"))
            type = "Grid";
        else if (type.equals("c"))
            type = "Collection";
        else if (type.equals("b"))
            type = "Blank";
        else
            type = "Blank";

        return type;
    }

}