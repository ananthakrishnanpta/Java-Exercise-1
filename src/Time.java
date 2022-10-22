public class Time {
    private int hour;

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return this.hour;
    }

    private int minute;

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getMinute() {
        return this.minute;
    }

    private int second;

    public void setSecond(int second) {
        this.second = second;
    }

    public int getSecond() {
        return this.second;
    }

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time add(Time t) {
        Time r = new Time();
        if (this.second + t.second < 60) {
            r.second = this.second + t.second;
        } else {
            r.minute = this.minute + 1;
            r.second = this.second + (60 - t.second);
        }

        if (this.minute + t.minute < 60) {
            r.minute = this.minute + t.minute;
        } else {
            r.hour = this.hour + 1;
            r.minute = this.minute + (60 - t.minute);
        }

        r.hour = r.hour + this.hour + t.hour;

        return r;
    }

    //This subtraction function doesn't work when subtracting into negative hours(i.e, the previous days)
    public Time subtract(Time t) {
        Time s = new Time();
        s.hour = this.hour - t.hour;

        // subtract the minutes
        s.minute = this.minute - t.minute;
        // if the minutes are less than 0
        if (s.minute < 0) {
            // add 60 to the minutes
            s.minute += 60;
            // subtract 1 from the hours
            s.hour--;

        }

        s.second = this.second - t.second;

        if (s.second < 0) {
            s.second += 60;
            s.minute--;
        }
        return s;
    }
// ---------------------- Subtracting time -------------------------//

//    public Time subtract(Time t) {
//        Time r = new Time();
//
//
//
//        if (this.hour - r.hour < 0){
//            r.hour = 0 - (this.hour - r.hour);
//
//        }
//        if (this.minute - t.minute > 0) {
//            r.minute = this.minute - t.minute;
//        } else {
//            r.hour = this.hour - 1;
//            r.minute = (60 - t.minute);
//        }
//
//
//        if (this.second + t.second < 60) {
//            r.second = this.second + t.second;
//        } else {
//            r.minute = this.minute + 1;
//            r.second = this.second + (60 - t.second);
//        }
//
//        return r;
//    }

    @Override
    public String toString() {
        return String.format("%d:%d:%d", getHour(), getMinute(), getSecond());
    }
    public void getTime() {
        System.out.println(this.hour + ":" + this.minute + ":" + this.second);
    }



    public static void main(String[] args) {
        Time time1 = new Time(3, 55, 0);
        Time time2 = new Time(1, 20, 0);
        Time r = time1.add(time2);
        System.out.println(r);

        Time time3 = new Time(5, 25, 10);
        Time time4 = new Time(3, 4, 8);
        Time s = time3.subtract(time4);
        System.out.println(s);
    }
}
