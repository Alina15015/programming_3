public class Main {
    public static void main(String[] args) {
        Human alice = new Human("Алиса");
        Thing court = new Thing("суд");
        Thing judgment = new Thing("судебный зал");
        Thing pie = new Thing("блюдо с пирожками");
        Thing table = new Thing("стол");
        Thing spit = new Thing("слюнки");
        Thing surrounding = new Thing("окружение");
        Thing everything = new Thing("все");

        table.doing(Moves.STAND, judgment, false);
        pie.doing(Moves.STAND_BEAUTIFUL, table, false);
        pie.addStatus("имеет аппетитный вид");
        pie.printStatus();
        spit.doing(Moves.LEAK, alice, false);
        alice.want(Moves.END, court);
        alice.want(Moves.INVITE, table);
        alice.seeing(surrounding);
        alice.doing(Moves.BE, judgment, true);
        alice.reading(judgment);
        alice.know(Moves.CALL, everything);
    }
}