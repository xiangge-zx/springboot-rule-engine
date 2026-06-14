package com.xuan.rule.web;

import com.xuan.rule.aviator.AviatorService;
import com.xuan.rule.domain.Order;
import com.xuan.rule.drools.DroolsService;
import com.xuan.rule.easyrules.EasyRulesService;
import com.xuan.rule.qlexpress.QlExpressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class RuleDemoController {

    private static final double DEMO_PRICE = 100.0;
    private static final String DEMO_LEVEL = "VIP";

    private final EasyRulesService easyRulesService;
    private final DroolsService droolsService;
    private final AviatorService aviatorService;
    private final QlExpressService qlExpressService;

    public RuleDemoController(EasyRulesService easyRulesService,
                              DroolsService droolsService,
                              AviatorService aviatorService,
                              QlExpressService qlExpressService) {
        this.easyRulesService = easyRulesService;
        this.droolsService = droolsService;
        this.aviatorService = aviatorService;
        this.qlExpressService = qlExpressService;
    }

    @GetMapping("/easy-rules")
    public RuleDemoResponse easyRules() {
        return toResponse("easy-rules", easyRulesService.apply(createDemoOrder()));
    }

    @GetMapping("/drools")
    public RuleDemoResponse drools() {
        return toResponse("drools", droolsService.apply(createDemoOrder()));
    }

    @GetMapping("/aviator")
    public RuleDemoResponse aviator() {
        return toResponse("aviator", aviatorService.apply(createDemoOrder()));
    }

    @GetMapping("/qlexpress")
    public RuleDemoResponse qlExpress() throws Exception {
        return toResponse("qlexpress", qlExpressService.apply(createDemoOrder()));
    }

    private Order createDemoOrder() {
        return new Order(DEMO_PRICE, DEMO_LEVEL);
    }

    private RuleDemoResponse toResponse(String engine, Order order) {
        return new RuleDemoResponse(engine, order.getOriginalPrice(), order.getFinalPrice(), order.getLevel());
    }
}
