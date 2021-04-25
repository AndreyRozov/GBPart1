package Lesson05;

public class HomeWork05 {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivan Ivanov", "Director", "i.ivanov@mail.ru", 1101, 30000, 40);
        persArray[1] = new Person("Petr Petrov", "Manager", "p.petrov@mail.ru", 1102, 25000, 28);
        persArray[2] = new Person("Ivan Petrov", "Engineer", "i.petrov@mail.ru", 1103, 20000, 26);
        persArray[3] = new Person("Petr Ivanov", "Engineer", "p.ivanov@mail.ru", 1104, 20000, 25);
        persArray[4] = new Person("Sidr Sidorov", "Cleaner", "s.sidorov@mail.ru", 1105, 15000, 45);

        for (int i = 0; i < persArray.length; i++ )
            if (persArray[i].age > 40) {
                System.out.println(persArray[i].name + " " + persArray[i].position + " " + persArray[i].email + " " + persArray[i].phone_number + " " + persArray[i].salary + " " + persArray[i].age);
                }

    }

}
