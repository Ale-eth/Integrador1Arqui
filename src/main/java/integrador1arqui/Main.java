package integrador1arqui;

import integrador1arqui.daos.ClienteMysqlDAO;
import integrador1arqui.daos.FacturaProductoMysqlDAO;
import integrador1arqui.dtos.RecaudacionDTO;
import integrador1arqui.entities.Cliente;
import integrador1arqui.factory.AbstractFactory;
import integrador1arqui.utils.HelperMySQL;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{

        System.out.println("////////////////////////////////////////////");
        System.out.println("1- Cree un programa utilizando JDBC que cree el esquema de la base de datos: ");
        HelperMySQL dbMySQL = new HelperMySQL();
        dbMySQL.dropTables();
        dbMySQL.createTables();
        System.out.println("////////////////////////////////////////////");

        System.out.println();

        System.out.println("////////////////////////////////////////////");
        System.out.println("2- Considere los CSV dados y escriba un programa JDBC que cargue los datos a la base de datos: ");
        dbMySQL.populateDB();
        dbMySQL.closeConnection();
        System.out.println("////////////////////////////////////////////");

        // Factory 1: MySQL
        AbstractFactory chosenFactory = AbstractFactory.getDAOFactory();
        ClienteMysqlDAO clienteMysqlDAO = chosenFactory.getClienteMysqlDAO();
        FacturaProductoMysqlDAO facturaProductoMysqlDAO = chosenFactory.getFacturaProductoMysqlDAO();

        System.out.println("");

        System.out.println("////////////////////////////////////////////");
        System.out.println("3- Escriba un programa JDBC que retorne el producto que más recaudó. Se define recaudación” como cantidad de productos vendidos multiplicado por su valor: ");
        RecaudacionDTO recaudacionDTO = facturaProductoMysqlDAO.getRecaudacion();
        System.out.println(recaudacionDTO);
        System.out.println("////////////////////////////////////////////");

        System.out.println("");

        System.out.println("////////////////////////////////////////////");
        System.out.println("4- Escriba un programa JDBC que imprima una lista de clientes, ordenada por a cuál se le facturó más: ");
        List<Cliente> listadoClientes = clienteMysqlDAO.selectList();
        System.out.println(listadoClientes);

    }
}