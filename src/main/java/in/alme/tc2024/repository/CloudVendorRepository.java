package in.alme.tc2024.repository;

import in.alme.tc2024.Model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String> {
  public List<CloudVendor> findByVendorName(String vendorname);

}
