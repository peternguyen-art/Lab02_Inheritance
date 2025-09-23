public class SalaryWorker extends Worker {

    private double annualSalary = 0.0;

    /**
     * Construction for SalaryWorker class
     *
     * @param IDNum         The worker's ID number.
     * @param lastName      The worker's last name.
     * @param firstName     The worker's first name.
     * @param title         The worker's title (e.g., "Mr.", "Ms.").
     * @param YOB           The worker's year of birth.
     * @param annualSalary  The worker's annual salary.
     */
    public SalaryWorker(String IDNum, String lastName, String firstName, String title, int YOB, double annualSalary) {
        super(IDNum, lastName, firstName, title, YOB, 0.0);
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return this.annualSalary/ 52.0;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.printf("Weekly pay of a salary man is 1/52 of their annual rate $%.2f%n",weeklyPay);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + this.annualSalary;
    }

    @Override
    public String toXML() {
        return super.toXML() + ", " + "<annualSalary>" + this.annualSalary + "</annualSalary>";
    }

    @Override
    public String toJSON(){
        return super.toJSON() + ", " + "\"annualSalary\": " + this.annualSalary + "}";
    }
}
