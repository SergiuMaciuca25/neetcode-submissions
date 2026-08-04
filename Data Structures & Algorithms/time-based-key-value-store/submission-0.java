
class Pair {

    int timeStamp;
    String value;

    Pair(int timeStamp, String value) {
        this.timeStamp = timeStamp;
        this.value = value;
    }
}


class TimeMap {

    private Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (! map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        List<Pair> pairs = map.get(key);
        pairs.add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> pairs = map.get(key);
        int left = 0;
        int right = pairs.size() - 1;

        int resultIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair currentPair = pairs.get(mid);

            if (currentPair.timeStamp <= timestamp) {
                resultIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    

    if (resultIndex == -1) {
        return "";
    } else {

        return pairs.get(resultIndex).value;
    }
    }
}

