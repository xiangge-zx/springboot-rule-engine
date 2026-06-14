package com.xuan.rule.aviator;

import com.xuan.rule.RuleTestPrinter;
import com.xuan.rule.domain.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AviatorServiceTest {

    private final AviatorService service = new AviatorService();

    @Test
    void vipGetsDiscount() {
        Order order = service.apply(new Order(100.0, "VIP"));
        RuleTestPrinter.print("Aviator", order);
        assertEquals(80.0, order.getFinalPrice());
    }

    @Test
    void normalKeepsOriginalPrice() {
        Order order = service.apply(new Order(100.0, "NORMAL"));
        RuleTestPrinter.print("Aviator", order);
        assertEquals(100.0, order.getFinalPrice());
    }
}
