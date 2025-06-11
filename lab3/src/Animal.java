public abstract class Animal {
    private final String name;
    private final boolean isPredator; // чи є хижаком
    private final double dailyFoodKg; // кг корму на день

    public Animal(String name, boolean isPredator, double dailyFoodKg) {
        this.name = name;
        this.isPredator = isPredator;
        this.dailyFoodKg = dailyFoodKg;
    }

    public String getName() {
        return name;
    }

    public boolean isPredator() {
        return isPredator;
    }

    public double getDailyFoodKg() {
        return dailyFoodKg;
    }

    public abstract String makeSound();

    public void printInfo() {
        System.out.println("Тварина: " + name + " | " +
                (isPredator ? "Хижак" : "Травоїдний") +
                " | Споживає " + dailyFoodKg + " кг корму/день");
    }
}