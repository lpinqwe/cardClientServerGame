package gameLogic.utils;

public class Card {
    int cost  ;
    String type;

    public int getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    Card(int cost, String type){
        this.cost = cost;
        this.type=type;
    }

}
