public class Item extends Main{

    private String code;
    private String supplierId;
    private String categoryName;
    private String description;
    private double unitPrice;
    private int qty;

    public Item(String code, String supplierId, String categoryName,String description, double unitPrice, int qty) {
        this.code = code;
        this.supplierId = supplierId;
        this.categoryName = categoryName;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    // ADD ITEM ==============================================================================================

    public static void addItems() throws InterruptedException {
        clearConsole();
        heading("ADD ITEMS       ");

        if(counter==0) {
            System.out.println("Oops! It seems that you don't have any suppliers in the system.");
            System.out.print("Do you want to add a new supplier? (Y/N): ");
            String moveToSup = scn.nextLine();

            if (moveToSup.equalsIgnoreCase("Y")) {
                clearConsole();
                loadingAnimation("Redirecting to Add Suppliers");
                clearConsole();
                Supplier.addSuppliers();
                return;
            }
            else if (moveToSup.equalsIgnoreCase("N")) {
                Menu.manageStocks();
                return;
            }
            else {
                System.out.println("Invalid Option.");
                Thread.sleep(1000);
                addItems();
                return;
            }
        }

        System.out.print("Do you want to add an item? (Y/N): ");
        String sI = scn.nextLine();

        String itemCode = null;

        if(sI.equalsIgnoreCase("Y")) {
            System.out.print("Enter Item Code: ");
            itemCode = scn.nextLine();

            clearConsole();

            for(int x=0;x<itemcounter;x++) {
                if(items[x].getCode() != null && items[x].getCode().equals(itemCode)) {
                    System.out.println("Item code already exists!");
                    Category.manageItemCategories();
                    return;
                }
            }
        }
        else{
            clearConsole();
        }
        // Suppliers exist
        heading("ADD ITEMS       ");

        System.out.println("");
        System.out.println("Supplier List");

        System.out.println("+------+----------------------+--------------------------------+");
        System.out.printf("| %-4s | %-20s | %-30s |%n","No.", "SUPPLIER ID", "SUPPLIER NAME");
        System.out.println("+------+----------------------+--------------------------------+");

        for(int i=0;i<counter;i++) {
            System.out.printf("| %-4d | %-20s | %-30s |%n", i + 1,
                    suppliers[i].getId(),
                    suppliers[i].getName());
        }

        System.out.println("+------+----------------------+--------------------------------+");

        System.out.println("");
        System.out.print("Select Supplier By No. To Item Code " + itemCode + ": ");
        String itemSupp = scn.nextLine();

        clearConsole();
        loadingAnimation("Saving Supplier");
        clearConsole();

        heading("ADD ITEMS       ");

        if(CategoryCounter ==0) {
            System.out.println("Oops! It seems that you don't have any Item Category in the system.");
            System.out.print("Do you want to add a new Item Category?(Y/N): ");
            String moveToSup = scn.nextLine();

            if(moveToSup.equalsIgnoreCase("Y")) {
                clearConsole();
                loadingAnimation("Redirecting to Item Category");
                clearConsole();
                Category.addNewItemCategory();
                return;
            }
            else if(moveToSup.equalsIgnoreCase("N")) {
                Menu.manageStocks();
                return;
            }
            else {
                System.out.println("Invalid Option.");
                Thread.sleep(1000);
                addItems();
                return;
            }
        }

        System.out.println("");
        System.out.println("Item Category");

        System.out.println("+------+--------------------------------+");
        System.out.printf("| %-4s | %-30s |%n",
                "No.", "CATEGORY NAME");
        System.out.println("+------+--------------------------------+");

        for(int i=0;i<CategoryCounter;i++) {
            System.out.printf("| %-4d | %-30s |%n", i + 1, categories[i].getName());
        }
        System.out.println("+------+--------------------------------+");

        System.out.print("Select Category To Item Code " + itemCode + ": ");
        String categoryNo = scn.nextLine();

        System.out.print("Description: ");
        String desc = scn.nextLine();

        System.out.print("Unit Price: ");
        double unitPrice = Double.parseDouble(scn.nextLine());

        System.out.print("Qty on hand : ");
        int qty = Integer.parseInt(scn.nextLine());

        String supplierID = "";

        for (int i=0;i<counter;i++) {
            if(itemSupp.equals(""+(i + 1))) {
                supplierID = suppliers[i].getId();
                break;
            }
        }

        String categoryName = "";

        for (int i=0;i<CategoryCounter;i++) {
            if (categoryNo.equals(""+(i + 1))) {
                categoryName = categories[i].getName();
                break;
            }
        }

        items[itemcounter]=new Item(itemCode, supplierID, categoryName, desc, unitPrice, qty);
        itemcounter++;

        System.out.println("\nItem added successfully!");

        System.out.print("Press any key to continue");
        scn.nextLine();

        Menu.manageStocks();
    }

     // View Items ================================================================================
    public static void viewItem() throws InterruptedException {
        clearConsole();
        heading("VIEW ITEMS       ");

        if (CategoryCounter == 0) {
            System.out.println("There are no item categories added.");

            System.out.print("\nDo you want to add a new category? (Y/N): ");
            String choice = scn.nextLine();

            if(choice.equalsIgnoreCase("Y")) {
                Category.addNewItemCategory();
            }
            else {
                Menu.manageStocks();
            }
            return;
        }

        for(int c=0;c<CategoryCounter;c++) {

            if (categories[c] == null) {
                continue;
            }

            System.out.println("Category          :            " + categories[c].getName());
            System.out.println("================================================================\n");

            System.out.printf("%-12s %-15s %-25s %-12s %-10s %-15s%n",
                    "Item Code","Supplier ID","Description","Unit Price","Quantity","Category");

            System.out.println("----------------------------------------------------------------------------------------------");
            boolean itemFound = false;

            for (int i=0;i<itemcounter;i++) {

                if (items[i].getCategoryName() != null && items[i].getCategoryName().equalsIgnoreCase(categories[c].getName())) {
                    System.out.printf("%-12s %-15s %-25s %-12s %-10s %-15s%n",
                            items[i].getCode(),
                            items[i].getSupplierId(),
                            items[i].getDescription(),
                            items[i].getUnitPrice(),
                            items[i].getQty(),
                            items[i].getCategoryName());

                    itemFound = true;
                }
            }

            if (!itemFound) {
                System.out.println("No items available in this category.");
                System.out.println("\n");
            }
        }

        System.out.print("\nPress Enter to return...");
        scn.nextLine();

        clearConsole();
        loadingAnimation("Redirecting to Manage Stock Page");

        Menu.manageStocks();
    }

    // rankIteamPerUnitPrice============================================================================
    public static void rankIteamPerUnitPrice() throws InterruptedException {

        clearConsole();
        System.out.println("+===============================================================+\n");
        System.out.println("|                    RANK ITEM PER UNIT PRICE                   |\n");
        System.out.println("|===============================================================+\n");

        for (int i=0;i<itemcounter-1;i++) {

            for(int j=0;j<itemcounter-i -1;j++) {
                double price1 = items[j].getUnitPrice();
                double price2 = items[j + 1].getUnitPrice();

                if (price1>price2) {
                    Item temp = items[j];
                    items[j] =items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }

        System.out.printf("%-12s %-15s %-20s %-12s %-10s%n",
                "Item Code",
                "Supplier ID",
                "Description",
                "Unit Price",
                "Quantity");

        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < itemcounter; i++) {
            System.out.printf("%-12s %-15s %-20s %-12s %-10s%n",
                    items[i].getCode(),
                    items[i].getSupplierId(),
                    items[i].getDescription(),
                    items[i].getUnitPrice(),
                    items[i].getQty());
        }
        System.out.print("\nPress Enter to continue...");
        scn.nextLine();

        Menu.manageStocks();
    }

     // getIteamSupplierWise============================================================================
    public static void getIteamSupplierWise() throws InterruptedException {
        clearConsole();

        System.out.println("+===============================================================+\n");
        System.out.println("|                    SEARCH ITEM SUPPLIER WISE                  |\n");
        System.out.println("+===============================================================+\n");

        System.out.println();
        System.out.print("Enter Supplier ID : ");
        String searchID = scn.nextLine();

        if (counter == 0) {
            System.out.println("There is no supplier existed!!!");

            System.out.println("Do you want to add a supplier(Y/N) : ");
            scn.nextLine();
        }

        boolean supplierFound = false;

        for(int i=0;i<counter;i++) {

            if(suppliers[i].getId()!= null && suppliers[i].getId().equalsIgnoreCase(searchID)) {

                supplierFound = true;

                System.out.println();
                System.out.println("Supplier Name : " + suppliers[i].getName());
                System.out.println();


                System.out.printf("%-12s %-20s %-20s %-12s %-10s%n",
                        "Item Code","Category","Description","Unit Price","Qty");

                System.out.println("--------------------------------------------------------------------------");

                boolean itemFound = false;

                for (int j=0;j<itemcounter;j++) {

                    if (items[j].getSupplierId() != null && items[j].getSupplierId().equalsIgnoreCase(searchID)) {

                        System.out.printf("%-12s %-20s %-20s %-12s %-10s%n",
                                items[j].getCode(),
                                items[j].getCategoryName(),
                                items[j].getDescription(),
                                items[j].getUnitPrice(),
                                items[j].getQty());

                        itemFound = true;

                        System.out.print("Do you want to Search an another Supplier (Y/N): ");
                        String searchAgain = scn.nextLine();

                        if (searchAgain.equalsIgnoreCase("Y")) {
                            getIteamSupplierWise();
                            return;
                        } else {
                            clearConsole();
                            Category.manageItemCategories();
                            return;
                        }
                    }
                }
                if (!itemFound) {
                    System.out.println("No items available for this supplier.");
                }
                break;
            }
        }
        if (!supplierFound) {
            System.out.println("\nSupplier ID not found.");
        }

        System.out.println("\nPress Enter to return...");
        scn.nextLine();

        Menu.manageStocks();
    }


}