package directory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class TelephoneDirectory {

    private final Map<String, HashSet<String>> directory;
    private static final Pattern PHONE_PATTERN = Pattern.compile("\\+\\d\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}");
    private static final Pattern LASTNAME_STRICT = Pattern.compile("^[A-Za-zА-Яа-яЁё]+$");

    public TelephoneDirectory() {
        directory = new HashMap<>();
    }

    public void add(String lastname, String phone) {
        if (!PHONE_PATTERN.matcher(phone).matches()) {
            throw new IllegalArgumentException("Ошибка: Неверный формат номера телефона.");
        }

        lastname = normalize(lastname);
        if (lastname == null || lastname.isBlank() || !LASTNAME_STRICT.matcher(lastname).matches()) {
            throw new IllegalArgumentException("Ошибка: Неверный формат фамилии.");
        }

        if (directory.containsKey(lastname)) {
            HashSet<String> phones = directory.get(lastname);
            phones.add(phone);
            directory.put(lastname, phones);
        } else {
            HashSet<String> phones = new HashSet<>();
            phones.add(phone);
            directory.put(lastname, phones);
        }
    }

    public List<String> get(String lastName) {
        lastName = normalize(lastName);
        return List.copyOf(directory.get(lastName));
    }

    private static String normalize(String s) {
        return s == null ? null : s.trim().toLowerCase(Locale.ROOT);
    }
}
