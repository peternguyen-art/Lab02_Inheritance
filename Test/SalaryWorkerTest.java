import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SalaryWorkerTest {

    private SalaryWorker peteNguyen;
    @BeforeEach
    public void setUp() {
        peteNguyen = new SalaryWorker("00000A", "Peter", "Nguyen", "Mr.",2004, 470000.0);
    }

    @Test
    void calculateWeeklyPay() {
        double expectedPay = 470000.0/52.0;

        double regPay = peteNguyen.calculateWeeklyPay(40);
        assertEquals(expectedPay, regPay, "Weekly pay for regular hours should equal annual salary / 52");

        double overPay = peteNguyen.calculateWeeklyPay(60);
        assertEquals(expectedPay, overPay, "Weekly pay for overtimed salary worker should not change");
    }


    @Test
    void toCSV() {
        String expectedCSV = "00000A, Peter, Nguyen, Mr., 2004, 0.0, 470000.0";
        assertEquals(expectedCSV, peteNguyen.toCSV());
    }

    @Test
    void toXML() {
        String expectedXML = "<Worker>" +
                "<IDNum>00000A</IDNum>" +
                "<firstName>Peter</firstName>" +
                "<lastName>Nguyen</lastName>" +
                "<title>Mr.</title>" +
                "<YOB>2004</YOB>" +
                "<annualSalary>470000.0</annualSalary>" +
                "</Worker>";
        assertEquals(expectedXML, peteNguyen.toXML());
    }

    @Test
    void toJSON() {
        String expectedJSON = "{" +
                "\"ID\": \"00000A\"," +
                "\"firstName\": \"Peter\"," +
                "\"lastName\": \"Nguyen\"," +
                "\"title\": \"Mr.\"," +
                "\"YOB\": 2004" +
                "\"annualSalary\": 470000.0" +
                "}";
    }
}
