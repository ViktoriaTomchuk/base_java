/**
 * Array based storage for Resumes
 *Реализуйте класс ArrayStorage, организовав хранение резюме на основе массива с методами save, get,
 * delete, size, clear, getAll
 * При этом храните все резюме в начале storage (без дырок в виде null), чтобы не перебирать
 * каждый раз все 10000 элементов
 * Схема хранения резюме в storage (от 0 до size - 1 элементов null нет):
 * r1, r2, r3,..., rn, null, null,..., null
 * <----- size ----->
 * <------- storage.length (10000) ------->
 * Протестируйте вашу реализацию с помощью классов MainArray.main() и MainTestArrayStorage.main()
 *
 * При реализации метода delete() сортировать резюме по uuid не требуется
 * Все резюме в хранилище имеют уникальный uuid, что исключает повторы
 * Давайте осмысленные комментарии коммитам
 * Перед каждым коммитом не забывайте пользоваться сочетанием клавиш Ctrl + Alt + L (автоматическое форматирование кода)
 * Не злоупотребляйте пустыми строками — выработай какой-то единый стиль их написания
 * Удаляйте неиспользуемые импорты (Ctrl + Alt + O)
 * Не игнорируйте подсказки IDEA (подсвечивает)
 * Resume r — давайте переменным осмысленные имена, например resume. r допустимо в коротких циклах и лямбдах
 * В методе clear() обнуление массива предполагает обнуление (null) ячеек, где хранятся Resume, а не
 * создание нового или присваивание ему null
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (Resume resume : storage)
            if (resume != null) {
                resume = null;
            }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            Resume resume = new Resume();
            if (resume != null) {
                storage[i] = resume;
            }
        }
    }

    String get(String uuid) {
        return uuid;
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        return storage.length;
    }
}
