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
    public void viewAllUsers(){
        for (User user : users) {
            System.out.println(user.ID + " " + user.login + " " + user.password);
        }
    }
    public void createNewUser(String login, String password){
        User user = new User();
        user.ID = users.size()+1;
        user.login = login;
        user.password = password;
        users.add(user);
        try(Connection con = DriverManager.getConnection(DbConnection.getUrl(), DbConnection.getUser(), DbConnection.getPassword())){
            PreparedStatement ps = con.prepareStatement("insert into users (id, login, password) values (?, ?, ?)");
            ps.setInt(1,user.ID);
            ps.setString(2,user.login);
            ps.setString(3, user.password);
            ps.executeUpdate();
            System.out.println("Новый пользователь успешно добавлен!");
            ps.close();
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
