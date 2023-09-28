package org.launchcode.techjobs.oo;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class JobTest {

    @Test
    public void testSettingJobId(){
        Job jobNew = new Job();
        Job jobNew2 = new Job();
        assertNotEquals(jobNew, jobNew2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobTest1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(jobTest1.getName() instanceof String);
        assertTrue(jobTest1.getEmployer() instanceof Employer);
        assertTrue(jobTest1.getLocation() instanceof Location);
        assertTrue(jobTest1.getPositionType() instanceof PositionType);
        assertTrue(jobTest1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", jobTest1.getName());
        assertEquals("ACME", jobTest1.getEmployer().getValue());
        assertEquals("Desert", jobTest1.getLocation().getValue());
        assertEquals("Quality control", jobTest1.getPositionType().getValue());
        assertEquals("Persistence", jobTest1.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality(){
        Job jobTest1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTest2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTest1.equals(jobTest2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobTest1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newline = "\n";
        boolean startString = jobTest1.toString().startsWith(newline);
        boolean endString = jobTest1.toString().endsWith(newline);
        assertEquals(true, startString);
        assertEquals(true, endString);

    }


    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobCorrectLabel = new Job("QA", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("\n" +
                "ID: " + jobCorrectLabel.getId() + "\n" +
                "Name: QA"  + "\n" +
                "Employer: ACME" + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence" + "\n", jobCorrectLabel.toString());

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job jobTest5 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String notAvailable = "Data not available";
        boolean fieldIsEmpty = jobTest5.toString().contains(notAvailable);

        assertEquals(true, fieldIsEmpty);
    }

}
