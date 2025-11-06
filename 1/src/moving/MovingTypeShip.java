package moving;

import surface.SurfaceType;

public class MovingTypeShip extends MovingType {

    @Override
    public int calcDistance(SurfaceType type) {
        switch (type) {
            case Mountains:
                return 0;
            case Sand:
                return 0;
            case Road:
                return 0;
            case Water:
                return 5;
            case Cave:
                return 0;
            default:
                return 0;
        }
    }

    @Override
    public String getName() {
        return "на корабле";
    }
}
