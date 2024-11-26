package structural.decorator;

public class Client {

	public static void main(String[] args) {

		System.out.println(new ConcreteComponent("hello").operation());
		System.out.println(new ParenthesisDecorator(new ConcreteComponent("hello")).operation());

		System.out.println(new ConcreteComponent("bye").operation());
		System.out.println(new BraceDecorator(new ParenthesisDecorator(new ConcreteComponent("bye"))).operation());

	}

}
