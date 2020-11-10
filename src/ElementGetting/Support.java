package ElementGetting;

import Contacts.Contact;

import java.util.ArrayList;

public class Support {
    public static boolean isMatchPN(Contact contact, String PN) {
        return contact.getPhoneNumber().equals(PN);
    }
    public static Contact getContactByPN(String PN, ArrayList<Contact> contactList) {
        for (Contact contact:contactList) {
            if (isMatchPN(contact, PN)){
                return contact;
            }
        }
        return null;
    }
    public static boolean isPNExist(String PN, ArrayList<Contact> contactList) {
        return getContactByPN(PN, contactList)!=null;
    }

}
