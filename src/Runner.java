import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        DbMethods methods = new DbMethods();
        showCommand();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Введите команду: ");
            String a = scanner.nextLine();
            if(a.equals("1")){
                showCommand();
            } else if (a.equals("2")) {
                methods.viewAllUsers();
            } else if (a.equals("3")) {
                System.out.println("Введите логин для нового пользователя: ");
                String login = scanner.nextLine();
                System.out.println("Введите пароль для нового пользователя: ");
                String password = scanner.nextLine();
                methods.createNewUser(login, password);
            } else if (a.equals("4")) {
                System.out.println("""
                        Укажите, какие данные хотите изменить у пользователя:
                        1 - логин
                        2 - пароль
                        3 - логин и пароль""");
                String parameter = scanner.nextLine();
                if(parameter.equals("1")){
                    System.out.println("Введите id пользователя, у которого хотите изменить данные: ");
                    int userID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите новый логин для пользователя: ");
                    String newLogin = scanner.nextLine();
                    methods.updateUserLogin(userID, newLogin);
                } else if (parameter.equals("2")) {
                    System.out.println("Введите id пользователя, у которого хотите изменить данные: ");
                    int userID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите новый пароль для пользователя: ");
                    String newPassword = scanner.nextLine();
                    methods.updateUserPassword(userID, newPassword);
                } else if (parameter.equals("3")) {
                    
                }
            } else if (a.equals("9")) {
                break;
            }
            System.out.println();
        }
    }
    public static void showCommand(){
        System.out.println("""
                Список команд: 
                1 - вывод списка команд
                2 - вывод списка пользователей
                3 - добавление нового пользователя
                4 - изменение данных пользователя
                ...
                9 - завершение сеанса""");
    }
}
