package com.ivan.database;

import java.sql.*;

public class Database
{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/datedispatch?user=user&password=pass";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public Database() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName(JDBC_DRIVER);
            // Setup the connection with the DB
            connect = DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            throw e;
        }
    }

    public void closeDb() {
        try {
            if (resultSet != null) { resultSet.close(); }
            if (statement != null) { statement.close(); }
            if (connect != null) { connect.close(); }
        } catch (Exception e) { }
    }


    public Connection getConnect() {
        return connect;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
}
