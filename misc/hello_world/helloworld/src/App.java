public class App {
    public static void main(String[] args) throws Exception {
        Circle one = new Circle(10, 5, 5);
        Circle two = new Circle(5);
        Circle three = new Circle();

        System.out.println(one.toString());
        System.out.println(two.toString());
        System.out.println(three.toString());

        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
    }
}
