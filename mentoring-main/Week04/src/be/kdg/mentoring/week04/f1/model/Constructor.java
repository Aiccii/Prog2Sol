package be.kdg.mentoring.week04.f1.model;

public class Constructor extends F1Entity {
    private String constructorId;
    private String name;
    private String nationality;
    private String url;

    public String getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
        setId(constructorId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
