package com.xuan.rule.drools;

import com.xuan.rule.RuleTestPrinter;
import com.xuan.rule.domain.Order;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DroolsServiceTest {

    private final DroolsService service =
            new DroolsService(KieServices.get().getKieClasspathContainer());

    @Test
    void vipGetsDiscount() {
        Order order = service.apply(new Order(100.0, "VIP"));
        RuleTestPrinter.print("Drools", order);
        assertEquals(80.0, order.getFinalPrice());
    }

    @Test
    void normalKeepsOriginalPrice() {
        Order order = service.apply(new Order(100.0, "NORMAL"));
        RuleTestPrinter.print("Drools", order);
        assertEquals(100.0, order.getFinalPrice());
    }
}
