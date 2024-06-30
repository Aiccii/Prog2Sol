package be.kdg.mentoring.week04.f1.repository;

import be.kdg.mentoring.week04.f1.model.Driver;

import java.util.Collection;

public interface DriverRepository extends F1Repository<Driver> {

    Collection<Driver> getDriverByCode(String code);

    Collection<Driver> getDriverByLastName(String name);

    Collection<Driver> getDriverByGivenName(String name);
}
