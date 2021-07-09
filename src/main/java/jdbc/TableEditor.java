package jdbc;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = properties.getProperty("url");
        String name = properties.getProperty("username");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, name, password);
    }

    public void createTable(String tableName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("create table if not exists %s" + "(id serial primary key, name varchar(255))", tableName);
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropTable(String tableName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("drop table if exists %s", tableName);
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addColumn(String tableName, String columnName, String type) {
        try (Statement st = connection.createStatement()) {
            String sql = String.format(
                    "alter table if exists %s " + "add column if not exists %s %s", tableName, columnName, type);
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropColumn(String tableName, String columnName) {
        try (Statement st = connection.createStatement()) {
            String sql = String.format(
                    "alter table if exists %s " + "drop column if exists %s", tableName, columnName);
            st.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("alter table if exists %s " + "rename %s to %s", tableName, columnName, newColumnName);
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (FileReader fr = new FileReader("./src/main/resources/app.properties")) {
            properties.load(fr);
        }
        TableEditor te = new TableEditor(properties);
        te.createTable("dbTest");
        te.addColumn("dbTest", "column2", "text");
        te.renameColumn("dbTest", "column2", "newColumn");
        te.dropColumn("dbTest", "column2");
        te.dropTable("dbTest");

    }
}