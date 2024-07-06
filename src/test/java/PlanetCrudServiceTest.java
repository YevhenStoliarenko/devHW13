import model.Planet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetCrudServiceTest {
    PlanetCrudService planetCrudService;

    @BeforeEach
    public void beforeEach(){
        planetCrudService = new PlanetCrudService();
    }

    @Test
    void getPlanetById() {
        String planetById = planetCrudService.getPlanetById("VEN").getId();
        String expected = "VEN";
        assertEquals(expected, planetById);
    }

    @Test
    void createPlanet() {
        Planet planet = new Planet();
        planet.setId("MER");
        planetCrudService.createPlanet(planet);
        assertNotNull(planet.getId());
    }

    @Test
    void updatePlanet() {
        boolean result = planetCrudService.updatePlanet("MER", "Mercuri");
        assertEquals(true, result);
    }
}