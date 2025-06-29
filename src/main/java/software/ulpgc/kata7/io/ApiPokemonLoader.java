package software.ulpgc.kata7.io;

import software.ulpgc.kata7.model.Pokemon;

public class ApiPokemonLoader implements PokemonLoader{
    private final PokemonReader pokemonReader;
    private final PokemonDeserializer pokemonDeserializer;
    private final PokemonAdapter pokemonAdapter;

    public ApiPokemonLoader(PokemonReader pokemonReader, PokemonDeserializer pokemonDeserializer, PokemonAdapter pokemonAdapter) {
        this.pokemonReader = pokemonReader;
        this.pokemonDeserializer = pokemonDeserializer;
        this.pokemonAdapter = pokemonAdapter;
    }

    @Override
    public Pokemon load(String pokemon) {
        return pokemonAdapter.adapt(pokemonDeserializer.deserialize(pokemonReader.read(pokemon.toLowerCase())));
    }
}
