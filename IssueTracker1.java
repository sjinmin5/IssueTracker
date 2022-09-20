
package issuetrackerapplication;

import java.util.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;

public class IssueTracker1 extends Application{
    Label lblUserName,lblPswd,lblGroup,lblNewName,lblNewPswd,lblNewGroup;
    Label lblMessage = new Label();
    TextField txtUserName,txtPswd,txtNewIssue,txtNewName,txtNewPswd,txtNewGroup;    
    Button btnUser,btnManager,btnDeveloper,btnLogin,btnNewIssue,btnIssue;
    Scene logIn,issueListU,issueListD, issueListM,
            newIssueDetailU,newIssueDetailD,newIssueDetailM,existIssueDetailU,
            existIssueDetailM, existIssueDetailD,addUser;
    Stage stage;
   
    ArrayList<String> newIssue = new ArrayList<String>();
    int position = 0;
    
    ArrayList<Newuser> newUser = new ArrayList<Newuser>();
    int newPosition = 0;
    
    ArrayList<CurrentIssue> currentIssue = new ArrayList<CurrentIssue>();
    CurrentIssue cIssue1 = new CurrentIssue(0, "Issue1", "New");
    CurrentIssue cIssue2 = new CurrentIssue(1, "Issue2", "Rejected");
    CurrentIssue cIssue3 = new CurrentIssue(2, "Issue3", "Validate");
    CurrentIssue cIssue4 = new CurrentIssue(3, "Issue4", "Resolved");
    CurrentIssue cIssue5 = new CurrentIssue(4, "Issue5", "Opened");
    

   @Override
   public void start(Stage primaryStage){
        stage = primaryStage;
        logIn = getLogIn();
        currentIssue.add(0, cIssue1);
        currentIssue.add(1, cIssue2);
        currentIssue.add(2, cIssue3);
        currentIssue.add(3, cIssue4);
        currentIssue.add(4, cIssue5);
        
        issueListU = getIssueListU();
        issueListM = getIssueListM();
        issueListD = getIssueListD();
        
        newIssueDetailU = getNewIssueDetailU();
        newIssueDetailM = getNewIssueDetailM();
        newIssueDetailD = getNewIssueDetailD();
        
        existIssueDetailU = getExistIssueDetailU();
        existIssueDetailM = getExistIssueDetailM();
        existIssueDetailD = getExistIssueDetailD();
        addUser = AddUser();
                
        stage.setTitle("ABC Co.");
        stage.setScene(getLogIn());
        stage.show();
    }

