package filenest.domain;

public class Manager {
    private String adminName;
    private String adminPassword;
    private String adminId;

    public Manager(String adminName, String adminPassword, String adminId) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
