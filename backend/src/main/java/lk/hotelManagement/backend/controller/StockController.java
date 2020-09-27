package lk.hotelManagement.backend.controller;

import lk.hotelManagement.backend.model.Stock;
import lk.hotelManagement.backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/")
    public List<Stock> stocks() {
        return stockService.stocks();
    }

    @PostMapping("/")
    public boolean createStock(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }
}