public class CharacterCopier {

    private final ISource source;
    private final IDestination destination;

    public CharacterCopier(ISource source, IDestination destination) {
        this.source = source;
        this.destination = destination;
    }

    public void copy() {
        char character = source.getChar();
        while(character != '\n') {
            destination.setChar(character);
            character = source.getChar();
        }
    }
}
