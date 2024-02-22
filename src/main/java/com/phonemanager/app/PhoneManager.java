package com.phonemanager.app;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PhoneManager {

    private long id;
    private String namePhone;
    private String versionPhone;
    private LocalDateTime created;
}
