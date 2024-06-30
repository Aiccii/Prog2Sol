package be.kdg.mentoring.week04.f1.model;

public class F1Entity implements Comparable<F1Entity> {
    private String id;

    @Override
    public int compareTo(F1Entity o) {
        return id.compareTo(o.id);
    }

    public String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +"{" +
                "id='" + id + '\'' +
                '}';
    }
}
