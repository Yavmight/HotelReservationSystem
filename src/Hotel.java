public class Hotel {
   private  String hotelName;
   private  String hotelLocation;
   private int buildingStories;
   private int totalRooms;
   private int totalReservation;


   public Hotel(String hotelName, String hotelLocation, int buildingStories,int totalRooms,int totalReservations){
       this.hotelName=hotelName;
       this.hotelLocation=hotelLocation;
       this.buildingStories=buildingStories;
       this.totalRooms=totalRooms;
       this.totalReservation=totalReservations;
   }


   // Add getters
   public String getHotelName() {
        return hotelName;
    }
    public String getHotelLocation(){
       return hotelLocation;

    }

    public int getBuildingStories() {
        return buildingStories;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public int getTotalReservation() {
        return totalReservation;
    }


   //add Setters
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public void setBuildingStories(int buildingStories) {
        this.buildingStories = buildingStories;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public void setTotalReservation(int totalReservation) {
        this.totalReservation = totalReservation;
    }
}
