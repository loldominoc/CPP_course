public class Ukulele extends MusicalInstrument {
    public Ukulele() {
        super("Укулеле");
    }

    @Override
    public void sound() {
        System.out.println("Укулеле звучить легко, дзвінко і весело.");
    }

    @Override
    public void desc() {
        System.out.println("Це невеликий гавайський чотириструнний інструмент.");
    }

    @Override
    public void history() {
        System.out.println("Укулеле виникло наприкінці XIX століття на Гаваях.");
    }
}