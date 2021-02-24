import javax.annotation.*;
import java.sql.*;
import javax.ejb.Stateful;
import javax.sql.DataSource;
import ExceptionSaver;

@Stateful
public class StudentBean implements Student {

    static Connection connection;
    @Resource(mappedName='java:/BoeDs')
    private DataSource datasource;

    @Override
    public boolean add(String name,String lastName, int nbRegistration){
        try {
            connection = datasource.getConnection();

            Statement query = connection.createStatement();
            query.executeUpdate("insert into etudiants(mat, nom, prenom) values("+nbRegistration+",'"+name+"',"+lastName+"');");

            connection.close();
            return true;
        } catch (Exception e) {
            ExceptionSaver es = new ExceptionSaver();
            es.save(e);
            return false;
        }

    }
    @Override
    public boolean pop(int nbRegistration){
        try {
            connection = datasource.getConnection();
            Statement query = connection.createStatement();
            return query.execute("DELETE FROM etudiants where mat="+nbRegistration+";");
        } catch (Exception e) {
            ExceptionSaver es = new ExceptionSaver();
            es.save(e);
            return false;
        }
    }

    @Override
    public void print(int nbRegistration){
        try {
            connection = datasource.getConnection();
            Statement query = connection.createStatement();
            ResultSet result = query.executeQuery("select * from etudiants where mat="+nbRegistration+";");
            while(result.next()){
                System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
            }
            
        } catch (Exception e) {
            ExceptionSaver es = new ExceptionSaver();
            es.save(e);
        }
    }

    
}
