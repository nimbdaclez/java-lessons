package lection04.online;

import java.util.Random;
import java.util.Scanner;

public class on4 {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    // Параметры карты
    public static int mapHeight;
    public static int mapWidth;
    public static char[][] map;
    public static int mapSizeMin = 4;
    public static int mapSizeMax = 5;
    public static char emptyCell = '_';

    // Параметры монетки
    public static char coin = 'c';
    public static int coinsOnMap;
    public static int coinsValue = 0;

    // Параметры игрока
    public static char player = '@';
    public static int playerHP = 100;
    public static int playerStr = 10;
    public static int playerCoins = 0;
    public static int playerScore = 0;
    public static int playerX;
    public static int playerY;

    // Параметры врагов
    public static char enemyVisible = 'E';
    public static char enemyHidden = '_';
    public static int enemyHP;
    public static int enemyStr;
    public static int enemyHpMin = 18;
    public static int enemyHpMax = 26;

    public static int enemiesCount;

    // Описание управления
    public static final int moveUp = 8;
    public static final int moveDown = 2;
    public static final int moveLeft = 4;
    public static final int moveRight = 6;

    public static final int attackHead = 8;
    public static final int attackBody = 5;
    public static final int attackLegs = 2;
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
        enemiesCount = (mapWidth + mapHeight) / 4;
        int enemyPosX;
        int enemyPosY;

        for (int i = 1; i <= enemiesCount; i++) {
            do {
                enemyPosX = random.nextInt(mapWidth);
                enemyPosY = random.nextInt(mapHeight);
            } while (!isEmptyCell(enemyPosX, enemyPosY));
            map[enemyPosY][enemyPosX] = enemyVisible;
        }
//        System.out.println("Enemies has been created. Count is " + enemiesCount);
    }

    public static void spawnCoins() {
        coinsOnMap = (mapWidth + mapHeight) / 2;
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
            System.out.print("Enter your destination: UP-" + moveUp + ") | -(" + moveDown + ") | LEFT-" + moveLeft + ") | RIGHT-" + moveRight + ") Where to go? > ");
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

        enemyHP = randomValue(enemyHpMin, enemyHpMax);

        if (map[playerY][playerX] == enemyVisible) {
            System.out.println();
            System.out.println("============ You meet ENEMY ====== Your HP: " + playerHP + " ====== Enemy HP: " + enemyHP + " ==============");

            do { playerBattleMechanic();
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

    public static void playerBattleMechanic() {
        int chooseAttack;

            int defencePosition = random.nextInt(1, 3);
            enemyStr = random.nextInt(7, 14);
            playerHP -= enemyStr;
            System.out.println();
            System.out.println("-----------------------------------ENEMY TURN-------------------------------------");
            System.out.println();
            System.out.println("Player has been attack by enemy on " + enemyStr + " damage" + ". Player HP now is: " + playerHP);
            System.out.println();
            System.out.println("-----------------------------------YOUR TURN--------------------------------------");
            System.out.println();

            System.out.print("Choose your attack: Hit the HEAD (" + attackHead + ") | Hit the BODY (" + attackBody + ") | Hit the LEGS (" + attackLegs + ") > ");
            chooseAttack = scanner.nextInt();
            switch (chooseAttack) {
                case attackHead:
                    if (defencePosition == 1) {
                        enemyHP -= playerStr / 2;
                        System.out.println("You attack HEAD, but enemy block it. You hit is BAD, on: " + playerStr / 2 + " damage" + ". Enemy HP is: " + enemyHP);
                    } else if (defencePosition == 2) {
                        enemyHP -= playerStr;
                        System.out.println("You attack HEAD, enemy block BODY. You hit is GOOD, on: " + playerStr + " damage" + ". Enemy HP is: " + enemyHP);
                    } else if (defencePosition == 3) {
                        enemyHP -= playerStr;
                        System.out.println("You attack HEAD, enemy block LEGS. You hit is GOOD, on: " + playerStr + " damage" + ". Enemy HP is: " + enemyHP);
                    }
                    break;
                case attackBody:
                    if (defencePosition == 1) {
                        enemyHP -= playerStr;
                        System.out.println("You attack BODY, enemy block HEAD. You hit is GOOD, on: " + playerStr + " damage" + ". Enemy HP is: " + enemyHP);
                    } else if (defencePosition == 2) {
                        enemyHP -= playerStr / 2;
                        System.out.println("You attack BODY, but enemy block it. You hit is BAD, on: " + playerStr / 2 + " damage" + ". Enemy HP is: " + enemyHP);
                    } else if (defencePosition == 3) {
                        enemyHP -= playerStr;
                        System.out.println("You attack BODY, enemy block LEGS. You hit is GOOD, on: " + playerStr + " damage" + ". Enemy HP is: " + enemyHP);
                    }
                    break;
                case attackLegs:
                    if (defencePosition == 1) {
                        enemyHP -= playerStr;
                        System.out.println("You attack LEGS, enemy block HEAD. You hit is GOOD, on: " + playerStr + " damage" + ". Enemy HP is: " + enemyHP);
                    } else if (defencePosition == 2) {
                        enemyHP -= playerStr;
                        System.out.println("You attack LEGS, enemy block BODY. You hit is GOOD, on: " + playerStr + " damage" + ". Enemy HP is: " + enemyHP);
                    } else if (defencePosition == 3) {
                        enemyHP -= playerStr / 2;
                        System.out.println("You attack LEGS, but enemy block it. You hit is BAD, on: " + playerStr / 2 + " damage" + ". Enemy HP is: " + enemyHP);
                    }
                    break;
            }

    }


    public static boolean isValidPlayerMoveNextCell(int nextCellX, int nextCellY, int lastCellX, int lastCellY) {
        if (isValidCell(nextCellX, nextCellY)) {
//            System.out.println("Player move to [" + (nextCellX + 1) + ":" + (nextCellY + 1) + "]");
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
