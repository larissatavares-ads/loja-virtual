package com.api.lojavirtual.Core.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSettings {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=loja_virtual;user=sa;password=adminWEB123#"
                    );
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
