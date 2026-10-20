// abstract class)What it does: It is the base for any kind of report. It stores a reportId and has two methods: displayReportType() with no body, and showReportId() which prints the ID.
package model;

public abstract class Report {

    protected String reportId;

    public Report(String reportId) {
        this.reportId = reportId;
    }

    public abstract void displayReportType();

    public void showReportId() {
        System.out.println("Report ID: " + reportId);
    }
}