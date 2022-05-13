package lection04.homework;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4App {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    // Параметры карты
    public static int mapHeight;
    public static int mapWidth;
    public static char[][] map;
    public static int mapSizeMin = 3;
    public static int mapSizeMax = 3;
    public static char emptyCell = '_';

    // Параметры игрока
    public static char player = '@';
    public static int playerHP = 100;
    public static int playerStr = 0;
    public static int playerCoins = 0;
    public static int playerScore = 0;
    public static int playerX;
    public static int playerY;

    // Параметры врагов
    public static char enemy = '_';
    public static int enemyHP;
    public static int enemyStr;

    public static int enemiesCount;

    // Параметры монетки
    public static char coin = 'c';
    public static int coinsOnMap;
    public static int coinsValue = 0;

    // Описание управления
    public static final int moveUp = 8;
    public static final int moveDown = 2;
    public static final int moveLeft = 4;
    public static final int moveRight = 6;

    // Счетчик уровней
    public static int gameLevel = 0;

    public static void main(String[] args) {

        while (isPlayerAlive()) {
            ++gameLevel;
            System.out.println("START GAME LEVEL " + gameLevel);
            levelCycle();
        }
        System.out.println("GAME OVER! Player Score " + playerScore);
    }

    public static void levelCycle() {
        createMap();
        createPlayer();
        spawnEnemies();
        spawnCoins();

        while (true) {
            printMap();
            playerMoveAction();

            if (!isPlayerAlive()) {
                System.out.println("Player dead. Game over");
                break;
            }

            if (!isEnemyExist()) {
                System.out.println("Player Win. Player Score " + playerScore + ". Level finish");
                break;
            }
        }
        printMap();
    }
    public static void createMap() {
        mapWidth = randomValue(mapSizeMin, mapSizeMax);
        mapHeight = randomValue(mapSizeMin, mapSizeMax);
        map = new char[mapHeight][mapWidth];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                map[y][x] = emptyCell;
            }
        }

    }
    public static void createPlayer() {
        playerX = randomValue(0, mapWidth - 1);
        playerY = randomValue(0, mapHeight - 1);
        map[playerY][playerX] = player;
        System.out.println("Player HP: " + playerHP);
    }

    public static void spawnEnemies() {
        enemiesCount = (mapWidth + mapHeight) / 2;
        int enemyPosX;
        int enemyPosY;

        for (int i = 1; i <= enemiesCount; i++) {
            do {
                enemyPosX = random.nextInt(mapWidth);
                enemyPosY = random.nextInt(mapHeight);
            } while (!isEmptyCell(enemyPosX, enemyPosY));
            map[enemyPosY][enemyPosX] = enemy;
        }
    }

    public static void spawnCoins() {
        coinsOnMap = (mapWidth + mapHeight) / 4;
        int coinsPosX;
        int coinsPosY;

        for (int i = 0; i < coinsOnMap; i++) {
            do {
                coinsPosX = random.nextInt(mapWidth);
                coinsPosY = random.nextInt(mapHeight);
            } while (!isEmptyCell(coinsPosX, coinsPosY));
            map[coinsPosY][coinsPosX] = coin;
        }

    }

    public static void playerMoveAction() {
        int playerLastX = playerX;
        int playerLastY = playerY;

        int playerDestination;

        do {
            System.out.print("Enter your destination: UP(" + moveUp + ") | DOWN(" + moveDown + ") | LEFT(" + moveLeft + ") | RIGHT(" + moveRight + ") Where to go? > ");
            playerDestination = scanner.nextInt();

            switch (playerDestination) {
                case moveUp:
                    playerY -= 1;
                    break;
                case moveDown:
                    playerY += 1;
                    break;
                case moveLeft:
                    playerX -= 1;
                    break;
                case moveRight:
                    playerX += 1;
                    break;
            }
        } while (!isValidPlayerMoveNextCell(playerX, playerY, playerLastX, playerLastY));

        playerAction();
        map[playerLastY][playerLastX] = emptyCell;
        map[playerY][playerX] = player;

    }

    public static void playerAction() {

        enemyHP = random.nextInt(19, 26);

        if (map[playerY][playerX] == enemy) {
            System.out.println();
            System.out.println("============ You meet ENEMY ====== Your HP: " + playerHP + " ====== Enemy HP: " + enemyHP + " ==============");
            do { battle();
            } while (enemyHP > 0);
            playerScore++;
            enemiesCount--;
        } else if (map [playerY][playerX] == coin) {
            coinsValue = random.nextInt(1,6);
            playerCoins = playerCoins + coinsValue;
            coinsOnMap--;
            System.out.println("Player found " + coinsValue + " coin(s)" + ". Total player coins: " + playerCoins);
        }
    }

    public static void battle() {
        enemyStr = random.nextInt(7, 14);
        playerStr = random.nextInt(9, 17);
        playerHP -= enemyStr;
        System.out.println("Enemy attack you on " + enemyStr + " damage" + ". Your HP: " + playerHP);
        enemyHP -= playerStr;
        System.out.println("You attack enemy on " + playerStr + " damage" + ". Enemy HP: " + enemyHP);
    }

    public static boolean isValidPlayerMoveNextCell(int nextCellX, int nextCellY, int lastCellX, int lastCellY) {
        if (isValidCell(nextCellX, nextCellY)) {
            return true;
        } else {
            System.out.println("Invalid move");
            playerX = lastCellX;
            playerY = lastCellY;
            return false;
        }
    }

    public static void printMap() {
        System.out.println("===== MAP =====");
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("===============");
    }

    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static boolean isEmptyCell(int x, int y) {
        return map[y][x] == emptyCell;
    }

    public static boolean isPlayerAlive() {
        return playerHP > 0;
    }

    public static boolean isValidCell(int x, int y) {
        return x >= 0 && x < mapWidth && y >= 0 && y < mapHeight;
    }

    public static boolean isEnemyExist() {
        return enemiesCount > 0;
    }
}
