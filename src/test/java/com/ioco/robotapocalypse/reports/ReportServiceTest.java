package com.ioco.robotapocalypse.reports;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ReportServiceTest {

    @Mock
    private ReportRepository reportRepository;

    @InjectMocks
    private ReportService reportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveReport_shouldReturnSavedReport() {
        // Arrange
        Report inputReport = new Report(1, 2, null);
        Report savedReport = new Report(1, 2, null);

        when(reportRepository.save(inputReport)).thenReturn(savedReport);

        // Act
        Report resultReport = reportService.saveReport(inputReport);

        // Assert
        assertEquals(savedReport, resultReport);
    }

    @Test
    void getAllReports_shouldReturnListOfReports() {
        // Arrange
        List<Report> expectedReports = Arrays.asList(
                new Report(1, 2, null),
                new Report(3, 4, null)
        );

        when(reportRepository.findAll()).thenReturn(expectedReports);

        // Act
        List<Report> actualReports = reportService.getAllReports();

        // Assert
        assertEquals(expectedReports, actualReports);
    }

    @Test
    void getReportById_shouldReturnOptionalReport() {
        // Arrange
        int reportId = 1;
        Report expectedReport = new Report(reportId, 2, null);

        when(reportRepository.findById(reportId)).thenReturn(Optional.of(expectedReport));

        // Act
        Optional<Report> actualReport = reportService.getReportById(reportId);

        // Assert
        assertTrue(actualReport.isPresent());
        assertEquals(expectedReport, actualReport.get());
    }

    @Test
    void getReportById_shouldReturnEmptyOptionalForNonexistentReport() {
        // Arrange
        int nonexistentReportId = 999;

        when(reportRepository.findById(nonexistentReportId)).thenReturn(Optional.empty());

        // Act
        Optional<Report> actualReport = reportService.getReportById(nonexistentReportId);

        // Assert
        assertTrue(actualReport.isEmpty());
    }

    @Test
    void deleteReport_shouldCallDeleteById() {
        // Arrange
        int reportId = 1;

        // Act
        reportService.deleteReport(reportId);

        // Assert
        verify(reportRepository, times(1)).deleteById(reportId);
    }

}
