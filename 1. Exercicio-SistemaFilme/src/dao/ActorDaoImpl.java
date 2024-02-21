package dao;

import model.Actor;

import java.util.ArrayList;
import java.util.List;

public class ActorDaoImpl implements ActorDao {

    private static ActorDaoImpl instance;
    private List<Actor> dataset;

    private ActorDaoImpl(){
        dataset = new ArrayList<>();
    }

    public static ActorDaoImpl getInstance() {
        if (instance == null) {
            instance = new ActorDaoImpl();
        }
        return instance;
    }
    public List<Actor> getAllActors() {
        return dataset;
    }

    public Actor getActorByName(String name) {
        Actor data = null;
        for (int i = 0; i < dataset.size() && data == null; i++) {
            if(dataset.get(i).getName().equals(name)){
                data = dataset.get(i);
            }
        }
        return data;
    }

    public boolean isNull(){
        return dataset == null;
    }

    public void insertActor(Actor actor) {
        if (getActorByName(actor.getName()) == null) {
            dataset.add(actor);
        }
    }

    public void updateActor(Actor old, Actor newActor) {
        for (int i = 0; i < dataset.size() && newActor != null; i++) {
            if (dataset.get(i).getName().equals(old.getName())) {
                dataset.set(i, newActor);
                newActor = null;
            }
        }
    }

    public void deleteActor(Actor actor) {
        for (int i = 0; i < dataset.size() && actor != null; i++){
            if(dataset.get(i).getName().equals(actor.getName())){
                dataset.remove(i);
                actor = null;
            }
        }
    }
}