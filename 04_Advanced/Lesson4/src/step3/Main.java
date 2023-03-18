/* Завдання 3. Спроєктуйте та розробіть метод, який визначає, скільки часу пройшло із заданої дати.
               За допомогою цього методи виведіть у консоль, скільки часу пройшло з вашого дня народження у зручному для сприйняття вигляді,
               наприклад: «Вам виповнилося 20 років, 3 місяці, 18 днів, 4 години, 5 хвилин та 10 секунд».
 */
package step3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

class DurationTester {
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public DurationTester(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;

        if (startDate.isAfter(endDate))
            throw new RuntimeException("Не виконується умова: перша дата повинна бути не більше другої (" + startDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " <= " + endDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ")");
    }

    @Override
    public String toString() {
        int d, mm, y, h, m, s;
        Period period = Period.between(startDate.toLocalDate(), endDate.toLocalDate());
        Duration duration = Duration.between(startDate, endDate);

        y = period.getYears();
        mm = period.getMonths();
        d = period.getDays();

        h = (int) duration.toHours() % 24;
        m = (int) duration.toMinutes() % 60;
        s = (int) duration.toSeconds() % 60;

        return String.format("Вам виповнилося %d років, %d місяці, %d днів, %d години, %d хвилин та %d секунд\n", y, mm, d, h, m, s);
    }
}

public class Main {
    public static void main(String[] args) {
        LocalDateTime startDate = LocalDateTime.of(2011, Month.SEPTEMBER, 11, 8, 46, 40);
        LocalDateTime endDate = // LocalDateTime.of(2010, Month.SEPTEMBER, 12, 9, 47, 45);
                                LocalDateTime.now();

        DurationTester tester = new DurationTester(startDate, endDate);
        System.out.println(tester);
    }
}
