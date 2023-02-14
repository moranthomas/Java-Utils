import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
public class TimeAndDateFormatterTest {

    private LocalDateTime dateTime1;
    private SimpleDateFormat simpleDateFormat1;
    private TimeAndDateFormatter timeAndDateFormatter;
    private String dateInString1;


    @BeforeEach
    public void setUp() {
        //dateTime1 = LocalDateTime.parse("2022-05005T11:50:55");
        timeAndDateFormatter = new TimeAndDateFormatter();

        simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy");
        dateInString1 = "7-Jan-2023";
    }

    @Test
    public void testUtilDate() throws ParseException {
        Date date1 = simpleDateFormat1.parse(dateInString1);
        timeAndDateFormatter.printJavaUtilDate(date1, simpleDateFormat1);
    }
}
