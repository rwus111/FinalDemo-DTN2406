import controller.UserController;
import entity.User;
import utils.ScannerUtils;

public class Program {
    private static UserController userController = new UserController();

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        while (true) {
            System.out.println("==== Login ====");
            System.out.println("Nhập email:");
            String email = ScannerUtils.inputEmail();
            System.out.println("Nhập password:");
            String password = ScannerUtils.inputPassword();
            User user = userController.login(email, password);
            if (user != null) {
                menu(user);
                break;
            } else {
                System.err.println("Email hoặc mật khẩu không chính xác");
            }
        }
    }

    private static void menu(User user) {
        System.out.println("Login thành công " + user.getFullName());
    }
}
