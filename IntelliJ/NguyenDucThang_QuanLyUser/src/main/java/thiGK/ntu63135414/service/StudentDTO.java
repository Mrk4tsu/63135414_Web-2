package thiGK.ntu63135414.service;

public class StudentDTO {
    private String id;
    private String name;
    private double cumulativeScore;

    public StudentDTO(String id, String name, double cumulativeScore) {
        this.id = id;
        this.name = name;
        this.cumulativeScore = cumulativeScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCumulativeScore() {
        return cumulativeScore;
    }

    public void setCumulativeScore(double cumulativeScore) {
        this.cumulativeScore = cumulativeScore;
    }
}
