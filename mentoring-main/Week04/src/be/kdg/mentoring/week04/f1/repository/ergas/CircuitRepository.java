package be.kdg.mentoring.week04.f1.repository.ergas;
//package be.kdg.pro2.week04.f1.repository.ergas;

import be.kdg.mentoring.week04.f1.model.Circuit;
import com.fasterxml.jackson.core.type.TypeReference;

public class CircuitRepository extends ErgasF1Repository<Circuit> {

    public CircuitRepository() {
        this(constructDefaultUrl("circuits"));
    }

    public CircuitRepository(String apiUrl) {
        super(apiUrl, new TypeReference<>() {
        });
    }
}
