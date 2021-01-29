package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {

    public static void main(String[] args) {
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(null, dTF);
        LocalDateTime localDateTime = localDate.atTime(0, 0);
    }
}
