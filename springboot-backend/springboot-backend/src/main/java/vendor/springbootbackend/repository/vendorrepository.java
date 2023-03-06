package vendor.springbootbackend.repository;

import org.springframework.stereotype.Service;
import vendor.springbootbackend.model.vendor;

import java.util.List;
@Service

public interface vendorrepository {

    List<vendor> findAll();

    vendor save(vendor vendor);
}
