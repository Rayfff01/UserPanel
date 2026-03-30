public class DbConnection {
    private final static String url = "jdbc:postgresql://localhost:5432/Test";
    private final static String user = "postgres";
    private final static String password = "123";

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}
