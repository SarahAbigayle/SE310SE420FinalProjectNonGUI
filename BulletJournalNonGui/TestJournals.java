/* Name: TestJournals
* 
*   Description: test class created specifically for testing the requirement
*   that journals would need to be created in less than three seconds each
*/
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class TestJournals {
    private static Vector<Journal> journalVector = new Vector<Journal>(0); 
    private static long startTime;
    private static long endTime; 
    private static long comparisonTime = 30000; // comparison time of 3 seconds - 3000 milliseconds
    private static int pass = 0;
    private static int fail = 0;

    public static void main(String[] args) {
        createPagesTest();

        System.out.println("Passes: " + pass);
        System.out.println("Fails: " + fail);
    }

    public static void createJournalsTest() {
        // Loop to create journals and add them to the vector
        while (journalVector.size() < 100)
        {
            // Record current time in milliseconds for the start time
            startTime = System.currentTimeMillis();

            // Create a journal and add it to the vector
            journalVector.add(new Journal("JournalTest", Colour.ANSI_CYAN)); 

            // Record current time in milliseconds for the end time
            endTime = System.currentTimeMillis();

            // Compare the time it took to create a new journal to 3 seconds
            if ((endTime - startTime) < comparisonTime)
                pass++; // if less than 3 seconds, add to pass counter
            else
                fail++; // if more than 3 seconds, add to fail counter
        }
    }

    public static void changeJournalTitleTest() {
        // Loop to create journals and add them to the vector
        int loopCounter = 0;
        while (journalVector.size() < 100)
        {
            // Create a journal and add it to the vector
            journalVector.add(new Journal("JournalTest", Colour.ANSI_CYAN)); 
            // Print out the journal to ensure title before it is changed
            System.out.println(journalVector.get(loopCounter).returnJournalName());
            loopCounter++;
        }

        // Loop to go through all journals and change their title
        for (int i = 0; i < journalVector.size(); i++)
        {
            startTime = System.currentTimeMillis();

            journalVector.get(i).changeJournalName("ChangeTest");

            endTime = System.currentTimeMillis();
            
            if ((endTime - startTime) < comparisonTime)
                pass++; // if less than 3 seconds, add to pass counter
            else
                fail++; // if more than 3 seconds, add to fail counter

            // print the name of the journal to ensure that it is actually changing 
            System.out.println(journalVector.get(i).returnJournalName());
        }
    }

    public static void changeJournalColourTest() {
        // Loop to create journals and add them to the vector
        int loopCounter = 0;
        while (journalVector.size() < 100)
        {
            // Create a journal and add it to the vector
            journalVector.add(new Journal("JournalTest", Colour.ANSI_CYAN)); 
            // Print out the journal to ensure colour before it is changed
            System.out.println(journalVector.get(loopCounter).returnJournalName());
            loopCounter++;
        }

        // Loop to go through all journals and change their colour
        for (int i = 0; i < journalVector.size(); i++)
        {
            startTime = System.currentTimeMillis();

            journalVector.get(i).changeCoverColour(Colour.ANSI_PURPLE);

            endTime = System.currentTimeMillis();
            
            if ((endTime - startTime) < comparisonTime)
                pass++; // if less than 3 seconds, add to pass counter
            else
                fail++; // if more than 3 seconds, add to fail counter

            // print the name of the journal to ensure that the colour is actually changing
            System.out.println(journalVector.get(i).returnJournalName());
        }
    }

    public static void deleteJournalsTest() {
        // Loop to create journals and add them to the vector
        int loopCounter = 0;
        while (journalVector.size() < 1000)
        {
            // Create a journal and add it to the vector
            journalVector.add(new Journal("JournalTest", Colour.ANSI_CYAN)); 
            // Print out the journal to ensure that the journals are being created
            System.out.println(journalVector.get(loopCounter).returnJournalName());
            loopCounter++;
        }

        // Loop to go through all journals and delete them
        for (int i = journalVector.size() - 1; i >= 0 ; i--)
        {
            startTime = System.currentTimeMillis();

            journalVector.remove(i);

            endTime = System.currentTimeMillis();
            
            if ((endTime - startTime) < comparisonTime)
                pass++; // if less than 3 seconds, add to pass counter
            else
                fail++; // if more than 3 seconds, add to fail counter
        }

        System.out.println("All journals list:");
        // loop through the journal vector to ensure that all journals have been deleted
        for (int i = 0; i < journalVector.size(); i++)
        {
            System.out.println(journalVector.get(i).returnJournalName());
        }
    }

    public static void openJournalsTest() {
        // Loop to create journals and add them to the vector
        int journalCounter = 0;
        int loopCounter = 0;
        while (journalVector.size() < 2)
        {
            // Create a journal and add it to the vector
            journalVector.add(new Journal("JournalTest", Colour.ANSI_CYAN)); 
            // Print out the journal to ensure that the journals are being created
            System.out.println(journalVector.get(journalCounter).returnJournalName());

            // Loop to create pages within the journal
            while (loopCounter < 100000)
            {
                journalVector.get(journalCounter).createPageForTest("Page Test", "Blank", "MyPageTests");
                loopCounter++;
            }

            journalCounter++;
            loopCounter = 0;
        }

        for (int i = 0; i < journalVector.size(); i++)
        {
            startTime = System.currentTimeMillis();

            journalVector.get(i).openJournalForTest();
            
            endTime = System.currentTimeMillis();

            if ((endTime - startTime) < comparisonTime)
                pass++; // if less than 3 seconds, add to pass counter
            else
                fail++; // if more than 3 seconds, add to fail counter
        }
    }

    public static void createPagesTest() {
        // Loop to create journals and add them to the vector
        int journalCounter = 0;
        int loopCounter = 0;
        while (journalVector.size() < 100)
        {
            // Create a journal and add it to the vector
            journalVector.add(new Journal("JournalTest", Colour.ANSI_CYAN)); 
            // Print out the journal to ensure that the journals are being created
            System.out.println(journalVector.get(journalCounter).returnJournalName());

            // Loop to create pages within the journal
            while (loopCounter < 100)
            {
                startTime = System.currentTimeMillis();
                journalVector.get(journalCounter).createPageForTest("Page Test", "Blank", "MyPageTests");
                endTime = System.currentTimeMillis();

                if ((endTime - startTime) < comparisonTime)
                    pass++; // if less than 3 seconds, add to pass counter
                else
                    fail++; // if more than 3 seconds, add to fail counter

                loopCounter++;
            }

            journalCounter++;
            loopCounter = 0;
        }

        for (int i = 0; i < journalVector.size(); i++)
        {
            startTime = System.currentTimeMillis();

            journalVector.get(i).openJournalForTest();
            
            endTime = System.currentTimeMillis();

            if ((endTime - startTime) < comparisonTime)
                pass++; // if less than 3 seconds, add to pass counter
            else
                fail++; // if more than 3 seconds, add to fail counter
        }
    }
}