package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job(){
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString(){
        if(getName().isBlank() && getEmployer().getValue().isBlank() && getLocation().getValue().isBlank() && getPositionType().getValue().isBlank() && getCoreCompetency().getValue().isBlank()){
            return System.lineSeparator() +
                    "ID: " + getId() + System.lineSeparator() +
                    "OOPS! this job does not seem to exist." + System.lineSeparator();
        }

        if(getName().isEmpty()){
            setName("Data not available");
        }
        if(getEmployer().getValue().isEmpty()){
            employer.setValue("Data not available");
        }
        if(getLocation().getValue().isEmpty()){
            location.setValue("Data not available");
        }
        if(getPositionType().getValue().isEmpty()){
            positionType.setValue("Data not available");
        }
        if(getCoreCompetency().getValue().isEmpty()){
            coreCompetency.setValue("Data not available");
        }

        return "\n" +
                "ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Employer: " + getEmployer().getValue() + "\n" +
                "Location: " + getLocation().getValue() + "\n" +
                "Position Type: " + getPositionType().getValue() + "\n" +
                "Core Competency: " + getCoreCompetency().getValue() + "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
