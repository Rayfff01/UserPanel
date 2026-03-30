import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        DbMethods methods = new DbMethods();

        System.out.println("""
                Типа приветствие!
                Список команд: 
                1 - завершение сеанса
                2 - вывод списка пользователей""");
        Scanner scanner = new Scanner(System.in);

        while(true){
            String a = scanner.nextLine();
            if(a.equals("1")){
                break;
            } else if (a.equals("2")) {
                methods.viewAllUsers();
            }

        }
    }
}
