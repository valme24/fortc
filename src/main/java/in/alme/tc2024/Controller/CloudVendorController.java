package in.alme.tc2024.Controller;

import in.alme.tc2024.Model.CloudVendor;
import in.alme.tc2024.response.ResponseHandler;
import in.alme.tc2024.service.CloudVendorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

     CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }
    // Initialize cloudVendor here or inject via constructor

    @GetMapping("/{vendorId}")
    @ApiOperation(value ="Cloud vendor id", notes="Provide cloud vendor details",
            response = ResponseEntity.class)
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable String vendorId) {
        // Check if vendorId exists, if not return 404
        return  ResponseHandler.responseBuilder("requested information is here",HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId));


    }

// for all cloud vendors details
@GetMapping("/")
    public List<CloudVendor> getAllCloudVendorsDetails() {
        // Check if vendorId exists, if not return 404
        return  cloudVendorService.getCloudVendors();

    }


    @PutMapping("/")
    public ResponseEntity<String> updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return ResponseEntity.ok("Cloud vendor updated successfully");
    }

    @PostMapping("/")
    public ResponseEntity<String> createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
        cloudVendorService.createCloudVendor(cloudVendor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cloud vendor created successfully");
    }

    @DeleteMapping("/{vendorId}")
    public ResponseEntity<String> deleteCloudVendorDetails(@PathVariable String vendorId) {

            cloudVendorService.deleteCloudVendor(vendorId);
            return ResponseEntity.ok("Cloud vendor deleted successfully");

    }
}
