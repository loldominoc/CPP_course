public class Cello extends MusicalInstrument {
    public Cello() {
        super("Віолончель");
    }

    @Override
    public void sound() {
        System.out.println("Віолончель має глибокий, оксамитовий звук.");
    }

    @Override
    public void desc() {
        System.out.println("Це великий струнний смичковий інструмент, нижчий за скрипку.");
    }

    @Override
    public void history() {
        System.out.println("Віолончель з’явилась у XVII столітті в Італії.");
    }
}