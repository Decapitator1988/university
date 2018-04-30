public class Students {
    private int studentId;
    private int groupId;
    private String firstName;
    private String lastName;

    public Students() {
    }

    public Students(int studentId, int groupId, String firstName, String lastName) {
        this.studentId = studentId;
        this.groupId = groupId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", groupId=" + groupId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
