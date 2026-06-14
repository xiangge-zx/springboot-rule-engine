package com.xuan.rule.qlexpress;

import com.xuan.rule.RuleTestPrinter;
import com.xuan.rule.domain.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QlExpressServiceTest {

    private final QlExpressService service = new QlExpressService();

    @Test
    void vipGetsDiscount() throws Exception {
        Order order = service.apply(new Order(100.0, "VIP"));
        RuleTestPrinter.print("QLExpress", order);
        assertEquals(80.0, order.getFinalPrice());
    }

    @Test
    void normalKeepsOriginalPrice() throws Exception {
        Order order = service.apply(new Order(100.0, "NORMAL"));
        RuleTestPrinter.print("QLExpress", order);
        assertEquals(100.0, order.getFinalPrice());
    }
}
