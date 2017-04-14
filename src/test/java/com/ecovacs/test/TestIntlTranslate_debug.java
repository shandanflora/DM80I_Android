package com.ecovacs.test;

import com.ecovacs.test.common.Common;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by ecosqa on 17/2/7.
 * test translate of intl app
 */
public class TestIntlTranslate_debug {
    private AndroidDriver driver = null;

    @BeforeClass
    public void setUp(){
        driver = Common.getInstance().getDriver();
        if(driver == null){
            return;
        }
        HandleDM80i.getInstance().init(driver);
        HandleDM80i.getInstance().translate_init("English");
        HandleDM80i.getInstance().translateErrorReport_init();
    }

    @AfterClass
    public void tearDown(){
        //HandleDM80i.getInstance().changeLanguage(PropertyData.getProperty("French"));
        //driver.quit();
    }

    @Test(priority = 1)
    public void translateMain(){
        Assert.assertTrue(HandleDM80i.getInstance().translateMain());
    }

    @Test(priority = 2)
    public void translateUnibotSetting(){
        Assert.assertTrue(HandleDM80i.getInstance().translateUnibotSetting());
    }

    @Test(priority = 3)
    public void translateWorkLog(){
        Assert.assertTrue(HandleDM80i.getInstance().translateWorkLog());
    }

    @Test(enabled = false)
    public void translateSelectDEEBOT(){
        Assert.assertTrue(HandleDM80i.getInstance().translateSelectDEEBOT());
    }

    @Test(enabled = false)
    public void translateNetworkSetting(){
        Assert.assertTrue(HandleDM80i.getInstance().translateNetworkSetting());
    }

    @Test(enabled = false)
    public void translateConnectGuide(){
        Assert.assertTrue(HandleDM80i.getInstance().translateConnectGuide());
    }

    @Test(enabled = false)
    public void translateNetworkSettingActivity_ing(){
        Assert.assertTrue(HandleDM80i.getInstance().translateNetworkSettingActivity_ing());
    }

    @Test(enabled = false)
    public void translateFailNetworkSetting(){
        Assert.assertTrue(HandleDM80i.getInstance().translateFailNetworkSetting());
    }

}
