public class Problem4 {
    private final int lockerNumber;
    private String combinationCode;

    public Problem4(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (!this.combinationCode.equals(currentCode)) {
            System.out.println("rejected, code is still \"" + this.combinationCode + "\"");
            return false;
        }
        this.combinationCode = newCode;
        System.out.println("success");
        return true;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Problem4 l = new Problem4(101, "1234");

        System.out.print("l.changeCode(\"1234\", \"5678\") -> ");
        l.changeCode("1234", "5678");

        System.out.print("l.changeCode(\"0000\", \"9999\") -> ");
        l.changeCode("0000", "9999");
    }
}