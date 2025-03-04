import controller.UserController;
import entity.Admin;
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
        while (true){
            System.out.println("====== User manage =====");
            System.out.println("1. Hiển thị toàn bộ user");
            System.out.println("2. Hiển thị user theo id");
            System.out.println("3. Xoá user theo id");
            int maxMenu = 3;
            if (user instanceof Admin){
                maxMenu = 4;
                System.out.println("4. Thêm user");
            }
            System.out.println("0. Thoát");
            System.out.println("Chọn menu:");
            int menu = ScannerUtils.inputFunction(0, maxMenu);
            switch (menu){
                case 1:
                    getAllUsers();
                    break;
                case 2:
                    getUserById();
                    break;
                case 3:
                    deleteUserById();
                    break;
                case 4:
                    addUser();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void addUser() {

    }

    private static void deleteUserById() {

    }

    private static void getUserById() {

    }

    private static void getAllUsers() {

    }
}
