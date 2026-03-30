import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
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
            }
            System.out.println(a);
        }
    }
}
