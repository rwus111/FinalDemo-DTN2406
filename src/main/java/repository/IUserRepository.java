package repository;

import entity.User;

public interface IUserRepository {
    User login(String email, String password);
}
