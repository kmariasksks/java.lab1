package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class WritingDesk {
    private int numberOfDrawers;
    private boolean hasKeyboardTray;
    private int maxWeightCapacity;
    private int currentHeight;
    private int maxHeight;

    private static WritingDesk instance;

    public static WritingDesk getInstance() {
        if (instance == null) {
            return new WritingDesk();
        }
        return instance;
    }

    public void adjustHeight(int centimeters) {
        int newHeight = currentHeight + centimeters;
        if (newHeight <= maxHeight) {
            currentHeight = newHeight;
        }
    }

    public void moveDown(int centimeters) {
        int newHeight = currentHeight + centimeters;
        if (newHeight > 0) {
            currentHeight = newHeight;
        } else {
            System.out.println("Writing Desk height is less than 0!");
        }
    }

    public static void main(String[] args) {
        WritingDesk[] writingDesk = new WritingDesk[4];

        //Create object by @NoArgsConstructor from lombok
        writingDesk[0] = new WritingDesk();

        //Create object by @AllArgsConstructor from lombok
        writingDesk[1] = new WritingDesk(8, true, 120, 80, 90);

        //Create 2 objects by method getInstance
        writingDesk[2] = getInstance();
        writingDesk[2].setNumberOfDrawers(4);
        writingDesk[2].setHasKeyboardTray(false);
        writingDesk[2].setMaxWeightCapacity(100);
        writingDesk[2].setCurrentHeight(70);
        writingDesk[2].setMaxHeight(80);

        writingDesk[3] = getInstance();
        writingDesk[3].setNumberOfDrawers(3);
        writingDesk[3].setHasKeyboardTray(true);
        writingDesk[3].setMaxWeightCapacity(75);
        writingDesk[3].setCurrentHeight(75);
        writingDesk[3].setMaxHeight(85);

        //Create a loop with a precondition to output all stadiums data
        for (int index = 0; index < writingDesk.length; index++) {
            System.out.println("" + (index + 1) + ": " + writingDesk[index].toString());
        }
    }
}

