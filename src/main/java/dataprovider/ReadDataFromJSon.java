package dataprovider;


import dataprovider.getdata.ConfigureInfoData;
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



}
