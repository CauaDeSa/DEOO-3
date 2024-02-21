package dao;

import model.Actor;
import java.util.List;

public interface ActorDao {
    List<Actor> getAllActors();
    Actor getActorByName(String name);
    void insertActor(Actor actor);
    void updateActor(Actor old, Actor newDirector);
    void deleteActor(Actor actor);
}
