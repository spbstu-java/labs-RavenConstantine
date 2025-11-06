package moving;

import surface.SurfaceType;

public class MovingTypeWalk extends MovingType {

    @Override
    public int calcDistance(SurfaceType type) {
        switch (type) {
            case Mountains: 
                return 1;
            case Sand:
                return 2;
            case Road:
                return 3;
            case Water:
                return 0;
            case Cave:
                return 4;
            default:
                return 0;
        }
    }

    @Override
    public String getName() {
        return "пешком";
    }
}
