package io;

import java.io.*;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "zipCode=" + zipCode +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception {
        final Contact contact = new Contact(1234, "+7 981 123 123");
        try (FileOutputStream fos = new FileOutputStream("test.txt")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contact);
        }
        try (FileInputStream fis = new FileInputStream("test.txt")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Contact temp = (Contact) ois.readObject();
            System.out.println(temp);
        }
    }
}
