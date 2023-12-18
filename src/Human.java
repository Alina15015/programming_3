import java.util.Objects;

public class Human extends Entity implements Invite, Read, See, Stand, Know, Want, Do, Using, Status {
    public Human(String name) {
        super(name);
    }

    private Thing currentThing = null;
    public void addThing(Thing smth) {
        currentThing = smth;
    }

    public void removeThing() {
        currentThing = null;
    }

    public Thing getThing() {
        return currentThing;
    }

    public void printThing() {
        if (currentThing == null) {
            System.out.println(getName() + " ничего не имеет");
        } else {
            System.out.println(getName() + " имеет " + currentThing.getName());
        }
    }

    public void want(Moves move, Thing smth) {
        System.out.print(getName() + " хочет, чтобы");
        if (smth.getName() == null) {
            switch (move) {
                case STAND -> System.out.println(" стоять");
                case THINK -> System.out.println(" думать");
                case INVITE -> System.out.println(" позвать");
                case SEE -> System.out.println(" видеть");
                case BE -> System.out.println(" быть");
                case READ -> System.out.println(" читать");
                case END -> System.out.println(" закончиться");
            }
        } else {
            switch (move) {
                case STAND -> System.out.println(" стоять на " + smth.getName());
                case THINK -> System.out.println(" думать о " + smth.getName());
                case INVITE -> System.out.println(" позвали к " + smth.getName());
                case SEE -> System.out.println(" видеть " + smth.getName());
                case BE -> System.out.println(" быть в " + smth.getName());
                case READ -> System.out.println(" читать " + smth.getName());
                case END -> System.out.println(" " + smth.getName() + " закончиться");
            }
        }
    }

    public void doing(Moves move, Entity smth, boolean negative) {
        System.out.print(getName());
        if (negative) {
            System.out.print(" не");
        }
        if (smth.getName() == null) {
            switch (move) {
                case STAND -> System.out.println(" стояла");
                case THINK -> System.out.println(" думала");
                case INVITE -> System.out.println(" позвала");
                case SEE -> System.out.println(" видела");
                case BE -> System.out.println(" была");
                case READ -> System.out.println(" читала");
            }
        } else {
            switch (move) {
                case STAND -> System.out.println(" стояла на " + smth.getName());
                case THINK -> System.out.println(" думала о " + smth.getName());
                case INVITE -> System.out.println(" позвала к" + smth.getName());
                case SEE -> System.out.println(" видела " + smth.getName());
                case BE -> System.out.println(" была в " + smth.getName());
                case READ -> System.out.println(" читала " + smth.getName());
            }
        }
    }

    public void know(Moves move, Thing smth) {
        System.out.print(getName() + " знала, как");
        if (smth.getName() == null) {
            switch (move) {
                case STAND -> System.out.println(" стоять");
                case THINK -> System.out.println(" думать");
                case INVITE -> System.out.println(" позвать");
                case SEE -> System.out.println(" видть");
                case BE -> System.out.println(" быть");
                case READ -> System.out.println(" читать");
                case CALL -> System.out.println(" называть");
            }
        } else {
            switch (move) {
                case STAND -> System.out.println(" стоять на " + smth.getName());
                case THINK -> System.out.println(" думать " + smth.getName());
                case INVITE -> System.out.println(" позвать " + smth.getName());
                case SEE -> System.out.println(" видеть " + smth.getName());
                case BE -> System.out.println(" быть " + smth.getName());
                case READ -> System.out.println(" читается " + smth.getName());
                case CALL -> System.out.println(" называется " + smth.getName());
            }
        }
    }

    public void inviting(Thing smth) {
        if (smth == null) {
            System.out.println(getName() + " пригласили");
        } else {
            System.out.println(getName() + " пригласили к " + smth.getName());
        }
    }

    public void reading(Thing smth) {
        if (smth == null) {
            System.out.println(getName() + " читала");
        } else {
            System.out.println(getName() + " читала про " + smth.getName());
        }
    }

    public void seeing(Thing smth) {
        if (smth == null) {
            System.out.println(getName() + " рассматривала");
        } else {
            System.out.println(getName() + " рассматривала " + smth.getName());
        }
    }

    public void standing(Thing smth) {
        if (smth == null) {
            System.out.println(getName() + " стояла");
        } else {
            System.out.println(getName() + " стояла на " + smth.getName());
        }
    }

    private String currentStatus = null;

    public void addStatus(String status) {
        currentStatus = status;
    }

    public void removeStatus() {
        currentStatus = null;
    }

    public void printStatus() {
        if (currentStatus == null) {
            System.out.println(getName() + " не имеет статуса");
        } else {
            System.out.println(getName() + " " + currentStatus);
        }
    }

    public String getStatus() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Human human = (Human) o;
        return Objects.equals(currentThing, human.currentThing) && Objects.equals(currentStatus, human.currentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentThing, currentStatus);
    }

    @Override
    public String toString() {
        return "Human{" +
                "currentThing=" + currentThing +
                ", currentStatus='" + currentStatus + '\'' +
                '}';
    }
}
