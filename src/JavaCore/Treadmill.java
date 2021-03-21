package JavaCore;

public class Treadmill implements Obstacle{
    private int length;

    public Treadmill(int length){
        this.length = length;
    }

    public boolean check(Competitor anybody){
        if (anybody.run(this.length)){
            System.out.println("Участник успешно пробежал");
            return true;
        } else {
            System.out.println("Участник не смог пробжать");
            return false;
        }
    }

}
