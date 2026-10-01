public class Asset {

    private String id;
    private String name;
    private String category;
    public boolean isAssigned;

    public Asset(String id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isAssigned = false;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
    public void assign() {
        this.isAssigned = true;
    }
    public void release() {
        this.isAssigned = false;
    }
    public boolean isAssigned() {
        return isAssigned;
    }
    public String getSummary() {
        String status;
        if (isAssigned) {
    status = "Assigned";
        }
        else {
            status = "Available";
        }
        return "[" + id + "]" + name + " (" + category + ") -" + status;
    }

}
