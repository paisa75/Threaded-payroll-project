package salary.payment.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PaymentFile {

    public void addToPaymentFile(salary.payment.model.dto.PaymentFileDto param) {
        // initialize Path object
        Path path = Paths.get("paymentFile.txt");
        //create file

        try {

            if (!Files.exists(path))
                Files.createFile(path);
            String text = param.toString();
            byte[] bs = text.getBytes();

            Files.write(path, (text + System.lineSeparator()).getBytes(UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
