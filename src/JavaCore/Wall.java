package JavaCore;

public class Wall implements Obstacle{
    private int height;

    public Wall (int height){
        this.height = height;
    }

    public boolean check(Competitor anybody){
        if (anybody.jump(this.height)){
                System.out.println("Участник успешно перепрыгнул");
                return true;
            } else {
                System.out.println("Участник не смог перепрыгнуть");
                return false;
            }
        }
}
