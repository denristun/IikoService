package ru.denmehta.iikoService.iiko.classes;

import com.sun.istack.NotNull;
import ru.denmehta.iikoService.iiko.enums.PaymentTypeKind;

public class Payment {

    @NotNull
    private PaymentTypeKind paymentTypeKind;

    @NotNull
    private double sum;

    @NotNull
    private String paymentTypeId;

    private boolean isProcessedExternally;

    private PaymentAdditionalData paymentAdditionalData;


    private boolean isFiscalizedExternally;

    public void setPaymentTypeKind(PaymentTypeKind paymentTypeKind) {
        this.paymentTypeKind = paymentTypeKind;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public void setProcessedExternally(boolean processedExternally) {
        isProcessedExternally = processedExternally;
    }

    public void setPaymentAdditionalData(PaymentAdditionalData paymentAdditionalData) {
        this.paymentAdditionalData = paymentAdditionalData;
    }

    public void setFiscalizedExternally(boolean fiscalizedExternally) {
        isFiscalizedExternally = fiscalizedExternally;
    }
}
