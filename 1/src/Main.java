import hero.Hero;
import moving.*;
import surface.*;
import java.lang.Math;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final int surfacesCount = 10;
        final int minSurfaceDistance = 1;
        final int maxSurfaceDistance = 10;
        int totalDistance = 0;
        int currentSurfaceIndex = 0;
        Hero hero = new Hero();
        ArrayList<Surface> surfaces = new ArrayList<Surface>();
        //Генерация случайного маршрута
        while (surfaces.size() < surfacesCount) {
            int type = (int) ((Math.random() * (SurfaceType.values().length - 0)) + 0);
            int distance = (int) ((Math.random() * (maxSurfaceDistance - minSurfaceDistance)) + minSurfaceDistance);
            surfaces.add(new Surface(SurfaceType.values()[type], distance));
            totalDistance += distance;
        }
        System.out.println("Маршрут построен.");
        System.out.println("Общая протяженность пути составялет " + totalDistance + " м");
        while (totalDistance > 0) {
            Surface currentSurface = surfaces.get(currentSurfaceIndex);
            System.out.println("Тип текущей локации - " + currentSurface.getType());
            System.out.println();
            System.out.println("Доступные действия:");
            System.out.println("1. Идти пешком");
            System.out.println("2. Плыть на корабле");
            System.out.println("3. Лететь на крыльях");
            System.out.println("4. Ехать верхом на лошади");
            System.out.println("5. Продолжить");
            System.out.println("0. Выйти");

            System.out.print("Выберите действие: ");
            int choice;
            try {
                choice = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
                continue;
            }
            System.out.println();
            switch (choice) {
                case 1, 2, 3, 4, 5:
                    switch (choice) {
                        case 1:
                            hero.ChangeMovingType(new MovingTypeWalk());
                            break;
                        case 2:
                            hero.ChangeMovingType(new MovingTypeShip());
                            break;
                        case 3:
                            hero.ChangeMovingType(new MovingTypeFly());
                            break;
                        case 4:
                            hero.ChangeMovingType(new MovingTypeRide());
                            break;
                    }
                    int distance = Math.min(hero.move(currentSurface.getType()), currentSurface.distance);
                    currentSurface.distance -= distance;
                    if (currentSurface.distance == 0)
                        currentSurfaceIndex++;
                    totalDistance -= Math.min(distance, totalDistance);
                    System.out.println("Пройдено " + distance + " км, осталось " + totalDistance + " км");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Герой растерян от переданных инструкций");
                    break;
            }
        }

        if (totalDistance == 0) {
            System.out.println("Герой прибыл на точку назначения");
        }
    }
}
