package com.phonemanager.app;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private final PhoneManagerDao dao;

    public Controller(PhoneManagerDao dao) {
        this.dao = dao;
    }

    /**
     * Создание новой строки таблицы
     * @param phoneManager - получает значения из ДБ
     * @return - Берет значения из запроса
     */
    @PostMapping                        //тело запроса
    public Long createPhoneManager(@RequestBody PhoneManager phoneManager) {
        return dao.createPhoneManager(phoneManager);
    }

    /**
     * Дает всю информацию о телефоне по id
     * @param id - Получает значение по id
     * @return - Берет значения из запроса
     */
    @GetMapping
    public PhoneManager getPhoneManagerById(@RequestParam long id) {
        return dao.getPhoneManagerById(id);
    }

    /**
     * изменяет уже существущие значения
     * @param phoneManager - получает значения из ДБ
     */
    @PutMapping
    public void editPhoneManager(@RequestBody PhoneManager phoneManager) {
        dao.editPhoneManager(phoneManager);
    }

    /**
     * Удаление с таблицы по id
     * @param id - Получает значение по id
     */
    @DeleteMapping
    public void deletePhoneManager(@RequestParam long id) {
        dao.deletePhoneManager(id);
    }
}
