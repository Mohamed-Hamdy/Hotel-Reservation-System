package Program;

import java.sql.Date;

public class Hotel {

    private int hotel_number;
    private String hotel_name;
    private double hotel_rating;
    private boolean hotel_availability;
    private double expected_price;
    private String hotel_Location;
    private String hotel_details;
    private String imageURL;
    private String hotel_gallary;
    private int tinyIntTranslate;
    private String hotel_url;
    private Date checkin;
    private Date checkout;
    private int max;

    public Hotel() {
        super();
    }

    public int getmax_allow() {
        return max;
    }

    public void setmax_allow(int num) {
        this.max = num;
    }

    public Date getcheckin() {
        return checkin;
    }

    public void setcheckin(Date chin) {
        this.checkin = chin;
    }

    public Date getcheckout() {
        return checkout;
    }

    public void setcheckout(Date chin) {
        this.checkout = chin;
    }

    public int getHotelNumber() {
        return hotel_number;
    }

    public void setHotelNumber(int number) {
        this.hotel_number = number;
    }

    public String getHotelName() {
        return hotel_name;
    }

    public void setHotelName(String Name) {
        this.hotel_name = Name;
    }

    public double getHotelRate() {
        return hotel_rating;
    }

    public void setHotelRate(double rate) {
        this.hotel_rating = rate;
    }

    public boolean isAvailable() {
        return hotel_availability;
    }

    public void setAvailable(boolean available) {
        hotel_availability = available;
    }

    public int getTinyIntTranslate() {
        int temp;
        if (this.hotel_availability) {
            temp = 1;
        } else {
            temp = 0;

        }
        return temp;
    }

    public void setTinyIntToIsAvailable(int tinyIntTranslate) {
        this.tinyIntTranslate = tinyIntTranslate;
        if (tinyIntTranslate == 1) {
            this.hotel_availability = true;
        } else if (tinyIntTranslate == 0) {
            this.hotel_availability = false;
        }
    }

    public void setImgURL(String img_URL) {
        this.imageURL = img_URL;
    }

    public String getImgURL() {
        return imageURL;
    }

    public void setgallaryImgsURL(String imgs_URL) {
        this.hotel_gallary = imgs_URL;
    }

    public String getgallaryImgsURL() {
        return hotel_gallary;
    }

    public void setexpected_price(double price) {
        this.expected_price = price;
    }

    public double getexpected_price() {
        return expected_price;
    }

    public void sethotel_Location(String Location) {
        this.hotel_Location = Location;
    }

    public String gethotel_Location() {
        return hotel_Location;
    }

    public void sethotel_details(String details) {
        this.hotel_details = details;
    }

    public String gethotel_details() {
        return hotel_details;
    }

    public String gethotellocationurl() {
        return hotel_url;
    }

    public void sethotellocationurl(String hotellocation) {
        this.hotel_url = hotellocation;
    }

    @Override
    public String toString() {
        return "Hotel{" + "hotel_name=" + hotel_name + ", hotel_rating=" + hotel_rating
                + ", hotel_availability=" + hotel_availability + ", expected_price=" + expected_price
                + ", hotel_Location=" + hotel_Location + ", hotel_details=" + hotel_details    
                + ", max=" + max + ", checkout=" + checkout + ", checkin=" + checkin + ", hotel_url=" + checkin + ", hotel_gallary=" + hotel_gallary 
                +", imageURL=" + imageURL + '}';
    }
}
