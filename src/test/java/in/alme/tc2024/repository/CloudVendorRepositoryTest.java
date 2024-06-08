package in.alme.tc2024.repository;

import in.alme.tc2024.Model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

@DataJpaTest
public class CloudVendorRepositoryTest {
   @Autowired
    private CloudVendorRepository cloudVendorRepository;
   CloudVendor cloudVendor;








   @BeforeEach
    void setup(){
       cloudVendor = new CloudVendor("1","amazon","USA","9411945707");
       cloudVendorRepository.save(cloudVendor);

   }

   @AfterEach
    void tearDown(){
       cloudVendor=null;
       cloudVendorRepository.deleteAll();

   }
///test case success
@Test
    void testByVendorName_Found(){
      List<CloudVendor> cloudVendorList =  cloudVendorRepository.findByVendorName("amazon");

      assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
      assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());


}









    ///test case fail

    @Test
    void testByVendorName_NotFound(){
        List<CloudVendor> cloudVendorList =  cloudVendorRepository.findByVendorName("google");
        assertThat(cloudVendorList.isEmpty()).isTrue();
//        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
//        assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());


    }

}
