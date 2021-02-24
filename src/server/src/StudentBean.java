import javax.annotation.*;
import java.sql.*;
import javax.ejb.Stateful;
import javax.sql.DataSource;

@Stateful
public class StudentBean implements Student {

    static Connection connection;
    @Resource(mappedName='java:/BoeDs')
    private DataSource datasource;

    @Override
    public boolean  add(String name,String lastName, int nbRegistration){
        try {
            connection = datasource.getConnection();
            System.out.println("congrats you've been connected to the Oracle");
            Statement query = connection.createStatement();
            query.executeUpdate("insert into etudiants(mat, nom, prenom) values("+nbRegistration+",'"+name+"',"+lastName+"');");
            System.out.println("row inserted successfully");
            connection.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    
}
