package integrador1arqui.factory;

import integrador1arqui.daos.ClienteMysqlDAO;
import integrador1arqui.daos.FacturaProductoMysqlDAO;


public abstract class AbstractFactory {
    public abstract ClienteMysqlDAO getClienteMysqlDAO();
    public abstract FacturaProductoMysqlDAO getFacturaProductoMysqlDAO();
    public abstract FacturaProductoMysqlDAO getRecaudacion();

    public static AbstractFactory getDAOFactory() {
        return MySQLDAOFactory.getInstance();
    }
}
