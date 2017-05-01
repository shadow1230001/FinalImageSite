package com.itransition.lyubin.localizaton.LocalizationImpl;

import com.itransition.lyubin.localizaton.LocalizationInterface;
import org.springframework.stereotype.Component;

@Component
public class LocalizationRU implements LocalizationInterface {

    private final String RULOCAL;

    public LocalizationRU() {
        RULOCAL = "[ " +
                "{ \"key\":\"home\",    \"value\":\"Главная\"}, " +
                "{ \"key\":\"search\",  \"value\":\"Поиск\"}, " +
                "{ \"key\":\"name\",    \"value\":\"Имя\"}, " +
                "{ \"key\":\"birth\",   \"value\":\"День рождения\"}, " +
                "{ \"key\":\"weight\",  \"value\":\"Вес\"}, " +
                "{ \"key\":\"height\",  \"value\":\"Рост\"}, " +
                "{ \"key\":\"sex\",     \"value\":\"Пол\"}, " +
                "{ \"key\":\"photo\",   \"value\":\"Тип фотографий\"}, " +
                "{ \"key\":\"dropzone\",\"value\":\"Дроп зона\"}, " +
                "{ \"key\":\"login\",   \"value\":\"Авторизация\"}, " +
                "{ \"key\":\"singup\",  \"value\":\"Регистрация\"}, " +
                "{ \"key\":\"table\",   \"value\":\"Таблица\"}, " +
                "{ \"key\":\"tile\",    \"value\":\"Плитка\"}, " +
                "{ \"key\":\"slide\",   \"value\":\"Слайд-шоу\"}, " +
                "{ \"key\":\"stylenavbar\",     \"value\":\"Стиль навбара\"}, " +
                "{ \"key\":\"stylebackground\", \"value\":\"Стиль фона\"}, " +
                "{ \"key\":\"dark\",    \"value\":\"Темный\"}, " +
                "{ \"key\":\"white\",   \"value\":\"Светлый\"}, " +
                "{ \"key\":\"uploadnewimage\",  \"value\":\"Загрузить новое изображение\"}, " +
                "{ \"key\":\"upload\",  \"value\":\"Загрузить\"}, " +
                "{ \"key\":\"tag\",     \"value\":\"Тег\"}, " +
                "{ \"key\":\"lang\",     \"value\":\"Язык\"}, " +
                "{ \"key\":\"password\",     \"value\":\"Пароль\"}, " +
                "{ \"key\":\"loginText\",     \"value\":\"Логин\"}, " +
                "{ \"key\":\"photoText\",     \"value\":\"Фото\"}, " +
                "{ \"key\":\"push\",     \"value\":\"Добавить\"} " +
                "]";
    }

    @Override
    public String getLocal() {
        return RULOCAL;
    }
}