import java.util.ArrayList;
import java.util.List;

public class PokemonTrainer {
    List<Pokemon> pokemons = new ArrayList<Pokemon>();
    String name;


    public PokemonTrainer(String name, List<Pokemon> pokemons) {
        this.pokemons = pokemons;
        this.name = name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
