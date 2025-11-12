package surface;

public class Surface {
    SurfaceType type;
    public int distance;

    public Surface(SurfaceType type, int distance){
        this.type = type;
        this.distance = distance;
    }
    public SurfaceType getType(){
        return type;
    }
}
