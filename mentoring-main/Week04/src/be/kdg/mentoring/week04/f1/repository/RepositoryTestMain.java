package be.kdg.mentoring.week04.f1.repository;

import be.kdg.mentoring.week04.f1.model.Circuit;
import be.kdg.mentoring.week04.f1.model.Constructor;
import be.kdg.mentoring.week04.f1.model.Driver;
import be.kdg.mentoring.week04.f1.model.Season;
import be.kdg.mentoring.week04.f1.repository.ergas.ErgasDriverRepository;
import be.kdg.mentoring.week04.f1.repository.memory.MemoryDriverRepository;

import java.time.Month;
import java.util.Collection;

public class RepositoryTestMain {

    public static void main(String[] args) {

        DriverRepository driverRepository = (DriverRepository) RepositoryFactory.create(MemoryDriverRepository.class.getName());
        Collection<Driver> allDrivers = driverRepository.getAll();
        System.out.println(allDrivers);

        F1Repository<Circuit> circuitRepo = (F1Repository<Circuit>) RepositoryFactory.create("circuits");
        Collection<Circuit> circuits = circuitRepo.getAll();
        System.out.println(circuits);

        circuits = circuitRepo.find(circuit -> circuit.getLocation().getCountry().equalsIgnoreCase("spain"));
        System.out.println(circuits);

        F1Repository<Constructor> constructorRepo = RepositoryFactory.createConstructorRepo();


//        F1Repository<Constructor> constructorRepo = new ErgasF1Repository<>(
//                "https://ergast.com/api/f1/constructors.json?limit=1000", new TypeReference<>() {});

//        constructorRepo = new RepositoryFactory<Constructor>().create(F1Repository.class);
//        F1Repository<Constructor> constructorRepo = new ConstructorRepository();

        Collection<Constructor> constructors = constructorRepo.getAll();
        System.out.println(constructors);

        F1Repository<Season> seasonRepo = RepositoryFactory.createSeasonRepo();
        Collection<Season> seasons = seasonRepo.getAll();
        System.out.println(seasons);
        DriverRepository fullDriverRepo = new ErgasDriverRepository();

        System.out.println("Drivers by name: " + fullDriverRepo.getDriverByLastName("Verstappen"));

        System.out.println("Drivers by code: " + fullDriverRepo.getDriverByCode("VER"));

        F1Repository<Driver> driverRepo = RepositoryFactory.createDriverRepo();

        Collection<Driver> drivers = driverRepo.find(driver -> driver.getNationality().equalsIgnoreCase("dutch"));
        System.out.println("found " + drivers.size() + " dutch drivers");
        for (Driver driver : drivers) {
            System.out.println(driver);
        }

        int dayOfMonth = 30;
        Month month = Month.SEPTEMBER;
        drivers = driverRepo.find(driver -> driver.getDateOfBirth().getMonth().equals(month) && driver.getDateOfBirth().getDayOfMonth() == dayOfMonth);
        System.out.println(String.format("found %d drivers born on the %dth of %s", drivers.size(), dayOfMonth, month));
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }
}
