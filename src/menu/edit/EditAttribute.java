package menu.edit;

import Contacts.Contact;
import Contacts.ContactManagement;
import ElementGetting.Support;
import input.Input;

import java.time.LocalDate;

public class EditAttribute {
    public static void editPN(ContactManagement contactManagement, Contact contact) {
        System.out.println("New phone number");
        String newPN = Input.takePN();
        while (Support.isPNExist(newPN, contactManagement.getContactList())) {
            System.out.println("Phone number was existed! Re-enter");
            newPN = Input.takePN();
        }
        contactManagement.editPN(contact, newPN);
    }
    public static void editName(ContactManagement  contactManagement, Contact contact) {
        System.out.println("New name");
        String newName = Input.takeName();
        contactManagement.editName(contact, newName);
    }
    public static void editAddress(ContactManagement contactManagement, Contact contact) {
        System.out.println("New address");
        String newAddress = Input.takeAddress();
        contactManagement.editAddress(contact, newAddress);
    }
    public static void editBirthDay(ContactManagement contactManagementagement, Contact contact) {
        System.out.println("New birthday");
        LocalDate newBirthDay = Input.takeBDay();
        contactManagementagement.editBirthDay(contact, newBirthDay);
    }
    public static void editGender(ContactManagement contactManagement, Contact contact) {
        System.out.println("New gender");
        String newGender = Input.takeSex();
        contactManagement.editSex(contact, newGender);
    }
    public static void editEmail(ContactManagement contactManagement, Contact contact) {
        System.out.println("New Email");
        String newEmail = Input.takeEmail();
        contactManagement.editEmail(contact, newEmail);
    }
    public static void editGroup(ContactManagement contactManagement, Contact contact) {
        System.out.println("New Group");
        String newGroup = Input.takeGroup();
        contactManagement.editEmail(contact, newGroup);
    }
}
