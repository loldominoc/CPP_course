public class Trombone extends MusicalInstrument {
    public Trombone() {
        super("Тромбон");
    }

    @Override
    public void sound() {
        System.out.println("Тромбон видає гучний і глибокий звук.");
    }

    @Override
    public void desc() {
        System.out.println("Це духовий мідний інструмент з рухомою кулісою.");
    }

    @Override
    public void history() {
        System.out.println("Тромбон бере початок у XV столітті в Західній Європі.");
    }
}