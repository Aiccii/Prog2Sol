package be.kdg.mentoring.week04.f1.repository.ergas;

import be.kdg.mentoring.week04.f1.model.F1Entity;
import be.kdg.mentoring.week04.f1.repository.F1Repository;
import be.kdg.mentoring.week04.f1.repository.memory.MemoryF1Repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class ErgasF1Repository<T extends F1Entity> implements F1Repository <T> {

    MemoryF1Repository<T> memoryRepository;

    private static final String ERGAS_API_URL = "https://ergast.com/api/f1/%s.json?limit=2000";
    private final TypeReference<List<T>> valueTypeRef;
    protected final String apiUrl;

    public ErgasF1Repository(String apiUrl, TypeReference<List<T>> valueTypeRef) {
        this.apiUrl = apiUrl;
        this.valueTypeRef = valueTypeRef;
        memoryRepository = new MemoryF1Repository<>(loadDriversFromSource());
//        data = loadDriversFromSource();
    }

    protected static String constructDefaultUrl(String moduleName) {
        return String.format(ERGAS_API_URL, moduleName);
    }

    protected List<T> loadDriversFromSource() {
        try {
            System.out.printf("Connecting to [%s] to load the data\n", apiUrl);
            URL url = new URL(apiUrl);
            try (InputStream input = url.openStream()) {
                InputStreamReader isr = new InputStreamReader(input);
                BufferedReader reader = new BufferedReader(isr);
                StringBuilder json = new StringBuilder();
                int c;
                while ((c = reader.read()) != -1) {
                    json.append((char) c);
                }

                String dataJson = json.substring(json.indexOf("["), json.indexOf("]") + 1);
                System.out.println(dataJson);

                // Parse JSON into Java objects
                ObjectMapper objectMapper = new ObjectMapper();
                // https://mkyong.com/java/jackson-java-8-date-time-type-java-time-localdate-not-supported-by-default/
                // necessary to enable the LocalDate parsing module
                objectMapper.findAndRegisterModules();
                List<T> result = objectMapper.readValue(dataJson, valueTypeRef);

                // Access the parsed data
                System.out.printf("Retrieved [%d] items from remote server\n", result.size());
                return new ArrayList<>(result);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while loading data data from server", e);
        }
    }

    @Override
    public Collection<T> getAll() {
        return memoryRepository.getAll();
    }

    @Override
    public Collection<T> findById(String id) {
        return memoryRepository.findById(id);
    }

    @Override
    public Collection<T> find(Predicate<T> filter) {
        return memoryRepository.find(filter);
    }
}