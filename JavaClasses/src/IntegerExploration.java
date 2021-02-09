public class IntegerExploration {
    public static void main(String[] args){
//        System.out.print("Integer Exploration");
        int number=256;
        System.out.println(Integer.bitCount(number));
        System.out.println(Integer.highestOneBit(number));
        System.out.println(Integer.toBinaryString(number));
    }
}
