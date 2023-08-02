public class Homework2Solutions {


	public static void mergeSort(Student[] arr) {

		if (arr == null || arr.length <= 1) {

		return; // Array is already sorted or empty
		}

		int n = arr.length;
		
		Student[] temp = new Student[n]; // Temporary array for merging
		
		mergeSortRecursive(arr, temp, 0, n - 1);

	}

	private static void mergeSortRecursive(Student[] arr, Student[] temp, int left, int right) {

		if (left >= right) {

			return; // Base case: array has 0 or 1 element
		}

		int mid = left + (right - left) / 2; // Calculate the middle index

		mergeSortRecursive(arr, temp, left, mid); // Sort left half
		mergeSortRecursive(arr, temp, mid + 1, right); // Sort right half
		merge(arr, temp, left, mid, right); // Merge the two sorted halves

	}
	
	private static void merge(Student[] arr, Student[] temp, int left, int mid, int right) {
		// Copy elements to the temporary array
		for (int i = left; i <= right; i++) {
	
			temp[i] = arr[i];
		}
	
		int i = left; // Pointer for the left half
		int j = mid + 1; // Pointer for the right half
		int k = left; // Pointer for the merged array

		// Merge the two halves by comparing the elements
		while (i <= mid && j <= right) {
		
			if (temp[i].getStuSurname().compareTo(temp[j].getStuSurname()) <= 0) {
		
				arr[k] = temp[i];
				i++;
		
			} else {
		
				arr[k] = temp[j];
				j++;
		
			}
		
			k++;
		}
		
		// Copy the remaining elements from the left half, if any
		while (i <= mid) {
		
			arr[k] = temp[i];
			i++;
			k++;
		}
		// Copy the remaining elements from the right half, if any
		while (j <= right) {
		
			arr[k] = temp[j];
			j++;
			k++;
		}
		}

	public static int findingForMergeSorted(Student[] arr) {
		
		String Surname = " ";
		int max = 1;
		int i = 0;

		int num = 1;
		for (int j = i +1 ; j+1 < arr.length; j++) {

			if (arr[j].getStuSurname().equals(arr[j+1].getStuSurname())) {
				
				num++;

				if (num >= max) {
					max = num;
					Surname = arr[i].getStuSurname();
				}
			}
			else {
				num = 1;
			}
		}
		return max;
	}

    public static int findingMaximumCount(Student[] arr) {
        
            int length = arr.length;
    
            int[] array_of_counters = new int[length];
        
            for (int i = 0; i < length; i++) {

                int count = 0;
                
                for (int j = 0; j < length; j++) {
                    if (arr[j].getStuSurname().equals(arr[i].getStuSurname())) {
                
                        count++;
                
                    }
                }
                array_of_counters[i] = count;
            }
        
            int maximumCount = 0;
            for (int i = 0; i < length; i++) {
                if (array_of_counters[i] > maximumCount) {
                    maximumCount = array_of_counters[i];
                }
            }
        
            return maximumCount;
        
    }

    public static void main(String[] args) {

        Student[] array_of_students = { new Student("Anil", "Polat"), 
		new Student("Emre", "Turker"), 
		new Student("Simurg", "Ozdemir"), 
		new Student("Aysegul", "Polat"), 
		new Student("Ali", "Turker"), 
		new Student("Alper", "Yildiz"), 
		new Student("Atakaan", "Polat"), 
		new Student("Dokan", "Turker"), 
		new Student("Utku", "Polat"), 
		new Student("Eda", "Polat") };

        // using the method which finds maximum count of the surname with using unsorted array
		System.out.println("Maximum count of Surname: " + findingMaximumCount(array_of_students));

		// sorting the array using mergeSort method
        mergeSort(array_of_students);

		// finding maximum count of the surname with using sorted array
		System.out.println("Maximum count of Surname: " + findingForMergeSorted(array_of_students));


    }
}
