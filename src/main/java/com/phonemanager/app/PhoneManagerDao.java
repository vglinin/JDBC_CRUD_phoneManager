package com.phonemanager.app;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PhoneManagerDao {
    private final NamedParameterJdbcTemplate template;

    public PhoneManagerDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    //Первый запрос
    public Long createPhoneManager(PhoneManager phoneManager) {
        String sql = "INSERT INTO phoneManager (namephone, versionphone) "
                + "VALUES (:namephone, :versionphone) RETURNING ID";
    //Структура данных
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("namephone", phoneManager.getNamePhone())
                .addValue("versionphone", phoneManager.getVersionPhone());

    return template.queryForObject(sql, parameterSource, Long.class);
    }

    public PhoneManager getPhoneManagerById(long id) {
        //достать данные
        String sql = "SELECT * FROM phonemanager WHERE phonemanager.id = :id";
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, parameterSource, new PhoneManagerRowMapper());
    }

    public void editPhoneManager(PhoneManager phoneManager) {
        String sql = """
                UPDATE phonemanager
                SET 
                namephone = :namephone,
                versionphone = :versionphone
                WHERE
                id = :id
                """;

        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", phoneManager.getId())
                .addValue("namephone", phoneManager.getNamePhone())
                .addValue("versionphone", phoneManager.getVersionPhone());
        template.update(sql, parameterSource);
    }

    public void deletePhoneManager(long id) {
        String sql = """
                DELETE FROM phonemanager
                WHERE id = :id
                """;
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        template.update(sql, parameterSource);
    }
}
