package Pizza;

public interface Pizza {
    String getDescription();
    double getCost();
}

class PlainPizza implements Pizza {
    @Override
    public String getDescription(){
        return "Plain Dough & Sauce";
    }

    @Override
    public double getCost(){
        return 5.0;
    }
}
