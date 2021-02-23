package salary.payment.io;


import org.apache.log4j.Logger;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InventoryFile {

    private final Logger logger = Logger.getLogger(this.getClass());

    public void replaceSelected(salary.payment.model.dto.InventoryFileDto param) {
        try {
            // input the file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader("inventoryFile.txt"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = file.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();
            String inputStr = inputBuffer.toString();


            logger.debug("****************: " + inputStr); // display the original file for debugging

            boolean found = false;
            String newInput = "";
            for (String li : inputStr.split("\n")) {
                if (li.contains(param.getDepositNo())) {
                    li = param.toString(); // replace the line here
                    found = true;
                }
                newInput = newInput.concat(li + "\n");
            }
            if (!found) {
                newInput = newInput.concat(param.toString() + "\n");
            }
            ////// use log4j
            logger.debug("new input after changes in inventory file : " + newInput);


            // display the new file for debugging
            logger.debug("******************\n " + inputStr);

            // write the new string with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream("inventoryFile.txt");
            fileOut.write(newInput.getBytes());
            fileOut.close();

        } catch (Exception e) {
            logger.debug("******************Problem reading file. ");
        }


    }

    public BigDecimal getDepositBalance(String depositNo) {
        BigDecimal balance = BigDecimal.ZERO;
        Path file = Paths.get("inventoryFile.txt");
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.contains(depositNo)) {
                    String amount = line.replace(depositNo, "");
                    amount = amount.replace("\t", "");
                    if (amount.equals("0"))
                        balance = BigDecimal.ZERO;
                    else
                        balance = new BigDecimal(amount);

                    ////// here use log4j
                    logger.debug("******************Company Balance is : " + balance);
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return balance;
    }

    public void createInventoryFile() {
        //initialize Path object
        Path path = Paths.get("inventoryFile.txt");
        //create file
        try {
            String str = "1.10.100.1\t1000";
            byte[] bs = str.getBytes();
            Path writtenFilePath = Files.write(path, bs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
