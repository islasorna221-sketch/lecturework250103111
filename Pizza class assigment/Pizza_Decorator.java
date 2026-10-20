package Pizza;

abstract class PizzaDecorator implements Pizza{
    protected final Pizza pizza;

    public PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }
}

class Cheese extends PizzaDecorator{
    public Cheese(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getDescription(){
        return pizza.getDescription()+",Cheese";
    }

    @Override
    public double getCost(){
        return pizza.getCost()+2.0;
    }
}

class Olives extends PizzaDecorator{
    public Olives(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ",Olives";
    }

    @Override
    public double getCost(){
        return pizza.getCost()+1.0;
    }
}

class Pineapple extends PizzaDecorator{
    public Pineapple(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ",Pineapple";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.5;
    }
}