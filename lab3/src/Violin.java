public class Violin extends MusicalInstrument {
    public Violin() {
        super("Скрипка");
    }

    @Override
    public void sound() {
        System.out.println("Скрипка звучить ніжно і мелодійно.");
    }

    @Override
    public void desc() {
        System.out.println("Це струнний смичковий інструмент з чотирма струнами.");
    }

    @Override
    public void history() {
        System.out.println("Скрипка з’явилась у XVI столітті в Італії.");
    }
}