package com.xuan.rule.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.xuan.rule.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class QlExpressService {

    private static final String VIP_DISCOUNT_SCRIPT =
            "if (level == 'VIP') { return originalPrice * 0.8; } else { return originalPrice; }";

    private final ExpressRunner runner = new ExpressRunner();

    public Order apply(Order order) throws Exception {
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("originalPrice", order.getOriginalPrice());
        context.put("level", order.getLevel());

        Object result = runner.execute(VIP_DISCOUNT_SCRIPT, context, null, true, false);
        order.setFinalPrice(((Number) result).doubleValue());
        return order;
    }
}
