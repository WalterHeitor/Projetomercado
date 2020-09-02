/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import com.mycompany.mercado.dao.ClienteDAO;
import com.mycompany.mercado.doumain.Cliente;

/**
 *
 * @author walter heitor
 */
public class TesteCliente {
    
    public static void main(String[] args) {
        testecliente();
    }

    public static void testecliente() {
        ClienteDAO cdao = new ClienteDAO();
        Cliente c = cdao.getById(1);
        System.out.println("CLIENTE---------"+c);
    }
}
