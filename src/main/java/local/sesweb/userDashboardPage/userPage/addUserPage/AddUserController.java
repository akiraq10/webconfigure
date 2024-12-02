package local.sesweb.userDashboardPage.userPage.addUserPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static local.sesweb.userDashboardPage.userPage.addUserPage.AddUserElements.getEle;
import static ults.ElementController.*;


public class AddUserController {
    private WebDriver driver ;

    public AddUserController(WebDriver driver) {
        this.driver=driver;

    }
    @Step("Input the UserName as: {userID}")
    public AddUserController fillUserID(String userID ) {
        fill(driver, getEle(driver).userIDTXT,userID);
        return this;
    }
    @Step("Input the Password as: {password}")
    public AddUserController fillPWD(String password ) {
        fill(driver, getEle(driver).passwordTXT,password);
        return this;
    }
    @Step("Input the First Name as: {firstname}")
    public AddUserController fillFirstName(String firstname ) {
        fill(driver, getEle(driver).firstNameTXT,firstname);
        return this;
    }
    @Step("Input the Last name as: {lastname}")
    public AddUserController fillLastName(String lastname ) {
        fill(driver, getEle(driver).lastNameTXT,lastname);
        return this;
    }
    @Step("Input the Email address as: {email}")
    public AddUserController fillEmail(String email ) {
        fill(driver, getEle(driver).emailTXT,email);
        return this;
    }
    @Step("Input the Description as: {description}")
    public AddUserController fillDescription(String description ) {
        fill(driver, getEle(driver).descriptionTXT,description);
        return this;
    }
    @Step("Check User must change password at next logon ")
    public AddUserController checkFinalPassword() {
        check(driver, getEle(driver).finalPWDCheckBox);
        return this;
    }
    @Step("Un-Check User must change password at next logon ")
    public AddUserController unCheckFinalPassword() {
        uncheck(driver, getEle(driver).finalPWDCheckBox);
        return this;
    }
    public AddUserController clickOnUserType(){
        click(driver, getEle(driver).userTypeListBox);
        return this;
    }
//    @Step("Select the user type as : {type}")
//    public AddUserController selectUserType(UserData type) {
//
//        switch (type){
//            case REGULAR :
//                select(getEle(driver).userTypeOpt,REGULAR.getValue());
//                break;
//            case AUTO:
//                select(getEle(driver).userTypeOpt,AUTO.getValue());
//                break;
//            case TEMPORARY:
//                select(getEle(driver).userTypeOpt, TEMPORARY.getValue());
//                break;
//            default:
//                System.out.println(type + "NOT available");
//                break;
//
//        }
//        return this;
//    }
    @Step("Click on the Save button")
    public AddUserController clickOnSaveBtn(){
        click(driver, getEle(driver).saveBtn);
        return this;
    }
}
