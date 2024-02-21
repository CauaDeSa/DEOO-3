package dao;

import model.Director;

import java.util.ArrayList;
import java.util.List;

public class DirectorDaoImpl {
    private static DirectorDaoImpl instance;
    private List<Director> dataset;

    private DirectorDaoImpl(){
        dataset = new ArrayList<>();
    }
    public static DirectorDaoImpl getInstance(){
        if (instance == null){
            instance = new DirectorDaoImpl();
        }
        return instance;
    }

    public List<Director> getAllDirectors(){
        return dataset;
    }
    public Director getDirectorByName(String name){
        Director director = null;
        for (int i = 0; i < dataset.size() && director == null; i++){
            if (dataset.get(i).getName().equals(name)){
                director = dataset.get(i);
            }
        }
        return director;
    }

    public boolean isNull(){
        return dataset == null;
    }
    public void insertDirector(Director director){
        if (getDirectorByName(director.getName()) == null){
            dataset.add(director);
        }
    }
    public void updateDirector(Director old, Director newDirector){
        for (int i = 0; i < dataset.size() && newDirector != null; i++) {
            if (dataset.get(i).getName().equals(old.getName())) {
                dataset.set(i, newDirector);
                newDirector = null;
            }
        }
    }
    public void deleteDirector(Director director){
        for (int i = 0; i < dataset.size() && director != null; i++){
            if(dataset.get(i).getName().equals(director.getName())){
                dataset.remove(i);
                director = null;
            }
        }
    }
}
