package com.armazem.backend.config;

import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DatabaseConnection {

    private static String url;
    private static String username;
    private static String password;
    private static final BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(10);

    static {
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                throw new RuntimeException("application.properties nao encontrado");
            }
            prop.load(input);
            url = prop.getProperty("spring.datasource.url");
            username = prop.getProperty("spring.datasource.username");
            password = prop.getProperty("spring.datasource.password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < 5; i++) {
                pool.offer(DriverManager.getConnection(url, username, password));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection realConn = pool.poll();
        if (realConn == null || realConn.isClosed() || !realConn.isValid(2)) {
            realConn = DriverManager.getConnection(url, username, password);
        }
        final Connection connFisica = realConn;
        return (Connection) Proxy.newProxyInstance(
                DatabaseConnection.class.getClassLoader(),
                new Class<?>[]{Connection.class},
                (proxy, method, args) -> {
                    if ("close".equals(method.getName())) {
                        if (!connFisica.isClosed()) {
                            connFisica.setAutoCommit(true);
                            if (!pool.offer(connFisica)) {
                                connFisica.close();
                            }
                        }
                        return null;
                    }
                    return method.invoke(connFisica, args);
                }
        );
    }
}
