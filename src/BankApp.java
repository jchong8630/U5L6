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

    public String bankAppMenu(){
        return "Bank App Menu:\n1. Make A Purchase\n2. Return An Item\n3. Open Second Card\n4. Check Bagel Inventory\n5. Deposit Profits\n6. Compare Credit Card Balances";
    }
    public void newCard(CreditCard card){
        card2 = card;
    }
    public String purchase(int quantity, String pin, int choice){
        if (choice == 1) {
            if (bagel.payForBagels(card, quantity, pin)) {
                return "\nPayment Successful";
            }
        }
        else if (choice == 2){
            if (card2.checkPIN(pin)){
                bagel.payForBagels(card2, quantity, pin);
                return "\nPayment Successful";
            }
        }
        return "\nPayment Failed";
    }
    public String returnItem(int quantity, String pin){
        if (card.checkPIN(pin)){
            bagel.returnBagels(card, quantity, pin);
            return "\nReturn Successful";
        }
        return "\nReturn Failed";
    }

    public BagelShop checkInventory(){
       return bagel;
    }

    public String depositProfits(){
        bagel.depositProfits();
        return "\nDeposit Successful";
    }

    public CreditCard printCard1(){
        return card;
    }
    public CreditCard printCard2(){
        return card2;
    }


}
