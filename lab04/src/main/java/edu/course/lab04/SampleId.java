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

    @Override 
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof SampleId)){
            return false;
        }
        SampleId value = (SampleId) obj;
        return (this.name.equals(value.name) && this.id == value.id);
    }

    @Override
    public int hashCode() {
        return 31 * this.name.hashCode() + this.id;
    }
}
