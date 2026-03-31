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
                ...
                9 - завершение сеанса""");
    }
}
