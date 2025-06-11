import java.util.ArrayList;
import java.util.List;

public class House {
    private final List<IPart> builtParts = new ArrayList<>();

    public void addPart(IPart part) {
        builtParts.add(part);
    }

    public List<IPart> getBuiltParts() {
        return builtParts;
    }

    public boolean isFinished() {
        int basements = 0, walls = 0, windows = 0, doors = 0, roofs = 0;
        for (IPart part : builtParts) {
            if (part instanceof Basement) basements++;
            else if (part instanceof Wall) walls++;
            else if (part instanceof Window) windows++;
            else if (part instanceof Door) doors++;
            else if (part instanceof Roof) roofs++;
        }
        return basements == 1 && walls == 4 && windows == 4 && doors == 1 && roofs == 1;
    }

    public void printProgress() {
        System.out.println("Поточний стан будинку:");
        for (IPart part : builtParts) {
            System.out.println(" - " + part.getName());
        }
        if (isFinished()) {
            System.out.println("Будинок повністю збудовано");
        }
    }
}
