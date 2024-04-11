import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckValues {

    public static Boolean CheckRequiredValues(String input) throws ParseException {
        Boolean checkValues = true;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String[] data = input.split(" ");

        try {
            checkQuantity(data);
        } catch (LessData | MoreData e) {
            checkValues = false;
            System.out.println("Ошибка: " + e.getMessage());
            return checkValues;
        }
        // String lastName = data[0];
        // String firstName = data[1];
        // String patronymic = data[2];

        try {
            Date date = formatter.parse(data[3]);
        } catch (ParseException e) {
            // e.printStackTrace();
            checkValues = false;
            System.out.println("Ошибка: Неверный формат даты рождения. " + e.getMessage());
        }

        try {
            int phoneNumber = Integer.parseInt(data[4]);
        } catch (NumberFormatException e) {
            // e.printStackTrace();
            checkValues = false;
            System.out.println("Ошибка: Неверный формат номера телефона. " + e.getMessage());
        }

        try {
            char gender = data[5].charAt(0);
            checkGenderValues(gender);
        } catch (IncorrectGender e) {
            checkValues = false;
            System.out.println("Ошибка: Неверный формат выбора пола. " + e.getMessage());
        }
        return checkValues;
    }

    public static void checkQuantity(String[] data) throws MoreData, LessData {

        if (data.length < 6) {
            throw new LessData();

        } else if (data.length > 6) {
            throw new MoreData();
        }
    }

    public static void checkGenderValues(char value) {
        if (value != 'f' && value != 'm') {
            throw new IncorrectGender("Only 'f' or 'm'.");
        }
    }
}
