package demo;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Work {
    public Work(int id, String time) {
        this.id = id;
        this.time = time;
    }

    public Work() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private int id;
    private String time;
}
