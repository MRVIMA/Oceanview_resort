package com.oceanviewresort.model;

public class UserTest {
    public static void main(String[] args) {
        System.out.println("--- TESTING USER MODEL ---");

        User adminUser = new User("admin_vima", "securePass123", "Admin");
        adminUser.setUser_id(1);

        if ("admin_vima".equals(adminUser.getUsername()) && "Admin".equals(adminUser.getRole())) {
            System.out.println("SUCCESS: Parameterized constructor and getters are working correctly.");
            System.out.println(" - Created User: " + adminUser.getUsername() + " | Role: " + adminUser.getRole());
        } else {
            System.out.println("FAILED: Constructor failed to map values.");
        }

        User receptionistUser = new User();
        receptionistUser.setUser_id(2);
        receptionistUser.setUsername("frontdesk_jane");
        receptionistUser.setPassword("deskpass456");
        receptionistUser.setRole("Receptionist");

        if (receptionistUser.getUser_id() == 2 && "Receptionist".equals(receptionistUser.getRole())) {
            System.out.println("SUCCESS: Empty constructor and setters mapped data correctly.");
        } else {
            System.out.println("FAILED: Setters/Getters are not functioning correctly.");
        }
    }
}