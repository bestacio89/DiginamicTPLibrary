package Diginamic.TP2JPA.Utilities;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.util.LiquibaseUtil;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
@Component
public class LiquidbaseUtil {
 private static final Properties properties = new Properties();

    static {
        try (InputStream input = LiquibaseUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new IOException("Unable to find application.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void runMigrations() {
        String url = properties.getProperty("database.url");
        String username = properties.getProperty("database.username");
        String password = properties.getProperty("database.password");
        String changelogFile = properties.getProperty("liquibase.changelog");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
            Liquibase liquibase = new Liquibase(changelogFile, new ClassLoaderResourceAccessor(), database);
            liquibase.update(new Contexts());
        } catch (SQLException | LiquibaseException e) {
            e.printStackTrace();
        }
    }
}
