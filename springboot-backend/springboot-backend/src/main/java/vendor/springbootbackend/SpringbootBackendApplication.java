package vendor.springbootbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vendor.springbootbackend.repository.vendorrepository;
import vendor.springbootbackend.model.vendor;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private vendorrepository vendorrepo;

	@Override
	public void run(String... args) throws Exception{
		vendor V1=new vendor();
		V1.setLastName("kumar");
		V1.setFirstName("Shubham");
		vendor V2=new vendor();
		V2.setFirstName("Rahul");
		V2.setLastName("Rai");

	}

}
