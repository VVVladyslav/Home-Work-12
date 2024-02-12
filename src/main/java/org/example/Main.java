package org.example;
import lombok.SneakyThrows;
import org.example.CRUDservice.ClientCrudService;
import org.example.CRUDservice.PlanetCrudService;
import org.example.Entity.Client;
import org.example.Entity.Planet;
import org.flywaydb.core.Flyway;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        try {
            Flyway flyway = Flyway.configure()
                    .dataSource("jdbc:h2:./test", "", null)
                    .baselineOnMigrate(true)
                    .locations("classpath:db.migration")
                    .load();
            flyway.migrate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        ClientCrudService clientCrudService = new ClientCrudService();
        Client client = new Client();
        Planet planet = new Planet();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        /////////////////////////////////
        client.setName("Johnnnn");
        clientCrudService.createClient(client);
        /////////////////////////////////
        clientCrudService.deleteClient(16);
        /////////////////////////////////
        System.out.println(clientCrudService.getAllClients());
        System.out.println(clientCrudService.getByIdClient(10l));
        /////////////////////////////////
        client.setName("Joh1212");
        client.setId(25);
        clientCrudService.updateClient(client);
        /////////////////////////////////



        planet.setId("MOROKO");
        planet.setName("moroko");
        planetCrudService.createPlanet(planet);
        /////////////////////////////////
        planetCrudService.deletePlanet("MOROKO");
        /////////////////////////////////
        System.out.println(planetCrudService.getAllPlanets());
        /////////////////////////////////
        System.out.println(planetCrudService.getByNamePlanet("MARS"));
        /////////////////////////////////
        planet.setId("MOROKO");
        planet.setName("Morrrrr");
        planetCrudService.updatePlanet(planet);
    }
}
