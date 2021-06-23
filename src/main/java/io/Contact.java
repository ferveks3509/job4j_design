package io;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        /*
        try (FileOutputStream fos = new FileOutputStream("test.txt")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contact);
        }
        try (FileInputStream fis = new FileInputStream("test.txt")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Contact temp = (Contact) ois.readObject();
            System.out.println(temp);
        }
         */
        List<String> list = new ArrayList<>();
        list.add("student");
        list.add("free");
        JSONArray json = new JSONArray(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("zipCode", contact.zipCode);
        jsonObject.put("phone", contact.getPhone());

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(contact).toString());
    }
}
