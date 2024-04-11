
import java.io.IOException;
import java.text.ParseException;

public class Program {
    public static void main(String[] args) throws ParseException, IncorrectGender, IOException {

        System.out.println("Введите данные в формате:");
        System.out.println("Фамилия Имя Отчество дата_рождения номер_телефона пол");
        System.out.println("   дата_рождения - в формате dd.mm.yyyy");
        System.out.println("   номер_телефона - целое беззнаковое число");
        System.out.println("   пол - символ латиницей f или m");
        System.out.print("> ");

        String input = System.console().readLine();

        Boolean checkValues = CheckValues.CheckRequiredValues(input);

        if (checkValues) {
            try {
                FileWriter.writeToFile(input);
            } catch (IOException e) {
                System.err.println("Ошибка при создании файла: ");
                e.printStackTrace();
            }
        } else {
            System.out.println("Повторите ввод данных!");
        }
    }
}
