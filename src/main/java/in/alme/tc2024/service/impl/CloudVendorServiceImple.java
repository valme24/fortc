package in.alme.tc2024.service.impl;

import in.alme.tc2024.Model.CloudVendor;
import in.alme.tc2024.repository.CloudVendorRepository;
import in.alme.tc2024.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImple implements CloudVendorService {


    CloudVendorRepository cloudVendorRepository ;

    public CloudVendorServiceImple(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudvendor) {
        cloudVendorRepository.save(cloudvendor);
        return "Success";
    }


    @Override
    public String updateCloudVendor(CloudVendor cloudvendor) {
        cloudVendorRepository.save(cloudvendor);
        return "update successfull";
    }


    @Override
    public String deleteCloudVendor(String cloudvendorId) {
        cloudVendorRepository.deleteById(cloudvendorId);
        return "";
    }


    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        return  cloudVendorRepository.findById(cloudVendorId).get();

    }


    @Override
    public List<CloudVendor> getCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}
