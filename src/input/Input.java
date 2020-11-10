package input;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    public static String nameRegex() {
        return "([A-Z][a-z]+\\s?)+";
    }
    public static String addressRegex() {
        return "[A-Za-z_0-9]+";
    }
    public static String sexRegex() {
        return "Male|Female";
    }
    public static String PNRegex() {
        return "^0[39][0-9]{8}$";
    }

    public static String passwordRegex() {
        return "[A-Za-z0-9]{8,15}$";
    }
    public static boolean isMatch(String regex, String catcher) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(catcher);
        return matcher.matches();
    }

    public static String enterName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name (at least 2 characters and capitalize first character)");
        String name = scanner.nextLine();
        return name;
    }
    public static String takeName() {
        boolean checkType;
        String name = null;
        do {
            try {
                name = enterName();
                checkType = isMatch(nameRegex(), name);
                if(!checkType) {
                    System.out.println("Wrong regex");
                }
            } catch (Exception e) {
                System.err.println("Type is wrong");
                checkType=false;
            }
        } while (!checkType);
        return name;
    }

    public static String enterEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Email ");
        String email = scanner.nextLine();
        return email;
    }
    public static String takeEmail() {
        boolean checkType;
        String email = null;
        do {
            checkType = true;
            try {
                email = enterEmail();
//                checkType = isMatch(nameRegex(), email);
//                if(!checkType) {
//                    System.out.println("Wrong regex");
//                }
            } catch (Exception e) {
                System.err.println("Type is wrong");
                checkType=false;
            }
        } while (!checkType);
        return email;
    }

    public static String enterGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Group ");
        String group = scanner.nextLine();
        return group;
    }
    public static String takeGroup() {
        boolean checkType;
        String group = null;
        do {
            checkType = true;
            try {
                group = enterGroup();
//                checkType = isMatch(nameRegex(), email);
//                if(!checkType) {
//                    System.out.println("Wrong regex");
//                }
            } catch (Exception e) {
                System.err.println("Type is wrong");
                checkType=false;
            }
        } while (!checkType);
        return group;
    }

    public static LocalDate enterBirthDay()throws Exception{
        Scanner scanner = new Scanner(System.in);
        LocalDate birthDay;
        System.out.println("Enter birthday");
        System.out.println("Enter date");
        int date = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter month");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter year");
        int year = Integer.parseInt(scanner.nextLine());
        birthDay =LocalDate.of(year, month, date);
        return birthDay;
    }
    public static LocalDate takeBDay() {
        boolean checkType = true;
        LocalDate day = null;
        do {
            try {
                day = enterBirthDay();
            } catch (Exception e) {
                System.err.println("Wrong type");
                checkType=false;
            }
        } while (!checkType);
        return day;
    }

    public static String enterAddress() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter address");
        String address = scanner.nextLine();
        return address;
    }
    public static String takeAddress() {
        String address = null;
        boolean checkType;
        do {
            try {
                address = enterAddress();
                checkType = isMatch(addressRegex(), address);
                if(!checkType) {
                    System.out.println("Wrong regex");
                }
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        return address;
    }

    public static String enterSex() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sex (Male/Female)");
        String sex = scanner.nextLine();
        return sex;
    }
    public static String takeSex() {
        String sex = null;
        boolean checkType;
        do {
            try {
                sex = enterSex();
                checkType = isMatch(sexRegex(), sex);
                if(!checkType) {
                    System.out.println("Wrong regex");
                }
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        return sex;
    }

    public static String enterSelect() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your selection");
        String selection = scanner.nextLine();
        return selection;
    }
    public static int takeSelect() {
        int select = 0;
        boolean checkType;
        do {
            checkType = true;
            try {
                select = Integer.parseInt(enterSelect());
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        return select;
    }

    public static String enterPN() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Phone Number (start with 09 or 03)");
        String ID = scanner.nextLine();
        return ID;
    }
    public static String takePN() {
        String ID = null;
        boolean checkType;
        do {
            try {
                ID = enterPN();
                checkType = isMatch(PNRegex(), ID);
                if(!checkType) {
                    System.out.println("Wrong regex");
                }
            } catch (Exception e) {
                checkType = false;
                System.err.println("Wrong type");
            }
        } while (!checkType);
        return ID;
    }


}
