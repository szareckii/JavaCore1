package lesson1;

import lesson1.obstacle.Obstacle;
import lesson1.obstacle.RunningTrack;
import lesson1.obstacle.Wall;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {
                new Human("Anton", 20000, 1),
                new Cat("Boris", 100, 2),
                new Robot("R2-D2", 20, 1)
        };

        Obstacle[] obstacles = {
                new RunningTrack(100),
                new Wall(2) 
        };

        for (Competitor c:competitors) {
            for (Obstacle o:obstacles) {
                o.doIt(c);
                if(!c.isOnDistance()) {
                    break;
                }
            }
        }
    }
}
