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
}
