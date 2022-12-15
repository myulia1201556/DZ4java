import java.util.Random;

public class program {
    public static void main(String[] args) {
        int sizeX = 30;
        int sizeY = 15;
        int[][] map = task004.map(sizeY, sizeX);

        Random random = new Random();
        int startX = random.nextInt(1, sizeY - 2);
        int startY = random.nextInt(1, sizeX - 2);
        int finishX = random.nextInt(1, sizeY - 2);
        int finishY = random.nextInt(1, sizeX - 2);
        map[startX][startY] = -2;
        map[finishX][finishY] = -3;

        map = task004.volnaLi(map, startX, startY, 0);
        map = task004.wayToStart(map, finishX, finishY);

        System.out.printf((char) 27 + "[32m█" + (char) 27 + "[0m" + " - Старт \n");
        System.out.printf((char) 27 + "[34m█" + (char) 27 + "[0m" + " - Финиш \n");
        System.out.printf((char) 27 + "[31m█" + (char) 27 + "[0m" + " - Короткий путь \n");
        task004.printRow(map, sizeY, sizeX);

    }
}
