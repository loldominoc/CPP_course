public class Worker implements IWorker {
    private final String name;

    public Worker(String name) {
        this.name = name;
    }

    public void work(House house) {
        if (house.getBuiltParts().stream().filter(p -> p instanceof Basement).count() < 1) {
            buildPart(house, new Basement());
        } else if (house.getBuiltParts().stream().filter(p -> p instanceof Wall).count() < 4) {
            buildPart(house, new Wall());
        } else if (house.getBuiltParts().stream().filter(p -> p instanceof Window).count() < 4) {
            buildPart(house, new Window());
        } else if (house.getBuiltParts().stream().filter(p -> p instanceof Door).count() < 1) {
            buildPart(house, new Door());
        } else if (house.getBuiltParts().stream().filter(p -> p instanceof Roof).count() < 1) {
            buildPart(house, new Roof());
        } else {
            System.out.println(name + " каже: все побудовано.");
        }
    }

    private void buildPart(House house, IPart part) {
        System.out.println(name + " працює:");
        part.build();
        house.addPart(part);
    }
}
