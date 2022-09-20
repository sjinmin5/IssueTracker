/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package issuetrackerapplication;

/**
 * This class +++Insert Description Here+++
 *
 * @author Suhjin Min
 */
public class CurrentIssue {
    private int currentPos;
    private String issueName;
    private String issueStatus;

    public CurrentIssue(int currentPos, String issueName, String issueStatus) {
        this.currentPos = currentPos;
        this.issueName = issueName;
        this.issueStatus = issueStatus;

    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    @Override
    public String toString() {
        return "Issue Name is : " + issueName + ", Issue Status is : " + issueStatus;
    }

}
