public class Team {
    private final IWorker[] workers;

    public Team(IWorker... workers) {
        this.workers = workers;
    }

    public void buildHouse(House house) {
        while (!house.isFinished()) {
            for (IWorker worker : workers) {
                worker.work(house);
                if (house.isFinished()) break;
            }
            System.out.println("---------------");
        }
    }
}
