package pl.pwr.ite.bd2.service;

import java.time.LocalDateTime;
import java.util.Date;

public interface ClockService {
    LocalDateTime getCurrentTime();

    Date getCurrentDate();
}
