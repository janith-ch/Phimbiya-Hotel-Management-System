package lk.hotelManagement.backend.service;
import lk.hotelManagement.backend.model.Utility;
import lk.hotelManagement.backend.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilityService {

    @Autowired
    UtilityRepository utilityRepository;

    public List<Utility> utilities() {
        return utilityRepository.utilities();
    }

}