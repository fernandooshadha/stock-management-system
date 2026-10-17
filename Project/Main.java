import java.util.Scanner;
import java.time.LocalDate;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static String userName = "Oshadha";
    public static String passWord = "1234";

    public static Supplier[] suppliers = new Supplier[100];
    public static int counter = 0;

    public static Supplier[] tempSupplier = new Supplier[100];
    public static int tempSupCounter = 0;

    public static Item[] items = new Item[200];
    public static int itemcounter = 0;

    public static Category[] categories = new Category[200];
    public static int CategoryCounter = 0;

    public static LocalDate currentDate = LocalDate.now();

    // CLEAR CONSOLE====================================================================================

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Heading====================================================================================

    public static void heading(String heading) {
        System.out.println("+===============================================================+\n");
        System.out.println("|\t\t\t" + heading + "\t" + "\t\t|\n");
        System.out.println("|===============================================================+\n");
    }

    // LOADING ANIMATION====================================================================================

    public static void loadingAnimation(String text) throws InterruptedException {
        System.out.print(text + " ");

        for (int i = 0; i < 10; i++) {
            Thread.sleep(60);
            System.out.print("█");
        }
        System.out.println();
        Thread.sleep(200);
    }

    // Main Menu ==============================================================================================

    public static void main(String[] args) throws InterruptedException {

        clearConsole();
        loadingAnimation("Loading System");
        Login.loginPage();
        Menu.mainMenu();
    }
}