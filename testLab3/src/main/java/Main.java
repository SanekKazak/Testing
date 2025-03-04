import Geo.Compas;
import Geo.GeoItem;
import Geo.WorldSide;

public class Main {
    public static void main(String[] args) {
        GeoItem item = new GeoItem(WorldSide.YG);


        System.out.println(item.getSide());
    }
}
