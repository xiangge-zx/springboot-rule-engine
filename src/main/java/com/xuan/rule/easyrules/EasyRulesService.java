package com.xuan.rule.easyrules;

import com.xuan.rule.domain.Order;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.stereotype.Service;

@Service
public class EasyRulesService {

    public Order apply(Order order) {
        Rules rules = new Rules();
        rules.register(new VipDiscountRule());

        Facts facts = new Facts();
        facts.put("order", order);

        new DefaultRulesEngine().fire(rules, facts);
        return order;
    }
}
