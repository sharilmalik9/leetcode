// https://leetcode.com/problems/design-underground-system

class UndergroundSystem {
    Map<Integer, CustomerCheckin> customerCheckinMap = new HashMap<>(); //customer id, CustomerCheckin
    Map<String, List<Integer>> journeyTimesForStationPairs = new HashMap<>(); //"startstation->endstation", List of journey
    // times between them for each trip, by any customer.

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        customerCheckinMap.put(id, new CustomerCheckin(id,stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        String checkinStation = customerCheckinMap.get(id).getCheckinStationName();
        String stationPair = getStationPair(checkinStation, stationName);
        List<Integer> journeyTimesForThisPair= journeyTimesForStationPairs.getOrDefault(stationPair, new ArrayList());

        int checkinTime = customerCheckinMap.get(id).getCheckinTime();
        journeyTimesForThisPair.add(t-checkinTime);
        journeyTimesForStationPairs.put(stationPair, journeyTimesForThisPair);
    }

    public double getAverageTime(String startStation, String endStation) {
        String stationPair = getStationPair(startStation, endStation);
        List<Integer> journeyTimes = journeyTimesForStationPairs.get(stationPair);
        double totalTime =0.0;
        double numberOfJourneys= 0.0;

        for (int journeyTime : journeyTimes) {
            totalTime += journeyTime;
            numberOfJourneys++;
        }

        if (numberOfJourneys ==0) {
            return 0;
        }
        return totalTime/numberOfJourneys;
    }

    /**
     * returns a station pair in String form.
     * @param checkinStation
     * @param checkoutStation
     * @return
     */
    private String getStationPair(String checkinStation, String checkoutStation) {
        return String.format("%s->%s", checkinStation, checkoutStation);
    }

    //Custom object to contain a customer's current checkin info
    class CustomerCheckin {
        int id;
        String checkinStationName;
        int checkinTime;

        public CustomerCheckin(int id, String checkinName, int checkinTime) {
            this.id =id;
            this.checkinStationName = checkinName;
            this.checkinTime = checkinTime;
        }

        public int getId () {
            return id;
        }

        public String getCheckinStationName() {
            return checkinStationName;
        }

        public int getCheckinTime() {
            return checkinTime;
        }
    }
}