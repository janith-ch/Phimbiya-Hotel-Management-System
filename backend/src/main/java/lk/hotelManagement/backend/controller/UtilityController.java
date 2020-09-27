package lk.hotelManagement.backend.controller;
import lk.hotelManagement.backend.model.Utility;
import lk.hotelManagement.backend.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/utility")
public class UtilityController {

    @Autowired
    UtilityService utilityService;

    @GetMapping("/")
    public List<Utility> utilities() {
        return utilityService.utilities();
    }
}