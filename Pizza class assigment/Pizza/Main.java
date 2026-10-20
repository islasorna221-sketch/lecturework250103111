package Pizza;

public class Main {
    public static void main(String[] args) {
        Pizza myPizza = new PlainPizza();
        myPizza = new Cheese(myPizza);
        myPizza = new Olives(myPizza);
        myPizza = new Pineapple(myPizza);
        myPizza = new Cheese(myPizza);
        myPizza = new Cheese(myPizza);

        System.out.println("Full Order:"+myPizza.getDescription());
        System.out.println("Price:$"+myPizza.getCost());

    }
}
