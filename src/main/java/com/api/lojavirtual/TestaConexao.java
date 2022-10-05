package com.api.lojavirtual;

import com.api.lojavirtual.daos.ConnectionFactory;

import java.sql.*;

public class TestaConexao {
    {
        try {
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(
                    "INSERT INTO produto (Nome, Descricao) " +
                            "VALUES ('Mouse', 'Mouse sem fio')", Statement.RETURN_GENERATED_KEYS);

            ResultSet rst = smt.getGeneratedKeys();

            while(rst.next()){
                Integer id = rst.getInt(1);
                System.out.println("O id criado foi:" + id);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
