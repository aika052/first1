import java.util.Scanner; // java.util - это пакет (java.util.iterator)
public class Scanner_primer {

        public static void main(String[] args) {
            Scanner scan = new Scanner("На голой ветке'" +
                    "Ворон сидит одиноко. " +
                    "Осенний вечер." +
                    "'***'" +
                    "В небе такая луна,'" +
                    "Словно дерево спилено под корень:'" +
                    "Белеет свежий срез." +
                    "''***''" +
                    "Как разлилась река!'" +
                    "Цапля бредет на коротких ножках,'" +
                    "По колено в воде.");

            scan.useDelimiter("'"); //В этот метод передается строка, которую вы хотите использовать в качестве разделителя.
            System.out.println(0.1*3); // !=0.3 или 0.1+0.2
            System.out.println(0.1*5);
            System.out.println(0.1*2);
            System.out.println(0.1*4==0.4);

            System.out.println(Integer.MAX_VALUE+Integer.MAX_VALUE);
            // hasNext() - итератор(переборщик) коллекции. если в итерируемом объекте остались еще значение — метод вернет true, если значения кончились false
           while (scan.hasNext())    System.out.println(scan.next()); //scan.next() - вернет следующий элемент в обходе и выдаст исключение, если больше не осталось элементов.

            //System.out.println(scan.next()); // выведет только первую строку
            //System.out.println(scan.next()); //выведет следующую строку
            scan.close();
        }
    }