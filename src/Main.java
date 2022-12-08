import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int count = 0;
        int choice = 1;
        String c = "";
        Scanner s = new Scanner(System.in);
        System.out.print("Full Name: ");
        String n = s.nextLine();
        Bank bank = new Bank();
        BagelShop bagel = new BagelShop(n, 500, 2, bank);
        System.out.print("What would you like your pin to be: ");
        String p = s.next();
        CreditCard card = new CreditCard(n, p);
        BankApp app = new BankApp(bagel, bank, card);
        while (!c.equals("7")) {
            System.out.println("\n" + app.bankAppMenu());
            System.out.print("Choice: ");
            c = s.next();
            if (c.equals("1")) {
                if (count > 0) {
                    System.out.print("Which card would you like to use: ");
                    choice = s.nextInt();
                }
                System.out.print("\nBagel Price: $2\nHow many bagels would you like to buy: ");
                int quantity = s.nextInt();
                System.out.print("Enter Pin Number: ");
                String pin = s.next();
                System.out.println(app.purchase(quantity, pin, choice));
            }
            if (c.equals("2")) {
                System.out.print("How many bagels would you like to return: ");
                int quantity = s.nextInt();
                System.out.print("Enter Pin Number: ");
                String pin = s.next();
                System.out.println(app.returnItem(quantity, pin));
            }
            if (c.equals("3") && (count == 0)) {
                System.out.print("\nFull Name: ");
                n = s.next();
                System.out.print("What would you like your pin to be: ");
                p = s.next();
                CreditCard card2 = new CreditCard(n, p);
                app.newCard(card2);
                count += 1;
                int cardCount = 2;
            }
            if (c.equals("3") && (count != 0)) {
                System.out.println("\nYou Have Already Opened A Second Card");
            }
            if (c.equals("4")) {
                System.out.println("\n" + app.checkInventory());
            }
            if (c.equals("5")) {
//                if (count > 1){
//                    System.out.println("Which account would you like to deposit to (1 or 2): ");
//                    int b = s.nextInt();
//                    if (b == 2){
//                        bagel.changeBank(bank2);
//                    }
                System.out.println(app.depositProfits());
                System.out.println(bank);
            }
            if (c.equals("6")) {
                System.out.println("\n" + app.printCard1());
                if (app.printCard2() != null) {
                    System.out.println("\n" + app.printCard2());
                }
            }

        }
        // call methods from your BankApp object to handle program logic
    }
}
