import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Day03 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("EEEE, dd-MMMM-yyyy", Locale.forLanguageTag("id-ID"));
        System.out.println(Formatter.format(today));
    }
}
