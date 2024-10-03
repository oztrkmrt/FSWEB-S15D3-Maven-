package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    private static Map<Integer, Employee> employeeMap;

    private static List<Employee> duplicatedEmployees;

    public static void main(String[] args) {

//        List<Employee> employees = new ArrayList<>();
//
//        employees.add(new Employee(1,"Mert","Öztürk"));
//        employees.add(new Employee(1,"Mert","Öztürk"));
//        employees.add(new Employee(1,"Mert","Öztürk"));
//        employees.add(new Employee(2,"İsim","Soyisim"));
//        employees.add(new Employee(2,"İsim","Soyisim"));
//        employees.add(new Employee(3,"Name","Lastname"));
//        employees.add(new Employee(3,"Name","Lastname"));
//        employees.add(new Employee(4,"Mert1","Öztürk1"));
//        employees.add(new Employee(5,"Ahmet","Mehmet"));
//
//        System.out.println(findDuplicates(employees).size());
//        System.out.println(findUniques(employees).size());
//        System.out.println(removeDublicates(employees).size());

        System.out.println(WordCounter.calculatedWord());

    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee == null){
                System.out.println("null record");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())){
                duplicatedEmployees.add(employee);
            } else {
                employeeMap.put(employee.getId(),employee);
            }
        }
        return duplicatedEmployees;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees){
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee == null){
                System.out.println("null record");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(duplicates);
        return onlyUnique;
    }
}