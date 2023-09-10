import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserInput {

    public static void main(String[] args) {
        try {
            // Запрос данных у пользователя
            String input = "Кузнецов Олег Сергеевич 1234567890 m";
            // Разделение введенной строки на отдельные значения
            String[] data = input.split(" ");
            // Проверка количества введенных данных
            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }
            // Извлечение отдельных параметров из введенных данных
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            LocalDate birthDate = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);
            if (gender != 'm' && gender != 'f') {
                throw new IllegalArgumentException("Неверный формат пола");
            }
            // Запись данных в файл
            String fileName = lastName + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(lastName + " " + firstName + " " + middleName + " " + birthDate.toString() + " " + phoneNumber
                    + " " + gender);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат номера телефона");
        } catch (DateTimeParseException e) {
            System.out.println("Неверный формат даты рождения");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
