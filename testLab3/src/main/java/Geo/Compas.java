package Geo;

import Geo.Exceptions.ExampleException;

import java.util.LinkedHashMap;
import java.util.Map;

public class Compas extends GeoItem {

    private Map<Integer, Integer> sideMap = new LinkedHashMap<>();

    public Compas(WorldSide worldSide) {
        super(worldSide);
        sideMap.put(1, 0);
        sideMap.put(2, 0);
        sideMap.put(3, 0);
        sideMap.put(4, 0);
        sideMap.put(worldSide.getValue(), 1);
    }

    public WorldSide changeSide(int value) throws ExampleException {
        if (value == 1) {
            if (this.side.getValue() == 4) {
                sideMap.put(this.side.getValue(), 0);
                sideMap.put(1, 1);
                this.side = WorldSide.check(1);
            } else {
                sideMap.put(this.side.getValue(), 0);
                sideMap.put(this.side.getValue() + 1, 1);
                this.side = WorldSide.check(this.side.getValue() + 1);
            }
        } else if (value == -1) {
            if (this.side.getValue() == 1) {
                sideMap.put(this.side.getValue(), 0);
                sideMap.put(4, 1);
                this.side = WorldSide.check(4);
            } else {
                sideMap.put(this.side.getValue(), 0);
                sideMap.put(this.side.getValue() - 1, 1);
                this.side = WorldSide.check(this.side.getValue() - 1);
            }
        } else if (value == 2) {
            if (this.side.getValue() == 3) {
                sideMap.put(this.side.getValue(), 0);
                sideMap.put(1, 1);
                this.side = WorldSide.check(1);
            } else if (this.side.getValue() == 4) {
                sideMap.put(this.side.getValue(), 0);
                sideMap.put(2, 1);
                this.side = WorldSide.check(2);
            } else {
                sideMap.put(this.side.getValue(), 0);
                sideMap.put(this.side.getValue() + 2, 1);
                this.side = WorldSide.check(this.side.getValue() + 2);
            }
        } else {
            throw new ExampleException("Error");
        }
        return this.side;
    }
}
