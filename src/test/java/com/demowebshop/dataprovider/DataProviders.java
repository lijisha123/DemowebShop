package com.demowebshop.dataprovider;

import org.testng.annotations.DataProvider;

import com.demowebshop.Utilities.ExcelUtility;
import com.demowebshop.pages.LoginPage;

public class DataProviders extends ExcelUtility{
	ExcelUtility excel=new ExcelUtility();
    @DataProvider(name="InvalidUserCredentials")
    public Object[][] InvalidUserCredentialsToLogin(){
        Object[][] data=excel.dataProviderRead("LoginPageDataProvider");
        return data;
    }

}
