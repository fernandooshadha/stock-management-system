public class Category extends Main {

    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // manageItemCategories============================================================================

    public static void manageItemCategories() throws InterruptedException {
        heading("MANAGE ITEM CATEGORIES");

        System.out.print("[1]Add New Item Category");
        System.out.println("\t[2]Delete Item Category");
        System.out.print("[3]Update Item Category");
        System.out.println("     \t[4]Stock Management");

        System.out.println(" ");

        System.out.print("Select an option: ");
        int itemOption = scn.nextInt();
        scn.nextLine();

        switch (itemOption) {
            case 1:
                addNewItemCategory();
                break;
            case 2:
                deleteItemCategory();
                break;
            case 3:
                updateItemCategory();
                break;
            case 4:
                Menu.manageStocks();
                break;
            case 5:
                Item.rankIteamPerUnitPrice();
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
    }

    // addNewItemCategory============================================================================

    public static void addNewItemCategory() throws InterruptedException {
        clearConsole();
        loadingAnimation("Redirecting to Add new item category");
        clearConsole();

        heading("ADD NEW ITEM Category");

        System.out.println("Add a new Category Item here press any key to continue...\n\n");
        scn.nextLine();

        System.out.print("Do you want to add new Cetegory (Y/N): ");
        String userAddNewC = scn.nextLine();

        System.out.println(" ");

        if (userAddNewC.equalsIgnoreCase("Y")) {
            System.out.print("Enter category name: ");
            String cName = scn.nextLine();
            categories[CategoryCounter] = new Category(cName);
            CategoryCounter++;

            System.out.println(" ");

            System.out.print("Press return to continue...");
            scn.nextLine();

            clearConsole();
            Menu.manageStocks();
        }
        else if (userAddNewC.equalsIgnoreCase("n")) {
            clearConsole();
            manageItemCategories();
        }
    }

    // deleteItemCategory============================================================================
    public static void deleteItemCategory() throws InterruptedException {
        clearConsole();
        heading("DELETE ITEM CATEGORY");

        System.out.println("Delete an item category...\n");
        scn.nextLine();

        System.out.print("Enter the item category name to delete: ");
        String userItemDel = scn.nextLine();

        for (int a=0; a<CategoryCounter; a++) {

            if(categories[a] !=null && userItemDel.equalsIgnoreCase(categories[a].getName())) {
                categories[a] = null;
                break;
            }
        }

        System.out.println("\n");
        System.out.println("Press any key to continue");
        scn.nextLine();

        clearConsole();
        loadingAnimation("Redirecting to Manag Stocks Page");
        clearConsole();
        Menu.manageStocks();
    }

    // updateItemCategory============================================================================
    public static void updateItemCategory() throws InterruptedException {

        clearConsole();

        heading("UPDATE ITEM CATEGORY");

        System.out.print("Enter the Category name to Update: ");
        String oldCategory = scn.nextLine();

        System.out.print("Enter the New Category name: ");
        String newCategory = scn.nextLine();

        boolean isFound = false;

        for (int i = 0; i < CategoryCounter; i++) {

            if (categories[i] != null && categories[i].getName().equalsIgnoreCase(oldCategory)) {
                categories[i].setName(newCategory);
                isFound = true;
            }
        }

        for (int i=0;i<itemcounter;i++) {
            if (items[i].getCategoryName() != null && items[i].getCategoryName().equalsIgnoreCase(oldCategory)) {
                items[i].setCategoryName(newCategory);
                isFound = true;
            }
        }

        if(isFound) {
            System.out.println("Category updated successfully!");
        }
        else {
            System.out.println("Category not found!");
        }
        System.out.print("Press Enter to continue...");
        scn.nextLine();

        Category.manageItemCategories();
    }


}