public class Login extends Main{
    // LOGIN PAGE====================================================================================

    public static void loginPage() throws InterruptedException {

        while (true) {

            clearConsole();

            heading("STOCK MANAGMENT SYSTEM");

            // Username Validation===============================================
            while (true) {

                System.out.print("Enter Username : ");
                String inputUserName = scn.nextLine();

                if (inputUserName.equals(userName)) {
                    loadingAnimation("Validating Username");
                    clearConsole();
                    heading("STOCK MANAGMENT SYSTEM");
                    loadingAnimation("Username Matched");
                    clearConsole();
                    break;
                } else {
                    clearConsole();
                    heading("STOCK MANAGMENT SYSTEM");
                    System.out.println("\nIncorrect Username! Please try again.\n");
                }
            }

            // Password Validation================================================
            while (true) {
                heading("STOCK MANAGMENT SYSTEM");

                System.out.print("Enter Password : ");
                String inputPassword = scn.nextLine();

                if (inputPassword.equals(passWord)) {
                    clearConsole();
                    loadingAnimation("Validating Password");
                    clearConsole();
                    heading("STOCK MANAGMENT SYSTEM");
                    loadingAnimation("Loading Main Menu");
                    Thread.sleep(600);

                    clearConsole();

                    return;
                } else {
                    System.out.println("\nIncorrect Password! Please try again.\n");
                    
                }
            }
        }
    }

    // Change Credentials====================================================================================

    public static void changeCredentials() throws InterruptedException {
        clearConsole();

        heading("CHANGE CREDENTIALS");

        while (true) {
            System.out.print("Enter Username : ");
            String credentialsInputUserName = scn.nextLine();

            if (credentialsInputUserName.equals(userName)) {
                clearConsole();
                heading("CHANGE CREDENTIALS");
                loadingAnimation("Validating Username");
                clearConsole();
                break;
            } else {
                System.out.println("\nIncorrect Username! Please try again.\n");
            }
        }

        while (true) {

            heading("CHANGE CREDENTIALS");
            System.out.print("Enter Password : ");
            String credentialsInputPassword = scn.nextLine();

            if (credentialsInputPassword.equals(passWord)) {
                heading("CHANGE CREDENTIALS");
                clearConsole();
                loadingAnimation("Validating Password");
                clearConsole();
                break;
            } else {
                clearConsole();
                heading("CHANGE CREDENTIALS");
                System.out.println("\nIncorrect Password! Please try again.\n");
            }
        }

        while (true) {
            heading("CHANGE CREDENTIALS");
            System.out.print("Enter your new Username : ");
            String newUserName = scn.nextLine();
            clearConsole();

            if (!newUserName.equals(userName)) {
                userName = newUserName;
                heading("CHANGE CREDENTIALS");
                loadingAnimation("Updating Username");
                clearConsole();
                break;
            } else {
                heading("CHANGE CREDENTIALS");
                System.out.println("Username is already in use. Try another.\n");
            }
        }

        while (true) {
            heading("CHANGE CREDENTIALS");
            System.out.print("Enter your new PassWord: ");
            String newPassWord = scn.nextLine();

            if (!newPassWord.equals(passWord)) {
                passWord = newPassWord;

                System.out.println(passWord);
                loadingAnimation("Updating Password");
                clearConsole();
                heading("CHANGE CREDENTIALS");
                loadingAnimation("Updating the Credentials");
                clearConsole();
                break;
            } else {
                heading("CHANGE CREDENTIALS");
                System.out.println("Username is already in use. Try another.\n");
            }
        }

        Menu.mainMenu();
    }
}
