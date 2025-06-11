public class TeamLeader implements IWorker {
    private final String name;

    public TeamLeader(String name) {
        this.name = name;
    }

    public void work(House house) {
        System.out.println(name + " формує звіт:");
        house.printProgress();
    }
}