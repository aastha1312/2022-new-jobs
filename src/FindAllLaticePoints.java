class FindAllLatticePoints {

    public static void main(String[] args){
        latticePoints(5);
    }
    public static int latticePoints(int r) {
        int result = 0;

        int i = 0;
        int j = r;
        while (j > i) {
            int firstSideSquare = i * i;
            int secondSideSquare = j * j;
            int radiusSquare = r * r;

            if (firstSideSquare + secondSideSquare == radiusSquare) {
                if (i * j == 0) {
                    result = result + 4;
                } else result = result + 8;
                i++;
                j--;
            }
            if (firstSideSquare + secondSideSquare > radiusSquare) {
                j--;
            }
            if (firstSideSquare + secondSideSquare < radiusSquare) {
                i++;
            }
        }
        System.out.println(result);
        return result;

    }
}