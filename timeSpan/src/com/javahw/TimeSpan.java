package com.javahw;

public class TimeSpan {

    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (minutes >= 60 || minutes < 0 || hours < 0) {
            throw new IllegalArgumentException("Неправильно задан промежуток времени");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    private void transformTimeSpan(TimeSpan timeSpan) {
        if(this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes = this.minutes % 60;
        }
    }


    public void add(TimeSpan timeSpan) {
        this.minutes += timeSpan.minutes;
        this.hours += timeSpan.hours;
        transformTimeSpan(this);
    }

    public void sub(TimeSpan timeSpan) {
        if(timeSpan.hours > this.hours) {
            throw new IllegalArgumentException("Промежуток времени не может быть отрицательным");
        }
        if(this.minutes < timeSpan.minutes) {
            this.hours--;
            this.minutes += 60;
        }
        this.minutes -= timeSpan.minutes;
        this.hours -= timeSpan.hours;
        transformTimeSpan(this);
    }

    public void mult(double times) {
        if(times < 0) {
            throw new IllegalArgumentException("Промежуток времени не может быть отрицательным");
        }
        this.minutes = (int) (this.minutes * times + (this.hours * times) % 1 * 60);
        this.hours *= times;
        transformTimeSpan(this);
    }

    @Override
    public String toString() {
        return "TimeSpan { " +
                "hours = " + hours +
                ", minutes = " + minutes +
                " }";
    }
}