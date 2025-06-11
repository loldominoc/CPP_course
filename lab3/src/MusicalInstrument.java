public abstract class MusicalInstrument {
    private final String name;

    public MusicalInstrument(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Назва інструменту: " + name);
    }

    public abstract void sound();
    public abstract void desc();
    public abstract void history();
}