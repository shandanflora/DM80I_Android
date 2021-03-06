package com.ecovacs.test.activity;

import com.ecovacs.test.common.Common;
import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by ecosqa on 17/2/15.
 * unibot cleaning
 */
public class UnibotCleanActivity {
    private static UnibotCleanActivity unibotCleanActivity = null;
    private static Logger logger = LoggerFactory.getLogger(UnibotCleanActivity.class);
    private AndroidDriver driver = null;

    private enum DIRECTION_PAGER{
        TO_RIGHT,
        TO_LEFT
    }

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/right")
    private MobileElement textViewRight = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/current_statue")
    private MobileElement textViewStatusValue = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    private MobileElement textViewStatus = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/stand_electricity")
    private MobileElement textViewDeBattery = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/auto")
    private MobileElement textViewDeAuto = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/charge")
    private MobileElement textViewDeCharge = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/border")
    private MobileElement textViewEdge = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/fixed")
    private MobileElement textViewSpot = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/standard")
    private MobileElement textViewStandard = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/strong")
    private MobileElement textViewStrong = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/vPager")
    private MobileElement viewPager = null;


    private UnibotCleanActivity() {

    }

    public static UnibotCleanActivity getInstance() {
        if (unibotCleanActivity == null) {
            unibotCleanActivity = new UnibotCleanActivity();
        }
        return unibotCleanActivity;
    }

