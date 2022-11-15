package org.example;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class Birthday {

    static int getAge(int year, int month, int date) {
        LocalDate birthDate = LocalDate.of(year, month, date);
        LocalDate currentDate = LocalDate.now();
        return  (int) DAYS.between(birthDate, currentDate);
    }

    static LocalDate nextBirthday(int year, int month, int date){
        int next1000 = (int) (((getAge(year, month, date)) / 1000 * 1000) +1000);
        int between = next1000 - getAge(year, month, date);
        return LocalDate.now().plusDays(between);
    }

}
