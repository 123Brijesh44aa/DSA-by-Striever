package leetcodedaily;

public class WaterBottles1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int q = numBottles / numExchange;
        int r = numBottles % numExchange;
        int total = numBottles + q;
        while ((q + r) >= numExchange) {
            int qpr = q + r;
            total = total + qpr / numExchange;
            q = qpr / numExchange;
            r = qpr % numExchange;
        }
        return total;
    }

    public static void main(String[] args) {
        int b = 15;
        int e = 4;
        System.out.println("maximum number of water bottles : " + new WaterBottles1518().numWaterBottles(b, e));
    }
}
