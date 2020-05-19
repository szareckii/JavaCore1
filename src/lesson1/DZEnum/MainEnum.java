package lesson1.DZEnum;

enum DayOfWeek {
    MONDAY("Понедельник"), TUESDAY("Вторник"), WEDNESDAY("Среда"), THURSDAY("Четверг"),
    FRIDAY("Пятница"), SATURDAY("Суббота"), SUNDAY("Воскресенье");
    private String russianTitle;

    public String getRussianTitle() {
        return russianTitle;
    }

    DayOfWeek(String russianTitle) {
        this.russianTitle = russianTitle;
    }
}

public class MainEnum {

    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
        System.out.println(getWorkingHours(DayOfWeek.TUESDAY));
        System.out.println(getWorkingHours(DayOfWeek.WEDNESDAY));
        System.out.println(getWorkingHours(DayOfWeek.THURSDAY));
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
        System.out.println(getWorkingHours(DayOfWeek.SATURDAY));
        System.out.println(getWorkingHours(DayOfWeek.SUNDAY));
    }

    private static String getWorkingHours(DayOfWeek day) {
        if (day.ordinal() == 5 || day.ordinal() == 6) {
            return  day.getRussianTitle() + ": Сегодня выходной";
        }
        else {
            return day.getRussianTitle() + ": до конца недели осталось " + 8 * (5 - day.ordinal()) + " рабочих часов";
        }
    }

}


