package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Movie {
    private String title;
    private Director director;
    private ArrayList<Actor> elenco;
    private int yearOfRelease;
    private int mark;

    public Movie(String title, Director director, int yearOfRelease, int mark) {
        this.title = title;
        this.director = director;
        this.elenco = new ArrayList<Actor>();
        this.yearOfRelease = yearOfRelease;
        this.mark = mark;
    }

    public Movie(String title, Director director, int yearOfRelease, int mark, Actor ...actor) {
        this.title = title;
        this.director = director;
        this.elenco = new ArrayList<Actor>();
        this.elenco.addAll(Arrays.asList(actor));
        this.yearOfRelease = yearOfRelease;
        this.mark = mark;
    }

    public String getTitle() {
        return title;
    }

    public Director getDirector() {
        return director;
    }

    public ArrayList<Actor> getElenco() {
        return elenco;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public int getMark() {
        return mark;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setElenco(ArrayList<Actor> elenco) {
        this.elenco = elenco;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void addActor(Actor actor) {
        this.elenco.add(actor);
    }

    public void removeActor(Actor actor) {
        this.elenco.remove(actor);
    }

    public String toString() {
        String msg = "Movie: " + title + "\nDirector: " + director.getName() +
                "\nYear of release: " + yearOfRelease + "\nMark: " + mark;

        if(elenco != null){
            msg += "\nElenco: ";
            for (Actor actor : elenco){
                msg += "\n" + actor.getName() + " (" + actor.getAge() + ")";
            }
        }

        return msg;
    }

}
