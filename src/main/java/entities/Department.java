package entities;

import java.util.ArrayList;

public class Department {

    private String deptName;
    private ArrayList<Section> sections;

    public Department(String deptName) {
        this.deptName = deptName;
        this.sections = new ArrayList<>();
    }

    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName) { this.deptName = deptName; }
    public ArrayList<Section> getSections() { return sections; }
    public void addSection(Section s) { sections.add(s); }
}