    public void init(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

    public boolean showActivity(){
        return Common.getInstance().showActivity(textViewStatusValue);
    }

    public void showText(String strText) {
        while (true) {
            if (textViewStatusValue.getText().contains(strText)) {
                logger.info(textViewStatusValue.getText());
                Common.getInstance().waitForSecond(500);
            } else {
                logger.info(textViewStatusValue.getText());
                break;
            }
        }
    }

    public void clickSetting(){
        textViewRight.click();
    }

    private void swipe(DIRECTION_PAGER direction){
        Point point = viewPager.getLocation();
        Dimension dimension = viewPager.getSize();
        int iRectX = point.getX();
        int iRectY = point.getY();
        int iWidth = dimension.getWidth();
        int iHeight = dimension.getHeight();

        point.x = iRectX + iWidth/2;
        point.y = iRectY + 3*iHeight/4;

        if(direction == DIRECTION_PAGER.TO_RIGHT){
            driver.swipe(point.x - iWidth/4, point.y,
                    point.x + iWidth/4, point.y, 200);
        }else if (direction == DIRECTION_PAGER.TO_LEFT){
            driver.swipe(iRectX + iWidth - iWidth/6, point.y,
                    iRectX + iWidth/3, point.y, 200);
        }
    }

    private boolean staticUITranslate(Map<String, String> tranMap) {
        Common.getInstance().waitForSecond(2000);
        String strLanguage = tranMap.get("language");
        boolean btextViewStatus = textViewStatus.getText().equalsIgnoreCase(tranMap.get("random_deebot_state"));
        if (!btextViewStatus) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewStatus.getText(),
                    tranMap.get("random_deebot_state"), "fail");
        }
        boolean btextViewStatusValue = textViewStatusValue.getText().equalsIgnoreCase(tranMap.get("random_deebot_state_standby"));
        if (!btextViewStatusValue) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewStatusValue.getText(),
                    tranMap.get("random_deebot_state_standby"), "fail");
        }
        boolean btextViewDeBattery = textViewDeBattery.getText().equalsIgnoreCase(tranMap.get("random_deebot_battery"));
        if (!btextViewDeBattery) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewDeBattery.getText(),
                    tranMap.get("random_deebot_battery"), "fail");
        }
        if(tranMap.get("language").equals("English")) {
            boolean btextViewDeAuto = textViewDeAuto.getText().equalsIgnoreCase(tranMap.get("random_deebot_auto"));
            if (!btextViewDeAuto) {
                TranslateErrorReport.getInstance().insetNewLine(
                        strLanguage, "UnibotClean", textViewDeAuto.getText(),
                        tranMap.get("random_deebot_auto"), "fail");
            }
            boolean btextViewDeCharge = textViewDeCharge.getText().equalsIgnoreCase(tranMap.get("random_deebot_state_go_charging"));
            if (!btextViewDeCharge) {
                TranslateErrorReport.getInstance().insetNewLine(
                        strLanguage, "UnibotClean", textViewDeCharge.getText(),
                        tranMap.get("random_deebot_state_go_charging"), "fail");
            }
            boolean btextViewEdge = textViewEdge.getText().equalsIgnoreCase(tranMap.get("random_deebot_edge"));
            if (!btextViewEdge) {
                TranslateErrorReport.getInstance().insetNewLine(
                        strLanguage, "UnibotClean", textViewEdge.getText(),
                        tranMap.get("random_deebot_edge"), "fail");
            }
            boolean btextViewSpot = textViewSpot.getText().equalsIgnoreCase(tranMap.get("random_deebot_spot"));
            if (!btextViewSpot) {
                TranslateErrorReport.getInstance().insetNewLine(
                        strLanguage, "UnibotClean", textViewSpot.getText(),
                        tranMap.get("random_deebot_spot"), "fail");
            }
            //right to left
            swipe(DIRECTION_PAGER.TO_LEFT);
            boolean btextViewStandard = textViewStandard.getText().equalsIgnoreCase(tranMap.get("random_deebot_standard"));
            if (!btextViewStandard) {
                TranslateErrorReport.getInstance().insetNewLine(
                        strLanguage, "UnibotClean", textViewStandard.getText(),
                        tranMap.get("random_deebot_standard"), "fail");
            }
            boolean btextViewStrong = textViewStrong.getText().equalsIgnoreCase(tranMap.get("random_deebot_max"));
            if (!btextViewStrong) {
                TranslateErrorReport.getInstance().insetNewLine(
                        strLanguage, "UnibotClean", textViewStrong.getText(),
                        tranMap.get("random_deebot_max"), "fail");
            }

            //left to right
            swipe(DIRECTION_PAGER.TO_RIGHT);
            return btextViewStatus && btextViewStatusValue && btextViewDeBattery &&
                    btextViewDeAuto && btextViewDeCharge && btextViewEdge &&
                    btextViewSpot && btextViewStandard && btextViewStrong;
        }else {
            return btextViewStatus && btextViewStatusValue && btextViewDeBattery;
        }

    }

    public boolean translate(Map<String, String> tranMap){
        boolean bStatic = staticUITranslate(tranMap);
        boolean bCheckStatus = checkStatus(tranMap);
        return bStatic && bCheckStatus;
    }

    private boolean checkStatus_clean_charge(Map<String, String> tranMap, MobileElement element){
        //auto to charge
        String strLanguage = tranMap.get("language");
        //check auto
        element.click();
        logger.info(textViewStatusValue.getText());
        boolean btextViewStatusValue = textViewStatusValue.getText().equalsIgnoreCase(tranMap.get("random_deebot_state_clean"));
        if (!btextViewStatusValue) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewStatusValue.getText(),
                    tranMap.get("random_deebot_state_clean"), "fail");
        }
        Common.getInstance().waitForSecond(1000 * 5);
        //check stand by
        element.click();
        logger.info(textViewStatusValue.getText());
        boolean btextViewStatusValue1 = textViewStatusValue.getText().equalsIgnoreCase(tranMap.get("random_deebot_state_standby"));
        if (!btextViewStatusValue1) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewStatusValue.getText(),
                    tranMap.get("random_deebot_state_standby"), "fail");
        }
        //check charge
        textViewDeCharge.click();
        logger.info(textViewStatusValue.getText());
        boolean btextViewStatusValue2 = textViewStatusValue.getText().equalsIgnoreCase(tranMap.get("ibt_return_charge_text"));
        if (!btextViewStatusValue2) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewStatusValue.getText(),
                    tranMap.get("ibt_return_charge_text"), "fail");
        }
        //check stand by
        textViewDeCharge.click();
        logger.info(textViewStatusValue.getText());
        boolean btextViewStatusValue3 = textViewStatusValue.getText().equalsIgnoreCase(tranMap.get("random_deebot_state_standby"));
        if (!btextViewStatusValue3) {
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "UnibotClean", textViewStatusValue.getText(),
                    tranMap.get("random_deebot_state_standby"), "fail");
        }
        textViewDeCharge.click();
        logger.info(textViewStatusValue.getText());
        showText(textViewStatusValue.getText());
        return btextViewStatusValue && btextViewStatusValue1 && btextViewStatusValue2
                && btextViewStatusValue3;
    }

    public void clickAuto7(){
        for (int i = 0; i < 7; i++){
            //auto
            textViewDeAuto.click();
            Common.getInstance().waitForSecond(3000);
            //standby
            textViewDeAuto.click();
            logger.info("i--" + i);
        }
        //charge
        textViewDeCharge.click();
        logger.info(textViewStatusValue.getText());
        showText(textViewStatusValue.getText());
    }

    private boolean checkStatus(Map<String, String> tranMap){
        //check auto to standby to charge
        boolean bAuto = checkStatus_clean_charge(tranMap, textViewDeAuto);
        //check edge to standby to charge
        boolean bEdge = checkStatus_clean_charge(tranMap, textViewEdge);
        //check spot to standby to charge
        boolean bSpot = checkStatus_clean_charge(tranMap, textViewSpot);
        return bAuto && bEdge && bSpot;
    }


}
