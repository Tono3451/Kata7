package software.ulpgc.kata7.model;

public record ApiPokemon(String name, Sprites sprites) {

    public record Sprites(String front_default) {
    }
}
