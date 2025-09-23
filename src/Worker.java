public class Worker extends Person {
    private double hourlyPayRate;

    /**
     * Constructor for the Worker class.
     *
     * @param IDNum         The worker's ID number.
     * @param lastName      The worker's last name.
     * @param firstName     The worker's first name.
     * @param title         The worker's title (e.g., "Mr.", "Ms.").
     * @param YOB           The worker's year of birth.
     * @param hourlyPayRate The worker's hourly pay rate.
     */
    public Worker(String IDNum, String lastName, String firstName, String title, int YOB, double hourlyPayRate) {
        super(IDNum, lastName, firstName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * Calculates the total weekly pay based on hours worked.
     * Hours up to 40 are paid at the regular hourly rate.
     * Hours over 40 are paid at time and a half (1.5x the regular rate).
     *
     * @param hours The number of hours worked in the week.
     * @return The total calculated weekly pay.
     */
    public double calculateWeeklyPay(double hours) {
        double payTotal = 0;

        if (hours <= 40.0) {
            payTotal = hours * this.hourlyPayRate;
        } else {
            double regularPay = 40.0 * this.hourlyPayRate;
            double overtimeHours = hours - 40.0;
            double overtimePay = overtimeHours * this.hourlyPayRate * 1.5;
            payTotal = regularPay + overtimePay;
        }
        return payTotal;
    }

    /**
     * Prints to console and show the number of hours of reg pay and
     * that of overtime pay
     * as well as the total pay
     *
     * @param hours The number of hours worked in the week
     */
    public void displayWeeklyPay(double hours) {
        double regHours = 0;
        double overHours = 0;

        if (hours <= 40.0) {
            regHours = hours * this.hourlyPayRate;
        } else {
            regHours = 40.0 * this.hourlyPayRate;
            double overtimeHours = hours - 40.0;
        }

        double regularPay = regHours * this.hourlyPayRate;
        double overtimePay = overHours * this.hourlyPayRate;
        double totalPay = regularPay + overtimePay;


        System.out.println("Regular Hours: " + regHours);
        System.out.printf("Regular Pay: $%.2f%n", regularPay);
        System.out.println("Overtime Hours: " + overHours);
        System.out.printf("Overtime Pay: $%.2f%n", overtimePay);
        System.out.printf("Total Pay: $%.2f%n", totalPay);

    }

        /**
         * Returns a comma-separated value (CSV) string representation of the Worker.
         * @return The CSV string including the hourly pay rate.
         */
        @Override
        public String toCSV () {
            return super.toCSV() + "," + this.hourlyPayRate;
        }

        /**
         * Returns an XML string representation of the Worker.
         * @return The XML string including the hourly pay rate.
         */
        @Override
        public String toXML () {
            return "<Worker>" + super.toXML().replace("</Person>", "") +
                    "<hourlyPayRate>" + this.hourlyPayRate + "</hourlyPayRate></Person></Worker>";
        }

        /**
         * Returns a JSON string representation of the Worker.
         * @return The JSON string including the hourly pay rate.
         */
        @Override
        public String toJSON () {
            String json = super.toJSON();
            return json.substring(0, json.length() - 1) + ", \"hourlyPayRate\": " + this.hourlyPayRate + "}";
        }
    }
