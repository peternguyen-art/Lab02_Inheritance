import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {

        ArrayList<Worker> employees = new ArrayList<>();

        employees.add(new Worker("00000A", "Peter", "Nguyen","Mr.",2004,45.00));
        employees.add(new Worker("00000B", "Harley","Davidson","Mr.",1972,23.00));
        employees.add(new Worker("0003", "Williams", "Bob", "Mr.", 1978, 35.00));

        employees.add(new SalaryWorker("0004", "Jones", "Sue", "Ms.", 1995, 50000.00));
        employees.add(new SalaryWorker("0005", "Davis", "Bill", "Mr.", 1982, 80000.00));
        employees.add(new SalaryWorker("0006", "Miller", "Emily", "Ms.", 1975, 120000.00));

        int[] hoursPerWeek = {40,50,40};

        for (int week = 1; week <= 3; week++) {
            double hoursWorked = hoursPerWeek[week - 1];
            System.out.println("----------------------------------------------------------------");
            System.out.printf("                        Week %s                                     \n", week);
            System.out.println("----------------------------------------------------------------");

            for (Worker worker : employees) {
                String workerType = (worker instanceof SalaryWorker) ? "Salary Worker" : "Hourly Worker";

                double weeklyPay = worker.calculateWeeklyPay(hoursWorked);

                System.out.printf("%-10s | %-20s | %-15s | $%-14.2f%n",
                        worker.getID(),
                        worker.getFirstName() + " " + worker.getLastName(),
                        workerType,
                        weeklyPay);

                System.out.println("----------------------------------------------------------------");
            }
        }
    }
}
