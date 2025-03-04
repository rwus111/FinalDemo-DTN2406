package service;

import entity.User;
import repository.IUserRepository;
import repository.UserRepository;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();

    @Override
    public User login(String email, String password) {
        return userRepository.login(email, password);
    }
}
