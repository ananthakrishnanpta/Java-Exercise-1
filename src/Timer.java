public class Timer extends Timeable{
    public Timer(Time t) {
        super(t);
    }

    public void countDown()  {

        time.setSecond(time.getSecond()  - 1);
    }
}
