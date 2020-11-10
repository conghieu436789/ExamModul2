package menu;

import Contacts.Contact;
import Contacts.ContactManagement;
import ElementGetting.Support;
import file.FileProcess;
import input.Input;
import menu.edit.EditProcess;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MainProcess {
    Scanner scanner = new Scanner(System.in);
    private static final String filepathContactList = "Contact.DAT";
    private ArrayList<Contact> contactList;
    private ContactManagement contactManagement;
    public MainProcess() {
        if (FileProcess.getFile(filepathContactList)==null) {
            contactList = new ArrayList<>();
        } else {
            contactList = (ArrayList<Contact>) FileProcess.getFile(filepathContactList);
        }
        contactManagement = new ContactManagement(contactList);
    }
    public void display() {
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("Chọn chức năng:");
    }
    public void getInfor() {
        contactManagement.printList();
    }
    public void add() {
        System.out.println("Add contact");
        Contact contact;
        String name = Input.takeName();
        LocalDate birthDay = Input.takeBDay();
        String address = Input.takeAddress();
        String sex = Input.takeSex();
        String group = Input.takeGroup();
        String email = Input.takeEmail();
        String phoneNumber = Input.takePN();
        while (Support.isPNExist(phoneNumber, contactList)) {
            System.out.println("Phone number was existed! Re-enter");
            phoneNumber = Input.takePN();
        }
        contact = new Contact(name, group, sex, address, email, birthDay, phoneNumber);
        System.out.println("Added new contact");
        System.out.println(contactManagement.add(contact));
    }
    public void remove() {
        System.out.println("Remove information");
        System.out.println("Enter Phone number to find");
        String PN = Input.takePN();
        Contact contact = contactManagement.searchByPhoneNumber(PN);;
        if (contact == null) {
            System.out.println("This contact not exist");
        } else {
            System.out.println(contact);
            System.out.println("Do you want delete this contact?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int select = Input.takeSelect();
            switch (select) {
                case 1:
                    contactManagement.remove(contact);
                    System.out.println("deleted");
                    break;
                case 2:
                    break;
            }
        }
    }

    public void searchByPhoneNumber() {
        System.out.println("Search by phone number");
        String PN;
        PN = Input.takePN();
        Contact contact = contactManagement.searchByPhoneNumber(PN);
        if (contact!=null) {
            System.out.println(contact);
        } else {
            System.out.println("This contact not exist");
        }
    }

    public void save() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want save?");
        System.out.println("1: Yes");
        System.out.println("2: No");
        int select = Input.takeSelect();
        switch (select) {
            case 1:
                FileProcess.writeFile(contactList,filepathContactList);
                System.out.println("saved");
                break;
            case 2:
                break;
        }
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }
    public void getFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Getting file");
        FileProcess.getFile(filepathContactList);
        System.out.println("Successfully");
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }
    public void selection() {
        boolean isExit;
        display();
        int select = Input.takeSelect();
        switch (select){
            case 1:
                getInfor();
                System.out.println("Press Enter to continue");
                scanner.nextLine();
//                while (continueAct()==1) {
//                    getInfor();
//                }
                break;
            case 2:
                add();
                while (continueAct()==1) {
                    add();
                }
                break;
            case 3:
                    System.out.println("Enter phone number to edit");
                    String PN;
                    PN = Input.takePN();
                    Contact contact = contactManagement.searchByPhoneNumber(PN);
                    if (contact!=null) {
                        do {
                            isExit = EditProcess.editProcess(contactManagement, contact);
                        } while (!isExit);
                    } else {
                        System.out.println("This contact not exist");
                    }
                break;
            case 4:
                remove();
                System.out.println("Press Enter to continue");
                scanner.nextLine();
                break;
//                while (continueAct()==1) {
//                    remove();
//                }
            case 5:
                searchByPhoneNumber();
                while (continueAct()==1) {
                    searchByPhoneNumber();
                }
                break;
            case 6:
                getFile();
                break;
            case 7:
                save();
                break;
            default:
                selection();
                break;
        }
    }
    public int continueAct() {
        System.out.println("Press '1' to continue, '2' to back" );
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        boolean checkType;
        do {
            checkType =true;
            try {
                select = select = Input.takeSelect();
                if (select!=1 && select!=2) {
                    System.out.println("Press '1' to continue, '2' to back");
                    checkType =false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                checkType =false;
                System.out.println("Press number '1' to continue, '2' to back");
            }
        } while (!checkType);
        return select;
    }


}
