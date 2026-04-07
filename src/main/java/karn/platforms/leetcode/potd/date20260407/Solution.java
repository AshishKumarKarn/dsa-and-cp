package karn.platforms.leetcode.potd.date20260407;

//https://leetcode.com/problems/walking-robot-simulation-ii/?envType=daily-question&envId=2026-04-07
//lc 2069. Walking Robot Simulation II
public class Solution {


}
class Robot {

    private int[] pos;
    private int direction;//0-> east, 1-> north, 2->west, 3-> south
    private int xMax;
    private int yMax;
    private int perimeter;

    public Robot(int width, int height) {
        this.xMax = width - 1;
        this.yMax = height - 1;
        this.perimeter = 2 * ((width - 1) + (height - 1));
        //setting initial position
        this.pos = new int[2];
        //these are already defaulted value for new initialized array.
        //this.pos[0] = 0;
        //this.pos[1] = 0;
        //this.direction = 0;
    }

    public void step(int num) {
        if (num == 0) {
            return;
        }
        //System.out.println(this.direction+" "+this.pos[0]+" "+this.pos[1]+" "+num);
        if (pos[0] == 0 || pos[1] == 0 || pos[0] == xMax || pos[1] == yMax) {

            if (num >= perimeter) {
                //this part is where we imagine the final direction of the bot after one complete
                //perimeter is completed and robot is situated at any corner cell.
                if (pos[0] == 0 && pos[1] == 0) {
                    direction = 3;
                }
                if (pos[0] == xMax && pos[1] == 0) {
                    direction = 0;
                }
                if (pos[0] == xMax && pos[1] == yMax) {
                    direction = 1;
                }
                if (pos[0] == 0 && pos[1] == yMax) {
                    direction = 2;
                }
                num %= (perimeter);

            }

        }

        if (this.direction == 0) {
            if (this.pos[0] + num > xMax) {
                this.direction = 1;
                num -= (xMax - this.pos[0]);
                this.pos[0] = xMax;
                step(num);
            } else {
                this.pos[0] += num;
            }

        } else if (this.direction == 1) {
            if (this.pos[1] + num > yMax) {
                this.direction = 2;
                num -= (yMax - this.pos[1]);
                this.pos[1] = yMax;
                step(num);
            } else {
                this.pos[1] += num;
            }
        } else if (this.direction == 2) {
            if (this.pos[0] - num < 0) {
                this.direction = 3;
                num -= (this.pos[0]);
                this.pos[0] = 0;
                step(num);
            } else {
                this.pos[0] -= num;
            }

        } else {
            if (this.pos[1] - num < 0) {
                this.direction = 0;
                num -= (this.pos[1]);
                this.pos[1] = 0;
                step(num);
            } else {
                this.pos[1] -= num;
            }
        }
    }

    public int[] getPos() {
        return this.pos;
    }

    public String getDir() {
        if (direction == 0) {
            return "East";
        }
        if (direction == 1) {
            return "North";
        }
        if (direction == 2) {
            return "West";
        }
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */