// Purpose:         Program used for actions regarding a person's first and last names.
// Programmer:      Araceli YM
// Created on:      5/06/2024

public class Person
{
   private String firstName;
   private String lastName;
   
   public Person(String newFirstName)
   {
      this.firstName = newFirstName;
      this.lastName = "";
   }
   
   public Person(String newFirstName, String newLastName)
   {
      this.firstName = newFirstName;
      this.lastName = newLastName;
   }
   
   public void setFirstName(String newName)
   {
      this.firstName = newName;
   }
   
   public void setLastName(String newName)
   {
      this.lastName = newName;
   }
   
   public String getFirstName()
   {
      return firstName;
   }
   
   public String getLastName()
   {
      return lastName;
   }
}
