import java.util.Objects;

public class Thing extends Entity implements Do, Using, Status {
    public Thing(String name) {
        super(name);
    }

    public void doing (Moves move, Entity smth, boolean negative) {
        System.out.print(getName());
        if (negative) {
            System.out.print(" не");
        }
        if (smth == null) {
            switch (move) {
                case STAND -> System.out.println(" стояло");
                case STAND_BEAUTIFUL -> System.out.println(" красовалось");
                case LEAK -> System.out.println(" потекли");
                case END -> System.out.println(" закончилось");
            }
        } else {
            switch (move) {
                case STAND -> System.out.println(" стояло в " + smth.getName());
                case STAND_BEAUTIFUL -> System.out.println(" красовалось на " + smth.getName());
                case LEAK -> System.out.println(" потекли у " + smth.getName());
                case END -> System.out.println(" закончилось в " + smth.getName());
            }
        }
    }

    private Thing content = null;

    public void addThing(Thing smth) {
        content = smth;
    }

    public void removeThing() {
        content = null;
    }

    public Thing getThing() {
        return content;
    }

    public void printThing() {
        if (content == null) {
            System.out.println(getName() + " ничего не содержит");
        } else {
            System.out.println(getName() + " содержит " + content.getName());
        }
    }

    private String status = null;

    public void addStatus(String st) {
        status = st;
    }

    public void removeStatus() {
        status = null;
    }

    public String getStatus() {
        return status;
    }

    public void printStatus() {
        if (status == null) {
            System.out.println(getName() + " не имеет статуса");
        } else {
            System.out.println(getName() + " " + status);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Thing thing = (Thing) o;
        return Objects.equals(content, thing.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content);
    }

    @Override
    public String toString() {
        return "Thing{" +
                "content=" + content +
                '}';
    }
}