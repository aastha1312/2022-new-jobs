import org.openjdk.jol.vm.VM;

import java.util.HashMap;
import java.util.function.Consumer;

public class HashMapUpdates {


    public static void main(String[] args) {
        HashMap<Employee, String> me = new HashMap<>();

        Employee e1 = new Employee("Aastha", 1);
        me.put(e1, "Aastha1");

        System.out.println(e1.hashCode());
        System.out.println(me.get(e1));
        System.out.println(e1);
        System.out.println(e1.id);
        System.out.println(e1.name);
        System.out.println("The memory address is " + VM.current().addressOf(e1));
        System.out.println("---------------------------------------");

        Employee e2 = e1;

        e1.id = 2;
        System.out.println(e1.hashCode());
        System.out.println(me.get(e1));
        System.out.println(e1);
        System.out.println(e1.id);
        System.out.println(e1.name);
        System.out.println("The memory address is " + VM.current().addressOf(e1));
        System.out.println("---------------------------------------");


        System.out.println(e2.hashCode());
        System.out.println(e2);
        System.out.println(me.get(e2));
        System.out.println(e2.id);
        System.out.println(e2.name);
        System.out.println("The memory address is " + VM.current().addressOf(e2));
        System.out.println("---------------------------------------");

        System.out.println(me.size());
        me.keySet().forEach(new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {
                System.out.println(employee + " " + employee.id + " " + employee.name + " " + employee.hashCode());
                System.out.println("The memory address is " + VM.current().addressOf(employee));

            }
        });

        me.keySet().forEach(new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {
                System.out.println(employee.equals(e1));
                System.out.println(employee == e1);


            }
        });
        System.out.println(me.keySet().size());
        System.out.println("---------------------------------------");

        me.values().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println(me.values().size());


    }
}

class Employee {
    String name;
    int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return id == employee.id && Objects.equals(name, employee.name);
//    }

    @Override
    public int hashCode() {
        //  return Objects.hash(name, id);
        return 1;
    }


//    @Override
//    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                ", id=" + id +
//                '}';
//    }
}
