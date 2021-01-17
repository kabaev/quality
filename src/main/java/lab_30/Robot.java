package lab_30;

/**
 * The {@code Robot} class describes an object representing a robot with two legs.
 *
 * @author Timur Kabaev
 */
public class Robot {

    private final LeftLeg leftLeg;
    private final RightLeg rightLeg;

    /** The value is used for synchronization steps. */
    private boolean stepSynchronizer;

    /** The value determines the number of steps required to take by every leg. */
    private int stepsNumber;

    /**
     * Initializes a newly created {@code Robot} object.
     */
    public Robot() {
        leftLeg = new LeftLeg();
        rightLeg = new RightLeg();
    }

    /**
     * Perform several steps.
     *
     * @param stepsNumber
     *        The number of steps required.
     */
    public void letsGo(int stepsNumber) {
        this.stepsNumber = stepsNumber;

        Thread left = new Thread(leftLeg);
        Thread right = new Thread(rightLeg);

        left.setName("Left leg");
        right.setName("Right leg");

        left.start();
        right.start();
    }

    /**
     * Takes step if stepSynchronizer has value false.
     */
    private synchronized void takeStepWithLeftLeg() {
        while(stepSynchronizer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is taking step");
        stepSynchronizer = !stepSynchronizer;
        notify();
    }

    /**
     * Takes step if stepSynchronizer has value true.
     */
    private synchronized void takeStepWithRightLeg() {
        while(!stepSynchronizer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is taking step");
        stepSynchronizer = !stepSynchronizer;
        notify();
    }

    private class LeftLeg implements Runnable {

        public void run() {
            for (int i = 0; i < stepsNumber; i++) {
                takeStepWithLeftLeg();
            }
        }
    }

    private class RightLeg implements Runnable {

        public void run() {
            for (int i = 0; i < stepsNumber; i++) {
                takeStepWithRightLeg();
            }
        }
    }
}
