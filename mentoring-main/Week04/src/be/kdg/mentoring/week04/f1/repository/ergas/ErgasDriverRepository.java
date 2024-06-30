package be.kdg.mentoring.week04.f1.repository.ergas;

import be.kdg.mentoring.week04.f1.model.Driver;
import be.kdg.mentoring.week04.f1.repository.DriverRepository;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;

public class ErgasDriverRepository extends ErgasF1Repository<Driver> implements DriverRepository {
    public static final String ERGAS_API_URL = "https://ergast.com/api/f1/drivers.json?limit=2000";

    public ErgasDriverRepository() {
        this(ERGAS_API_URL);
    }

    public ErgasDriverRepository(String apiUrl) {
        super(apiUrl, new TypeReference<>() {
        });
    }

    @Override
    public Collection<Driver> getDriverByCode(String code) {
        return super.findById(code);
    }

    @Override
    public Collection<Driver> getDriverByLastName(String name) {
        return find(driver -> driver.getFamilyName().equalsIgnoreCase(name));
    }

    @Override
    public Collection<Driver> getDriverByGivenName(String name) {
        return find(driver -> driver.getGivenName().equalsIgnoreCase(name));
    }
}
