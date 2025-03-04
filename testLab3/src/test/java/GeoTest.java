import Geo.Compas;
import Geo.Exceptions.ExampleException;
import Geo.GeoItem;
import Geo.WorldSide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GeoTest {
    @Test
    public void getterAndSetterTest(){
        GeoItem tester = new Compas(WorldSide.SV);
        tester.setSide(WorldSide.Z);
        assertEquals(WorldSide.Z, tester.getSide());
    }
    @Test
    public void constructorTest(){
        GeoItem tester = new Compas(WorldSide.SV);
        assertEquals(WorldSide.SV, tester.getSide());
    }
    @Test
    public void betweenTest(){
        GeoItem tester = new Compas(WorldSide.SV);
        Compas tester1 = new Compas(tester.getSide());
        assertEquals(tester.getSide(), tester1.getSide());
    }
    @Test
    public void methodBoundsDefTest() throws ExampleException {
        Compas tester = new Compas(WorldSide.SV);
        assertThrows(ExampleException.class, () -> {
            tester.changeSide(3);
        });
    }
    @Test
    public void methodResultFirstLeftSpinTest() throws ExampleException{
        Compas tester = new Compas(WorldSide.SV);
        assertEquals(WorldSide.Z, tester.changeSide(1));
        assertEquals(WorldSide.Z, tester.getSide());
    }
    @Test
    public void methodResultSecondLeftSpinTest() throws ExampleException{
        Compas tester = new Compas(WorldSide.Z);
        assertEquals(WorldSide.YG, tester.changeSide(1));
        assertEquals(WorldSide.YG, tester.getSide());
    }
    @Test
    public void methodResultThirdLeftSpinTest() throws ExampleException{
        Compas tester = new Compas(WorldSide.YG);
        assertEquals(WorldSide.V, tester.changeSide(1));
        assertEquals(WorldSide.V, tester.getSide());
    }
    @Test
    public void methodResultFourthLeftSpinTest() throws ExampleException{
        Compas tester = new Compas(WorldSide.V);
        assertEquals(WorldSide.SV, tester.changeSide(1));
        assertEquals(WorldSide.SV, tester.getSide());
    }
    @Test
    public void methodResultSpinFirstRightTest() throws ExampleException{
        Compas tester = new Compas(WorldSide.SV);
        assertEquals(WorldSide.V, tester.changeSide(-1));
        assertEquals(WorldSide.V, tester.getSide());
    }

    @Test
    public void methodResultSpinSecondRightTest() throws ExampleException{
        Compas tester = new Compas(WorldSide.V);
        assertEquals(WorldSide.YG, tester.changeSide(-1));
        assertEquals(WorldSide.YG, tester.getSide());
    }
    @Test
    public void methodResultSpinThirdRightTest() throws ExampleException{
        Compas tester = new Compas(WorldSide.YG);
        assertEquals(WorldSide.Z, tester.changeSide(-1));
        assertEquals(WorldSide.Z, tester.getSide());
    }
    @Test
    public void methodResultSpinFourthRightTest() throws ExampleException{
        Compas tester = new Compas(WorldSide.Z);
        assertEquals(WorldSide.SV, tester.changeSide(-1));
        assertEquals(WorldSide.SV, tester.getSide());
    }
    @Test
    public void methodResultFullSpinFromSVToYGTest() throws ExampleException{
        Compas tester = new Compas(WorldSide.SV);
        assertEquals(WorldSide.YG, tester.changeSide(2));
        assertEquals(WorldSide.YG, tester.getSide());
    }
    @Test
    public void methodResultFullSpinFromYGToSVTest() throws ExampleException{
        Compas tester = new Compas(WorldSide.YG);
        assertEquals(WorldSide.SV, tester.changeSide(2));
        assertEquals(WorldSide.SV, tester.getSide());
    }
    @Test
    public void methodResultFullSpinVToZTest() throws ExampleException{
        Compas tester = new Compas(WorldSide.V);
        assertEquals(WorldSide.Z, tester.changeSide(2));
        assertEquals(WorldSide.Z, tester.getSide());
    }
    @Test
    public void methodResultFullSpinZToVTest() throws ExampleException{
        Compas tester = new Compas(WorldSide.Z);
        assertEquals(WorldSide.V, tester.changeSide(2));
        assertEquals(WorldSide.V, tester.getSide());
    }
}
