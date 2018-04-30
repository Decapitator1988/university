public class Groups {
    private int groupId;
    private String name;

    public Groups() {
    }

    public Groups(int groupId, String name) {
        this.groupId = groupId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "groupId=" + groupId +
                ", name='" + name + '\'' +
                '}';
    }
}
