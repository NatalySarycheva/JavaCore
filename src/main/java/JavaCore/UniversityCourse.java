package JavaCore;

interface Course {
    String getName();
}

public class UniversityCourse implements Course {
    private String name;

    public UniversityCourse(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
