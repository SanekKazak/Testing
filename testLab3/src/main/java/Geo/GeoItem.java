package Geo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeoItem {
    protected WorldSide side;

    public GeoItem(WorldSide side) {
        this.side = side;
    }
}
