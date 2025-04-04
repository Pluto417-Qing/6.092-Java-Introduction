class GravityCalculator {
	public static void main(String[] args){
		double gravity = -9.81; // Earth's gravity in m/s^2
		double initialVelocity = 0.0;
		double fallingTime = 10.0;
		double initialPosition = 0.0;
		double finalPosition = calDistance(fallingTime);
		 System.out.println("The object's position after " + fallingTime +
		" seconds is " + finalPosition + " m.");
	}
	
	public static double calDistance(double time){
		return 0.5*(-9.81)*time*time;
	}
}
