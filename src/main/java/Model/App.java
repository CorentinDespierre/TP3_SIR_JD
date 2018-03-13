package Model;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import java.net.UnknownHostException;


public class App {

  public static void main(String[] args) throws UnknownHostException {
    Morphia morphia = new Morphia();
    MongoClient mongo = new MongoClient();
    morphia.map(Person.class).map(Address.class);
    Datastore ds = morphia.createDatastore(mongo, "data");

    Address address = new Address();
    address.setStreet("123 Some street");
    address.setCity("Some City");
    address.setPostCode("123 456");
    address.setCountry("Some country");

    Address address2 = new Address();
    address2.setStreet("47 Some streed");
    address2.setCity("Los angeles");
    address2.setPostCode("778 956");
    address2.setCountry("USA");

    Person p = new Person();
    p.setName("Toto");

    Person p2 = new Person();
    p2.setName("Bob");

    Article a = new Article("Mobile", 5);
    Article a2 = new Article("Car", 4);

    p.addAddress(address);
    p2.addAddress(address2);
    a.addBuyer(p);
    a.addBuyer(p2);

    ds.save(address);
    ds.save(address2);
    ds.save(p);
    ds.save(p2);
    ds.save(a);
    ds.save(a2);

    System.out.println("Liste des personne :");
    for (Person e : ds.find(Person.class)) {
      System.out.println("Name : " + e.getName());
      for (Address addr : e.getAddressList()) {
        System.out.println("Address : " + addr.getStreet() + " " + addr.getPostCode() + " " + addr.getCity() + " " + addr.getCountry());
      }
    }
  }
}
