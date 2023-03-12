import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        Queue<Person> attraction = new ArrayDeque<>(generateClient());
        //создайте очередь на аттракцион и заполните её людьми из списка,
        // который вам вернёт метод generateClients()
        //Теперь заведите бесконечный цикл,
        while (!attraction.isEmpty()) {
            Person nextPerson = attraction.poll(); // На каждой итерации вытаскивается из очереди следующий клиент,
            nextPerson.setTickets((nextPerson.getTickets()) - 1);
            // При этом у клиента уменьшается количество билетов на 1
            System.out.println(nextPerson.getSurName() + " " + nextPerson.getName() + " " + "прокатился, осталось " + nextPerson.getTickets() + " билетов");

            if (nextPerson.getTickets() > 0) {
                attraction.offer(nextPerson);// если оно не стало нулевым, он вставляется обратно в очередь в её конец
            }
            if (nextPerson.getTickets() == 0) {
                System.out.println();
                System.out.println("Билеты закончились у " + nextPerson.getSurName() + " " + nextPerson.getName());
                System.out.println();
            }
        }
        System.out.println("Аттракцион закрыт.Билеты закончились. Люди разошлись");
        //Пока очередь на аттракцион не пуста
    }

    private static List<Person> generateClient() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Василий", "Маслов", 30, 3));
        personList.add(new Person("Ирина", "Тараканова", 50, 1));
        personList.add(new Person("Марина", "Ефремова", 40, 2));
        personList.add(new Person("Ирина", "Звонарева", 40, 5));
        personList.add(new Person("Ольга", "Кузьмина", 25, 3));
        return personList;
    }
    //который бы возвращал список из порядка 5 людей, который вы заполняете прямо в коде
}