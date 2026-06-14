package com.xuan.rule.easyrules;

import com.xuan.rule.RuleTestPrinter;
import com.xuan.rule.domain.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EasyRulesServiceTest {

    private final EasyRulesService service = new EasyRulesService();

    @Test
    void vipGetsDiscount() {
        Order order = service.apply(new Order(100.0, "VIP"));
        RuleTestPrinter.print("Easy Rules", order);
        assertEquals(80.0, order.getFinalPrice());
    }

    @Test
    void normalKeepsOriginalPrice() {
        Order order = service.apply(new Order(100.0, "NORMAL"));
        RuleTestPrinter.print("Easy Rules", order);
        assertEquals(100.0, order.getFinalPrice());
    }
}
