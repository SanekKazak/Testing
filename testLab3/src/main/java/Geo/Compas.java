package Geo;

import Geo.Exceptions.ExampleException;

public class Compas extends GeoItem {

    public Compas(WorldSide worldSide) {
        super(worldSide);
    }

    public WorldSide changeSide(int value) throws ExampleException {
        if (value == 1) {
            if (this.side.getValue() == 4) {
                this.side = WorldSide.check(1);
            } else {
                this.side = WorldSide.check(this.side.getValue() + 1);
            }
        } else if (value == -1) {
            if (this.side.getValue() == 1) {
                this.side = WorldSide.check(4);
            } else {
                this.side = WorldSide.check(this.side.getValue() - 1);
            }
        } else if (value == 2) {
            if (this.side.getValue() == 3) {
                this.side = WorldSide.check(1);
            } else if (this.side.getValue() == 4) {
                this.side = WorldSide.check(2);
            } else {
                this.side = WorldSide.check(this.side.getValue() + 2);
            }
        } else {
            throw new ExampleException("Error");
        }
        return this.side;
    }
}
