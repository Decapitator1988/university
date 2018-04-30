public class Cources {
    private int courseId;
    private String name;
    private String description;

    public Cources() {
    }

    public Cources(int courseId, String name, String description) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Cources{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
