package behavioral.iterator;

public class Client {

	public static void main(String[] args) {

		@SuppressWarnings("unchecked")
		Aggregate<String> fruits = new AggregateImpl<>(new String[] { "사과", "바나나", "오렌지" });

		Iterator<String> it = fruits.createIterator();

		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}

	}
}
