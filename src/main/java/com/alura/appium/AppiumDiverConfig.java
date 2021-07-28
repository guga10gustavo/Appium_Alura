package com.alura.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDiverConfig {
     public final AppiumDriver driver;
     private static AppiumDiverConfig _instance;

     public static AppiumDiverConfig Instance(){
         if(AppiumDiverConfig._instance == null){
             AppiumDiverConfig._instance = new AppiumDiverConfig();
         }
         return AppiumDiverConfig._instance;
     }

    private AppiumDiverConfig() {

        File apk = new File("C:\\Users\\gsalesol\\OneDrive - everis\\Documentos\\Curso_Appium_Alura\\AluraAppiumProjects\\src\\main\\resources\\alura_esporte.apk");

        DesiredCapabilities configuracoes = new DesiredCapabilities();
        configuracoes.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());
        configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        URL urlConxao = null;
        try {
            urlConxao = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AppiumDriver<>(urlConxao,configuracoes);
    }
}
