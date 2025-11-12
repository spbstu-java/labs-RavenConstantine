package moving;

import surface.SurfaceType;

public class MovingTypeFly extends MovingType {

    @Override
    public int calcDistance(SurfaceType type) {
        switch (type) {
            case Mountains:
                return 3;
            case Sand:
                return 3;
            case Road:
                return 3;
            case Water:
                return 3;
            case Cave:
                return 0;
            default:
                return 0;
        }
    }
    
    @Override
    public String getName() {
        return "на крыльях";
    }
}
