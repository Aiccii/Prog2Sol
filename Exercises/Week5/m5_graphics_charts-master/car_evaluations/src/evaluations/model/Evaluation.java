package evaluations.model;

public class Evaluation {
	double userRating;
	double mileage;
	double Safety;

	public Evaluation(double userRating, double mileage, double safety) {
		this.userRating = userRating;
		this.mileage = mileage;
		Safety = safety;
	}

	public double getUserRating() {
		return userRating;
	}

	public double getMileage() {
		return mileage;
	}

	public double getSafety() {
		return Safety;
	}
}
