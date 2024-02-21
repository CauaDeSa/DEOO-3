package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance;
    private static List<User> dataset;

    private UserDaoImpl() {
        dataset = new ArrayList<>(0);
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    public int getId() {
        return dataset.size() + 1;
    }

    public User selectByUsername(String username) {
        for (User user : dataset) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User login(String username, String password) {
        for (User user : dataset) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean changePassword(String username, String email,
                               String newPassword) {
        for (User user : dataset) {
            if (user.getUsername().equals(username) &&
                    user.getEmail().equals(email)) {
                user.setPassword(newPassword);
                return true;
            }
        }
        return false;
    }

    public boolean insert(User user) {
        if (selectByUsername(user.getUsername()) != null) {
            return false;
        }
        dataset.add(user);
        return true;
    }
}
