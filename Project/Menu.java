public class Menu extends Main{
     // MAIN MENU====================================================================================

    public static void mainMenu() throws InterruptedException {
        System.out.println(currentDate);
        
        heading("STOCK MANAGMENT SYSTEM");
        System.out.println("|                  [1] Change the Credentials                   |\n");
        System.out.println("|                  [2] Manage Suppliers                         |\n");
        System.out.println("|                  [3] Stock Manage                             |\n");
        System.out.println("|                  [4] Logout                                   |\n");
        System.out.println("|                  [5] Reports                                   |\n");
        System.out.println("|                  [6] Exit the System                          |\n");
        System.out.println("+===============================================================+");

        System.out.print("Enter an option to continue: ");
        int option = scn.nextInt();
        scn.nextLine();

        switch (option) {
            case 1:
                Login.changeCredentials();
                break;
            case 2:
                manageSupplier();
                break;
            case 3:
                manageStocks();
                break;
            case 4:
                Login.loginPage();
                break;
            case 5:
                Supplier.reports();
                break;
            case 6:
                exitSystem();
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
    }

        // Exit the system====================================================================
    public static void exitSystem() throws InterruptedException {
        System.out.println("+===============================================================+\n");
        System.out.println("|                 EXITING STOCK MANAGEMENT SYSTEM               |");
        System.out.println("|===============================================================+\n");

        clearConsole();
        System.out.println("+===============================================================+");
        System.out.println("|                                                               |");
        System.out.println("|              EXITING STOCK MANAGEMENT SYSTEM                  |");
        System.out.println("|                                                               |");
        System.out.println("|              Thank you for your time!                         |");
        System.out.println("|              Have a great day!                                |");
        System.out.println("|                                                               |");
        System.out.println("+===============================================================+");

        Thread.sleep(2000);
        clearConsole();
    }

    // Manage stock ============================================================================================

    public static void manageStocks() throws InterruptedException {
        clearConsole();
        loadingAnimation("Opening Stock Management...");
        clearConsole();
        heading("STOCK MANAGMENT   ");

        System.out.print("[1]Manage Item Categories");
        System.out.println("\t[2]Add Items");
        System.out.print("[3]Get Item Supplier Wise");
        System.out.println("\t[4]View Item");
        System.out.print("[5]Rank Item Per Unit Price");
        System.out.println("\t[6]Home Page");

        System.out.print("\nEnter Your Option: ");
        int supplierOption = scn.nextInt();
        scn.nextLine();

        clearConsole();

        switch (supplierOption) {
            case 1:
                Category.manageItemCategories();
                break;
            case 2:
                Item.addItems();
                break;
            case 3:
                Item.getIteamSupplierWise();
                break;
            case 4:
                Item.viewItem();
                break;
            case 5:
                Item.rankIteamPerUnitPrice();
                break;
            case 6:
                Menu.mainMenu();
                break;

            default:
                System.out.println("Invalid Option");
                break;
        }
    }



     // MANAGE SUPPLIERS ====================================================================================
    public static void manageSupplier() throws InterruptedException {
        clearConsole();
        loadingAnimation("Opening supplier management...");
        clearConsole();
        heading("MANAGE SUPPLIERS");

        System.out.print("[1]Add Suppliers");
        System.out.println("\t[2]Update Suppliers");
        System.out.print("[3]Delete Suppliers");
        System.out.println("\t[4]View Suppliers");
        System.out.print("[5]Search Suppliers");
        System.out.println("\t[6]Home Page");
        System.out.println("[7]Recently Deleted");

        System.out.print("\nEnter Your Option: ");
        int supplierOption = scn.nextInt();
        scn.nextLine();

        clearConsole();

        switch (supplierOption) {
            case 1:
                Supplier.addSuppliers();
                break;
            case 2:
                Supplier.updateSuppliers();
                break;
            case 3:
                Supplier.deleteSuppliers();
                break;
            case 4:
                Supplier.viewSuppliers();
                break;
            case 5:
                Supplier.searchSupplier();
                break;
            case 6:
                Menu.mainMenu();
                break;
            case 7:
                Supplier.recentlyDeleted();
                break;

            default:
                System.out.println("Invalid Option");
                break;
        }
    }

}
