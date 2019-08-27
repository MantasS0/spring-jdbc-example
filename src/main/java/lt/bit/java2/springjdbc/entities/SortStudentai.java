package lt.bit.java2.springjdbc.entities;

import java.util.Comparator;

public class SortStudentai implements Comparator<Studentas> {
    @Override
    public int compare(Studentas o1, Studentas o2) {
        if (o1.getPavarde().equals(o2.getPavarde())){
            return o1.getVardas().compareTo(o2.getVardas());
        }
        return o1.getPavarde().compareTo(o2.getPavarde());
    }
}
