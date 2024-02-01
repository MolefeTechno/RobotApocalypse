package com.ioco.robotapocalypse.reports;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ContaminationReports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    private Integer reportedID;
    private Integer reporterID;
   
  
    public Timestamp getReportDate() {
        return reportDate;
    }

    public void setReportDate(Timestamp reportDate) {
        this.reportDate = reportDate;
    }
@Column(nullable = false)
    private Timestamp reportDate;

    
    public Report() {
    }
    
    public Report(Integer reportedID, Integer reporterID, Timestamp reportDate) {
       
        this.reportedID = reportedID;
        this.reporterID = reporterID;
        this.reportDate = reportDate;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
   
    public Integer getReportedID() {
        return reportedID;
    }

    public void setReportedID(Integer reportedID) {
        this.reportedID = reportedID;
    }

    public Integer getReporterID() {
        return reporterID;
    }

    public void setReporterID(Integer reporterID) {
        this.reporterID = reporterID;
    }


}
