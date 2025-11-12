package hero;

import moving.MovingType;
import surface.SurfaceType;

public class Hero {
    private MovingType movingType;

    public void ChangeMovingType(MovingType movingType) {
        this.movingType = movingType;
        System.out.println("Новый способ перемещения: " + movingType.getName());
    }

    public int move(SurfaceType type) {
        if (movingType == null) {
            System.out.println("Не решив как ему перемещаться, Герой не сдвинулся с места");
            return 0;
        }
        System.out.print("Герой ");
        int distance = movingType.move(type);
        System.out.println();
        return distance;
    }

}