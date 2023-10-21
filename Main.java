import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        Scanner scanner = new Scanner(System.in, "UTF-8");

        boolean continueAdding = true;
        while (continueAdding) {
            System.out.println("Добавление информации о сотруднике:");
            System.out.print("Введите табельный номер: ");
            String employeeId = scanner.nextLine();

            System.out.print("Введите номер телефона: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Введите имя: ");
            String name = scanner.nextLine();

            System.out.print("Введите стаж: ");
            int experience = Integer.parseInt(scanner.nextLine());

            Employee employee = new Employee(employeeId, phoneNumber, name, experience);
            directory.addEmployee(employee);

            System.out.print("Хотите добавить еще сотрудников? (yes/no): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                continueAdding = false;
            }
        }
        for (Employee employee : directory.getEmployees()) {
            System.out.println("Имя: " + employee.getName() + ", Номер телефона: " + employee.getPhoneNumber());
        }
    
        
        System.out.print("Введите стаж для поиска сотрудника: ");
        int searchExperience = Integer.parseInt(scanner.nextLine());
        List<Employee> employeesByExperience = directory.findEmployeeByExperience(searchExperience);
        if (!employeesByExperience.isEmpty()) {
            System.out.println("Сотрудники с опытом работы " + searchExperience + " лет:");
            for (Employee employee : employeesByExperience) {
                System.out.println("Имя: " + employee.getName());
            }
        } else {
            System.out.println("Сотрудников с таким стажем не найдено.");
        }

       
        System.out.print("Введите имя сотрудника для поиска номера телефона: ");
        String searchName = scanner.nextLine();
        String phoneNumberByName = directory.findPhoneNumberByName(searchName);
        System.out.println("Номер телефона для " + searchName + ": " + phoneNumberByName);

        
        System.out.print("Введите табельный номер для поиска сотрудника: ");
        String searchId = scanner.nextLine();
        Employee employeeById = directory.findEmployeeById(searchId);
        if (employeeById != null) {
            System.out.println("Сотрудник с табельным номером " + searchId + " найден: " + employeeById.getName());
        } else {
            System.out.println("Сотрудник с табельным номером " + searchId + " не найден.");
        }
        
    
        scanner.close();
    }
}
