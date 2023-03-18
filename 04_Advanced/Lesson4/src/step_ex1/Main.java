/* Додаткове завдання по регулярним виразам:
   Створити регулярний вираз для відфільтровування невалідних паролів. Вимоги до пароля придумайте якомога високими і реалізуйте цей патерн.
*/
//                                   *************
//   Хвала тобі, великий та могутній ** ChatPGT ** !!!!
//                                   *************

package step_ex1;

public class Main {

    public static boolean validatePassword(String password) {

        String allValidSymbols = "[a-zA-Zа-яієїА-ЯІЇЄ0-9~!?@#$%^&*()\\[\\]{}><\\/\\\\|\"',.:;-]+";
        int len = password.length();

        System.out.print("Пароль: [" + password + "]: ");

        if (len < 8) {
            System.out.println("Довжина повинна бути не менше 8 символів. Наразі " + len);
            return false;
        }
        if (password.length() > 128) {
            System.out.println("Довжина паролю повинна бути менше 128 символів. Наразі " + len);
            return false;
        }
        if (!password.matches(allValidSymbols)) {
            System.out.println("Пароль містить неприпустимі символи. Дозволяються наступні символи.");
            System.out.println("\t1. Латинські чи кириличні літери в обох регістрах");
            System.out.println("\t2. Арабські цифри 0..9");
            System.out.println("\t3. Символи ~ ! ? @ # $ % ^ & * _ - + ( ) [ ] { } > < / \\ | ''.,:");
            return false;
        }

        // ".*\\d+.*"
        if (!password.matches(".*\\d+.*")) {
            System.out.println("Пароль повинен містити хоча б одну цифру");
            return false;
        }

        if (!password.matches(".*[a-zа-яієї]+.*")) {
            System.out.println("Пароль повинен містити хоча б одну лат/кир літеру в нижньому регістрі");
            return false;
        }

        if (!password.matches(".*[A-ZА-ЯІЇЄ]+.*")) {
            System.out.println("Пароль повинен містити хоча б одну лат/кир  літеру у верхньому регістрі");
            return false;
        }

        System.out.println("коректний");
        return true;
    }

    public static void main(String[] args) {
        validatePassword("1qwe");           // довжина
        validatePassword("1qweQWEйцуЙЦУ "); // пробіл
        validatePassword("qweQWEйцуЙЦУ");   // без цифр
        validatePassword("1qweasdzxc");     // без великих літер лат
        validatePassword("QWEASDQWE1");     // без малих літер лат
        validatePassword("йцу1фівячс");     // без великих літер кир
        validatePassword("1ЙЦУФІВЯЧС");     // без малих літер кир

        validatePassword("іїєІЇЄ123");     // Зв великими та малими укр. доп. символами
    }
}

