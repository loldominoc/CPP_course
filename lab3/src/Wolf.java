public class Wolf extends Animal {
    public Wolf(String name) {
        super(name, true, 5.0); // 5 кг на день
    }

    @Override
    public String makeSound() {
        return "Аууууф!";
    }
}