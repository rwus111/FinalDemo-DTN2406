package service;

import entity.User;

public interface IUserService {
    User login(String email, String password);
}
