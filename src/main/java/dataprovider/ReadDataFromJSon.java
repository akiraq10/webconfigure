package dataprovider;


import dataprovider.getdata.ConfigureInfoData;
import dataprovider.getdata.GroupInfoData;
import dataprovider.getdata.UserInfoData;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class ReadDataFromJSon {

    String fileLocation="/Data/";

    @DataProvider(name="ConfigureServer",parallel = true)
    public ConfigureInfoData[] configureInfoData(Method method){
        switch (method.getName()){
            default : return DataObjectBuilder.buildDataObject(fileLocation+ "ConfigServerInfo.json",ConfigureInfoData[].class);
        }
    }
    @DataProvider(name="UserInfo")
    public UserInfoData[] userInfoData(Method method){
        switch (method.getName()){
            case "loginSES":return DataObjectBuilder.buildDataObject(fileLocation+ "AdminInfo.json", UserInfoData[].class);

            default : return DataObjectBuilder.buildDataObject(fileLocation+ "UserInfo.json", UserInfoData[].class);
        }
    }
    @DataProvider(name="GroupInfo",parallel = true)
    public GroupInfoData[] groupInfoData(Method method){
        switch (method.getName()){
            default : return DataObjectBuilder.buildDataObject(fileLocation+ "GroupInfo.json", GroupInfoData[].class);
        }
    }



}
