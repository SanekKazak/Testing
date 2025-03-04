package Geo;

import Geo.Exceptions.ExampleException;

public class Compas extends GeoItem {

    public Compas(WorldSide worldSide) {
        super(worldSide);
    }

    public WorldSide changeSide(int value) throws ExampleException {

        if (value == 1 && !this.side.equals(null)) {
            return switch (this.side) {
                case WorldSide.SV -> {
                    this.side = WorldSide.Z;
                    yield WorldSide.Z;
                }
                case WorldSide.YG -> {
                    this.side = WorldSide.V;
                    yield WorldSide.V;
                }
                case WorldSide.V -> {
                    this.side = WorldSide.SV;
                    yield WorldSide.SV;
                }
                case WorldSide.Z -> {
                    this.side = WorldSide.YG;
                    yield WorldSide.YG;
                }
            };
        } else if (value == -1 && !this.side.equals(null)) {
            return switch (this.side) {
                case WorldSide.SV -> {
                    this.side = WorldSide.V;
                    yield WorldSide.V;
                }
                case WorldSide.YG -> {
                    this.side = WorldSide.Z;
                    yield WorldSide.Z;
                }
                case WorldSide.V -> {
                    this.side = WorldSide.YG;
                    yield WorldSide.YG;
                }
                case WorldSide.Z -> {
                    this.side = WorldSide.SV;
                    yield WorldSide.SV;
                }
            };
        } else if (value == 2 && !this.side.equals(null)) {
            return switch (this.side) {
                case WorldSide.SV -> {
                    this.side = WorldSide.YG;
                    yield WorldSide.YG;
                }
                case WorldSide.YG -> {
                    this.side = WorldSide.SV;
                    yield WorldSide.SV;
                }
                case WorldSide.V -> {
                    this.side = WorldSide.Z;
                    yield WorldSide.Z;
                }
                case WorldSide.Z -> {
                    this.side = WorldSide.V;
                    yield WorldSide.V;
                }
            };
        } else {
            throw new ExampleException("Error");
        }
    }
}
