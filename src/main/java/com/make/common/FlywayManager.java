package com.make.common;

import org.flywaydb.core.Flyway;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/28
 * Description:
 */
public class FlywayManager {

    public static void main(String[] args) {
        String url = PropertiesTool.getproperties("spring.datasource.url", "application.properties");
        String user = PropertiesTool.getproperties("spring.flyway.user", "application.properties");
        String password = PropertiesTool.getproperties("spring.flyway.password", "application.properties");;
        Flyway flyway = Flyway.configure().dataSource(url, user, password).load();
        flyway.clean();
        flyway.migrate();
    }

}
