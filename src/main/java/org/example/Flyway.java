package org.example;

public class Flyway {
    public void startFlyway(){
        try {
            org.flywaydb.core.Flyway flyway = org.flywaydb.core.Flyway.configure()
                    .dataSource("jdbc:h2:./test", "", null)
                    .baselineOnMigrate(true)
                    .locations("classpath:db.migration")
                    .load();
            flyway.migrate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
