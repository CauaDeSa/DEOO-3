package dao;

import model.Director;
import java.util.List;

public interface DirectorDao {
    List<Director> getAllDirectors();
    Director getDirectorByName(String name);
    void insertDirector(Director director);
    void updateDirector(Director old, Director newDirector);
    void deleteDirector(Director director);
}
