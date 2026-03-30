import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbMethods {
    private List<User> users = new ArrayList<>();

    public DbMethods(){
        try(Connection con = DriverManager.getConnection(DbConnection.getUrl(), DbConnection.getUser(), DbConnection.getPassword())){
            PreparedStatement ps = con.prepareStatement("select * from users");
            ResultSet res = ps.executeQuery();
            while(res.next()){
                User user = new User();
                user.ID = res.getInt("id");
                user.login = res.getString("login");
                user.password = res.getString("password");
                users.add(user);
            }
            res.close();
            ps.close();
        }
        catch (SQLException ex){
            System.out.println("Проблемы с подключением...");
        }
    }
}
