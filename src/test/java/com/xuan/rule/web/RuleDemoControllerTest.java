package com.xuan.rule.web;

import com.xuan.rule.aviator.AviatorService;
import com.xuan.rule.domain.Order;
import com.xuan.rule.drools.DroolsService;
import com.xuan.rule.easyrules.EasyRulesService;
import com.xuan.rule.qlexpress.QlExpressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RuleDemoController.class)
class RuleDemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EasyRulesService easyRulesService;

    @MockitoBean
    private DroolsService droolsService;

    @MockitoBean
    private AviatorService aviatorService;

    @MockitoBean
    private QlExpressService qlExpressService;

    @Test
    void easyRulesEndpoint() throws Exception {
        when(easyRulesService.apply(any(Order.class))).thenReturn(new Order(100.0, "VIP") {{
            setFinalPrice(80.0);
        }});

        mockMvc.perform(get("/demo/easy-rules"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.engine").value("easy-rules"))
                .andExpect(jsonPath("$.originalPrice").value(100.0))
                .andExpect(jsonPath("$.finalPrice").value(80.0))
                .andExpect(jsonPath("$.level").value("VIP"));
    }

    @Test
    void droolsEndpoint() throws Exception {
        when(droolsService.apply(any(Order.class))).thenReturn(new Order(100.0, "VIP") {{
            setFinalPrice(80.0);
        }});

        mockMvc.perform(get("/demo/drools"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.engine").value("drools"))
                .andExpect(jsonPath("$.finalPrice").value(80.0));
    }

    @Test
    void aviatorEndpoint() throws Exception {
        when(aviatorService.apply(any(Order.class))).thenReturn(new Order(100.0, "VIP") {{
            setFinalPrice(80.0);
        }});

        mockMvc.perform(get("/demo/aviator"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.engine").value("aviator"))
                .andExpect(jsonPath("$.finalPrice").value(80.0));
    }

    @Test
    void qlExpressEndpoint() throws Exception {
        when(qlExpressService.apply(any(Order.class))).thenReturn(new Order(100.0, "VIP") {{
            setFinalPrice(80.0);
        }});

        mockMvc.perform(get("/demo/qlexpress"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.engine").value("qlexpress"))
                .andExpect(jsonPath("$.finalPrice").value(80.0));
    }
}
