package demo;

import javax.faces.bean.ManagedBean;

import java.util.ArrayList;
import java.util.List;


@ManagedBean
public class BasicView {

    private String text;
    private List<Work> works;

    public List<Work> getWorks() {
        works = new ArrayList<>();
        works.add(new Work(1, "helo"));
        works.add(new Work(2, "hele"));
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

}
