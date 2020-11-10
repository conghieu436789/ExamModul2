package menu.edit;

import Contacts.Contact;
import Contacts.ContactManagement;
import input.Input;

import java.util.Scanner;

import static menu.edit.EditAttribute.*;
import static menu.edit.EditDisplay.editDisplay;

public class EditProcess {
    public static boolean editProcess(ContactManagement contactManagement, Contact contact) {
        Scanner scanner = new Scanner(System.in);
        editDisplay();
        int select = Input.takeSelect();
        switch (select) {
            case 0:return true;
            case 1:
                editPN(contactManagement, contact);
                System.out.println("Edited");
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                break;
            case 2:
                editName(contactManagement, contact);
                System.out.println("Edited");
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                break;
            case 3:
                editAddress(contactManagement, contact);
                System.out.println("Edited");
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                break;
            case 4:
                editBirthDay(contactManagement, contact);
                System.out.println("Edited");
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                break;
            case 5:
                editGender(contactManagement, contact);
                System.out.println("Edited");
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                break;
            case 6:
                editEmail(contactManagement, contact);
                System.out.println("Edited");
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                break;
            case 7:
                editGroup(contactManagement, contact);
                System.out.println("Edited");
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                break;
            case 8:
                editName(contactManagement, contact);
                editAddress(contactManagement, contact);
                editBirthDay(contactManagement, contact);
                editGender(contactManagement, contact);
                editEmail(contactManagement, contact);
                editGroup(contactManagement, contact);
                editPN(contactManagement, contact);
                System.out.println("Edited");
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                break;
            default:
                System.out.println("Re-enter");
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                editProcess(contactManagement, contact);
        }
        return false;
    }
}
