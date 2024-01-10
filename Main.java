import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws RemovalFromEmptyListException {

        {
            System.out.println("DODAWANIE NOWCYH ELEMENTÓW");
            SortedDoublyLinkedList l = new SortedDoublyLinkedList();
            l.add(new Student("Michał", "Tomaszewski", 534));
            l.add(new Student("Sławomir", "Dańczak", 12764));
            l.add(new Student("Filip", "Kwiatkowski", 17137));
            System.out.println(l);
            System.out.println("\n");
        }

        {
            System.out.println("DODAWANIE NOWCYH ELEMENTÓW - TAKIE SAME NAZWISKA");
            SortedDoublyLinkedList l = new SortedDoublyLinkedList();
            l.add(new Student("Michał", "Tomaszewski", 534));
            l.add(new Student("Sławomir", "Dańczak", 12764));
            l.add(new Student("Filip", "Kwiatkowski", 17137));
            l.add(new Student("Adam", "Dańczak", 1337)); // nowy element
            System.out.println(l);

            System.out.println("ROZMIAR LISTY");
            l.size();
            System.out.println("\n");
        }

        {
            System.out.println("DODAWANIE NOWCYH ELEMENTÓW - ODWROCENIE LISTY I ODWROTNE DODAWNIANIE");
            SortedDoublyLinkedList l = new SortedDoublyLinkedList();
            l.add(new Student("Michał", "Tomaszewski", 534));
            l.add(new Student("Sławomir", "Dańczak", 12764));
            l.add(new Student("Filip", "Kwiatkowski", 17137));
            l.add(new Student("Adam", "Dańczak", 1337));

            System.out.println(l);
            l.reverse();
            System.out.println(l);

            System.out.println("Dodanie nowego elementu");

            l.add(new Student("Marcin", "Zupowy", 381));
            System.out.println(l);

            System.out.println("\n");
        }

        {
            System.out.println("USUWANIE ELEMENTÓW (index 2, pierwszy, ostatni))");
            SortedDoublyLinkedList l = new SortedDoublyLinkedList();
            l.add(new Student("Adam", "Dańczak", 1337));
            l.add(new Student("Sławomir", "Dańczak", 12764));
            l.add(new Student("Filip", "Kwiatkowski", 17137));
            l.add(new Student("Michał", "Tomaszewski", 534));
            
            System.out.println(l);

            l.removeAt(2);
            l.removeFirst();
            l.removeLast();

            System.out.println(l);
            System.out.println("\n");
        }

        {
            System.out.println("TWORZENIE TABLICY Z LISTY ZA POMOCA KLASY ArrayBuilder");
            SortedDoublyLinkedList l = new SortedDoublyLinkedList();
            l.add(new Student("Filip", "Kwiatkowski", 17137));
            l.add(new Student("Michał", "Tomaszewski", 534));
            l.add(new Student("Sławomir", "Dańczak", 12764));

            System.out.println(l);

            ArrayBuilder builder = new ArrayBuilder();
            l.supplyTo(builder);

            System.out.println(Arrays.toString(builder.getStudents()));
            System.out.println("\n");
        }

        {
            System.out.println("SZUKANIE ELEMENTU O INDEKSIE 11");
            SortedDoublyLinkedList l = new SortedDoublyLinkedList();
            l.add(new Student("Filip", "Kwiatkowski", 11));
            l.add(new Student("Michał", "Tomaszewski", 11));
            l.add(new Student("Sławomir", "Dańczak", 999));

            System.out.println(l);

            IndexFinder finding11 = new IndexFinder(11);
            l.supplyTo(finding11);

            System.out.println(finding11.getTrackedStudent());
            System.out.println("\n");
        }

        {
            System.out.println("SZUKANIE ELEMENTOW O MAX I MIN INDEXIE");
            SortedDoublyLinkedList l = new SortedDoublyLinkedList();
            l.add(new Student("Filip", "Kwiatkowski", 12));
            l.add(new Student("Michał", "Tomaszewski", 11));
            l.add(new Student("Sławomir", "Dańczak", 10));

            System.out.println(l);

            MinFinder minFinder = new MinFinder();
            MaxFinder maxFinder = new MaxFinder();
            l.supplyTo(minFinder);
            l.supplyTo(maxFinder);

            System.out.println("Min index: " + minFinder.getTrackedStudent());
            System.out.println("Max index: " + maxFinder.getTrackedStudent());

            System.out.println("\n");

        }

        {
            System.out.println("TEST EXCEPTIONS");
            SortedDoublyLinkedList l = new SortedDoublyLinkedList();
            l.add(new Student("Filip", "Kwiatkowski", 12));
            l.add(new Student("Michał", "Tomaszewski", 11));
            l.add(new Student("Sławomir", "Dańczak", 10));

            System.out.println(l);

            l.removeAt(10);

            for (int i = 0; i < 4; i++) {
                l.removeFirst();
            }
            
            System.out.println(l);
        }
    }
}
