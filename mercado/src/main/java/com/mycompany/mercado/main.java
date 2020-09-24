/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado;

import com.mycompany.mercado.dao.ClienteDAO;
import com.mycompany.mercado.dao.EstadoDAO;
import com.mycompany.mercado.doumain.Categoria;
import com.mycompany.mercado.doumain.Cidade;
import com.mycompany.mercado.doumain.Cliente;
import com.mycompany.mercado.doumain.Endereco;
import com.mycompany.mercado.doumain.Estado;
import com.mycompany.mercado.doumain.Fornecedor;
import com.mycompany.mercado.doumain.Pessoa;
import com.mycompany.mercado.doumain.Produto;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author walter heitor
 */
public class main {

    public static void main(String[] args) {

        instaciar();
        //buscar();
        //buscarEst();
        //teste();
    }

    public static void teste(){
        try {
            EntityManager manager = Persistence.createEntityManagerFactory("vendas")
                .createEntityManager();
        } catch (RuntimeException e) {
            System.out.println("ERRO ------"+e);
        }
    }
    public static void instaciar() {
        try {
             EntityManager manager = Persistence.createEntityManagerFactory("vendas")
                .createEntityManager();
        manager.getTransaction().begin();

//        //INSTACIAÇÃO DE SIGLAS DOS ESTADOS
        Estado est1 = new Estado("AC");
        Estado est2 = new Estado("AL");
        Estado est3 = new Estado("AP");
        Estado est4 = new Estado("AM");
        Estado est5 = new Estado("BA");
        Estado est6 = new Estado("CE");
        Estado est7 = new Estado("DF");
        Estado est8 = new Estado("ES");
        Estado est9 = new Estado("GO");
        Estado est10 = new Estado("MA");
        Estado est11 = new Estado("MT");
        Estado est12 = new Estado("MS");
        Estado est13 = new Estado("MG");
        Estado est14 = new Estado("PA");
        Estado est15 = new Estado("PB");
        Estado est16 = new Estado("PR");
        Estado est17 = new Estado("PE");
        Estado est18 = new Estado("PI");
        Estado est19 = new Estado("RJ");
        Estado est20 = new Estado("RN");
        Estado est21 = new Estado("RS");
        Estado est22 = new Estado("RO");
        Estado est23 = new Estado("RR");
        Estado est24 = new Estado("SC");
        Estado est25 = new Estado("SP");
        Estado est26 = new Estado("SE");
        Estado est27 = new Estado("TO");

        manager.persist(est1);
        manager.persist(est2);
        manager.persist(est3);
        manager.persist(est4);
        manager.persist(est5);
        manager.persist(est6);
        manager.persist(est7);
        manager.persist(est8);
        manager.persist(est9);
        manager.persist(est10);
        manager.persist(est11);
        manager.persist(est12);
        manager.persist(est13);
        manager.persist(est14);
        manager.persist(est15);
        manager.persist(est16);
        manager.persist(est17);
        manager.persist(est18);
        manager.persist(est19);
        manager.persist(est20);
        manager.persist(est21);
        manager.persist(est22);
        manager.persist(est23);
        manager.persist(est24);
        manager.persist(est25);
        manager.persist(est26);
        manager.persist(est27);

        //##########            Cliente         ##########
        
        Cliente pesCli = new Cliente("79809499999", "Walter Heitor", "walter@heitor",new GregorianCalendar(2020, 2, 28) );
        System.out.println("Cliente ---- " + pesCli);
        manager.persist(pesCli);
        Endereco e = new Endereco("logadouro", "complemeto", "bairro", "79809499191", pesCli);
        Cidade cidade = new Cidade("itumbiara", est9);
        e.setCidade(cidade);
        manager.persist(e);
        manager.persist(cidade);
        //##########            Cliente 1        ##########
        Cliente c1 = new Cliente( "12345678911", "maria clara", "maria@clara", new GregorianCalendar(2020, 2, 22));
        Cliente c2 = new Cliente( "12345678911", "roberta miranda", "robert@miranda",new GregorianCalendar(2020, 3, 20));
        Cliente c3 = new Cliente( "12311178911", "mario quintana", "mario@quintana", new GregorianCalendar(2020, 4, 22));
        Cliente c4 = new Cliente( "11111118911", "martagonzales", "marta@gozales", new GregorianCalendar(2020, 5, 18));
        Endereco e1 = new Endereco("rua antonio domingos borges", "N° 129", "marolina", "123456-000", c1);
        Endereco e2 = new Endereco("rua olegario aquino ramos", "N° 13", "multirao", "122226-000", c2);
        Endereco e3 = new Endereco("rua mariana tomas borges", "N° 29", "morada dos sonhos", "222256-000", c2);
        Endereco e4 = new Endereco("rua mario domingos alves", "N° 19", "planalto", "990056-000", c3);
        Endereco e5 = new Endereco("rua antonio bbbbbbbb borges", "N° 129", "bbbbbbbbbb", "333333-000", c4);

        Cidade cid1 = new Cidade("Uberlandia", est1);
        Cidade cid2 = new Cidade("Campo Verde", est2);
        Cidade cid3 = new Cidade("Paracatu", est3);
        Cidade cid4 = new Cidade("São Paulo", est4);
        Cidade cid5 = new Cidade("Fox do Iguaçu", est5);
        e1.setCidade(cid1);
        e2.setCidade(cid2);
        e3.setCidade(cid3);
        e4.setCidade(cid4);
        e5.setCidade(cid5);

        manager.persist(c1);
        manager.persist(c2);
        manager.persist(c3);
        manager.persist(c4);

        manager.persist(e1);
        manager.persist(e2);
        manager.persist(e3);
        manager.persist(e4);
        manager.persist(e5);

        manager.persist(cid1);
        manager.persist(cid2);
        manager.persist(cid3);
        manager.persist(cid4);
        manager.persist(cid5);

        //#########         Categoria           ##########
        Categoria cat1 = new Categoria("Informática");
        Categoria cat2 = new Categoria("Escritório");
        Categoria cat3 = new Categoria("Eletronicos");
        Categoria cat4 = new Categoria("Cama mesa e banho");
        Categoria cat5 = new Categoria("Mecanica");
        Categoria cat6 = new Categoria("Solda");
        //#########         Fornecedores            ##########
           // Fornecedor f = new Fornecedor(fantasia, razaoSociao, cnpj, nome, email, dataCadastro);
            Fornecedor f = new Fornecedor("Sangung", "Sangung.LTDA", "11111111111111", "juia junqueira", "julia@sansung", new GregorianCalendar(2020, 1,1));
            Fornecedor f2 = new Fornecedor("Dell", "Dell.LTDA", "11111111111111", "beth ferreira", "beth@Dell", new GregorianCalendar(2020, 2,1));
            Fornecedor f3 = new Fornecedor("Informatia", "Informatia.LTDA", "11111111111111", "raquel miranda", "raquel@Informatia", new GregorianCalendar(2020, 3,1));
            Fornecedor f4 = new Fornecedor("CasaBem", "CasaBem.LTDA", "11111111111111", "macia arantes", "macia@CasaBem", new GregorianCalendar(2020, 4,1));
        //#########         Produtos            ########## 
      //Produto p  = new Produto(descricao, marca, Double.MAX_VALUE, Double.NaN, Integer.SIZE, unidade, cat6, pesCli)
        Produto p1 = new Produto("12345", "Computador", "Dell", 1300.00, 2000.00, 1,"PEÇA", f2);
        Produto p2 = new Produto("23456", "Impressora", "HP",458.00, 800.00, 1, "PEÇA", f3);
        Produto p3 = new Produto("34567", "Mouse", "MAX", 20.00, 80.00, 5, "UNIDADE", f3);
        Produto p4 = new Produto("45678", "Mesa de escritorio", "Moveis Planejados", 150.00, 300.00,4,"UNIDADE",f4);
        Produto p5 = new Produto("54321", "Toalha", "CasaBem", 18.60, 50.00, 30, "UNIDADE", f4);
        Produto p6 = new Produto("65432", "Colcha", "CasaBem", 140.00, 200.00, 27, "UNIDADE");
        Produto p7 = new Produto("76543", "TV 50 pol sansung", "SANSUNG", 1300.00, 2680.00, 16, "UNIDADE");
        Produto p8 = new Produto("87654", "Roçadeira", "Balmer", 298.90, 780.00, 4, "pEÇA");
        Produto p9 = new Produto("98765", "Abajur", "CasaBem",33.90, 70.00, 13, "PEÇA");

        p1.setCategoria(cat1);
        p2.setCategoria(cat1);
        p3.setCategoria(cat1);
        p4.setCategoria(cat2);
        p5.setCategoria(cat4);
        p6.setCategoria(cat4);
        p7.setCategoria(cat3);
        p8.setCategoria(cat5);
        p9.setCategoria(cat3);
        
        p6.setPessoa(f4);
        p7.setPessoa(f);
        p8.setPessoa(f4);
        p9.setPessoa(f4);
        
        manager.persist(f);
        manager.persist(f2);
        manager.persist(f3);
        manager.persist(f4);
        
        manager.persist(p1);
        manager.persist(p2);
        manager.persist(p3);
        manager.persist(p4);
        manager.persist(p5);
        manager.persist(p6);
        manager.persist(p7);
        manager.persist(p8);
        manager.persist(p9);
        
        manager.persist(cat1);
        manager.persist(cat2);
        manager.persist(cat3);
        manager.persist(cat4);
        manager.persist(cat5);
        manager.persist(cat6);
        
        

        manager.getTransaction().commit();
        manager.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO AO INSTANCIAR -> "+e);
        }

    }

    public static void buscar() {
        List<Cliente> c1 = ClienteDAO.getInstance().findAll();
        System.out.println("CLIENTE---------" + c1);
    }
    public static void buscarEst(){
        Estado estado = EstadoDAO.getInstance().getNome("MG");
        System.out.println("ESTADO-------"+estado);
    }
}
