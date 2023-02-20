package Lesson1_3;
/*
Потрібно: Створити клас Book (Main).
Створити класи Title, Author та Content, кожен з яких повинен містити одне рядкове поле та метод void show().
Реалізуйте можливість додавання до книги назви книги, імені автора та змісту.
Виведіть на екран за допомогою методу show() назву книги, ім'я автора та Зміст.
*/
class Attrib{
    protected String Name;
    public Attrib(String n) { this.Name = n; }
}
class Title extends Attrib {
    public Title(String n) { super(n); }
    public void Show() { System.out.printf("\nНазва: %s\n", Name); }
}
class Author extends Attrib{
    public Author(String n) { super(n); }
    public void Show() { System.out.printf("Автор: %s\n", Name);}
}
class Content extends Attrib{
    public Content(String n) { super(n); }
    public void Show() { System.out.printf("Опис: %s.\n", Name);}
}
class Book {
    private Title title;
    private Author author;
    private Content content;

    public Book (String title_, String author_, String content_) {
        title = new Title(title_);
        author = new Author(author_);
        content = new Content(content_);
    }
    public void Show(){
        title.Show();
        author.Show();
        content.Show();
    }
}

public class Main{
    public static void main(String[] args) {
        Book [] book = {new Book("Фактор Черчилля: Як одна людина змінила історію", "Джонсон Борис", "Історія про те, як ексцентричний геній Черчилля, прем’єр-міністра Великої Британії, одного з найвизначніших лідерів ХХ століття, формував світову політику"),
                        new Book("1984", "Джордж Орвелл", "Зла сатира на комуністичні режими")};

        for(Book b: book)
            b.Show();
    }
}
