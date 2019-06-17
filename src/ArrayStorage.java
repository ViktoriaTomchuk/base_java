/**
 * Array based storage for Resumes
 * Реализуйте класс ArrayStorage, организовав хранение резюме на основе массива с методами save, get,
 * delete, size, clear, getAll
 * При этом храните все резюме в начале storage (без дырок в виде null), чтобы не перебирать
 * каждый раз все 10000 элементов
 * Схема хранения резюме в storage (от 0 до size - 1 элементов null нет):
 * r1, r2, r3,..., rn, null, null,..., null
 * <----- size ----->
 * <------- storage.length (10000) ------->
 * Протестируйте вашу реализацию с помощью классов MainArray.main() и MainTestArrayStorage.main()
 * <p>
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
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Resume" + r.getUuid() + "not exist");
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            System.out.println("Resume" + r.getUuid() + "already exist");
        } else if (size == storage.length) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume" + uuid + "not exist");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        for (int i = 0; i < size; i++) {
            result[i] = storage[i];
        }
        return result;
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid == storage[i].getUuid()) {
                return i;
            }
        }
        return -1;
    }
}