package JavaCore;

public class Main {

    public static void main(String[] args) {

	Robot robert = new Robot("Robert", 20, 500);
	Human vasia = new Human("Vasia", 80,1000);
	Cat tom = new Cat("Tom", 110, 700);


	Treadmill track25 = new Treadmill(25);
	Treadmill track50 = new Treadmill(50);
	Treadmill track100 = new Treadmill(100);
	Wall wall1 = new Wall(50);
	Wall wall2 = new Wall(100);

	Competitor[] competitors = {robert, vasia, tom};
	Obstacle[] obstacles = {track25, wall1, track50, wall2, track100};

	for (Competitor competitor:competitors) {
		System.out.println("==== next run ====");
		for (Obstacle obstacle:obstacles) {
			if (!obstacle.check(competitor)) {
				break;
			}
		}
	}

    }

}
