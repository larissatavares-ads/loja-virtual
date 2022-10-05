package org.example;

import com.api.lojavirtual.daos.ProdutoDao;
import com.api.lojavirtual.models.ProdutoModel;

public class Main {
    public static void main(String[] args){

        ProdutoDao dao = new ProdutoDao();

        //dao.inserirDado();
        dao.deletarDado();

        for (ProdutoModel p : dao.recuperarLista()){
            System.out.println(p.toString());
        }
    }
}