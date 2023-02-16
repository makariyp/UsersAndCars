package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;

    public Car() {

    }

    public Car(String model, int series) {
        this.series = series;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car: " +
                "id = " + id +
                ", model = '" + model + '\'' +
                ", series = " + series;
    }
}
