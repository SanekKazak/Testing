import Geo.Compas;
import Geo.Exceptions.ExampleException;
import Geo.GeoItem;
import Geo.Service.CompasService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockTest {
    @Test
    public void constructorTest(){
        GeoItem tester = Mockito.mock(GeoItem.class);
        assertNull(tester.getSide());
    }
    @Test
    public void getterTest() throws ExampleException {
        Compas tester = Mockito.mock(Compas.class);
        when(tester.getSide()).thenReturn(null);

        CompasService service = new CompasService(tester);
        assertNull(service.getSide());
        verify(tester).getSide();
    }

    @Test
    public void mainMethodTest() throws ExampleException {
        Compas tester = Mockito.mock(Compas.class);
        when(tester.changeSide(2)).thenThrow(new ExampleException("Error"));

        CompasService service = new CompasService(tester);
        assertThrows(ExampleException.class, () -> {
            service.getWorldSide(2);
        });
        verify(tester).changeSide(2);
    }
}
