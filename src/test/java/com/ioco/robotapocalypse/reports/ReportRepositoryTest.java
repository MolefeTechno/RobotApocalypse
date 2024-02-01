package com.ioco.robotapocalypse.reports;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ReportRepositoryTest {

    @Autowired
    private ReportRepository reportRepository;

    @Test
    void CheckIfSaveReportReturnsSavedReport() {
        // Arrange
        Report inputReport = new Report(1, 2, null);
        Report savedReport = reportRepository.save(inputReport);

        // Act
        Report resultReport = reportRepository.findById(savedReport.getId()).orElse(null);

        // Assert
        assertEquals(savedReport, resultReport);
    }

    @Test
    void checkIfFindAllReturnsListOfReports() {
        // Arrange
        List<Report> expectedReports = List.of(
                new Report(1, 2, null),
                new Report(3, 4, null)
        );

        reportRepository.saveAll(expectedReports);

        // Act
        List<Report> actualReports = reportRepository.findAll();

        // Assert
        assertEquals(expectedReports, actualReports);
    }

}
