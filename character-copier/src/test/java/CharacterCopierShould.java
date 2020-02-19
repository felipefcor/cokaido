import org.junit.Assert;
import org.junit.Test;

public class CharacterCopierShould {

    @Test
    public void copy_a_character_from_source_to_destination(){

        ISource source = new CharacterSource("p\n");
        CharacterDestination destination = new CharacterDestination();
        CharacterCopier copier = new CharacterCopier(source, destination);

        copier.copy();

        Assert.assertEquals('p', destination.getCharCopy());
    }

    @Test
    public void not_copy_character_if_newline(){
        ISource source = new CharacterSource("\n");
        CharacterDestination destination = new CharacterDestination();
        CharacterCopier copier = new CharacterCopier(source, destination);

        copier.copy();

        Assert.assertEquals(0, destination.getCharCopy());
    }

    @Test
    public void stop_copying_when_character_is_a_newline(){
        ISource source = new CharacterSource("pe\n");
        CharacterDestination destination = new CharacterDestination();
        CharacterCopier copier = new CharacterCopier(source, destination);

        copier.copy();

        Assert.assertEquals('e', destination.getCharCopy());
    }
}
