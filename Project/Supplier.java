public class Supplier extends Main{
    private String id;
    private String name;

    public Supplier(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void addSuppliers() throws InterruptedException {
        clearConsole();
        heading("ADD SUPPLIERS        ");
        loadingAnimation("Loading Add Suppliers Page");

        do {
            clearConsole();
            heading("ADD SUPPLIERS        ");

            System.out.print("Do you want to add another Supplier(Y / N): ");
            String newSup = scn.nextLine();

            clearConsole();
            heading("ADD SUPPLIERS        ");

            if (newSup.equalsIgnoreCase("Y")) {

                if (counter >= suppliers.length) {
                    heading("ADD SUPPLIERS        ");
                    System.out.println("Cannot add more suppliers. Maximum limit reached!");
                    break;
                }

                clearConsole();
                heading("ADD SUPPLIERS        ");

                String supID;

                while (true) {
                    System.out.print("Enter the supplier ID: ");
                    supID = scn.nextLine();

                    boolean isExists = false;

                    for (int i = 0; i < counter; i++) {
                        if (suppliers[i].getId() != null && suppliers[i].getId().equalsIgnoreCase(supID)) {
                            isExists = true;
                            break;
                        }
                    }

                    if (isExists) {
                        System.out.println("Supplier ID already exists, Please try another one.");
                    } else {
                        break;
                    }
                }

                clearConsole();
                heading("ADD SUPPLIERS        ");
                System.out.print("Enter the supplier Name: ");
                String supName = scn.nextLine();

                suppliers[counter] = new Supplier(supID, supName);
                counter++;

                System.out.println("\nSupplier added successfully!");

            } else if (newSup.equalsIgnoreCase("N")) {
                clearConsole();

                heading("ADD SUPPLIERS        ");
                System.out.println("Supplier addition completed successfully!");
                Thread.sleep(1000);
                clearConsole();
                loadingAnimation("Suppliers added successfully");
                Menu.manageSupplier();
                break;

            } else {

                heading("ADD SUPPLIERS        ");
                System.out.println("Invalid Option. Please enter Y or N.");
                Thread.sleep(1000);

            }

        } while (true);
    }

    // View Suppliers ========================================================================================

    public static void viewSuppliers() throws InterruptedException {
        clearConsole();
        heading("VIEW SUPPLIERS      ");

        System.out.printf("%-20s %-35s%n", "Supplier ID", "Supplier Name");
        System.out.println("----------------------------------------");

        for (int i=0;i<counter;i++) {
            System.out.printf("%-20s %-35s%n", suppliers[i].getId(), suppliers[i].getName());
        }

        System.out.println("\nPress Enter to return");
        scn.nextLine();

        Menu.manageSupplier();
    }

     // Search suppliers ==============================================================================

    public static void searchSupplier() throws InterruptedException {
        clearConsole();
        heading("SEARCH SUPPLIERS");
        System.out.print("Search the supplier by ID : ");
        String supSearch = scn.nextLine();

        boolean foundSupplier = false;

        for (int i=0;i<counter;i++) {

            if (suppliers[i].getId() != null && suppliers[i].getId().equals(supSearch)) {
                clearConsole();

                heading("SEARCH SUPPLIERS");

                loadingAnimation("Searching for " + supSearch);
                clearConsole();

                System.out.println("\nSupplier Found!\n");
                System.out.printf("%-15s %-30s%n", "Supplier ID", "Supplier Name");
                System.out.println("------------------------------------------");
                System.out.printf("%-15s %-30s%n", suppliers[i].getId(), suppliers[i].getName());

                foundSupplier = true;
                break;
            }
        }

        if (!foundSupplier) {
            clearConsole();
            heading("SEARCH SUPPLIERS");
            System.out.println("\nSupplier ID not found.");
        }
        System.out.println("\nPress Enter to return...");
        scn.nextLine();

        clearConsole();
        loadingAnimation("Please Wait");
        Menu.manageSupplier();
    }

    // DELETE SUPPLIERS===============================================================================

    public static void deleteSuppliers() throws InterruptedException {
    clearConsole();
    heading("DELETE SUPPLIERS");

    System.out.print("Enter Supplier ID to delete: ");
    String delSupID = scn.nextLine();

    boolean found = false;

    for(int i=0;i<counter;i++) {
        if (suppliers[i].getId().equalsIgnoreCase(delSupID)) {

            tempSupplier[tempSupCounter] = suppliers[i];
            tempSupCounter++;

            for (int j = i; j < counter - 1; j++) {
                suppliers[j] = suppliers[j + 1];
            }
            suppliers[counter - 1] = null;
            counter--;

            found = true;
            break;
        }
    }

        if (!found) {
            System.out.println("Supplier ID not found.");

        }
        else {
            clearConsole();
            loadingAnimation("Deleting Supplier");

            System.out.println("Supplier deleted successfully.");
        }

        System.out.println("\nPress Enter to continue...");
        scn.nextLine();

        Menu.manageSupplier();
    }

    // update Supplier =================================================================================================

    public static void updateSuppliers() throws InterruptedException {
        clearConsole();
        heading("UPDATE SUPPLIERS");

        System.out.print("Enter the Supplier ID to update: ");
        String upSupId = scn.nextLine();

        boolean found = false;

        for (int i = 0; i < counter; i++) {
            if (upSupId.equals(suppliers[i].getId())) {
                System.out.print("Enter new Supplier ID: ");
                
                
                suppliers[i].setId(scn.nextLine());

                System.out.print("Enter new Supplier Name: ");
                suppliers[i].setName(scn.nextLine());

                found = true;
                break;
            }
        }

        if (!found) {
            heading("UPDATE SUPPLIERS");
            System.out.println("Sorry! Supplier ID not found.");
        }
        Menu.manageSupplier();
    }

        public static void recentlyDeleted()throws InterruptedException {
        clearConsole();
        heading("Recently Deleted");

        System.out.printf("%-20s %-35s%n", "Supplier ID", "Supplier Name");
        System.out.println("----------------------------------------");

        for(int x=0;x<tempSupCounter;x++){
            System.out.printf("%-20s %-35s%n", tempSupplier[x].getId(), tempSupplier[x].getName());
        }

        System.out.println("Do you want to clear the Recycle Bin? (Y/N) : ");
        String clearRecycle = scn.nextLine();

        if(clearRecycle.equalsIgnoreCase("Y")){
            loadingAnimation("Clearing the Recycle Bin");
            clearConsole();
            loadingAnimation("Please wait");
            clearConsole();

            heading("RECYCLE BIN IS CLEARED");

            for (int i=0;i<tempSupCounter;i++) {
                tempSupplier[i] = null;
            }
            tempSupCounter = 0;
        }
        else if(clearRecycle.equalsIgnoreCase("n")){
            System.out.println("\nPress Enter to return");
            scn.nextLine();
        }
        else{
            System.out.println("Invalid Option");
            Menu.manageSupplier();
        }

        Menu.manageSupplier();
    }


    // REPORTS  ================================================================================================
    public static void reports() throws InterruptedException{
        clearConsole();
        System.out.println("=====================================");
        System.out.println("              REPORTS                ");
        System.out.println("=====================================\n\n");

        System.out.println("+-------------------------------------+");
        System.out.println("    STOCK MANAGMENT SYSTEM REPORTS     ");
        System.out.println("---------------------------------------");

        System.out.println("\tSuppliers Currently Added: " + counter);
        System.out.println("|                                      |");
        System.out.println("\tSuppliers Deleted : "+ tempSupCounter);
        System.out.println("|                                      |");
        System.out.println("\tCategories Currently Added: " + CategoryCounter);
        System.out.println("|                                      |");
        System.out.println("\tItems Currently Added: "+ itemcounter);
        System.out.println("|+____________________________________+|");

        if(counter==0 && tempSupCounter==0 && CategoryCounter==0 && itemcounter==0){
            System.out.println("");
            System.out.println("Nothing Added yet!");
        }


        System.out.println("\n\nPress any key to go back: ");
        scn.nextLine();

        clearConsole();
        loadingAnimation("Loading Main Menu");
        clearConsole();
        
        Menu.mainMenu();
    }

}
