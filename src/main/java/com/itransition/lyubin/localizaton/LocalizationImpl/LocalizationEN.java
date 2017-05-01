package com.itransition.lyubin.localizaton.LocalizationImpl;

import com.itransition.lyubin.localizaton.LocalizationInterface;
import org.springframework.stereotype.Component;

@Component
public class LocalizationEN implements LocalizationInterface {

    private final String ENLOCAL;

    public LocalizationEN() {
        ENLOCAL = "[ " +
                "{ \"key\":\"home\",    \"value\":\"Home\"}, " +
                "{ \"key\":\"search\",  \"value\":\"Search\"}, " +
                "{ \"key\":\"name\",    \"value\":\"Name\"}, " +
                "{ \"key\":\"birth\",   \"value\":\"Birth\"}, " +
                "{ \"key\":\"weight\",  \"value\":\"Weight\"}, " +
                "{ \"key\":\"height\",  \"value\":\"Height\"}, " +
                "{ \"key\":\"sex\",     \"value\":\"Sex\"}, " +
                "{ \"key\":\"photo\",   \"value\":\"Type of photo\"}, " +
                "{ \"key\":\"dropzone\",\"value\":\"Drop zone\"}, " +
                "{ \"key\":\"login\",   \"value\":\"Login\"}, " +
                "{ \"key\":\"singup\",  \"value\":\"Singup\"}, " +
                "{ \"key\":\"table\",   \"value\":\"Table\"}, " +
                "{ \"key\":\"tile\",    \"value\":\"Tile\"}, " +
                "{ \"key\":\"slide\",   \"value\":\"Slide\"}, " +
                "{ \"key\":\"stylenavbar\",     \"value\":\"Style navbar\"}, " +
                "{ \"key\":\"stylebackground\", \"value\":\"Style background\"}, " +
                "{ \"key\":\"dark\",    \"value\":\"Dark\"}, " +
                "{ \"key\":\"white\",   \"value\":\"White\"}, " +
                "{ \"key\":\"uploadnewimage\",  \"value\":\"Upload new image\"}, " +
                "{ \"key\":\"upload\",  \"value\":\"Upload\"}, " +
                "{ \"key\":\"tag\",     \"value\":\"Tag\"}, " +
                "{ \"key\":\"lang\",     \"value\":\"Lang\"}, " +
                "{ \"key\":\"password\",     \"value\":\"Password\"}, " +
                "{ \"key\":\"loginText\",     \"value\":\"Login\"}, " +
                "{ \"key\":\"photoText\",     \"value\":\"Photo\"}, " +
                "{ \"key\":\"push\",     \"value\":\"Push\"} " +
                "]";
    }

    @Override
    public String getLocal() {
        return ENLOCAL;
    }
}
