package com.ecovacs.test.activity;

import com.ecovacs.test.common.Common;
import com.ecovacs.test.common.TranslateErrorReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by ecosqa on 17/2/17.
 * work log activity
 */
public class WorkLogActivity {
    private static WorkLogActivity workLogActivity = null;

    @FindBy(id = "com.ecovacs.ecosphere.intl:id/titleContent")
    private MobileElement title = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/tv_time_sign")
    private MobileElement timeTotal = null;
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")
    private MobileElement timeTips = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/tv_log_hint")
    private MobileElement cleanHistory = null;
    @FindBy(id = "com.ecovacs.ecosphere.intl:id/lv_log")
    private MobileElement listHistory = null;

    private WorkLogActivity(){

    }

    public static WorkLogActivity getInstance(){
        if(workLogActivity == null){
            workLogActivity = new WorkLogActivity();
        }
        return workLogActivity;
    }

    public void init(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void showActivity(){
        Common.getInstance().showActivity(listHistory);
    }

    private boolean staticUITranslation(Map<String, String> tranMap){
        String strLanguage = tranMap.get("language");
        boolean btitle = title.getText().equalsIgnoreCase(tranMap.get("random_deebot_work_log"));
        if (!btitle){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Work log", title.getText(),
                    tranMap.get("random_deebot_work_log"), "fail");
        }
        String strTotalTime = timeTotal.getText();
        boolean btimeTotal;
        if (strTotalTime.contains(tranMap.get("day"))){
            btimeTotal = strTotalTime.contains(tranMap.get("hour")) && strTotalTime.contains(tranMap.get("minute"));
        }else if (strTotalTime.contains(tranMap.get("hour"))){
            btimeTotal = strTotalTime.contains(tranMap.get("minute"));
        }else {
            btimeTotal = strTotalTime.contains(tranMap.get("minute"));
        }
        if (!btimeTotal){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Work log", timeTotal.getText(),
                    tranMap.get("minute"), "fail");
        }
        boolean btimeTips = timeTips.getText().equalsIgnoreCase(tranMap.get("random_deebot_time_all"));
        if (!btimeTips){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Work log", timeTips.getText(),
                    tranMap.get("random_deebot_time_all"), "fail");
        }
        boolean bcleanHistory = cleanHistory.getText().equalsIgnoreCase(tranMap.get("random_deebot_work_log1"));
        if (!bcleanHistory){
            TranslateErrorReport.getInstance().insetNewLine(
                    strLanguage, "Work log", cleanHistory.getText(),
                    tranMap.get("random_deebot_work_log1"), "fail");
        }
        return btitle && btimeTotal && btimeTips && bcleanHistory;
    }

    private boolean historyListView(Map<String, String> tranMap){
        List<MobileElement> rows = listHistory.findElementsByClassName("android.widget.RelativeLayout");
        System.out.println("rows.size()--" + rows.size());
        for(MobileElement row:rows){
            List<MobileElement> linears = row.findElementsByClassName("android.widget.LinearLayout");
            System.out.println("linears.size()" + linears.size());
            for(MobileElement linear:linears) {
                List<MobileElement> linearList = linear.findElementsByClassName("android.widget.LinearLayout");
                if(linearList.size() > 0){
                    System.out.println("continue!!!");
                    continue;
                }
                List<MobileElement> eleDate= linear.findElementsById("com.ecovacs.ecosphere.intl:id/tv_date");
                List<MobileElement> eleDuration= linear.findElementsById("com.ecovacs.ecosphere.intl:id/tv_qingSaoMianJi");
                if (eleDate.size() > 0){
                    System.out.println(eleDate.get(0).getText());
                }else if(eleDuration.size() > 0){
                    System.out.println(eleDuration.get(0).getText());
                }
            }
        }
        return true;

    }

    public boolean translate(Map<String, String> tranMap){
        boolean bStatic = staticUITranslation(tranMap);
        boolean bHis = historyListView(tranMap);
        return bStatic && bHis;
    }

}
