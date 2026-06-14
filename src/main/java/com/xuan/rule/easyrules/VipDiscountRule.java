package com.xuan.rule.easyrules;

import com.xuan.rule.domain.Order;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "VIP discount", description = "VIP 客户 8 折")
public class VipDiscountRule {

    @Condition
    public boolean isVip(@Fact("order") Order order) {
        return "VIP".equals(order.getLevel());
    }

    @Action
    public void applyDiscount(@Fact("order") Order order) {
        order.setFinalPrice(order.getOriginalPrice() * 0.8);
    }
}
