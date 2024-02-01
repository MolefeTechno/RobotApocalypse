package com.ioco.robotapocalypse.reports;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ioco.robotapocalypse.survivor.Survivor;

public class ReportTest {

    private Report report;
    private Survivor reporter;
    private Survivor reported;
    private Timestamp reportDate;

     @BeforeEach
    void setUp() {
         
        report = new Report();        
        reporter = new Survivor();
        reported = new Survivor();

        report.setReporterID(1);
        report.setReportedID(2);
        report.setReportDate(reportDate);
    }
    
    @Test
  
    //ToBeContinued = Test failed
    void testContaminationReportDetailsAndCheckIfReportDateIsNotNull(){
        assertEquals(reporter, report.getReporterID());
        assertEquals(reported, report.getReportedID());
        assertNotNull(report.getReportDate());
   }
}
