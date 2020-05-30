package entity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Order {
    private int orderCode;
    private Date sendDate;

    public Order(int orderCode, Date sendDate) {
        this.orderCode = orderCode;
        this.sendDate = sendDate;
    }

    public Order() {
        this(-1, new Date());
    }

    public int getOrderCode() {
        return orderCode;
    }

    public String getSQLDate() {
        LocalDate localDate = this.sendDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return new StringBuilder()
                .append(localDate.getYear())
                .append("-")
                .append(localDate.getMonthValue())
                .append("-")
                .append(localDate.getDayOfMonth()).toString();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("order code: ")
                .append(this.orderCode)
                .append(", send date: ")
                .append(this.sendDate.toString())
                .toString();
    }
}
