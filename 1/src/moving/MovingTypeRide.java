package moving;

import surface.SurfaceType;

public class MovingTypeRide extends MovingType {
    
    @Override
    public int calcDistance(SurfaceType type) {
        switch (type) {
            case Mountains:
                return 0;
            case Sand:
                return 2;
            case Road:
                return 5;
            case Water:
                return 0;
            case Cave:
                return 1;
            default:
                return 0;
        }
    }

    @Override
    public String getName() {
        return "верхом на лошади";
    }
}
