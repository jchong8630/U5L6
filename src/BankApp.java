import java.util.Scanner;
public class BankApp {
    private Bank bank;
    private CreditCard card;
    private CreditCard card2;
    private BagelShop bagel;
    public BankApp(BagelShop bagel, Bank bank, CreditCard card){
        this.bagel = bagel;
        this.bank = bank;
        this.card = card;
    }

    public String bagelShopMenu(){
        return "Bagel Menu:\n1. Make A Purchase\n2. Return An Item\n3. Open Second Card\n4. Exit";
    }
    public void newCard(CreditCard card){
        card2 = card;
    }
    public String purchase(int quantity, String pin, int choice){
        if (choice == 1) {
            if (card.checkPIN(pin)) {
                bagel.payForBagels(card, quantity, pin);
                return "Payment Successful";
            }
        }
        else if (choice == 2){
            if (card2.checkPIN(pin)){
                bagel.payForBagels(card2, quantity, pin);
                return "Payment Successful";
            }
        }
        return "Payment Failed";
    }
    public String returnItem(int quantity, String pin){
        if (card.checkPIN(pin)){
            bagel.returnBagels(card, quantity, pin);
            return "Return Successful";
        }
        return "Return Failed";
    }



}
