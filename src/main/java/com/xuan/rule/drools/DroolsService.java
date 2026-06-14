package com.xuan.rule.drools;

import com.xuan.rule.domain.Order;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class DroolsService {

    private final KieContainer kieContainer;

    public DroolsService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Order apply(Order order) {
        KieSession session = kieContainer.newKieSession("ksession-rules");
        try {
            session.insert(order);
            session.fireAllRules();
            return order;
        } finally {
            session.dispose();
        }
    }
}
