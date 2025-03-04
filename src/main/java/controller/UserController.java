package controller;

import entity.User;
import service.IUserService;
import service.UserService;

public class UserController {
    private IUserService userService = new UserService();

    public User login(String email, String password) {
        return userService.login(email, password);
    }
}
