package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;
    private static final int DEFAULT_BADGES = 0;

    public Trainer(String name) {
        this.name = name;
        numberOfBadges = DEFAULT_BADGES;
        this.pokemons = new ArrayList<>();
    }

    private int getPokemonCount(){
        return this.pokemons.size();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public boolean containsPokemonsWithGivenElement (String element){
        return this.pokemons.stream().anyMatch(pokemon -> pokemon.getElement().equals(element));
    }
    public void increaseBadges(){
        this.numberOfBadges++;
    }
    public void decreasePokemonHealth (){
        this.pokemons = this.pokemons.stream()
                .peek(Pokemon::decreaseHealth)
                .filter(p->p.getHealth()>0)
                .collect(Collectors.toList());
    }
    @Override
    public String toString (){
        return String.format("%s %d %d",getName(),getNumberOfBadges(),getPokemonCount());
    }

}
