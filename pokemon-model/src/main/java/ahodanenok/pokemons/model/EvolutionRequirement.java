package ahodanenok.pokemons.model;

public class EvolutionRequirement {

    private String item;
    private int amount;

    public EvolutionRequirement() { }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
