public class Tiger extends Animal {
    public Tiger(String name) {
        super(name, true, 8.0); // 8 кг на день
    }

    @Override
    public String makeSound() {
        return "Рррр!";
    }
}