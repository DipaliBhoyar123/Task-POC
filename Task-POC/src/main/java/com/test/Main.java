package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	
	 public static void main(String[] args) {
		        
		        Adult adult1 = new Adult("John", "Doe", 30);

		        // Serialize the object
		        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("adult.ser"))) {
		            oos.writeObject(adult1);
		            System.out.println("Serialization successful: " + adult1);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		        // Deserialize the object
		        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("adult.ser"))) {
		            Adult deserializedAdult = (Adult) ois.readObject();
		            System.out.println("Deserialization successful: " + deserializedAdult);
		        } catch (IOException | ClassNotFoundException e) {
		            e.printStackTrace();
		        }

		        // Attempt to create an invalid Adult instance
		        try {
		            Adult invalidAdult = new Adult("", "Smith", 17);
		            System.out.println("Created invalid adult: " + invalidAdult);
		        } catch (IllegalArgumentException e) {
		            System.out.println("Caught exception for invalid adult: " + e.getMessage());
		        }

		        // Attempt to deserialize an invalid Adult instance (should fail)
		        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("invalid_adult.ser"))) {
		            Adult invalidAdult = new Adult("Jane", "Smith", 17);
		            oos.writeObject(invalidAdult);
		            System.out.println("Serialization successful: " + invalidAdult);
		        } catch (IllegalArgumentException e) {
		            System.out.println("Caught exception for invalid adult serialization: " + e.getMessage());
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		        // Deserialize the invalid object (should fail)
		        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("invalid_adult.ser"))) {
		            Adult deserializedInvalidAdult = (Adult) ois.readObject();
		            System.out.println("Deserialization successful: " + deserializedInvalidAdult);
		        } catch (IOException | ClassNotFoundException e) {
		            System.out.println("Caught exception for invalid adult deserialization: " + e.getMessage());
		        }
		    
		}

}
