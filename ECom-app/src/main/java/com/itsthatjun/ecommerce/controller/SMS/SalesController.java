package com.itsthatjun.ecommerce.controller.SMS;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
@Api(tags = "Sales related", description = "find items that's on sales")
public class SalesController {
}
