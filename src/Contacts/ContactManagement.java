package Contacts;

import ElementGetting.Support;

import java.time.LocalDate;
import java.util.ArrayList;

public class ContactManagement {
    private ArrayList<Contact> contactList;

    public ContactManagement(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    public Contact add(Contact contact) {
        contactList.add(contact);
        return contact;
    }
    public Contact remove(Contact contact) {
        contactList.remove(contact);
        return contact;
    }
    public Contact searchByPhoneNumber(String PN) {
        if (Support.isPNExist(PN,contactList)) {
            return Support.getContactByPN(PN, contactList);
        } else {
            return null;
        }
    }

    public void editPN(Contact contact, String newID) {
        contact.setPhoneNumber(newID);
    }
    public void editName(Contact contact, String name) {
        contact.setName(name);
    }
    public void editAddress(Contact contact, String address) {
        contact.setAddress(address);
    }
    public void editBirthDay(Contact contact, LocalDate birthDay) {
        contact.setBirthDay(birthDay);
    }
    public void editSex(Contact contact, String sex) {
        contact.setGender(sex);
    }
    public void editEmail(Contact contact, String email) {
        contact.setEmail(email);
    }
    public void editGroup(Contact contact, String group) {
        contact.setGroup(group);
    }

    public void printList() {

        if (contactList.isEmpty()) {
            System.out.println("Contact list is empty!");
        } else {
            int count =1;
            System.out.println("Contact List");
            for (Contact contact:contactList) {
                System.out.print(count +". ");
                System.out.println(contact);
                count++;
            }
        }
    }
}
