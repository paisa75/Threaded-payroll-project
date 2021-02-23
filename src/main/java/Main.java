import org.apache.log4j.Logger;
import salary.payment.io.InventoryFile;
import salary.payment.model.dto.EmployeeSalary;
import salary.payment.service.PaymentService;
import salary.payment.service.PaymentServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger logger = Logger.getLogger("Main.class");

    public static void main(String[] args) throws Exception {
        logger.debug("*********************** main class started");
        InventoryFile inventory = new InventoryFile();
        inventory.createInventoryFile();

        List<EmployeeSalary> employeeSalaryList = new ArrayList<>();
        salary.payment.model.dto.EmployeeSalary salary = new salary.payment.model.dto.EmployeeSalary();
        salary.setId(1);
        salary.setDepositNo("1.20.100.1");
        salary.setAmount(BigDecimal.valueOf(300));

        employeeSalaryList.add(salary);
        salary.payment.model.dto.EmployeeSalary salary2 = new salary.payment.model.dto.EmployeeSalary();
        salary2.setId(2);
        salary2.setDepositNo("1.20.100.2");
        salary2.setAmount(BigDecimal.valueOf(700));
        employeeSalaryList.add(salary2);

        PaymentService paymentService = new PaymentServiceImpl();
        paymentService.doPayment(employeeSalaryList);
        logger.debug("*********************** payment Don!!!!");


    }


}

