package hiber.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(name = "car")
   @Value("null")
   private Car car;


   public Optional<Car> getCar() {
      return Optional.ofNullable(car);
   }

   public void setCar(Car car) {
      this.car = car;
   }

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }


}
