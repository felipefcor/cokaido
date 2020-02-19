import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class CharacterCopierMockShould {
    private CharacterCopier copier;
    @Mock
    private ISource source;
    @Mock
    private IDestination destination;

    @BeforeEach
    void Init() {
        copier = new CharacterCopier(source, destination);
    }

    @Test
    void copy_one_character_from_source_to_destination() {
        //Arrange
        when(source.getChar()).thenReturn('a', 'b','\n');
        //Act
        copier.copy();
        //Assert
        verify(destination).setChar('a');
    }
}