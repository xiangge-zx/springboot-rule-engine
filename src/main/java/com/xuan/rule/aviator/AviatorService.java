package com.xuan.rule.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.xuan.rule.domain.Order;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AviatorService {

    private static final String VIP_DISCOUNT_EXPR =
            "level == 'VIP' ? originalPrice * 0.8 : originalPrice";

    public Order apply(Order order) {
        Object result = AviatorEvaluator.execute(VIP_DISCOUNT_EXPR, Map.of(
                "originalPrice", order.getOriginalPrice(),
                "level", order.getLevel()
        ));
        order.setFinalPrice(((Number) result).doubleValue());
        return order;
    }
}