    public void switchScreens(Scene scene){
        stage.setScene(scene);
    }
    public Scene getLogIn(){
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));
        Label lblMember = new Label("Member Login");
        lblUserName = new Label("User Name");
        lblPswd = new Label("Password");
        lblGroup = new Label("Choose your Group and login");
        txtUserName = new TextField();
        txtPswd = new TextField();
        btnUser = new Button("User");
        btnManager = new Button("Manager");
        btnDeveloper = new Button("Developer");
       
        pane.add(lblMember,1,0,3,1);
        pane.add(lblUserName,0,1,1,1);
        pane.add(txtUserName,1,1,2,1);
        pane.add(lblPswd,0,2,1,1);
        pane.add(txtPswd,1,2,2,1);
        pane.add(lblGroup,0,3,1,1);
        pane.add(btnUser,0,4,1,1);
        pane.add(btnManager,1,4,1,1); 
        pane.add(btnDeveloper,2,4,1,1);
        btnUser.setOnAction(e -> switchScreens(issueListU));
        btnDeveloper.setOnAction(e -> switchScreens(issueListD));
        btnManager.setOnAction(e -> switchScreens(issueListM));
    
        logIn = new Scene(pane,300,300);
        return logIn;
    }
    public Scene getIssueListU(){
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));
     
        Label lblIssue = new Label("Issue List");
        Label lblNewIssue = new Label("If you have new issue to add, please click");
        btnNewIssue = new Button("New Issue");
        Label lblIssueList = new Label("For checking issue list, please click");        
        Button btnIssue1 = new Button("Issue1");
        Button btnIssue2 = new Button("Issue2");
        Button btnIssue3 = new Button("Issue3");
        Button btnIssue4 = new Button("Issue4");
        Button btnIssue5 = new Button("Issue5");
       
        pane.add(lblIssue,1,0,1,1);
        pane.add(lblNewIssue,0,1,2,1);
        pane.add(btnNewIssue, 0, 2,1,1);
        pane.add(lblIssueList,0,3,2,1);
        pane.add(btnIssue1,0,4,1,1);
        pane.add(btnIssue2,0,5,1,1);
        pane.add(btnIssue3,0,6,1,1);
        pane.add(btnIssue4,0,7,1,1);
        pane.add(btnIssue5,0,8,1,1);
    
        btnNewIssue.setOnAction(e -> switchScreens(newIssueDetailU));                
        
        btnIssue1.setOnAction(e -> {           
            setMessage(cIssue1.toString());
            switchScreens(existIssueDetailU);
        });
        btnIssue2.setOnAction(e -> {
            setMessage(cIssue2.toString());
            switchScreens(existIssueDetailU);
        });
        btnIssue3.setOnAction(e -> {
            setMessage(cIssue3.toString());
            switchScreens(existIssueDetailU);
        });
        btnIssue4.setOnAction(e -> {
            setMessage(cIssue4.toString());
            switchScreens(existIssueDetailU);
        });
        btnIssue5.setOnAction(e -> {
            setMessage(cIssue5.toString());
            switchScreens(existIssueDetailU);
        });
       issueListU = new Scene(pane,300,300);
        return issueListU;   
    }
    
    public Scene getIssueListD(){
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));
     
        Label lblIssue = new Label("Issue List");
        Label lblNewIssue = new Label("If you have new issue to add, please click");
        btnNewIssue = new Button("New Issue");
        Label lblIssueList = new Label("For checking issue list, please click");        
        Button btnIssue1 = new Button("Issue1");
        Button btnIssue2 = new Button("Issue2");
        Button btnIssue3 = new Button("Issue3");
        Button btnIssue4 = new Button("Issue4");
        Button btnIssue5 = new Button("Issue5");
       
        pane.add(lblIssue,1,0,1,1);
        pane.add(lblNewIssue,0,1,2,1);
        pane.add(btnNewIssue, 0, 2,1,1);
        pane.add(lblIssueList,0,3,2,1);
        pane.add(btnIssue1,0,4,1,1);
        pane.add(btnIssue2,0,5,1,1);
        pane.add(btnIssue3,0,6,1,1);
        pane.add(btnIssue4,0,7,1,1);
        pane.add(btnIssue5,0,8,1,1);
    
        btnNewIssue.setOnAction(e -> switchScreens(newIssueDetailD));                
        
        btnIssue1.setOnAction(e -> {
            setMessage(cIssue1.toString());
            switchScreens(existIssueDetailD);
        });
        btnIssue2.setOnAction(e -> {
            setMessage(cIssue2.toString());
            switchScreens(existIssueDetailD);
        });
        btnIssue3.setOnAction(e -> {
            setMessage(cIssue3.toString());
            switchScreens(existIssueDetailD);
        });
        btnIssue4.setOnAction(e -> {
            setMessage(cIssue4.toString());
            switchScreens(existIssueDetailD);
        });
        btnIssue5.setOnAction(e -> {
            setMessage(cIssue5.toString());
            switchScreens(existIssueDetailD);
        });
       issueListD = new Scene(pane,300,300);
        return issueListD;   
    }
     public Scene getIssueListM(){
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));
     
        Label lblIssue = new Label("Issue List");
        Label lblNewIssue = new Label("If you have new issue to add, please click");
        btnNewIssue = new Button("New Issue");
        Label lblIssueList = new Label("For checking issue list, please click");        
        Button btnIssue1 = new Button("Issue1");
        Button btnIssue2 = new Button("Issue2");
        Button btnIssue3 = new Button("Issue3");
        Button btnIssue4 = new Button("Issue4");
        Button btnIssue5 = new Button("Issue5");
        Button btnAddUser = new Button("Add User");
        
        pane.add(lblIssue,1,0,1,1);
        pane.add(lblNewIssue,0,1,2,1);
        pane.add(btnNewIssue, 0, 2,1,1);
        pane.add(lblIssueList,0,3,2,1);
        pane.add(btnIssue1,0,4,1,1);
        pane.add(btnIssue2,0,5,1,1);
        pane.add(btnIssue3,0,6,1,1);
        pane.add(btnIssue4,0,7,1,1);
        pane.add(btnIssue5,0,8,1,1);
        
        pane.add(btnAddUser,0,9,1,1);
        btnAddUser.setOnAction(e -> switchScreens(addUser));
      
        for(int i =0; i<currentIssue.size(); i++){
            if(currentIssue.get(i).getIssueStatus().equals("New")){
                btnNewIssue.setOnAction(e -> switchScreens(newIssueDetailM)); 
            }else{
                btnIssue1.setOnAction(e -> {
                setMessage(cIssue1.toString());
                switchScreens(existIssueDetailM);
                });
                btnIssue2.setOnAction(e -> {
                    setMessage(cIssue2.toString());
                    switchScreens(existIssueDetailM);
                });
                btnIssue3.setOnAction(e -> {
                    setMessage(cIssue3.toString());
                    switchScreens(existIssueDetailM);
                });
                btnIssue4.setOnAction(e -> {
                    setMessage(cIssue4.toString());
                    switchScreens(existIssueDetailM);
                });
                btnIssue5.setOnAction(e -> {
                    setMessage(cIssue5.toString());
                    switchScreens(existIssueDetailM);
                });
            }
        }
        
        
       issueListM = new Scene(pane,300,300);
        return issueListM;   
    }
    
    public String getNewIssue(){
        return txtNewIssue.getText();
    }
    public void saveNewIssue(String str){
        newIssue.add(str);
        position = newIssue.size()-1;
    }
    
    
    public void setMessage(String msg){
        lblMessage.setText(msg);        
    }
    public Scene getNewIssueDetailU(){
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));        
        lblMessage = new Label("Enter new issue here");
        txtNewIssue = new TextField();
        Button btnSubmit = new Button("Submit");
        Button btnCancel = new Button("Cancel");       
        pane.add(lblMessage,0,0);
        pane.add(txtNewIssue, 0, 1);
        pane.add(btnSubmit,0,2);   
        pane.add(btnCancel,1,2);
 
        btnSubmit.setOnAction(e -> {
           saveNewIssue(getNewIssue());
           switchScreens(issueListU);
        });
        btnCancel.setOnAction(e -> switchScreens(issueListU));
        newIssueDetailU = new Scene(pane,300,300);
        return newIssueDetailU;
    }
    public Scene getNewIssueDetailD(){
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));        
        lblMessage = new Label("Enter new issue here");
        txtNewIssue = new TextField();
        Button btnSubmit = new Button("Submit");
        Button btnCancel = new Button("Cancel"); 

        pane.add(lblMessage,0,0);
        pane.add(txtNewIssue, 0, 1);
        pane.add(btnSubmit,0,2);   
        pane.add(btnCancel,1,2);   
      
        
        btnSubmit.setOnAction(e -> {
            saveNewIssue(getNewIssue());
           switchScreens(issueListD);
        });
        btnCancel.setOnAction(e -> switchScreens(issueListD));
        newIssueDetailD = new Scene(pane,300,300);
        return newIssueDetailD;
    }
    public Scene getNewIssueDetailM(){
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));        
        lblMessage = new Label("Enter new issue here");
        txtNewIssue = new TextField();
        Button btnSubmit = new Button("Submit");
        Button btnCancel = new Button("Cancel"); 
        pane.add(lblMessage,0,0);
        pane.add(txtNewIssue, 0, 1);
        pane.add(btnSubmit,0,2);   
        pane.add(btnCancel,1,2);

        btnSubmit.setOnAction(e -> {
            saveNewIssue(getNewIssue());
           switchScreens(issueListM);
        });
        btnCancel.setOnAction(e -> switchScreens(issueListM));
        newIssueDetailM = new Scene(pane,300,300);
        return newIssueDetailM;
    }
    public Scene getExistIssueDetailU(){
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));          
 
        lblMessage = new Label();
        Button btnCancel = new Button("Cancel");
        pane.add(lblMessage,0,0);
        pane.add(btnCancel,0,1);
        
        btnCancel.setOnAction(e -> switchScreens(issueListU));
      
        existIssueDetailU = new Scene(pane,300,300);
        return existIssueDetailU;
    
    }
    public Scene getExistIssueDetailM(){
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));
        lblMessage = new Label();
        Button btnCancel = new Button("Cancel");
        pane.add(lblMessage,0,0);
        pane.add(btnCancel,0,1);
        
        
        for(int i =0; i<currentIssue.size(); i++){
        
            if(currentIssue.get(i).getIssueStatus().equals("Rejected")){
                Button btnAssign = new Button("Assign");
                pane.add(btnAssign,1,1);
                currentIssue.get(i).setIssueStatus("Assigned");
                btnAssign.setOnAction(e -> switchScreens(issueListM));
                
            }else if(currentIssue.get(i).getIssueStatus().equals("Opened")){
                Button btnClose = new Button("Close");
                pane.add(btnClose,2,1);
                currentIssue.get(i).setIssueStatus("Closed");
                btnClose.setOnAction(e -> switchScreens(issueListM));
                

            }else if(currentIssue.get(i).getIssueStatus().equals("Validate")){
                Button btnValidate = new Button("Validate");
                pane.add(btnValidate,3,1);
                currentIssue.get(i).setIssueStatus("Validated");
                btnValidate.setOnAction(e -> switchScreens(issueListM));
                
            }else if(currentIssue.get(i).getIssueStatus().equals("Resolved")){
                Button btnFail = new Button("Fail");
                pane.add(btnFail,4,1);
                currentIssue.get(i).setIssueStatus("Failed");
                btnFail.setOnAction(e -> switchScreens(issueListM));
            }
            
        }
        
        btnCancel.setOnAction(e -> switchScreens(issueListM));
        
        existIssueDetailM = new Scene(pane,300,300);      
        return existIssueDetailM;
    }
    public Scene getExistIssueDetailD(){
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));
        lblMessage = new Label();
        Button btnCancel = new Button("Cancel");
        pane.add(lblMessage,0,0);
        pane.add(btnCancel,0,1);
        
        for(int i =0; i<currentIssue.size(); i++){
        
            if(currentIssue.get(i).getIssueStatus().equals("Assigned")){
                Button btnOpen = new Button("Open");
                pane.add(btnOpen,1,1);
                currentIssue.get(i).setIssueStatus("Opened");
                btnOpen.setOnAction(e -> switchScreens(issueListD));
                
            }else if(currentIssue.get(i).getIssueStatus().equals("Failed")){
                Button btnReject = new Button("Reject");
                pane.add(btnReject,2,1);
                currentIssue.get(i).setIssueStatus("Rejected");
                btnReject.setOnAction(e -> switchScreens(issueListD));
                

            }else if(currentIssue.get(i).getIssueStatus().equals("Opened")){
                Button btnResolve = new Button("Resolve");
                pane.add(btnResolve,3,1);
                currentIssue.get(i).setIssueStatus("Resolved");
                btnResolve.setOnAction(e -> switchScreens(issueListD));
            }
        }
        btnCancel.setOnAction(e -> switchScreens(issueListD));
        
        existIssueDetailD = new Scene(pane,300,300);      
        return existIssueDetailD;
    }    
    //ArrayList<Newuser> newuser
    public String getNewName(){
        return txtNewName.getText();
    }
    public String getNewPswd(){
        return txtNewName.getText();
    }
    public String getNewGroup(){
        return txtNewGroup.getText();
    }
    public void setNewName(String val){
        txtNewName.setText(""+ val);
    }
    public void setNewPswd(String val){
        txtNewName.setText(""+ val);
    }
    public void setNewGroup(String val){
        txtNewGroup.setText(""+ val);
    }
    public void addContact(Newuser n){
        newUser.add(n);
     }
     public void save(Newuser newUser){
        newUser = new Newuser(getNewName(),getNewPswd(),getNewGroup());
        addContact(newUser);
        //newPosition = newUser.size()-1;
     }
     
   public Scene AddUser(){
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(5));               
        
        txtNewName = new TextField();
        txtNewPswd = new TextField();
        txtNewGroup = new TextField();
        Button btnSubmit = new Button("Submit");
        Button btnCancel = new Button("Cancel");       
        pane.add(new Label("Enter new user info here"),0,0);
        pane.add(new Label("Name"),0,1);
        pane.add(new Label("Password"),0,2);
        pane.add(new Label("Group"),0,3);
        pane.add(txtNewName, 1, 1);
        pane.add(txtNewPswd, 1, 2);
        pane.add(txtNewGroup, 1, 3);
        
        pane.add(btnSubmit,0,4);   
        pane.add(btnCancel,1,4);
       
        btnSubmit.setOnAction(e -> {
            saveNewIssue(getNewIssue());
           switchScreens(issueListM);
        });
        btnCancel.setOnAction(e -> switchScreens(issueListM));
        
        addUser = new Scene(pane,300,300);
       return addUser;
   }
 
   public static boolean checkUserName(String name){     
        if(name == ""){
            return false;
        }      
            return true;
    }
   public static boolean checkLength(String pswd){
        if(pswd.length() <= 4){
            return false;
        }      
            return true;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}


