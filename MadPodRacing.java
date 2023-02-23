import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    private static int getAngleModifier(int nextCheckpointAngle) {
        return (Math.abs(nextCheckpointAngle) * 3 / 2);
    }

    private static int getDistanceModifier(int nextCheckpointDist) {
        if (nextCheckpointDist < 700) {
            return 80;
        }
        else if (nextCheckpointDist < 1000) {
            return 50;
        }
        else if (nextCheckpointDist < 1500) {
            return 30;
        }
        else {
            return 0;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int thrust = 100;
        boolean boostAvailable = true;

        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            int nextCheckpointY = in.nextInt(); // y position of the next check point
            int nextCheckpointDist = in.nextInt(); // distance to the next checkpoint
            int nextCheckpointAngle = in.nextInt(); // angle between your pod orientation and the direction of the next checkpoint
            int opponentX = in.nextInt();
            int opponentY = in.nextInt();

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            thrust = Math.max(0, (100 - getAngleModifier(nextCheckpointAngle)
                                        - getDistanceModifier(nextCheckpointDist)));
            System.err.println(getAngleModifier(nextCheckpointAngle));
            System.err.println(getDistanceModifier(nextCheckpointDist));
            // if (nextCheckpointDist < 700) {
            //     thrust = 20;
            // }
            // else if (nextCheckpointDist < 1000) {
            //     thrust = 50;
            // }
            // else if (nextCheckpointDist < 1500) {
            //     thrust = 70;
            // }
            // else {
            //     thrust = 100;
            // }

            // if (nextCheckpointAngle > 45 || nextCheckpointAngle < -45) {
            //     thrust = 15;
            // }

            if (boostAvailable && thrust == 100 && nextCheckpointDist > 7000
                && nextCheckpointAngle < 30 && nextCheckpointAngle > -30) {
                System.out.println(nextCheckpointX + " " + nextCheckpointY + " BOOST");
                boostAvailable = false;
            }
            else {
                System.out.println(nextCheckpointX + " " + nextCheckpointY + " " + thrust);
            }
        }
    }
}