package edu.course.lab04;

public final class SampleId {
    private final String name;
    private final int id;

    public SampleId(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }
}
