package prob05;

public class Sol05 {
	public static void main(String[] arg) {

		int array[] = {5, 9, 3, 8, 60, 20, 1};
		int count = array.length;

		System.out.println("Before Sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}

		//
		for(int i = 0; i < count-1; i++) {
            boolean swapped = false; // 교환이 일어났는지 확인

			for(int j = 0; j < count-1; j++) {
				if(array[j] < array[j+1]) { 
					int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					
					swapped = true;
				}
			}
			if(swapped == false) {
				break;
			}
      		// System.out.println(Arrays.toString(array));
		}
		//

		System.out.println("\nAfter Sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}
	}
}