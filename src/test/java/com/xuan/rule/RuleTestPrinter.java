package com.xuan.rule;

import com.xuan.rule.domain.Order;

public final class RuleTestPrinter {

    private RuleTestPrinter() {
    }

    public static void print(String engine, Order order) {
        boolean vipDiscountApplied = order.getFinalPrice() < order.getOriginalPrice();
        String scenario = vipDiscountApplied ? "VIP 打折" : "非 VIP 原价";
        String explanation = vipDiscountApplied
                ? "规则命中，VIP 8 折已生效"
                : "未命中 VIP 规则，保持原价";

        System.out.println();
        System.out.println("========================================");
        System.out.printf(" [%s] %s%n", engine, scenario);
        System.out.println("----------------------------------------");
        System.out.printf(" 输入  level=%s, originalPrice=%.1f%n",
                order.getLevel(), order.getOriginalPrice());
        System.out.printf(" 输出  finalPrice=%.1f%n", order.getFinalPrice());
        System.out.printf(" 说明  %s%n", explanation);
        System.out.println("========================================");
    }
}
