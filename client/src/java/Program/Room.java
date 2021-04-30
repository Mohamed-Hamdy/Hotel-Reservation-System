package Program;

import java.sql.Date;

public class Room {
    private String category;
    private int roomNumber;
    private boolean isAvailable;
    protected int maxGuestAAllowance;
    protected double pricePerNight;
    protected String imageURL;
    private String roomDetails;
    private String roomDescription;
    private int tinyIntTranslate;
    private int hotel_id;
    private Date check_in;
    private Date check_out;
    
    public Room() {
        super();
    }

    public int gethotelid() {
        return hotel_id;
    }

    public void sethotelid(int hotelid) {
        this.hotel_id = hotelid;
    }

    public Date getroomcheckIn() {
        return check_in;
    }

    public void setroomcheckIn(Date CI) {
        this.check_in = CI;
    }

    public Date getroomcheckOut() {
        return check_out;
    }

    public void setroomcheckOut(Date CO) {
        this.check_out = CO;
    }

    
    public String getRoomCategoryName() {
        return category;
    }

    public void setRoomCategoryName(String roomCategoryName) {
        this.category = roomCategoryName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getTinyIntTranslate() {
        int temp;
        if (this.isAvailable) {
            temp = 1;
        } else {
            temp = 0;

        }
        return temp;
    }

    public void setTinyIntToIsAvailable(int tinyIntTranslate) {
        this.tinyIntTranslate = tinyIntTranslate;
        if (tinyIntTranslate == 1) {
            this.isAvailable = true;
        } else if (tinyIntTranslate == 0) {
            this.isAvailable = false;
        }

    }

//    public String getCategory() {
//        return category;
//    }
//
//    private void setCategory(String category) {
//        this.category = category;
//    }

    public int getMaxGuestAAllowance() {
        return maxGuestAAllowance;
    }

    public void setMaxGuestAAllowance(int maxGuestAAllowance) {
        this.maxGuestAAllowance = maxGuestAAllowance;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

//    public void setRoomType(String category, int maxGuestAAllowance, double pricePerNight, String imgURL,
//            String roomDescription, String roomDetails) {
//        this.category = category;
//        this.maxGuestAAllowance = maxGuestAAllowance;
//        this.pricePerNight = pricePerNight;
//        this.imageURL = imgURL;
//        this.roomDetails = roomDetails;
//        this.roomDescription = roomDescription;
//    }

    public void setImgURL(String imgURL) {
        this.imageURL = imgURL;
    }

    public String getImgURL() {
        return imageURL;
    }

    public String getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(String roomDetails) {
        this.roomDetails = roomDetails;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    @Override
    public String toString() {
        return "Room{" + "Category=" + category + "roomNumber=" + roomNumber + ", isAvailable=" + isAvailable
                +", maxGuestAAllowance =" + maxGuestAAllowance + ", pricePerNight=" + pricePerNight + "imgURL: " + imageURL + "roomDetails" + roomDetails 
                + "roomDescription " + roomDescription + ",hotel_id" + hotel_id + '}';
    }
}
