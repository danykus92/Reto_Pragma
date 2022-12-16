package enums;

public enum Portal {

    MY_STORE("http://automationpractice.com/index.php");

    String portal;

    private Portal(String url) {
        this.portal = url;
    }

    public String getPortal() {
        return portal;
    }
}
