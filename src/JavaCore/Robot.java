package JavaCore;

public class Robot implements Competitor {
    private String name;
    private int maxHeight;
    private int maxLength;

    public Robot(String name, int maxHeight, int maxLength){
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }
    @Override
    public boolean jump(int height) {
        System.out.println("Робот " + name + " прыгает");
        return height < maxHeight;
    }

    private int coveredDistance = 0;

    @Override
    public boolean run(int length) {
        System.out.println("Робот " + name + " бежит");
        this.coveredDistance += length;
        return length < maxLength;
    }

}
