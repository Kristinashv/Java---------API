import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, TreeSet<String>> phoneBook = new HashMap<>();

        // Пример заполнения телефонной книги
        addContact(phoneBook, "Иванов", "123456789");
        addContact(phoneBook, "Петров", "987654321");
        addContact(phoneBook, "Сидоров", "111222333");
        addContact(phoneBook, "Иванов", "999888777");
        addContact(phoneBook, "Петров", "555666777");
        addContact(phoneBook, "Иванов", "444555666");

        // Сортировка и вывод по убыванию числа телефонов
        List<Map.Entry<String, TreeSet<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        System.out.println("Телефонная книга:");

        for (Map.Entry<String, TreeSet<String>> entry : sortedEntries) {
            String name = entry.getKey();
            TreeSet<String> phones = entry.getValue();
            System.out.println(name + ": " + phones);
        }
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(HashMap<String, TreeSet<String>> phoneBook, String name, String phone) {
        TreeSet<String> phones = phoneBook.getOrDefault(name, new TreeSet<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }
}
