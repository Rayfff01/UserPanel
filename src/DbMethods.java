import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbMethods {
    private List<User> users = new ArrayList<>();

    public DbMethods(){
        try(Connection con = DriverManager.getConnection(DbConnection.getUrl(), DbConnection.getUser(), DbConnection.getPassword())){
            PreparedStatement ps = con.prepareStatement("select * from users order by id asc");
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
    public void updateUserLogin(int id, String newLogin){
        User user = users.get(id-1);
        user.login = newLogin;
        users.set(id, user);
        try(Connection con = DriverManager.getConnection(DbConnection.getUrl(), DbConnection.getUser(), DbConnection.getPassword())){
            PreparedStatement ps = con.prepareStatement("update users set login = ? where id = ?");
            ps.setString(1, newLogin);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Данные изменены!");
            ps.close();
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void updateUserPassword(int id, String newPassword){
        User user = users.get(id);

    }
    public void updateUserLoginAndPassword(int id, String newLogin, String newPassword){
        User user = users.get(id);

    }
}
