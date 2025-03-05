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
    private int value;

    public static WorldSide check(Integer value){
        switch(value){
            case(1):
                return WorldSide.SV;
            case(2):
                return WorldSide.Z;
            case(3):
                return WorldSide.YG;
            case(4):
                return WorldSide.V;
        }
        return null;
    }
}
