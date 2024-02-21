package dao;

import model.User;

public interface UserDao {

    User selectByUsername(String username);
    boolean changePassword(String username, String email,
                               String newPassword);
    boolean insert(User user);
}
