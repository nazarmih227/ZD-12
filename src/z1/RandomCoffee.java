package z1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCoffee {

    public static void main(String[] args) {

        List<Stranger> strangers = new ArrayList<>(List.of(
                new Stranger("Анна", 29),
                new Stranger("Иван", 25),
                new Stranger("Мария", 25),
                new Stranger("Павел", 26),
                new Stranger("Святослав", 27),
                new Stranger("Екатерина", 28)
        ));
        PairGenerator pairGenerator = new PairGenerator();

        System.out.println("На этой неделе в Random Coffee участвуют: " + strangers);

        List<List<Stranger>> splitByPairs = pairGenerator.splitByPairs(strangers);

        System.out.println("Генератор случайных чисел составил пары: " + splitByPairs);
    }
}



class PairGenerator {

    // Random — класс в Java, отвечающий за генерацию случайных элементов.
    private static final Random rnd = new Random();

    /**
     * Разбивает список незнакомцев по парам.
     */

    // Укажите правильный тип, возвращаемый этой функцией. Вам нужно преобразовать список незнакомцев в
    // набор пар, т.е. в список, состоящий из других списков.
    public List<List<Stranger>> splitByPairs(List<Stranger> strangers) {

        // Укажите тип ещё раз.
        List<List<Stranger>> pairs = new ArrayList<>();
        while (!strangers.isEmpty()) {

            List<Stranger> pair = getRandomPair(strangers);
            pairs.add(pair);
            // Добавьте новый элемент в набор пар.
        }

        return pairs;
    }

    /**
     * Возвращает одну пару и удаляет её из списка strangers
     */
    private List<Stranger> getRandomPair(List<Stranger> strangers) {

        // Генерируем два случайных индекса в пределах списка
        int p1Index = rnd.nextInt(strangers.size());
        int p2Index = rnd.nextInt(strangers.size());
        while (p2Index == p1Index) {
            p2Index = rnd.nextInt(strangers.size());
        }

        // Получаем элементы по сгенерированным индексам
        Stranger strangerOne = strangers.get(p1Index);
        Stranger strangerTwo = strangers.get(p2Index);

        /* Осталось только удалить двух найденных незнакомцев из списка strangers,
           а затем вернуть их в качестве результата! */
        List<Stranger> str = new ArrayList<>();
        str.add(strangerOne);
        str.add(strangerTwo);
        strangers.removeAll(str);
        return str;
    }
}

class Stranger {
    public final String name;
    public final int age;

    public Stranger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}