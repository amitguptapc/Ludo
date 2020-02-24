public class Dice {
    int roll() {
        return (int) ((((Math.random() * 10)) % 6) + 1);
    }
}