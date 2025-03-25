class Marathon {
    public static void main (String[] arguments) {
        String[] names = {
            "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
            "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
            "Aaron", "Kate"
        };

        int[] times = {
            341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
            343, 317, 265
        };

		int best = 0;
		int second_best = 0;
		int bestIndex = -1;
		int secondBestIndex = -1;
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + times[i]);
        }
		
		for(int i = 0; i < times.length; i++){
			if(times[i] > best){
				bestIndex = i;
				best = times[i];
			} else if(times[i] > second_best){
				second_best = times[i];
				secondBestIndex = i;
			}
		}
		
		System.out.println("Best runner: " + names[bestIndex] + " grade: " + best);
		System.out.println("Second-Best runner: " + names[secondBestIndex] + " grade: " + second_best);
    }
} 