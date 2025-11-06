package moving;

import surface.SurfaceType;

public abstract class MovingType {
    
    public int move(SurfaceType type){
        System.out.print("перемещается " + getName() + " по территории " + type);
        return calcDistance(type);
    };

    public abstract int calcDistance(SurfaceType type);

    public abstract String getName();
}
