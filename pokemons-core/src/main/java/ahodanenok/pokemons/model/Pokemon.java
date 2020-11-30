package ahodanenok.pokemons.model;

import java.util.List;
import java.util.Set;

public class Pokemon {

    private int number;

    private String name;
    private String description;
    private String generation;

    private Set<PokemonType> types;
    private Set<PokemonType> resistance;
    private Set<PokemonType> weakness;

    private Set<PokemonAttack> fastAttacks;
    private Set<PokemonAttack> specialAttacks;

    private int maxHP;
    private int maxCP;

    private int minHeight;
    private int maxHeight;

    private int minWeight;
    private int maxWeigth;

    private int baseStamina;
    private int baseAttack;
    private int baseDefense;
    private int baseFleeRate;

    private EvolutionRequirement evolutionRequirement;
    private List<Evolution> previousEvolutions;
    private List<Evolution> nextEvolutions;

    public Pokemon() { }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public Set<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(Set<PokemonType> types) {
        this.types = types;
    }

    public Set<PokemonType> getResistance() {
        return resistance;
    }

    public void setResistance(Set<PokemonType> resistance) {
        this.resistance = resistance;
    }

    public Set<PokemonType> getWeakness() {
        return weakness;
    }

    public void setWeakness(Set<PokemonType> weakness) {
        this.weakness = weakness;
    }

    public Set<PokemonAttack> getFastAttacks() {
        return fastAttacks;
    }

    public void setFastAttacks(Set<PokemonAttack> fastAttacks) {
        this.fastAttacks = fastAttacks;
    }

    public Set<PokemonAttack> getSpecialAttacks() {
        return specialAttacks;
    }

    public void setSpecialAttacks(Set<PokemonAttack> specialAttacks) {
        this.specialAttacks = specialAttacks;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMaxCP() {
        return maxCP;
    }

    public void setMaxCP(int maxCP) {
        this.maxCP = maxCP;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public int getMaxWeigth() {
        return maxWeigth;
    }

    public void setMaxWeigth(int maxWeigth) {
        this.maxWeigth = maxWeigth;
    }

    public int getBaseStamina() {
        return baseStamina;
    }

    public void setBaseStamina(int baseStamina) {
        this.baseStamina = baseStamina;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public int getBaseFleeRate() {
        return baseFleeRate;
    }

    public void setBaseFleeRate(int baseFleeRate) {
        this.baseFleeRate = baseFleeRate;
    }

    public EvolutionRequirement getEvolutionRequirement() {
        return evolutionRequirement;
    }

    public void setEvolutionRequirement(EvolutionRequirement evolutionRequirement) {
        this.evolutionRequirement = evolutionRequirement;
    }

    public List<Evolution> getPreviousEvolutions() {
        return previousEvolutions;
    }

    public void setPreviousEvolutions(List<Evolution> previousEvolutions) {
        this.previousEvolutions = previousEvolutions;
    }

    public List<Evolution> getNextEvolutions() {
        return nextEvolutions;
    }

    public void setNextEvolutions(List<Evolution> nextEvolutions) {
        this.nextEvolutions = nextEvolutions;
    }
}
