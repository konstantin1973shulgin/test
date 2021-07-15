package lesson1;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

       CanRunJump[] participants = {
               new Human(4, 2, "Иван"),
                new Human(2, 1, "Василий"),
                new Cat(2, 4, "Барсик"),
                new Cat(1, 1, "Мурзик"),
                new Robot(4,7,"Роберт"),
                new Robot(0,10,"Вертер")

        };

        Obstaclable[] obstacles = {
                new RunningTrack(2),
                new RunningTrack(4),
                new Wall(2),
                new Wall(3)
        };

        for (CanRunJump participant : participants) {
            System.out.println("К прохождению препятствий приступает " + participant);
            boolean player = true;
            for (Obstaclable obstacle : obstacles) {
                System.out.println(participant + " пытается " + obstacle);
                if (obstacle.toJump(participant.getMaxHeight()) ||
                        obstacle.toRun(participant.getMaxLength())) {
                    System.out.println("Пройдено успешно!");
                } else {
                    player = false;
                    System.out.println("Не получилось преодолеть.");
                    break;
                }
            }

            if(player) {
                System.out.println(participant + " преодолел дистанцию!");
            } else {
                System.out.println(participant + " проиграл.");
            }
            System.out.println();
        }
    }
}
