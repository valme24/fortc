package in.alme.tc2024.service;

import in.alme.tc2024.Model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudvendor);
    public String updateCloudVendor(CloudVendor cloudvendor);
    public String deleteCloudVendor(String cloudvendorId);
    public CloudVendor getCloudVendor(String cloudvendorId);
    public List<CloudVendor> getCloudVendors();



}
