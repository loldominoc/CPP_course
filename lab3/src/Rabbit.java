public class Rabbit extends Animal {
    public Rabbit(String name) {
        super(name, false, 0.5); // 0.5 кг на день
    }

    @Override
    public String makeSound() {
        return "Пііі!";
    }
}