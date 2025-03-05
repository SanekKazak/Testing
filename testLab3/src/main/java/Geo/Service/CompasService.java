package Geo.Service;

import Geo.Compas;
import Geo.Exceptions.ExampleException;
import Geo.WorldSide;

public class CompasService {
    private final Compas compas;

    public CompasService(Compas compas) {
        this.compas = compas;
    }

    public WorldSide getSide() {
        return compas.getSide();
    }

    public WorldSide getWorldSide(int operation) throws ExampleException {
        return compas.changeSide(operation);
    }
}
