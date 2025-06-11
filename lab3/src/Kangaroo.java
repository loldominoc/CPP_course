public class Kangaroo extends Animal {
    public Kangaroo(String name) {
        super(name, false, 3.0); // 3 кг на день
    }

    @Override
    public String makeSound() {
        return "Бум-бум!";
    }
}