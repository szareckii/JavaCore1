package lesson1.obstacle;

import lesson1.Competitor;

public class RunningTrack extends Obstacle {

    private int dist;

    public RunningTrack(int dist) {
        this.dist = dist;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(dist);
    }
}
