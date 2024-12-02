package behavioral.observer;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		Subject<Integer> intSubject = new Subject<>();

		///// Concrete Observer
		// anonymous
		intSubject.registerObserver(new Observer<Integer>() {
			@Override
			public void update(Integer val) {
				System.out.println("Observer 01: " + val);
			}

		});
		// lambda
		intSubject.registerObserver((val) -> {
			System.out.println("Observer 02: " + val);
		});

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print(">> ");
			Integer val = sc.nextInt();
			intSubject.changeSubject(val);
		}
	}

}
