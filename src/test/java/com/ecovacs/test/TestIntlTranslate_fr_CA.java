package com.ecovacs.test;

import com.ecovacs.test.common.Common;
import com.ecovacs.test.common.PropertyData;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by ecosqa on 17/2/7.
 * test translate of intl app
 */
public class TestIntlTranslate_fr_CA {
    private AndroidDriver driver = null;

    @BeforeClass
    public void setUp(){
        driver = Common.getInstance().getDriver();
        if(driver == null){
            return;
        }
        HandleDM80i.getInstance().init(driver);
        HandleDM80i.getInstance().translate_init("fr-CA");
        //HandleDM80i.getInstance().translateErrorReport_init();
    }

    @AfterClass
    public void tearDown(){
        HandleDM80i.getInstance().changeLanguage(PropertyData.getProperty("English"));
        driver.quit();
    }

    @Test
    public void translateWelcome(){
        Assert.assertTrue(HandleDM80i.getInstance().translateWelcome());
    }

    @Test
    public void translateLogin(){
        Assert.assertTrue(HandleDM80i.getInstance().translateLogin());
    }

    @Test
    public void translateCountryRegion(){
        Assert.assertTrue(HandleDM80i.getInstance().translateCountryRegion());
    }

    @Test
    public void translateForget(){
        Assert.assertTrue(HandleDM80i.getInstance().translateForget());
    }

    @Test
    public void translateRegister(){
        Assert.assertTrue(HandleDM80i.getInstance().translateRegister());
    }

    @Test
    public void translateMain(){
        Assert.assertTrue(HandleDM80i.getInstance().translateMain());
    }

    @Test
    public void translateSelectDEEBOT(){
        Assert.assertTrue(HandleDM80i.getInstance().translateSelectDEEBOT());
    }

    @Test
    public void translateNetworkSetting(){
        Assert.assertTrue(HandleDM80i.getInstance().translateNetworkSetting());
    }

    @Test
    public void translateConnectGuide(){
        Assert.assertTrue(HandleDM80i.getInstance().translateConnectGuide());
    }

    @Test
    public void translateNetworkSettingActivity_ing(){
        Assert.assertTrue(HandleDM80i.getInstance().translateNetworkSettingActivity_ing());
    }

    @Test
    public void translateFailNetworkSetting(){
        Assert.assertTrue(HandleDM80i.getInstance().translateFailNetworkSetting());
    }

    @Test
    public void translateMore(){
        Assert.assertTrue(HandleDM80i.getInstance().translateMore());
    }

    @Test
    public void translateChangePass(){
        Assert.assertTrue(HandleDM80i.getInstance().translateChangePass());
    }

    @Test
    public void translateAbout(){
        Assert.assertTrue(HandleDM80i.getInstance().translateAbout());
    }

    @Test
    public void translateUserAgree(){
        Assert.assertTrue(HandleDM80i.getInstance().translateUserAgree());
    }

    @Test
    public void translateLanguage(){
        Assert.assertTrue(HandleDM80i.getInstance().translateLanguage());
    }

    @Test
    public void translateHelpCenter(){
        Assert.assertTrue(HandleDM80i.getInstance().translateHelpCenter());
    }

    @Test
    public void translateUnibotClean(){
        Assert.assertTrue(HandleDM80i.getInstance().translateUnibotClean());
    }

    @Test
    public void translateUnibotSetting(){
        Assert.assertTrue(HandleDM80i.getInstance().translateUnibotSetting());
    }

    @Test
    public void translateWorkLog(){
        Assert.assertTrue(HandleDM80i.getInstance().translateWorkLog());
    }

    @Test
    public void translateContinueClean(){
        Assert.assertTrue(HandleDM80i.getInstance().translateContinueClean());
    }

    @Test
    public void translateContiuneClean_Status(){
        Assert.assertTrue(HandleDM80i.getInstance().translateContinueClean_Status());
    }

    @Test
    public void translateNoTimeSchedule(){
        Assert.assertTrue(HandleDM80i.getInstance().translateNoTimeSchedule());
    }

    @Test
    public void translateNewSchedule(){
        Assert.assertTrue(HandleDM80i.getInstance().translateNewSchedule());
    }

    @Test
    public void translateRepetition(){
        Assert.assertTrue(HandleDM80i.getInstance().translateRepetition());
    }

    @Test
    public void translateSelectWeekOfDate(){
        Assert.assertTrue(HandleDM80i.getInstance().translateSelectWeekOfDate());
    }

    @Test
    public void translateSelectWeekend(){
        Assert.assertTrue(HandleDM80i.getInstance().translateSelectWeekend());
    }

    @Test
    public void translateSelectWorkday(){
        Assert.assertTrue(HandleDM80i.getInstance().translateSelectWorkday());
    }

    @Test
    public void translateSelectEveryday(){
        Assert.assertTrue(HandleDM80i.getInstance().translateSelectEveryday());
    }

    @Test
    public void translateConsumable(){
        Assert.assertTrue(HandleDM80i.getInstance().translateConsumable());
    }
    //
    @Test
    public void translateRename(){
        Assert.assertTrue(HandleDM80i.getInstance().translateRename());
    }

    @Test
    public void translateFirmwareVer(){
        Assert.assertTrue(HandleDM80i.getInstance().translateFirmVer());
    }

    @Test
    public void translateAddTimeSchedule_sun(){
        Assert.assertTrue(HandleDM80i.getInstance().translateAddTimeSchedule_sun());
    }

    @Test
    public void translateAddTimeSchedule_never(){
        Assert.assertTrue(HandleDM80i.getInstance().translateAddTimeSchedule_never());
    }

    @Test
    public void translateDelSchedule_Edit(){
        Assert.assertTrue(HandleDM80i.getInstance().translateDelSchedule_edit());
    }

    @Test
    public void translateDelSchedule_Swipe(){
        Assert.assertTrue(HandleDM80i.getInstance().translateDelSchedule_swipe());
    }
    @Test
    public void translateOverTimeSchedule(){
        Assert.assertTrue(HandleDM80i.getInstance().translateOverTimeSchedule());
    }

}
