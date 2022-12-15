import java.util.Random;

public class task004 {
    static int[][] map(int sizeY, int sizeX) {
        Random ra = new Random();
        int[][] map = new int[sizeY][sizeX];
        int randnum = 0;
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                randnum = ra.nextInt(-1, 6);
                if (i == 0 || i == sizeY - 1) {
                    map[i][j] = -1;
                } else if (j == 0 || j == sizeX - 1) {
                    map[i][j] = -1;
                } else if (randnum == -1) {
                    map[i][j] = randnum;
                } else {
                    map[i][j] = 0;
                }
            }
        }
        return map;
    }

    static int[][] volnaLi(int[][] arr, int startX, int startY, int way) {
        if (arr[startX][startY] != -3) {
            if (arr[startX][startY] != -2)
                arr[startX][startY] = way;
            if (arr[startX][startY - 1] != -1 && arr[startX][startY - 1] == 0 || arr[startX][startY - 1] > way) {
                arr[startX][startY - 1] = way;
                volnaLi(arr, startX, startY - 1, way + 1);
            }
            if (arr[startX - 1][startY] != -1 && arr[startX - 1][startY] == 0 || arr[startX - 1][startY] > way) {
                arr[startX - 1][startY] = way;
                volnaLi(arr, startX - 1, startY, way + 1);
            }
            if (arr[startX][startY + 1] != -1 && arr[startX][startY + 1] == 0 || arr[startX][startY + 1] > way) {
                arr[startX][startY + 1] = way;
                volnaLi(arr, startX, startY + 1, way + 1);
            }
            if (arr[startX + 1][startY] != -1 && arr[startX + 1][startY] == 0 || arr[startX + 1][startY] > way) {
                arr[startX + 1][startY] = way;
                volnaLi(arr, startX + 1, startY, way + 1);
            }
            // }
        }
        return arr;
    }

    static int[][] wayToStart(int[][] map, int fX, int fY) {
        int way = -4;
        int[] min = new int[2];
        while (true) {

            min = findMinAndShortWay(map, fX, fY);
            fX = min[0];
            fY = min[1];
            if (map[fX][fY] == -2) {
                // map[fX][fY] = way;
                break;
            }
            map[fX][fY] = way;

        }
        return map;
    }

    static int[] findMinAndShortWay(int[][] map, int fX, int fY) {
        int min[] = new int[2];
        int minMax = 0;
        try {
            if (minMax <= map[fX - 1][fY]) {
                minMax = map[fX - 1][fY];
            }
            if (minMax <= map[fX + 1][fY]) {
                minMax = map[fX + 1][fY];
            }
            if (minMax <= map[fX][fY + 1]) {
                minMax = map[fX][fY + 1];
            }
            if (minMax <= map[fX][fY - 1]) {
                minMax = map[fX][fY - 1];
            }

            if (minMax <= map[fX - 1][fY - 1]) {
                minMax = map[fX - 1][fY - 1];
            }
            if (minMax <= map[fX + 1][fY - 1]) {
                minMax = map[fX + 1][fY - 1];
            }
            if (minMax <= map[fX + 1][fY + 1]) {
                minMax = map[fX + 1][fY + 1];
            }
            if (minMax <= map[fX - 1][fY + 1]) {
                minMax = map[fX - 1][fY + 1];
            }

            if (map[fX - 1][fY] >= -2 && map[fX - 1][fY] != -1) {
                if (minMax >= map[fX - 1][fY]) {
                    minMax = map[fX - 1][fY];
                    min[0] = fX - 1;
                    min[1] = fY;
                }
            }
            if (map[fX + 1][fY] >= -2 && map[fX + 1][fY] != -1) {
                if (minMax >= map[fX + 1][fY]) {
                    minMax = map[fX + 1][fY];
                    min[0] = fX + 1;
                    min[1] = fY;
                }
            }
            if (map[fX][fY + 1] >= -2 && map[fX][fY + 1] != -1) {
                if (minMax >= map[fX][fY + 1]) {
                    minMax = map[fX][fY + 1];
                    min[0] = fX;
                    min[1] = fY + 1;
                }
            }
            if (map[fX][fY - 1] >= -2 && map[fX][fY - 1] != -1) {
                if (minMax >= map[fX][fY - 1]) {
                    minMax = map[fX][fY - 1];
                    min[0] = fX;
                    min[1] = fY - 1;
                }
            }

            if (map[fX - 1][fY - 1] >= -2 && map[fX - 1][fY - 1] != -1) {
                if (minMax >= map[fX - 1][fY - 1]) {
                    minMax = map[fX - 1][fY - 1];
                    min[0] = fX - 1;
                    min[1] = fY - 1;
                }
            }
            if (map[fX + 1][fY - 1] >= -2 && map[fX + 1][fY - 1] != -1) {
                if (minMax >= map[fX + 1][fY - 1]) {
                    minMax = map[fX + 1][fY - 1];
                    min[0] = fX + 1;
                    min[1] = fY - 1;
                }
            }
            if (map[fX + 1][fY + 1] >= -2 && map[fX + 1][fY + 1] != -1) {
                if (minMax >= map[fX + 1][fY + 1]) {
                    minMax = map[fX + 1][fY + 1];
                    min[0] = fX + 1;
                    min[1] = fY + 1;
                }
            }
            if (map[fX - 1][fY + 1] >= -2 && map[fX - 1][fY + 1] != -1) {
                if (minMax >= map[fX - 1][fY + 1]) {
                    minMax = map[fX - 1][fY + 1];
                    min[0] = fX - 1;
                    min[1] = fY + 1;
                }
            }
        } catch (ArrayIndexOutOfBoundsException ae) {

        }
        return min;
    }

    static void printRow(int[][] arr, int sizeY, int sizeX) {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {

                if (arr[i][j] == -1) {
                    System.out.printf((char) 27 + "[38m█" + (char) 27 + "[0m");
                } else if (arr[i][j] == -2) {
                    System.out.printf((char) 27 + "[32m█" + (char) 27 + "[0m");
                } else if (arr[i][j] == -3) {
                    System.out.printf((char) 27 + "[34m█" + (char) 27 + "[0m");
                } else if (arr[i][j] == -4) {
                    System.out.printf((char) 27 + "[31m█" + (char) 27 + "[0m");
                } else if (arr[i][j] == 0) {
                    System.out.print(' ');
                } else if (arr[i][j] > 0) {
                    System.out.print(' ');
                }
                System.out.print("");
            }
            System.out.println();
        }
        System.out.println();
    }
}
