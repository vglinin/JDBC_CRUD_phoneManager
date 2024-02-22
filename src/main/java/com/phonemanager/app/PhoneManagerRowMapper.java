package com.phonemanager.app;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PhoneManagerRowMapper implements RowMapper<PhoneManager> {
    @Override
    public PhoneManager mapRow(ResultSet rs, int rowNum) throws SQLException {
        PhoneManager phoneManager = new PhoneManager();
        phoneManager.setId(rs.getLong("id"));
        phoneManager.setNamePhone(rs.getString("namephone"));
        phoneManager.setVersionPhone(rs.getString("versionphone"));
        phoneManager.setCreated(rs.getTimestamp("created").toLocalDateTime());
        return phoneManager;
    }
}
