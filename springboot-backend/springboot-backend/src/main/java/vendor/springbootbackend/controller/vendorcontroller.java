package vendor.springbootbackend.controller;

import vendor.springbootbackend.exception.ResourceNotFoundException;
import vendor.springbootbackend.model.vendor;
import vendor.springbootbackend.repository.vendorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/vendor")
public class vendorcontroller{

    @Autowired
    private vendorrepository vendorRepository;

    @GetMapping
    public List<vendor> getAllvendor(){
        return vendorRepository.findAll();
    }

//     build create vendor REST API
    @PostMapping
    public vendor createvendor(@RequestBody vendor vendor) {
        return vendorRepository.save(vendor);
    }

//     build get vendor by id REST API
    @GetMapping("{id}")
    public ResponseEntity<vendor> getvendorById(@PathVariable  long id){
        vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("vendor not exist with id:" + id));
        return ResponseEntity.ok(vendor);
    }

    // build update vendor REST API
    @PutMapping("{id}")
    public ResponseEntity<vendor> updatevendor(@PathVariable long id,@RequestBody vendor vendorDetails) {
        vendor updatevendor = vendorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("vendor not exist with id: " + id));

        updatevendor.setFirstName(vendorDetailsDetails.getFirstName());
        updatevendor.setLastName(vendorDetailsDetails.getLastName());
        updatevendor.setAddress(vendorDetailsDetails.getAddress());

        vendorRepository.save(updatevendor);

        return ResponseEntity.ok(updatevendor);
    }

    // build delete vendor REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletevendor(@PathVariable long id){

        vendor v1 = vendorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("vendor not exist with id: " + id));

        vendorRepository.delete(v1);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}