public class Player {
    private final String name;
    private final String surname;
    private Integer points;


    public Player (String name, String surname, Integer points) {
        this.name = name;
        this.surname = surname;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public Integer getPoints() {
        return points;
    }

    public void increasePoints(){
        points++;
    }
}
