package repository;

import entity.Admin;
import entity.Employee;
import entity.User;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository implements IUserRepository {
    @Override
    public User login(String email, String password) {
        String sql = "SELECT * FROM User WHERE Email = ? AND `Password` = ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fullName = resultSet.getString(2);
                String role = resultSet.getString(5);
                if (role.equals("Employee")) {
                    String proSkill = resultSet.getString("ProSkill");
                    return new Employee(id, fullName, email, password, proSkill);
                } else {
                    int expInYear = resultSet.getInt("ExpInYear");
                    return new Admin(id, fullName, email, password, expInYear);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
