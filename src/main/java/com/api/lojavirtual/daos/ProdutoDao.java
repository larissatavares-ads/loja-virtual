package com.api.lojavirtual.daos;

import com.api.lojavirtual.models.ProdutoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao extends ProdutoModel{
    public List<ProdutoModel> recuperarLista(){
        List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
        try {
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement("SELECT * FROM produto");

            ResultSet rs = smt.executeQuery(); //armazena o resultado que vai retornar do select

            //mapeamento
            while (rs.next()){
                ProdutoModel p = new ProdutoModel();
                p.setId(rs.getInt("Id"));
                p.setNome(rs.getString("Nome"));
                p.setDescricao(rs.getString("Descricao"));
                produtos.add(p);
            }
            rs.close();
            smt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produtos;
    }
    public void inserirDado(){
        try {
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(
                    "use loja_DB;" +
                            "INSERT INTO produto (Nome, Descricao) " +
                            "VALUES ('TECLADO', 'TECLADO MECANICO');", Statement.RETURN_GENERATED_KEYS);

            ResultSet rst = smt.executeQuery();

            while(rst.next()){
                Integer id = rst.getInt(1);
                System.out.println("O id criado foi:" + id);
            }
            rst.close();
            smt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deletarDado(){
        try {
            Connection con = new ConnectionFactory().getConnection();

            Statement smt = con.createStatement();
            smt.execute("delete from produto where Id > 2;");

            Integer linhasModificadas = smt.getUpdateCount();
            System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);

            smt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
