package salary.payment.model.dto;

import java.math.BigDecimal;

public class TransactionFileDto {
    private String debtorDepositNo;
    private String creditorDepositNo;
    private BigDecimal amount;

    public TransactionFileDto() {
    }

    public TransactionFileDto(String debtorDepositNo, String creditorDepositNo, BigDecimal amount) {
        this.debtorDepositNo = debtorDepositNo;
        this.creditorDepositNo = creditorDepositNo;
        this.amount = amount;
    }

    public String getDebtorDepositNo() {
        return debtorDepositNo;
    }

    public void setDebtorDepositNo(String debtorDepositNo) {
        this.debtorDepositNo = debtorDepositNo;
    }

    public String getCreditorDepositNo() {
        return creditorDepositNo;
    }

    public void setCreditorDepositNo(String creditorDepositNo) {
        this.creditorDepositNo = creditorDepositNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return debtorDepositNo + "\t" + creditorDepositNo + "\t" + amount;
    }
}
