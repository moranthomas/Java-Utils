import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class TimeAndDateFormatter {

    public void printJavaUtilDate(Date utilDate, SimpleDateFormat simpleDateFormat) {
        log.info("Formatted Date: {} ", simpleDateFormat.format(utilDate));
    }
}
