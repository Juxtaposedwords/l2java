public class App {
    private Circle one, two, three;

    public App() {
        one = new Circle(10, 5, 5);
        two = new Circle(5);
        three = new Circle();
    }

    public static void main(String[] args) throws Exception {
        App foo = new App();

        System.out.println(foo.one.toString());
        System.out.println(foo.two.toString());
        System.out.println(foo.three.toString());

        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
    }

    @Override
    public String toString() {
        return String.format("circle 1: %s circle 2: %s circle 3: %s", one, two, three);
    }

}
