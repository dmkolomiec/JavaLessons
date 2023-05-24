package entity;

public class CourseProvider {
    private String providerName;

    public CourseProvider(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public String toString() {
        return "CourseProvider{ " + providerName + " }";
    }
}
