package Geo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WorldSide {
    YG(3),
    SV(1),
    V(4),
    Z(2);
    private final int value;

    public static WorldSide check(Integer value){
        return switch (value) {
            case (1) -> WorldSide.SV;
            case (2) -> WorldSide.Z;
            case (3) -> WorldSide.YG;
            case (4) -> WorldSide.V;
            default -> null;
        };
    }
}
